package com.stackroute.controller;

import com.stackroute.modals.Result;
import com.stackroute.service.WebSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;


//controller to get links from the api
@RestController
@ControllerAdvice(basePackages = "com.stackroute")
public class WebSearchServiceController {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    private Result result;
    private static final String TOPIC = "Kafka_Example";

    @Autowired
    private WebSearchService searchService;

    String input;
    @KafkaListener(topics = "Fetch_Moviename", groupId = "group_id")
    public void consumer(String message) throws IOException,URISyntaxException {

        this.input=message;
        getSearchResults(input);
    }


    public WebSearchServiceController(WebSearchService searchService) {
        this.searchService = searchService;
    }

    //getMapping to get the links from the api
    @GetMapping("/search")
    public ResponseEntity<String> getSearchResults(String searchString1) throws URISyntaxException
    {
        String searchString=input;
        int i;
        String url;
        ArrayList<String> urlarr = new ArrayList<>();
        String [] stringarr = searchString.replace(" ","_").replace("\"","").split(",");
        for(i=0;i<stringarr.length;i++)
        {
            url = searchService.getSearchResults(stringarr[i]);
            urlarr.add(url);
        }

        this.kafkaTemplate.send(TOPIC,urlarr);
        return new ResponseEntity<String>(searchService.getSearchResults(null), HttpStatus.OK);
    }

}