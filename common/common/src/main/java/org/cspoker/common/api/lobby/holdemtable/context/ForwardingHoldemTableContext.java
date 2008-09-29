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
package org.cspoker.common.api.lobby.holdemtable.context;

import org.cspoker.common.api.lobby.holdemtable.holdemplayer.context.HoldemPlayerContext;
import org.cspoker.common.api.lobby.holdemtable.listener.ForwardingHoldemTableListener;
import org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener;

public class ForwardingHoldemTableContext implements HoldemTableContext{

	private HoldemTableContext holdemTableContext;
	private ForwardingHoldemTableListener forwardingListener;

	public ForwardingHoldemTableContext(HoldemTableContext holdemTableContext) {
		this.holdemTableContext  = holdemTableContext;
		this.forwardingListener = new ForwardingHoldemTableListener();
		holdemTableContext.subscribe(wrapListener(forwardingListener));
	}
	
	public HoldemTableListener wrapListener(HoldemTableListener listener){
		return listener;
	}

	public HoldemPlayerContext getHoldemPlayerContext() {
		return holdemTableContext.getHoldemPlayerContext();
	}

	public void leaveTable() {
		holdemTableContext.leaveTable();
	}

	public void sitIn(long seatId) {
		holdemTableContext.sitIn(seatId);
	}

	public void startGame() {
		holdemTableContext.startGame();
	}

	public void subscribe(HoldemTableListener holdemTableListener) {
		forwardingListener.subscribe(holdemTableListener);
	}

	public void unSubscribe(HoldemTableListener holdemTableListener) {
		forwardingListener.unSubscribe(holdemTableListener);
	}
	
}