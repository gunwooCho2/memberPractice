package com.busanit501.firstpractice.User.DAO;

import com.busanit501.firstpractice.User.DTO.LoginDTO;
import com.busanit501.firstpractice.User.DTO.RegisterDTO;
import com.busanit501.firstpractice.User.VO.UserVO;
import com.busanit501.firstpractice.Utill.DAO;
import com.busanit501.firstpractice.Utill.TableData;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public enum UserDAO {
    INSTANCE;
    private final DAO dao = DAO.INSTANCE;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public boolean insertUser(RegisterDTO registerDTO) {
        String sql = "insert into userTable (userID, userPassword, userName, userUUID) values(?,?,?,?)";
        String userUUID = UUID.randomUUID().toString() + "-" + registerDTO.getUserID();
        ArrayList<Object> params = new ArrayList<>(Arrays.asList(registerDTO.getUserID(), registerDTO.getUserPassword(), registerDTO.getUserName(), userUUID));
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

    public UserVO getUserVo(int userNo) {
        String sql = "select * from userTable where userNo = ?";
        UserVO userVO = null;
        ArrayList<Object> params = new ArrayList<>(List.of(userNo));
        TableData data = dao.getData(sql, params);
        if (data.isData()) {
            ArrayList<String> userData = data.getTableData().get(0);
            userVO = dataToUserVO(userData);
        }
        return userVO;
    }

    public ArrayList<UserVO> getUserVoAll() {
        String sql = "select * from userTable";
        TableData data = dao.getData(sql);
        ArrayList<UserVO> userVOArrayList = new ArrayList<>();
        if (data.isData()) {
            for (ArrayList<String> userData: data.getTableData()) {
                userVOArrayList.add(dataToUserVO(userData));
            }
        }
        return userVOArrayList;
    }

    @SneakyThrows
    public UserVO dataToUserVO(ArrayList<String> data) {
        return UserVO.builder()
                .userNo(Integer.parseInt(data.get(0)))
                .userID(data.get(1))
                .userPassword(data.get(2))
                .userName(data.get(3))
                .registerDate(dateFormat.parse(data.get(4))).build();
    }

    public String getUserUUID(int userNo) {
        String sql = "select userUUID from userTable where userNo = ?";
        ArrayList<Object> params = new ArrayList<>(List.of(userNo));
        return dao.getData(sql, params).getTableData().get(0).get(0);
    }

    public UserVO getUserVOToUUID(String userUUID) {
        String sql = "select * from userTable where userUUID = ?";
        ArrayList<Object> params = new ArrayList<>(List.of(userUUID));
        TableData data = dao.getData(sql, params);
        if (!data.isData()) return null;
        return dataToUserVO(data.getTableData().get(0));
    }

    public boolean isUserName(String userName) {
        String sql = "select userName from userTable where userName = ?";
        ArrayList<Object> params = new ArrayList<>(List.of(userName));
        return dao.getData(sql, params).isData();
    }
}
