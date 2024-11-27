package com.busanit501.firstpractice.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RegisterDTO {
    private String userID;
    private String userPassword;
    private String userName;
}
