package com.stackroute.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
public class Movie {
    // properties of movie
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Release year")
    private String year;
    @JsonProperty("Starring")
    private String starring;
    @JsonProperty("Directed by")
    private String director;
    @JsonProperty("Language")
    private String language;
    @JsonProperty("Produced by")
    private String producer;

    // no args constructor
    public Movie() {
    }

    // all args constructor
    public Movie(String title, String year, String starring, String director, String language, String producer) {
        this.title = title;
        this.year = year;
        this.starring = starring;
        this.director = director;
        this.language = language;
        this.producer = producer;
    }

    // getter and setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    // toString method
    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", starring='" + starring + '\'' +
                ", director='" + director + '\'' +
                ", language='" + language + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
