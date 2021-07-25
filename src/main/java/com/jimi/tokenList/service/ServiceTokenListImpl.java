package com.jimi.tokenList.service;

import com.jimi.tokenList.dao.DaoTokenList;
import com.jimi.tokenList.entities.tokenList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTokenListImpl implements ServiceTokenList{

    @Autowired
    DaoTokenList daoTokenList;
    @Override
    public List<tokenList> getToken() {
        return daoTokenList.findAll();
    }

    @Override
    public String saveToken(String access_token) {
        tokenList list = new tokenList();
        list.setAccess_token(access_token);
        daoTokenList.save(list);
        return "saved";
    }
}
