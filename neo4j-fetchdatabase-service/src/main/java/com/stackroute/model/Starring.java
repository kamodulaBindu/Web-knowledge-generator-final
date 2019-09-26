package com.stackroute.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Starring {

    @Id
    private String name;
    public Starring()
    {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Starring(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Starring{" +
                "name='" + name + '\'' +
                '}';
    }
}
