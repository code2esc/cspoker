package org.cspoker.server.rmi.unremote.listener;

import org.cspoker.common.api.lobby.event.TableCreatedEvent;
import org.cspoker.common.api.lobby.event.TableRemovedEvent;
import org.cspoker.common.api.lobby.listener.LobbyListener;
import org.cspoker.common.api.lobby.listener.RemoteLobbyListener;
import org.cspoker.common.api.shared.Trigger;
import org.cspoker.common.api.shared.listener.ForwardingListener;

public class UnremoteLobbyListener extends ForwardingListener<RemoteLobbyListener> implements LobbyListener{

	private final Trigger connection;

	public UnremoteLobbyListener(Trigger connection,
			RemoteLobbyListener lobbyListener) {
		super(lobbyListener);
		this.connection = connection;
	}

	public void onTableCreated(TableCreatedEvent tableCreatedEvent) {
		try {
			for (RemoteLobbyListener listener : listeners) {
				listener.onTableCreated(tableCreatedEvent);
			}
		} catch (Exception exception) {
			connection.trigger();
		}
	}

	public void onTableRemoved(TableRemovedEvent tableRemovedEvent) {
		try {
			for (RemoteLobbyListener listener : listeners) {
				listener.onTableRemoved(tableRemovedEvent);
			}
		} catch (Exception exception) {
			connection.trigger();
		}
	}

}