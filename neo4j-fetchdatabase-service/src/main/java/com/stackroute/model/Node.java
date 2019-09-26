package com.stackroute.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class Node {

    @Id
    private Object name;

    private Object type;

    public Object getName() {
        return name;
    }

    public Object getType()
    {
        return type;
    }

    public void setName(Object name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name=" + name +
                '}';
    }

    public void setType(Object type) {
        this.type = type;
    }
}
