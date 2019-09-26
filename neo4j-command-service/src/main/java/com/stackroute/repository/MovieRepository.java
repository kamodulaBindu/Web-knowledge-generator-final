package com.stackroute.repository;

import com.stackroute.domain.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;


import java.util.Collection;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    // method to save movie into neo4j database
    @Query("FOREACH ( ignoreMe in CASE WHEN  {title}<>'null' AND {starring}<>'null' AND {year}<>'null' AND {director}<>'null' THEN [1]\n" +
            " ELSE [] END | " +
            "MERGE (movie:Movie {title: {title}}))\n" +

            "WITH {language} as l UNWIND split({language}, ',') AS languag\n" +
            "FOREACH ( ignoreMe in CASE WHEN  {title}<>'null' AND {starring}<>'null' AND {year}<>'null' AND {director}<>'null' THEN [1]\n" +
            "ELSE [] END | " +
            "MERGE (varLanguage:Language {name: languag}))\n" +
            "WITH {language} as lang\n" +
            "MATCH (movie:Movie {title: {title}})\n" +
            "UNWIND split({language}, ',') AS matchedLanguage\n" +
            "MATCH (varMatchedLanguage:Language {name: matchedLanguage})\n" +
            "MERGE (movie)-[r:HAS_LANGUAGE]->(varMatchedLanguage)\n" +
            "MERGE (movie)<-[rb:LANGUAGE_OF]-(varMatchedLanguage)\n" +

            "WITH {director} as d UNWIND split({director}, ',') AS director\n" +
            "FOREACH ( ignoreMe in CASE WHEN  {title}<>'null' AND {starring}<>'null' AND {year}<>'null' AND {director}<>'null' THEN [1]\n" +
            "ELSE [] END | " +
            "MERGE (varDirector:Director {name: director}))\n" +
            "WITH {director} as dir\n" +
            "MATCH (movie:Movie {title: {title}})\n" +
            "UNWIND split({director}, ',') AS matchedDirector\n" +
            "MATCH (varMatchedDirector:Director {name: matchedDirector})\n" +
            "MERGE (movie)-[r:DIRECTED_BY]->(varMatchedDirector)\n" +
            "MERGE (movie)<-[rb:DIRECTED]-(varMatchedDirector)\n" +

            "WITH {producer} as p UNWIND split({producer}, ',') AS producer\n" +
            "FOREACH ( ignoreMe in CASE WHEN  {title}<>'null' AND {starring}<>'null' AND {year}<>'null' AND {director}<>'null' THEN [1]\n" +
            "ELSE [] END | " +
            "MERGE (varProducer:Producer {name: producer}))\n" +
            "WITH {producer} as pro\n" +
            "MATCH (movie:Movie {title: {title}})\n" +
            "UNWIND split({producer}, ',') AS matchedProducer\n" +
            "MATCH (varMatchedProducer:Producer {name: matchedProducer})\n" +
            "MERGE (movie)-[r:PRODUCED_BY]->(varMatchedProducer)\n" +
            "MERGE (movie)<-[rb:PRODUCED]-(varMatchedProducer)\n" +

            "WITH {starring} as s UNWIND split({starring}, ',') AS starring \n" +
            "FOREACH ( ignoreMe in CASE WHEN  {title}<>'null' AND {starring}<>'null' AND {year}<>'null' AND {director}<>'null' THEN [1]\n" +
            "ELSE [] END | " +
            "MERGE (varStarring:Starring {name: starring}))\n" +
            "WITH {starring} as star\n" +
            "MATCH (movie:Movie {title: {title}})\n" +
            "UNWIND split({starring}, ',') AS matchedStarring\n" +
            "MATCH (varMatchedStarring:Starring {name: matchedStarring})\n" +
            "MERGE (movie)-[r:HAS_CAST]->(varMatchedStarring)\n" +
            "MERGE (movie)<-[rb:CASTED_IN]-(varMatchedStarring)\n" +

            "WITH {year} as y\n" +
            "FOREACH ( ignoreMe in CASE WHEN  {title}<>'null' AND {starring}<>'null' AND {year}<>'null' AND {director}<>'null' THEN [1]\n" +
            "ELSE [] END | " +
            "MERGE (year:ReleasedYear {year: {year}}))\n" +
            "WITH {year} as ye\n" +
            "MATCH (movie:Movie {title: {title}})\n" +
            "MATCH (year:ReleasedYear {year: {year}})\n" +
            "MERGE (movie)-[r:RELEASED_IN]->(year)\n" +
            "MERGE (movie)<-[rb:HAS_MOVIE]-(year);")
    public String saveMovie(String title, String starring, String year, String director, String producer, String language);

    // method to get movie by title from neo4j database
    @Query("MATCH (m:Movie{title:{title}}) RETURN m.title")
    public String getMovieByTitle(String title);
}
