package com.jimi.tokenList.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import com.jimi.tokenList.entities.tokenList;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoTokenList extends JpaRepository<tokenList, UUID> {
}
