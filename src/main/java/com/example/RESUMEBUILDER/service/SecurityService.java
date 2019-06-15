package com.example.RESUMEBUILDER.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
