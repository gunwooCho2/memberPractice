package com.busanit501.firstpractice.User.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterDTO {
    private String userID;
    private String userPassword;
    private String userName;

    public RegisterDTO(String userID,  String userPassword, String userName) {
        this.userID = scaleStr(userID, 20);
        this.userPassword = scaleStr(userPassword, 20);
        this.userName = scaleStr(userName, 15);
    }

    public String scaleStr(String str, int maxLength) {
        str = str.trim();
        str = str.length() > maxLength ? str.substring(0, maxLength) : str;
        return str;
    }
}
