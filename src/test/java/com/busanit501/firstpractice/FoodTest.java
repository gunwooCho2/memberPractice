package com.busanit501.firstpractice;

import com.busanit501.firstpractice.Food.DAO.FoodDAO;
import com.busanit501.firstpractice.Food.DTO.FoodDTO;
import com.busanit501.firstpractice.Food.Service.FoodService;
import com.busanit501.firstpractice.Food.VO.FoodVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class FoodTest {
    FoodDAO dao = FoodDAO.INSTANCE;
    FoodService service = FoodService.INSTANCE;
    FoodDTO foodDTO = new FoodDTO("Avocado", "맛있다.", "1");
    @Test
    public void foodInsert() {
        dao.foodInsert(foodDTO);
    }

    @Test
    public void getTest() {
        log.info(dao.getFood(1));
    }

    @Test
    public void getAllTest() {
        for (FoodVO foodVO : dao.getAllFood()) {
            log.info(foodVO);
        }
    }

    @Test
    public void getNameAllTest() {
        service.getFoodViewDTOList().forEach(log::info);
    }
}
