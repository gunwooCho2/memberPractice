package com.busanit501.firstpractice.User;

import com.busanit501.firstpractice.Utill.DAO;
import com.busanit501.firstpractice.Utill.TableData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum UserDAO {
    INSTANCE;
    final DAO dao = DAO.INSTANCE;

    public boolean insertUser(RegisterDTO registerDTO) {
        String sql = "insert into userTable (userID, userPassword, userName) values(?,?,?)";
        ArrayList<Object> params = new ArrayList<>(Arrays.asList(registerDTO.getUserID(), registerDTO.getUserPassword(), registerDTO.getUserName()));
        return dao.executeUpdate(sql, params) != -1;
    }

    public ArrayList<Boolean> duplicateUser(RegisterDTO registerDTO) {
        boolean duplicateID = false;
        boolean duplicateUserName = false;

        String sqlID = "select * from userTable where userID = ?";
        ArrayList<Object> paramsID = new ArrayList<>(List.of(registerDTO.getUserID()));
        String sqlUserName = "select * from userTable where userName = ?";
        ArrayList<Object> paramsUserName = new ArrayList<>(List.of(registerDTO.getUserName()));

        if (dao.getData(sqlID, paramsID).getTableData().isEmpty()) duplicateID = true;
        if (dao.getData(sqlUserName, paramsUserName).getTableData().isEmpty()) duplicateUserName = true;

        return new ArrayList<>(Arrays.asList(duplicateID, duplicateUserName));
    }

    public boolean updateUser(int userNo, RegisterDTO registerDTO) {
        String sql = "UPDATE userTable SET userID = ?, userPassword = ?, userName = ? WHERE userNO = ?";
        ArrayList<Object> params = new ArrayList<>(Arrays.asList(registerDTO.getUserID(), registerDTO.getUserPassword(), registerDTO.getUserName(), userNo));
        return dao.executeUpdate(sql, params) != -1;
    }

    public boolean deleteUser(int userNo) {
        String sql = "delete from userTable where userNo = ?";
        ArrayList<Object> params = new ArrayList<>(List.of(userNo));
        return dao.executeUpdate(sql, params) != -1;
    }

    public int logInUser(LoginDTO loginDTO) {
        String sql = "select * from userTable where userID = ? and userPassword = ?";
        ArrayList<Object> params = new ArrayList<>(List.of(loginDTO.getUserID(), loginDTO.getUserPassword()));
        TableData data = dao.getData(sql, params);
        if (data.isData()) return Integer.parseInt(data.getTableData().get(0).get(0));
        else return -1;
    }
}