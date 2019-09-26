package com.stackroute.repository;

import com.stackroute.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface MovieRepository extends MongoRepository<Movie, String>
{

    //Query to store movie name in mongodbs
    @Query("{name : ?0}")
    public Movie findByMovieName(@Param("movie") String movie);

}
