package com.stackroute.controller;


import com.stackroute.service.WebPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;


//controller to fetch websiteData
@RestController
public class WebPageController {
    private WebPageService webPageService;
    public WebPageController(WebPageService webPageService) {
        this.webPageService = webPageService;
    }

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    private static final String TOPIC = "Fetch_Webpage";
    public String consumedUrl;
    @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
    public void consumer(String url) throws IOException {
        this.consumedUrl=url;
        getAllContent();
    }

    //getMapping to fetch the reqiured contents from the url
    @GetMapping("getContent")
    //Controller method to return the data
    public ResponseEntity<String> getAllContent() throws IOException {
        ResponseEntity responseEntity;
        String url=this.consumedUrl;
        String[] urlarr  = url.replace("\"","").replace("[","").replace("]","").split(",");
        String result = "";
        int i;
        for(i=0;i<urlarr.length;i++){
            result = result + webPageService.getTableData(urlarr[i])+"\n\n\n" ;
        };
        responseEntity = new ResponseEntity<String>(result,HttpStatus.OK);
        this.kafkaTemplate.send(TOPIC,result);
        return responseEntity;
    }
}
