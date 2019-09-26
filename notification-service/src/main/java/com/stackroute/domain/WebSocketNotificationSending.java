package com.stackroute.domain;

public class WebSocketNotificationSending {
    private String content;
    public WebSocketNotificationSending() {
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WebSocketNotificationSending(String content) {
        this.content = content;
    }

}
