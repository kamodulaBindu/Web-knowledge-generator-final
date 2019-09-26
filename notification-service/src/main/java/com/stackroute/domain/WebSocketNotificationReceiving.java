package com.stackroute.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebSocketNotificationReceiving {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WebSocketNotificationReceiving(String name) {
        this.name = name;
    }
    public WebSocketNotificationReceiving() {
    }
}
