package com.stackroute.model;


import org.springframework.data.annotation.Id;

public class Movie
{

    //Movie names from csv file
    @Id
    private String name;

    public Movie() {
    }

    public Movie( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
