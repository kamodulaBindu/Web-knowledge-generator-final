package com.stackroute.controller;
import com.stackroute.model.Dictionaryy;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;


@RestController
@RequestMapping(value="/api/v1")
public class POSController
{
    @Autowired
    private StanfordCoreNLP stanfordCoreNLP;

    @Autowired
    Dictionaryy dictionary;
    ResponseEntity responseEntity;

    @Autowired
    private KafkaTemplate<String,HashMap> kafkaTemplate;
    private static final String TOPIC = "Search-nlp";

    String searchString="";
    @KafkaListener(topics = "SearchString", groupId = "group_id")
    public void consumer(String message) throws IOException {

        this.searchString=message;
        ner();
    }


    @PostMapping
    @RequestMapping(value="/pos")
    public HashMap<String,String> ner()
    {
        CoreDocument coreDocument = new CoreDocument(searchString+"?");
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreLabel> coreLabels=coreDocument.tokens();
        LinkedList<String> listobj = new LinkedList<String>(collectionList(coreLabels));
        HashMap<String,String> response= new HashMap<String,String>(dictionary.mapvalue(listobj));
        this.kafkaTemplate.send(TOPIC,response);
        return response;

    }

    private List<String> collectionList(List<CoreLabel> coreLabels)
    {
        List<String> res= Arrays.asList(new String[coreLabels.size()]);
        int i=0;
        String splstring = "";
        for(CoreLabel corelabel : coreLabels)
        {
            String pos=corelabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            if(pos.equals("NNP"))
            {
                splstring+=corelabel.originalText()+" ";

            }
            else if(pos.equals("NN")||pos.equals("NNS")||pos.equals("CD")||pos.equals("VBN")||pos.equals("VBD"))
            {
                if(!corelabel.originalText().equals("name")||!corelabel.originalText().trim().equals("list")||!corelabel.originalText().equals("is")) {
                    res.set(i, corelabel.originalText().trim());
                    i++;
                }
            }
            else
            {
                res.set(i,splstring.trim());
                splstring="";
                i++;
            }
        }

        return res;
    }
}