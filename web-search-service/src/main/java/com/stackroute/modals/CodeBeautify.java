package com.stackroute.modals;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
//class codebeautify to get the data from the api
public class CodeBeautify {

    Query queryObject;
    ArrayList<Result> organic = new ArrayList < Result > ();
    private String number_of_results = null;


    // Getter Methods

    public Query getQuery() {
        return queryObject;
    }

    public String getNumber_of_results() {
        return number_of_results;
    }

    public Query getQueryObject() {
        return queryObject;
    }

    public void setQueryObject(Query queryObject) {
        this.queryObject = queryObject;
    }

    public ArrayList<Result> getOrganic() {
        return organic;
    }

    public void setOrganic(ArrayList<Result> organic) {
        this.organic = organic;
    }

    public void setQuery(Query queryObject) {
        this.queryObject = queryObject;
    }

    public void setNumber_of_results(String number_of_results) {
        this.number_of_results = number_of_results;
    }

    //toString
    @Override
    public String toString() {
        return "CodeBeautify{" +
                "queryObject=" + queryObject +
                ", organic=" + organic +
                ", number_of_results='" + number_of_results + '\'' +
                '}';
    }
}

