package com.stackroute.service;

import java.net.URISyntaxException;


//Interface
public interface WebSearchService {
    //method to search and get the links from the api
    String getSearchResults(String searchString) throws URISyntaxException;
    //method to save the links
    // Result saveResults(Result resultList) throws URISyntaxException;
}