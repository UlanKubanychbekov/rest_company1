package com.example.rest_company.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * author: Ulansky
 */
@Getter @Setter
public class RegisterRequest {

    private String email;

    private String password;
}
