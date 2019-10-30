package com.chf.loraserver;

import com.chf.loraserver.messages.UplinkMessage;
import com.chf.loraserver.mqtt.Client;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * loraserver mqtt 客户端抽象类
 */
public abstract class AbstractClient {
    public static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER
                .setVisibility(PropertyAccessor.ALL, Visibility.NONE)
                .setVisibility(PropertyAccessor.FIELD, Visibility.ANY)
                .setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 启动
     *
     * @return the Client instance
     * @throws Exception in case something goes wrong
     */
    public abstract AbstractClient start() throws Exception;

    /**
     * 停止 超时时间 5000 ms
     *
     * @return the Client instance
     * @throws Exception in case something goes wrong
     */
    public abstract AbstractClient end() throws Exception;

    /**
     * 停止，指定超时时间
     *
     * @param _timeout 超时时间
     * @return the Client instance
     * @throws Exception in case something goes wrong
     */
    public abstract AbstractClient end(long _timeout) throws Exception;

    /**
     * 立即停止
     *
     * @return the Client instance
     * @throws Exception in case something goes wrong
     */
    public abstract AbstractClient endNow() throws Exception;

    /**
     * 下发
     *
     * @param _devEUI
     * @param _data
     * @param _port
     * @throws Exception
     */
    public abstract void send(String _devEUI, byte[] _data, int _port) throws Exception;

    /**
     * 下发
     *
     * @param _devEUI
     * @param _data
     * @param _port
     * @param _confirmed
     * @throws Exception
     */
    public abstract void send(String _devEUI, byte[] _data, int _port, boolean _confirmed) throws Exception;

    /**
     * 连接建立事件
     *
     * @param _handler
     * @return the Connection instance
     * @throws Exception in case something goes wrong
     */
    public abstract AbstractClient onConnected(Consumer<Connection> _handler) throws Exception;

    /**
     * 错误时
     *
     * @param _handler
     * @return the Client instance
     * @throws Exception in case something goes wrong
     */
    public abstract AbstractClient onError(Consumer<Throwable> _handler) throws Exception;

    /**
     * 上行数据消息时
     *
     * @param _handler
     * @return
     */
    public abstract Client onMessage(BiConsumer<String, UplinkMessage> _handler);


}
