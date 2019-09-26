//package com.stackroute.service;
//
//import com.stackroute.modals.Result;
//import com.stackroute.repository.SearchRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.net.URISyntaxException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.mockito.internal.verification.VerificationModeFactory.times;
//
//public class WebSearchServiceImplTest {
//
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Mock
//    SearchRepository searchRepository;
//
//    @InjectMocks
//    WebSearchServiceImpl webSearchService;
//
//    Result result;
//
//    Result result1;
//
//    List<Result> resultList;
//
//    @Before
//    public void setup()
//    {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(webSearchService).build();
//        resultList = new ArrayList<>();
//        result= new Result(1,"https://www.fandango.com/movies-in-theaters");
//        result1= new Result(2,"https://www.indigo.com/movies-in-theaters");
//        resultList.add(result);
//        resultList.add(result1);
//    }
//
//    @Test
//    public void saveResultsTest() throws Exception
//    {
//        when(searchRepository.save(result)).thenReturn(result);
//        List<Result> savedresults = webSearchService.saveResults(resultList);
//        Assert.assertEquals(resultList,savedresults);
//        verify(searchRepository,times(1)).save(Mockito.any(Result.class));
//      //  verify(trackRepository,times(1)).existsById(1);
//        verifyNoMoreInteractions(searchRepository);
//    }
//
////    @Test
////    public void getSearchResultsTest() throws URISyntaxException
////    {
////        when(searchRepository.save(result)).thenReturn(result);
////        List<Result> retrievedTracks = webSearchService.getSearchResults("movie");
////        Assert.assertEquals(resultList,retrievedTracks);
////       verify(searchRepository,times(1)).findAll();
////        verifyNoMoreInteractions(searchRepository);
////    }
//}
