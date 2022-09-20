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
        return "ti zashel v obrabotky isklucheniy Logs";
    }
    @GetMapping(path = "/logs")
    public String helloLogs(@RequestParam(name = "login") String userLogin,
                            @RequestParam(name = "password") String userPassword,
                            @RequestParam(name = "confirmpassword") String userConfirmPassword) {
       try{
           return serviceLogs.exeptionLogs(userLogin, userPassword, userConfirmPassword);
       } catch (WrongLoginExceptions e){
           return "dlina logina bolee 20 simvolov";
       } catch (WrongLengthPasswordExceptions e){
           return "dlina parolya bolee 20 simvolov";
       } catch (WrongPasswordException e){
           return "paroli ne sovpadaut";
       }catch (WrongSimvolException e){
           return "simvol ne korrekten";
       }
    }
}
