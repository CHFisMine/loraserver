package com.chf.loraserver.mqtt;

import com.chf.loraserver.AbstractClient;
import com.chf.loraserver.Connection;
import com.chf.loraserver.events.EventHandler;
import com.chf.loraserver.messages.UplinkMessage;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Client extends AbstractClient {

    /**
     * 连接相关信息
     */
    private final String broker;
    private final String appId;
    private MqttClientPersistence persistence = new MemoryPersistence();
    private final MqttConnectOptions connOpts;

    /**
     * 事件
     */
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final Map<Class, List<EventHandler>> handlers = new HashMap<>();

    /**
     * 连接实例
     */
    private MqttClient mqttClient;

    /**
     * 构建
     *
     * @param _broker MQTT服务器
     * @param _appId loraserver 中applicationId 同时是 mqtt 用户名
     * @param _appAccessKey 密码
     * @throws java.net.URISyntaxException
     */
    public Client(String _broker, String _appId, String _appAccessKey) throws URISyntaxException {
        this(_broker, _appId, _appAccessKey, null);
    }

    /**
     * 构建
     *
     * @param _broker MQTT服务器
     * @param _appId loraserver 中applicationId 同时是 mqtt 用户名
     * @param _appAccessKey 密码
     * @param _connOpts MQTT 连接选项
     * @throws java.net.URISyntaxException
     */
    public Client(String _broker, String _appId, String _appAccessKey, MqttConnectOptions _connOpts) throws URISyntaxException {
        broker = validateBroker(_broker);
        appId = _appId;
        if (_connOpts != null) {
            connOpts = _connOpts;
        } else {
            connOpts = new MqttConnectOptions();
        }
        connOpts.setUserName(_appId);
        connOpts.setPassword(_appAccessKey.toCharArray());
    }

    private String validateBroker(String _source) throws URISyntaxException {

        URI tempBroker = new URI(_source);

        if ("tcp".equals(tempBroker.getScheme())) {
            if (tempBroker.getPort() == -1) {
                return tempBroker.toString() + ":1883";
            } else {
                return tempBroker.toString();
            }
        } else if ("ssl".equals(tempBroker.getScheme())) {
            if (tempBroker.getPort() == -1) {
                return tempBroker.toString() + ":8883";
            } else {
                return tempBroker.toString();
            }
        } else if (tempBroker.getPort() != -1) {
            return "tcp://" + tempBroker.toString();
        } else {
            return "tcp://" + tempBroker.toString() + ":1883";
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public AbstractClient start() throws Exception {
        return null;
    }

    @Override
    public AbstractClient end() throws Exception {
        return null;
    }

    @Override
    public AbstractClient end(long _timeout) throws Exception {
        return null;
    }

    @Override
    public AbstractClient endNow() throws Exception {
        return null;
    }

    @Override
    public void send(String _devEUI, byte[] _data, int _port) throws Exception {

    }

    @Override
    public void send(String _devEUI, byte[] _data, int _port, boolean _confirmed) throws Exception {

    }

    @Override
    public AbstractClient onConnected(Consumer<Connection> _handler) throws Exception {
        return null;
    }

    @Override
    public AbstractClient onError(Consumer<Throwable> _handler) throws Exception {
        return null;
    }

    @Override
    public Client onMessage(BiConsumer<String, UplinkMessage> _handler) {
        return null;
    }
}
