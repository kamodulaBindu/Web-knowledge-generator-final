package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovieServiceImpl implements MovieService{

    // autowire the movieRepository
    @Autowired
    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    // method to save movie in neo4j database
    @Override
    public String saveMovie(Movie movie) {

        // call repository method to save movie
        movieRepository.saveMovie(movie.getTitle(),movie.getStarring(),movie.getYear(),movie.getDirector(),movie.getProducer(),movie.getLanguage());
        // return the title of saved movie
        return movieRepository.getMovieByTitle(movie.getTitle());
    }
}