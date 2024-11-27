package com.busanit501.firstpractice.User.Serviece;

import com.busanit501.firstpractice.User.DAO.UserDAO;
import com.busanit501.firstpractice.User.DTO.LoginDTO;
import com.busanit501.firstpractice.User.DTO.RegisterDTO;
import com.busanit501.firstpractice.User.VO.UserVO;
import com.busanit501.firstpractice.Utill.MapperUtil;
import org.modelmapper.ModelMapper;

import java.text.ParseException;
import java.util.ArrayList;

public enum UserServiece {
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
            errorMessage = "Duplicate UserID";
            return errorMessage;
        }
        return errorMessage;
    }

    public LoginDTO mapLoginDTO(RegisterDTO registerDTO) {
        return modelMapper.map(registerDTO, LoginDTO.class);
    }

    public UserVO getUser(int userNo) throws ParseException {
        return userDAO.getUserVo(userNo);
    }

    public void insertUser(RegisterDTO registerDTO) {
        userDAO.insertUser(registerDTO);
    }

    public ArrayList<UserVO> getAllUsers() throws ParseException {
        return userDAO.getUserVoAll();
    }
}
