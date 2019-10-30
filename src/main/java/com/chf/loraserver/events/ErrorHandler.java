package com.chf.loraserver.events;

import com.chf.loraserver.Subscribable;

/**
 * 错误事件处理
 */
public abstract class ErrorHandler implements EventHandler {

    public void safelyHandle(Throwable _error) {
        try {
            handle(_error);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public abstract void handle(Throwable _error);

    @Override
    public void subscribe(Subscribable _client) throws Exception {

    }
}
