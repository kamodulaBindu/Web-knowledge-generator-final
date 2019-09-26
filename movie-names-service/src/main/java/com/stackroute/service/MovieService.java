package com.stackroute.service;
import com.stackroute.model.Movie;

public interface MovieService
{
    //method to store movie name
    Movie saveMovie(Movie movie);

    //method to search if movie already present
    public Movie searchByMovieName(String name);
}
