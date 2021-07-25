package com.jimi.tokenList.controller;

import com.jimi.tokenList.entities.tokenList;
import com.jimi.tokenList.service.ServiceTokenList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    com.jimi.tokenList.script.script script;
    @Autowired
    private ServiceTokenList serviceTokenList;

    @GetMapping("/token")
    private List<tokenList> getToken(){
        return serviceTokenList.getToken();
    }
    @PostMapping("/token")
    private String saveToken(@RequestBody String access_token){
        serviceTokenList.saveToken(access_token);
        return "Done";
    }
}
