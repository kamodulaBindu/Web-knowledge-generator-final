//package com.stackroute.controller;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//
//import static org.junit.Assert.assertEquals;
//
//public class POSControllerTest
//{
//    POSController ob;
//
//    @Before
//    public void setup() throws Exception
//    {
//        ob=new POSController();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        ob=null;
//    }
//
//    @Test
//    public void givenAStringProgramShouldReturnVariousParts()
//    {
//        String input="% % % %Saaho% % % % % Theatrical release poster% % % % %Directed by% %Sujeeth% % % %Produced by% % % % %Vamsi Krishna Reddy% %Pramod Uppalapati% %Bhushan Kumar% % % % % %Written by% % % % %Sujeeth% %% %K. G. R. Ashok% %% %Abbas Dalal% %Hussain Dalal% %% % % % % %Starring% % % % %Prabhas% %Shraddha Kapoor% % % % % %Music by% % % % %Songs:% %Tanishk Bagchi% %Guru Randhawa% %Badshah% %Shankar–Ehsaan–Loy% %Score:% %Ghibran%% % % % % %Cinematography% %R. Madhi% % % %Edited by% %A. Sreekar Prasad% % % % % Production% %company % % % % % % %UV Creations% %T-Series% % % % % % % %Distributed by% %AA Films% %Yash Raj Films%Phars Film %% % % % % Release date% % % % % % %30August2019%%% % % % % % % % Running time% % %170 minutes%% % % %Country% %India% % % %Language% % % % %Hindi% %Tamil% %Telugu% % % % % %Budget% %₹%350 crore%% % % %Box office% %est.% %₹%400 crore%% % %";
//        LinkedHashMap<String,String> result=ob.ner(input);
//        LinkedHashMap<String,String> actual=new LinkedHashMap<>();
//        actual.put("title","Saaho");
//        actual.put("Directed by","Sujeeth");
//        actual.put("Produced by","Vamsi Krishna Reddy,Pramod Uppalapati,Bhushan Kumar");
//        actual.put("Release year","2019");
//        actual.put("Starring","Prabhas,Shraddha Kapoor");
//        assertEquals(actual,result);
//    }
//
//}
