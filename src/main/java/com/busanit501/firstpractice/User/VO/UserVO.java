package com.busanit501.firstpractice.User.VO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@Builder
@ToString
public class UserVO {
    private int userNo;
    private String userID;
    private String userPassword;
    private String userName;
    private Date registerDate;
    private String userUUID;
}
