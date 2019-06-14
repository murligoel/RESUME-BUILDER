package com.example.RESUMEBUILDER;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
