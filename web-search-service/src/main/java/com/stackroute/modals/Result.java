package com.stackroute.modals;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

//class result to get links and positions
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

  private String url;

  public Result(String url) {
    this.url = url;
  }

  public Result() {
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString()
  {
    return url ;
  }
}