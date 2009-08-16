/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package org.cspoker.client.communication.pokersource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.cspoker.client.communication.pokersource.commands.JSONCommand;
import org.cspoker.client.communication.pokersource.commands.Logout;
import org.cspoker.client.communication.pokersource.eventlisteners.all.AllEventListener;
import org.cspoker.client.communication.pokersource.events.JSONEvent;
import org.cspoker.client.communication.pokersource.events.general.AuthOk;
import org.cspoker.client.communication.pokersource.events.general.Serial;
import org.cspoker.client.communication.pokersource.events.poker.AutoBlindAnte;
import org.cspoker.client.communication.pokersource.events.poker.BatchMode;
import org.cspoker.client.communication.pokersource.events.poker.BuyInLimits;
import org.cspoker.client.communication.pokersource.events.poker.PlayerArrive;
import org.cspoker.client.communication.pokersource.events.poker.PlayerChips;
import org.cspoker.client.communication.pokersource.events.poker.PlayerInfo;
import org.cspoker.client.communication.pokersource.events.poker.PlayerLeave;
import org.cspoker.client.communication.pokersource.events.poker.PlayerStats;
import org.cspoker.client.communication.pokersource.events.poker.Seat;
import org.cspoker.client.communication.pokersource.events.poker.Seats;
import org.cspoker.client.communication.pokersource.events.poker.Sit;
import org.cspoker.client.communication.pokersource.events.poker.StreamMode;
import org.cspoker.client.communication.pokersource.events.poker.Table;
import org.cspoker.client.communication.pokersource.events.poker.UserInfo;
import org.cspoker.client.communication.pokersource.events.poker.client.ClientPlayerChips;
import org.cspoker.client.communication.pokersource.events.poker.client.CurrentGames;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public class PokersourceConnection extends RESTConnection{
	
	private final static Logger logger = Logger.getLogger(PokersourceConnection.class);
	
	public PokersourceConnection(String server) throws MalformedURLException {
		super(server);
	}

	public void send(JSONCommand command) throws IOException{
		logger.info("Sending: "+command.getClass().getSimpleName()+": "+command);
		String response = put(command.toString());
		logger.info("Received: "+response);
		JSONArray jsonResponse = (JSONArray) JSONSerializer.toJSON( response );
		signalEvents(jsonResponse);
	}

	private void signalEvents(JSONArray jsonResponse) {
		for(int i=0; i<jsonResponse.size();i++){
			JSONObject jsonEvent = jsonResponse.getJSONObject(i);
			JsonConfig jsonConfig = new JsonConfig();  
			jsonConfig.setRootClass( eventTypes.get(jsonEvent.get("type")) ); 
			try {
				JSONEvent event = (JSONEvent) JSONSerializer.toJava( jsonEvent, jsonConfig );  
				signal(event);
			} catch (ClassCastException e) {
				throw new IllegalStateException("Couldn't unmarshall: "+jsonEvent,e);
			}
		}
	}
	
	private final List<AllEventListener> listeners = new CopyOnWriteArrayList<AllEventListener>();
	
	public void addListener(AllEventListener listener){
		listeners.add(listener);
	}
	
	private void signal(JSONEvent event) {
		for(AllEventListener listener:listeners) event.signal(listener);
	}

	public void close() throws IOException {
		send(new Logout());
		super.close();
	}

	private final static ImmutableMap<String, Class<? extends JSONEvent>> eventTypes = 
		(new Builder<String, Class<? extends JSONEvent>>())
		.put(AuthOk.getStaticType(), AuthOk.class)
		.put(Serial.getStaticType(), Serial.class)
		.put(PlayerInfo.getStaticType(), PlayerInfo.class)
		.put(Table.getStaticType(), Table.class)
		.put(CurrentGames.getStaticType(), CurrentGames.class)
		.put(BuyInLimits.getStaticType(), BuyInLimits.class)
		.put(BatchMode.getStaticType(), BatchMode.class)
		.put(PlayerLeave.getStaticType(), PlayerLeave.class)
		.put(PlayerArrive.getStaticType(), PlayerArrive.class)
		.put(Seats.getStaticType(), Seats.class)
		.put(PlayerStats.getStaticType(), PlayerStats.class)
		.put(PlayerChips.getStaticType(), PlayerChips.class)
		.put(ClientPlayerChips.getStaticType(), ClientPlayerChips.class)
		.put(Sit.getStaticType(), Sit.class)
		.put(StreamMode.getStaticType(), StreamMode.class)
		.put(UserInfo.getStaticType(), UserInfo.class)
		.put(AutoBlindAnte.getStaticType(), AutoBlindAnte.class)
		.put(Seat.getStaticType(), Seat.class)
		.build();
}