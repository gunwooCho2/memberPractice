package com.busanit501.firstpractice.User.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDTO {
    private String userID;
    private String userPassword;

    public LoginDTO(String userID, String userPassword) {
        this.userID = scaleStr(userID, 20);
        this.userPassword = scaleStr(userPassword, 20);
    }

    public String scaleStr(String str, int maxLength) {
        str = str.trim();
        str = str.length() > maxLength ? str.substring(0, maxLength) : str;
        return str;
    }
}
