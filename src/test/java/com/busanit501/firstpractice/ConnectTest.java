package com.busanit501.firstpractice;
import com.busanit501.firstpractice.Food.FoodDAO;
import com.busanit501.firstpractice.Food.FoodDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class ConnectTest {
    @Test
    public void insertFood() {
        FoodDAO.INSTANCE.insertFood("Avocado");
    }

    @Test
    public void getFood() {
        for (FoodDTO foodDTO:FoodDAO.INSTANCE.getFood(">", 0)) {
            log.info(foodDTO.toString());
        }
    }

    @Test
    public void updateFood() {
        FoodDTO foodDTO = FoodDAO.INSTANCE.getFood("=", 2).get(0);
        if(FoodDAO.INSTANCE.updateFood(foodDTO, "updateBanana")) System.out.println("update Success");
        else System.out.println("update Fail");
    }

    @Test
    public void deleteFood() {
        FoodDTO foodDTO = FoodDAO.INSTANCE.getFood("=", 8).get(0);
        if(FoodDAO.INSTANCE.deleteFood(foodDTO)) System.out.println("delete Success");
        else System.out.println("delete Fail");
    }
}
