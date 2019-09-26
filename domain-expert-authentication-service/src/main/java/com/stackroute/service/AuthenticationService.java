package com.stackroute.service;


public interface AuthenticationService {
    //method to check if the DomainExpert Credentials are correct or not
    public boolean authenticateDomainExpert(String userName, String password);
}
