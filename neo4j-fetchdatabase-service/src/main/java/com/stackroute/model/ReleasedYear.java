package com.stackroute.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class ReleasedYear {
    private String year;
    public ReleasedYear()
    {

    }
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ReleasedYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "ReleasedYear{" +
                "year='" + year + '\'' +
                '}';
    }
}
