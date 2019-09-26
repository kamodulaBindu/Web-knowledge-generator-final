package com.stackroute.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.domain.WebSocketNotificationReceiving;
import com.stackroute.domain.WebSocketNotificationSending;
import com.stackroute.modal.Result;
import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;

@Controller
//STOMP messages routed to @Controller classes
@RestController
public class WebSocketNotificationController
{

    private static final String TOPIC = "SearchString";

    private WebSocketNotificationSending webSocketNotificationSending;
    String data [];
    String input="";
    Result node=new Result();
    String resultMapper;
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @KafkaListener(topics = "SearchResult", groupId = "group_id")
    public void consumer(String mapper) throws IOException
    {
        input = mapper;
        Result node1 = objectMapper.readValue(mapper, Result.class);
        this.node=node1;
    }

    @MessageMapping("/search")
    @SendTo("/topic/result")
    @CrossOrigin("*")
    public WebSocketNotificationSending webSocketNotificationSending(WebSocketNotificationReceiving webSocketNotificationReceiving) throws Exception
    {
        String searchString = HtmlUtils.htmlEscape(webSocketNotificationReceiving.getName());
        System.out.println("incoming message is "+searchString);
        this.kafkaTemplate.send(TOPIC,searchString);
        System.out.println(input);
        Thread.sleep(4000);
        if(!input.equals(""))
        {
            return new WebSocketNotificationSending(HtmlUtils.htmlEscape("") + input);
        }
        input="";
        return new WebSocketNotificationSending("Result Not Found");
    }

    }
