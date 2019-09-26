package com.stackroute.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Director {
    private String name;
    public Director()
    {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Director(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                '}';
    }
}
