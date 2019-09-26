package com.stackroute.repository;

import com.stackroute.modal.DomainExpert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthenticationRepository extends MongoRepository<DomainExpert, String> {
    //query to find if username and password is present in mongodb
    @Query("{ 'userName' : ?0, 'userPassword' : ?1 }")
    //method to authenticate DomainExpert Credentials
     public List<DomainExpert> findByUserName(@Param("userName")String userName, @Param("userPassword") String userPassword);
}
