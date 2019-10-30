package com.chf.loraserver.events;

import com.chf.loraserver.Subscribable;
import com.chf.loraserver.messages.UplinkMessage;

public abstract class UplinkHandler implements EventHandler {
    private String _appId;

    public UplinkHandler(String appId) {
        _appId = appId;
    }

    public abstract void handle(String _devEUI, UplinkMessage _data);

    @Override
    public void subscribe(Subscribable _client) throws Exception {
        _client.subscribe(new String[]{
                "application",
                _appId,
                "node",
                _client.getWordWildcard(),
                "rx"
        });

        _client.subscribe(new String[]{
                "application",
                _appId,
                "device",
                _client.getWordWildcard(),
                "rx"
        });
    }
}
