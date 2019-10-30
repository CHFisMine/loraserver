package com.chf.loraserver.messages;

/**
 * 上行数据消息
 */
public class UplinkMessage implements DataMessage {
    private String payloadRaw;
    private byte[] data;

    public UplinkMessage(String _payloadRaw, byte[] _data) {
        payloadRaw = _payloadRaw;
        data = _data;
    }

    public byte[] getData() {
        return data;
    }

    public String getPayloadRaw() {
        return payloadRaw;
    }
}
