package com.stackroute.repository;

import com.stackroute.modals.Result;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//repository extending mongo repository to save links in mongo database
@Repository
public interface SearchRepository extends MongoRepository<Result, Integer>
{
}
