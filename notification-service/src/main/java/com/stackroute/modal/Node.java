package com.stackroute.modal;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.annotation.QueryResult;
@JsonIgnoreProperties(ignoreUnknown = true)
@QueryResult

public class Node {

    @Id
    @JsonProperty("name")
    private Object name;

    @JsonProperty("type")
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
