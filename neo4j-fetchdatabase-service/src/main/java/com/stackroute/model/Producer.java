package com.stackroute.model;


import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Producer {
    private String name;
    public Producer()
    {

    }

    public Producer(String name) {
        this.name = name;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "name='" + name + '\'' +
                '}';
    }
}
