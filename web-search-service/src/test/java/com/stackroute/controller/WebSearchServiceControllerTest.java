//package com.stackroute.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.modals.Result;
//import com.stackroute.service.WebSearchService;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.mockito.internal.verification.VerificationModeFactory.times;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//public class WebSearchServiceControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Mock
//    WebSearchService webSearchService;
//
//    public Result result;
//
//    @InjectMocks
//    WebSearchServiceController webSearchServiceController;
//
//    List<Result> resultList;
//
//    @Before
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(webSearchServiceController).build();
//        resultList = new ArrayList<>();
//        Result result= new Result(1,"https://www.fandango.com/movies-in-theaters");
//        Result result1= new Result(2,"https://www.indigo.com/movies-in-theaters");
//        resultList.add(result);
//        resultList.add(result1);
//    }
//
//    @Test
//    public void saveResultsTest() throws Exception {
//        when(webSearchService.saveResults(resultList)).thenReturn(resultList);
//        mockMvc.perform(post("/result")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(resultList)))
//                .andExpect(status().isOk());
//        verify(webSearchService, times(1)).saveResults(Mockito.anyListOf(Result.class));
//        verifyNoMoreInteractions(webSearchService);
//    }
//
////    @Test
////    public void searchResultsTest() throws Exception {
////        when(webSearchService.getSearchResults("movie")).thenReturn(resultList);
////        when(webSearchService.saveResults(resultList)).thenReturn(resultList);
////        mockMvc.perform(get("/search/?searchString=movie")
////                .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk());
////
////        verify(webSearchService, times(1)).getSearchResults(Mockito.anyString());
////    }
//
//    private static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
