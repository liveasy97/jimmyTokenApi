package com.jimi.tokenList.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@Entity
@Table(name = "tokenList")
@Data
public class tokenList {
    @Id
    private String type = "tokenList";
    private String access_token;

}
