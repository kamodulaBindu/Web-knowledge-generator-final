package com.stackroute.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.neo4j.annotation.QueryResult;
import java.util.Collection;
import java.util.HashMap;

@QueryResult
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    @JsonProperty("node")
    Collection<Node> node;

  @JsonProperty("suggestions")
    HashMap<String,String> suggestions;
    public Result()
    {
    }
    public Result(Collection<Node> node, HashMap<String, String> suggestions) {
        this.node = node;
        this.suggestions = suggestions;
    }
    public Collection<Node> getNode() {
        return node;
    }
    public void setNode(Collection<Node> node) {
        this.node = node;
    }
    public HashMap<String, String> getSuggestions() {
        return suggestions;
    }
    public void setSuggestions(HashMap<String, String> suggestions) {
        this.suggestions = suggestions;
    }
    @Override
    public String toString() {
        return "Result{" +
                "node=" + node +
                ", suggestions=" + suggestions +
                '}';
    }
}
