package com.chf.loraserver;

import com.chf.loraserver.handler.mqttClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoraserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoraserverApplication.class, args);
//        mqttClient mqttClient = new mqttClient();
//        mqttClient.publishMessage("topic","playoud",1);
    }

}
