package com.chf.loraserver.events;


import com.chf.loraserver.Connection;
import com.chf.loraserver.Subscribable;

public abstract class ConnectHandler implements EventHandler {

    public abstract void handle(Connection _conn);

    @Override
    public void subscribe(Subscribable _client) throws Exception {

    }
}
