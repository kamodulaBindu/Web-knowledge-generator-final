package com.stackroute.controller;

import com.stackroute.App;
import com.stackroute.controller.AuthenticationController;
import com.stackroute.modal.DomainExpert;
import com.stackroute.service.AuthenticationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = App.class)
@WebMvcTest
public class AuthenticationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private DomainExpert domainExpert;

    //Inject the mocks as dependencies into UserServiceImpl
    @MockBean
    private AuthenticationService authenticationService;

    @InjectMocks
    private AuthenticationController authenticationController;

    private List<DomainExpert> list= null;

    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(authenticationController).build();
        domainExpert = new DomainExpert();
        domainExpert.setUserName("expert");
        domainExpert.setPassword("expert");
        list = new ArrayList<>();
        list.add(domainExpert);
    }

    @Test
    public void updateTrack() throws Exception {
        when(authenticationService.authenticateDomainExpert((domainExpert.getUserName()), domainExpert.getPassword())).thenReturn(true);

        mockMvc.perform(get("/api/v1"));

    }
}