package com.busanit501.firstpractice;

import com.busanit501.firstpractice.User.DTO.LoginDTO;
import com.busanit501.firstpractice.User.DTO.RegisterDTO;
import com.busanit501.firstpractice.User.DAO.UserDAO;
import com.busanit501.firstpractice.User.Serviece.UserService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

@Log4j2
public class UserTest {
    private final RegisterDTO registerDTO = new RegisterDTO("alex9305", "xlea92741611", "박신례");
    private final LoginDTO loginDTO = new LoginDTO("alex9305", "xlea92741611");
    private final UserService service = UserService.INSTANCE;
    @Test
    public void insertUser() {
        ArrayList<Boolean> duplicates = UserDAO.INSTANCE.duplicateUser(registerDTO);
        if (duplicates.get(0)) {
            if (duplicates.get(1)) {
                UserDAO.INSTANCE.insertUser(registerDTO);
            } else log.info("duplicate userName");
        } else log.info("duplicate userID");
    }

    @Test
    public void updateUser() {
        int userNo = UserDAO.INSTANCE.logInUser(loginDTO);
        if (userNo != -1) {
            log.info("login success");
            if (service.updateUser(userNo, registerDTO)) log.info("update user success");
            else log.info("update user fail");
        }
    }

    @Test
    public void deleteUser() {
        int userNo = UserDAO.INSTANCE.logInUser(loginDTO);
        if (userNo != -1) {
            log.info("login success");
            if (service.deleteUser(userNo)) log.info("delete user success");
        }
    }

    @Test
    public void getUser() {
        log.info(UserDAO.INSTANCE.getUserVo(1));
    }

    @Test
    public void getAllUser() {
        UserDAO.INSTANCE.getUserVoAll();
    }

    @Test
    public void loginUser() {
        service.logInUser(loginDTO);
    }
}
