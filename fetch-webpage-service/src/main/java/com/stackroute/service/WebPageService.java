package com.stackroute.service;

import java.io.IOException;

public interface WebPageService {
    //Method to fetch the whole html source code from the url.
    public String getSourceCodeOfWebPage(String url) throws IOException;
    //Method to fetch the data in <p> tags.
    public String getAllPTextsFromBody(String url) throws IOException;
    //Method to fetch the title of the website.
    public String getTitle(String url) throws IOException;
    //Method to fetch the body content of the website
    public String getBody(String url) throws IOException;
    //Method to fetch the headings of the website
    public String getHeading(String url) throws IOException;
    //Method to fetch the Image data from the webSite.
    public String getImages(String url) throws IOException;
    //Method to fetch the form information from the website
    public String getForm(String url) throws IOException;
    //Method to fetch the <a href> tags data from the website
    public  void getLinks(String url) throws IOException;
    public String getTableData(String url) throws IOException;
}
