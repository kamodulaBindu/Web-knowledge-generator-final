package com.stackroute.modals;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Query {
    private String string;
    private String language;
    private String country_code;
    private String location;
    private String search_engine;
    private String apikey;
    private String url;

    //default constructor
    public Query() {
    }

 // Getter Methods

    public String getString() {
        return string;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getLocation() {
        return location;
    }

    public String getSearch_engine() {
        return search_engine;
    }

    public String getApikey() {
        return apikey;
    }

    public String getUrl() {
        return url;
    }

    // Setter Methods

    public void setString(String string) {
        this.string = string;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSearch_engine(String search_engine) {
        this.search_engine = search_engine;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}


