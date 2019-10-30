package com.chf.loraserver.events;

import com.chf.loraserver.Subscribable;

public interface EventHandler {

    public void subscribe(Subscribable _client) throws Exception;
}
