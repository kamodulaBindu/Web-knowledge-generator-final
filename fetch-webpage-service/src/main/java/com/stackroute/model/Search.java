package com.stackroute.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//class to get Search url

@JsonIgnoreProperties(ignoreUnknown = true)

public class Search {

  @JsonProperty("url")
   private String url;
//get method for url
    public String getUrl() {
        return url;
    }
//set method for url
    public void setUrl(String url) {
        this.url = url;
    }
//No Args Constructor
    public Search() {

            }
}
