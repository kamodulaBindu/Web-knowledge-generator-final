package com.stackroute.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Language {
    private String name;
    public Language()
    {

    }
    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }



    public Language(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Language{" +
                "name='" + name + '\'' +
                '}';
    }
}
