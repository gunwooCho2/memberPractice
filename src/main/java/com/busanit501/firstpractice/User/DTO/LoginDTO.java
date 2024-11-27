package com.busanit501.firstpractice.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginDTO {
    private String userID;
    private String userPassword;
}
