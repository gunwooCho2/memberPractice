package com.busanit501.firstpractice.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class UserVO {
    private int userNo;
    private String userID;
    private String userPassword;
    private String userName;
    private Date registerDate;
}
