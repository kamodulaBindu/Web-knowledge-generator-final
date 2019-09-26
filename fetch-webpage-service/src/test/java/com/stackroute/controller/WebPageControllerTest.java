package com.stackroute.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.FetchWebPage;
import com.stackroute.model.Search;
import com.stackroute.service.WebPageService;
import com.stackroute.service.WebPageServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;





@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WebPageControllerTest.class)
@WebMvcTest(WebPageController.class)
public class WebPageControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private Search search;

    private String data;

    @MockBean
    private WebPageService webPageService;

    @InjectMocks
    private WebPageController webPageController;

    private List<Search> list= null;

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @Before
    public void setUp() throws Exception{
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(webPageController).build();
        search = new Search();
        search.setUrl("https://en.wikipedia.org/wiki/Google");
        webPageController.consumedUrl = "https://en.wikipedia.org/wiki/Kabir_Singh";
    }

    @Test
    public void getAllContentSuccess() throws Exception {
        when(webPageService.getHeading(any())).thenReturn("");
        when(webPageService.getAllPTextsFromBody(any())).thenReturn("");

        mockMvc.perform(get("/getContent")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON)
                .content((asJsonString(data))))
                .andExpect(status().isOk())
                .andDo(print());
    }

    private String asJsonString(String data) throws JsonProcessingException {
        try {
            return new ObjectMapper().writeValueAsString(data);
        }
        catch (Exception e) {
            throw new RuntimeException();
        }
    }



}