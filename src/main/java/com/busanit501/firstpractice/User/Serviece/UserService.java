package com.busanit501.firstpractice.User.Serviece;

import com.busanit501.firstpractice.User.DAO.UserDAO;
import com.busanit501.firstpractice.User.DTO.LoginDTO;
import com.busanit501.firstpractice.User.DTO.RegisterDTO;
import com.busanit501.firstpractice.User.VO.UserVO;
import com.busanit501.firstpractice.Utill.MapperUtil;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;

public enum UserService {
    INSTANCE;
    private final UserDAO userDAO = UserDAO.INSTANCE;
    private final ModelMapper modelMapper = MapperUtil.INSTANCE.getModelMapper();

    public String duplicatesCheck(RegisterDTO registerDTO) {
        String errorMessage = "";
        ArrayList<Boolean> duplicates = userDAO.duplicateUser(registerDTO);
        if (!duplicates.get(0) && !duplicates.get(1)) {
            errorMessage = "Duplicate UserID and Name";
            return errorMessage;
        }
        else if (!duplicates.get(0)) {
            errorMessage = "Duplicate UserID";
            return errorMessage;
        }
        else if (!duplicates.get(1)) {
            errorMessage = "Duplicate UserName";
            return errorMessage;
        }
        return errorMessage;
    }

    public UserVO getUser(int userNo) {
        return userDAO.getUserVo(userNo);
    }

    public void insertUser(RegisterDTO registerDTO) {
        userDAO.insertUser(registerDTO);
    }

    public ArrayList<UserVO> getAllUsers() {
        return userDAO.getUserVoAll();
    }

    public boolean updateUser(int userNo, RegisterDTO registerDTO) {
        return UserDAO.INSTANCE.updateUser(userNo, registerDTO);
    }

    public boolean deleteUser(int userNo) {
        return UserDAO.INSTANCE.deleteUser(userNo);
    }

    public int logInUser(LoginDTO loginDTO) {
        return UserDAO.INSTANCE.logInUser(loginDTO);
    }

    public String getUserUUID(int userNo) {
        return UserDAO.INSTANCE.getUserUUID(userNo);
    }

    public RegisterDTO getRegDTOToUUID(String UUID) {
        return modelMapper.map(UserDAO.INSTANCE.getUserVOToUUID(UUID), RegisterDTO.class);
    }

    public boolean isUserName(String UserName) {
        return UserDAO.INSTANCE.isUserName(UserName);
    }
}
