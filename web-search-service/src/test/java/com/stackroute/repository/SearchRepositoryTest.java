//package com.stackroute.repository;
//
//import com.stackroute.modals.Result;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class SearchRepositoryTest {
//
//    @Autowired
//    SearchRepository searchRepository;
//
//    Result result;
//
//    @Before
//    public void setUp()
//    {
//        result = new Result(1,"https://www.fandango.com/movies-in-theaters");
//    }
//
//    @After
//    public void tearDown(){
//
//        searchRepository.deleteAll();
//    }
//
//    @Test
//    public void testSaveTrack(){
//        searchRepository.save(result);
//        Result fetchresult = searchRepository.findById(result.getPosition()).get();
//        Assert.assertEquals(1,fetchresult.getPosition());
//    }
//
//}
