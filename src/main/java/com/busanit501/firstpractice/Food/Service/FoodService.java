package com.busanit501.firstpractice.Food.Service;

import com.busanit501.firstpractice.Food.DAO.FoodDAO;
import com.busanit501.firstpractice.Food.DTO.FoodDTO;
import com.busanit501.firstpractice.Food.DTO.FoodViewDTO;
import com.busanit501.firstpractice.Food.VO.FoodVO;
import com.busanit501.firstpractice.Utill.MapperUtil;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.stream.Collectors;

public enum FoodService {
    INSTANCE;
    private final FoodDAO dao = FoodDAO.INSTANCE;
    private final ModelMapper modelMapper = MapperUtil.INSTANCE.getModelMapper();

    public ArrayList<FoodViewDTO> getFoodViewDTOList() {
        return (ArrayList<FoodViewDTO>) dao.getAllFood().stream()
                .map(foodVO -> modelMapper.map(foodVO, FoodViewDTO.class))
                .collect(Collectors.toList());
    }

    public FoodVO getFood(int foodNo) {
        return dao.getFood(foodNo);
    }

    public boolean insertFood(FoodDTO foodDTO) {
        return dao.foodInsert(foodDTO);
    }
}
