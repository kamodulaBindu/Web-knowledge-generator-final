package com.stackroute.controller;


import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController

//Creates the base url
@RequestMapping(value="/api/v1")
public class POSController {

    @Autowired
    private StanfordCoreNLP stanfordCoreNLP;
    String input="";
    @KafkaListener(topics = "Fetch_Webpage", groupId = "group_id")
    public void consumer(String message) throws IOException
    {

        this.input=message;
        ner(input);

    }

    @Autowired
    private KafkaTemplate<String,LinkedHashMap> kafkaTemplate;
    private static final String TOPIC = "Fetch-Keyword";


    @GetMapping
    @RequestMapping(value="/pos")
    public LinkedHashMap<Integer,LinkedHashMap<String,String>> ner(String datanew)
    {
        String data=input;
        int j;
        int k=0;
        String[] contentarr  = data.split("\n");
        LinkedHashMap<String,String> collect;
        LinkedHashMap<Integer,LinkedHashMap<String,String>> all = new LinkedHashMap<>();
        LinkedList<LinkedHashMap<String,String>> list = new LinkedList();
        for(j=0;j<contentarr.length;j++){
            collect=new LinkedHashMap<>();
            //String is converted to string array
            String content=contentarr[j].toString();
            String[] nodes=content.split("%");
            nodes[0]=" ";
            int flag=0;
            for(int i=0;i<nodes.length;i++){
                if(!nodes[i].equals(" ")&&flag==0)
                {
                    //put is used to add key-value pairs in LinkedHashMap
                    collect.put("Title",nodes[i]);
                    flag+=1;
                }
                if(nodes[i].trim().equals("Directed by")||nodes[i].trim().equals("Produced by")||nodes[i].trim().equals("Starring"))
                {
                    String activity=nodes[i].trim();
                    String directors=giveDirectors(nodes,i+1);
                    collect.put(activity,directors.substring(0,directors.length()-1));
                }
                if(nodes[i].trim().equals("Release date"))
                {
                    String date=giveDate(nodes,i+1);
                    collect.put("Release year",date.substring(date.length()-4));
                }
                if(nodes[i].trim().equals("Language"))
                {
                    String lang=giveDate(nodes,i+1);
                    collect.put("Language",lang);
                }

            }
             if(collect.size() != 0) {
                all.put(k++, collect);
            }

        }
        //produce map object to kafka
        this.kafkaTemplate.send(TOPIC,all);
        return all;
    }


    //Method to extract values for each key
    public static String giveDirectors(String[] nodes, int posn)
    {
        String names="";
        for(int i=posn;i<nodes.length;i++)
        {

            if(!nodes[i].equals(" "))
            {

                if (nodes[i].trim().equals("Based on")||nodes[i].trim().equals("Story by")||nodes[i].trim().equals("Produced by")||nodes[i].trim().equals("Written by")||nodes[i].trim().equals("Music by")||nodes[i].trim().equals("Screenplay by"))
                {
                    break;
                }
                else
                {
                    names += nodes[i].trim() + ",";
                }
            }
        }
        return names;
    }

    //Method to extract value for Released year
    public static String giveDate(String[] nodes, int posn)
    {

        String date="";
        for(int i=posn;i<nodes.length;i++)
        {
            if(!nodes[i].equals(" "))
            {
                date+=nodes[i];
                break;
            }
        }
        return date;
    }
}