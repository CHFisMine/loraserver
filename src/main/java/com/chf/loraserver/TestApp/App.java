package com.chf.loraserver.TestApp;

import com.chf.loraserver.Connection;
import com.chf.loraserver.messages.UplinkMessage;
import com.chf.loraserver.mqtt.Client;

public class App {
    public static void main(String[] args) throws Exception{
        Client client = new Client("192.168.101.185", "1", "");

        client.onMessage((String devEUI, UplinkMessage data) -> {
            try {
                byte[] received = data.getData();
                System.out.println("收到:devEUI=" + " 数据: " + bytesToHex(received));

                // 下发
                System.out.println("下发 led ");
                client.send(devEUI, "led".getBytes(), 1);
            } catch (Exception ex) {
                System.out.println("异常: " + ex.getMessage());
            }
        });

        client.onError((Throwable _error) -> System.err.println("error: " + _error.getMessage()));

        client.onConnected((Connection _client) -> System.out.println("connected !"));

        client.start();
    }

    /**
     * byte array to hex string
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if(hex.length() < 2){
                sb.append(0);
            }
            sb.append(hex);
            sb.append(" ");
        }
        return sb.toString();
    }

}
