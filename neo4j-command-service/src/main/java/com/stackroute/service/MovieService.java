package com.stackroute.service;

import com.stackroute.domain.Movie;

public interface MovieService {

  // method to save movie in neo4j database
  String saveMovie(Movie movie);
}