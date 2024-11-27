package com.busanit501.firstpractice.Food;

import java.util.ArrayList;

public enum FoodServiece {
    INSTANCE;
    private FoodDAO dao = FoodDAO.INSTANCE;

    public ArrayList<FoodDTO> listAll() {
        ArrayList<FoodDTO> list = dao.getFood(">", 0);
        return list;
    }
    public FoodDTO getFoodByID(int id) {
        return dao.getFood("=", id).get(0);
    }
}
