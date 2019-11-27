package com.asu.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AuthenticationResponse implements Serializable {

	private final String jwt;
	public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }
}
