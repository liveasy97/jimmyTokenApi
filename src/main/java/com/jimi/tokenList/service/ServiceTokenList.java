package com.jimi.tokenList.service;

import com.jimi.tokenList.entities.tokenList;

import java.util.List;

public interface ServiceTokenList {
    public List<tokenList> getToken();
    public String saveToken(String access_token);
}
