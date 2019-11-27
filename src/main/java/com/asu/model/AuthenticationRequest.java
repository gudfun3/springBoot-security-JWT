package com.asu.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AuthenticationRequest implements Serializable {

	private String username;
    private String password;
    
    public AuthenticationRequest(){
    }

    public AuthenticationRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }
}
