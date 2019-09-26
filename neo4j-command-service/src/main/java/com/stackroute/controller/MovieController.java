package com.stackroute.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.domain.Movie;
import com.stackroute.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

@RestController
public class MovieController
{

    //autowire the movieService
    @Autowired
    private MovieService movieService;
    ResponseEntity responseEntity;


    String input = "";
    ObjectMapper objectMapper = new ObjectMapper();
    Movie movie1 = new Movie();
    LinkedHashMap<String, LinkedHashMap<String, String>> all = new LinkedHashMap();

    @KafkaListener(topics = "Fetch-Keyword", groupId = "group_id")
    public void consumer(LinkedHashMap message) throws IOException
    {
        this.all = message;
        saveMovie();
    }

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // method to save json data into neo4j as nodes and relationships
    @PostMapping("/saveMovie")
    public ResponseEntity<?> saveMovie() throws IOException
    {
        int i = 0;
        for (i = 0; i < all.size(); i++)
        {

            this.movie1 = objectMapper.convertValue(all.get("" + i),Movie.class);
            String result = (movieService.saveMovie(movie1));

            if (result != null)
                responseEntity = new ResponseEntity<String>(result, HttpStatus.CREATED);

            else{
                responseEntity = new ResponseEntity<String>(result, HttpStatus.CONFLICT);
            }

        }

        return responseEntity;
    }
}