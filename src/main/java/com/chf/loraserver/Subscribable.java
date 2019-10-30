package com.chf.loraserver;

/**
 * 订阅主题
 */
public interface Subscribable {
    public void subscribe(String[] _key) throws Exception;

    public String getWordWildcard();

    public String getPathWildcard();
}
