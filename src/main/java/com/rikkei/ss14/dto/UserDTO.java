package com.rikkei.ss14.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
}