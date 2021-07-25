package com.jimi.tokenList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.jimi.tokenList.script.script;

@SpringBootApplication
public class TokenListApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TokenListApplication.class, args);

		script.call_me();
	}
}
