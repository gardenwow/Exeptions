package com.example.exeption;

import exceptions.WrongLengthPasswordExceptions;
import exceptions.WrongLoginExceptions;
import exceptions.WrongPasswordException;
import exceptions.WrongSimvolException;
import org.springframework.stereotype.Service;

@Service
public class ServiceLogs {
    public String exeptionLogs(String userLogin, String userPassword, String userConfirmPassword) {
        final String regex = "[A-Za-z0-9_]+";
        if (userLogin.length() > 20) {
            throw new WrongLoginExceptions("dlina logina bolee 20 simvolov");
        } else if (userPassword.length() > 20){
            throw new WrongLengthPasswordExceptions("dlina bolwe 20 simvolov");
        }
        else if (!(userLogin.matches(regex))){
            throw new WrongSimvolException("неправлиьно задан символ логина");
        }
        else if (!(userPassword.matches(regex))){
            throw new WrongSimvolException("неправлиьно задан символ пароля");
        }
        else if (!userConfirmPassword.equals(userPassword)) {
            throw new WrongPasswordException("paroli ne sovpadaut");
        }
        return "login: " + userLogin + " " + "parol: " + userPassword;
    }

}
