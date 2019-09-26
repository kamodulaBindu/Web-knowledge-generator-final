package com.stackroute.modal;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "credentials")
public class DomainExpert {


    String userName;
    String userPassword;

    public DomainExpert() {
    }

    public DomainExpert(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "DomainExpert{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        userName = userName;
    }

    public String getPassword() {
        return userPassword;
    }

    public void setPassword(String password) {
        userPassword = password;
    }
}