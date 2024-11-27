package com.busanit501.firstpractice.Food;

import com.busanit501.firstpractice.Utill.DAO;
import com.busanit501.firstpractice.Utill.TableData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public enum FoodDAO {
    INSTANCE;

    private static final Map<String, String> SQL_MAP = Map.of(
            "=", "select * from FOODTABLE where FOODNO = ?",
            ">", "select * from FOODTABLE where FOODNO > ?",
            "<", "select * from FOODTABLE where FOODNO < ?",
            ">=", "select * from FOODTABLE where FOODNO >= ?",
            "<=", "select * from FOODTABLE where FOODNO <= ?"
    );

    public ArrayList<FoodDTO> getFood(String ca, int i) {
        ArrayList<FoodDTO> foodData = new ArrayList<>();
        String sql = getSql(ca);
        TableData data = DAO.INSTANCE.getData(sql, new ArrayList<>(List.of(i)));
        if (data.isData()) {
            for (ArrayList<String> rowData: data.getTableData()) {
                foodData.add(new FoodDTO(rowData.get(0), rowData.get(1),rowData.get(2)));
            }
        } return foodData;
    }

    public boolean insertFood(String foodName) {
        String sql = "insert into FOODTABLE (FOODNAME) values (?)";
        ArrayList<Object> inputData = new ArrayList<>(List.of(foodName));
        return DAO.INSTANCE.executeUpdate(sql, inputData) != -1;
    }

    public boolean updateFood(FoodDTO food, String foodName) {
        String sql = "update FOODTABLE set FOODNAME = ? where FOODNO = ?";
        ArrayList<Object> inputData = new ArrayList<>(Arrays.asList(foodName, food.getFoodNo()));
        return DAO.INSTANCE.executeUpdate(sql, inputData) != -1;
    }

    public boolean deleteFood(FoodDTO food) {
        String sql = "delete from FOODTABLE where FOODNO = ?";
        ArrayList<Object> inputData = new ArrayList<>(List.of(food.getFoodNo()));
        return DAO.INSTANCE.executeUpdate(sql, inputData) != -1;
    }

    public String getSql(String ca) {
        if (!SQL_MAP.containsKey(ca)) {
            throw new IllegalArgumentException("Invalid comparison operator: " + ca);
        }
        return SQL_MAP.get(ca);
    }
}
