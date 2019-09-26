package com.stackroute.core;


import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class Pipeline {
    private static Properties properties;
    //Annotators of coreNLP used
    private static String propertiesName="tokenize, ssplit, pos, lemma, ner";
    private static StanfordCoreNLP stanfordCoreNLP;


    private Pipeline()
    {

    }

    //executed only once, before any constructor
    static {
        properties = new Properties();
        properties.setProperty("annotators", propertiesName);
    }


    @Bean(name = "stanfordCoreNLP")
    public  static StanfordCoreNLP getPipeline()
    {
        if(stanfordCoreNLP == null)
        {
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }
}