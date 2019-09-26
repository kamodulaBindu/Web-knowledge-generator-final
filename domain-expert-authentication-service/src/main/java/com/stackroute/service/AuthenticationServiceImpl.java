package com.stackroute.service;

import com.stackroute.modal.DomainExpert;
import com.stackroute.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {


    /* No Argument Constructor for the class */

    @Autowired
    public AuthenticationServiceImpl() {
    }


    @Autowired
    AuthenticationRepository authenticationRepository;

    @Override
    public boolean authenticateDomainExpert(String userName, String password) {
        List<DomainExpert> domainExpert=authenticationRepository.findByUserName(userName,password);

        if(domainExpert.isEmpty()){
            return false;

        }else {
            return true;
        }

    }
}