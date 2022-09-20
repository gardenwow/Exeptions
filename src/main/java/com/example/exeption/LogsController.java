package com.example.exeption;

import exceptions.WrongLengthPasswordExceptions;
import exceptions.WrongLoginExceptions;
import exceptions.WrongPasswordException;
import exceptions.WrongSimvolException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogsController {

    private final ServiceLogs serviceLogs;

    public LogsController(ServiceLogs logs) {
        this.serviceLogs = logs;
    }
    @GetMapping
    public String hello(){
        return "you've logged into exception handling";
    }
    @GetMapping(path = "/logs")
    public String helloLogs(@RequestParam(name = "login") String userLogin,
                            @RequestParam(name = "password") String userPassword,
                            @RequestParam(name = "confirmpassword") String userConfirmPassword) {
       try{
           return serviceLogs.exeptionLogs(userLogin, userPassword, userConfirmPassword);
       } catch (WrongLoginExceptions e){
           return "login length is more than 20 characters";
       } catch (WrongLengthPasswordExceptions e){
           return "password length is more than 20 characters";
       } catch (WrongPasswordException e){
           return "passwords dont match";
       }catch (WrongSimvolException e){
           return "the symbol is not correct";
       }
    }
}
