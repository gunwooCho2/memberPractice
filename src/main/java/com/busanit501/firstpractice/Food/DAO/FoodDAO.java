package com.busanit501.firstpractice.Food.DAO;

import com.busanit501.firstpractice.Food.DTO.FoodDTO;
import com.busanit501.firstpractice.Food.VO.FoodVO;
import com.busanit501.firstpractice.Utill.DAO;
import com.busanit501.firstpractice.Utill.TableData;
import lombok.SneakyThrows;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum FoodDAO {
    INSTANCE;
    private final DAO dao = DAO.INSTANCE;
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public boolean foodInsert(FoodDTO foodDTO) {
        String sql = "insert into foodTable (foodName, foodExplain, writer) values (?,?,?)";
        ArrayList<Object> inputData = new ArrayList<>(Arrays.asList(foodDTO.getFoodName(), foodDTO.getFoodExplain(), foodDTO.getWriter()));
        return dao.executeUpdate(sql, inputData) != -1;
    }

    public FoodVO getFood(int foodNo) {
        String sql = "select * from foodTable where foodNo = ?";
        ArrayList<Object> inputData = new ArrayList<>(List.of(foodNo));
        TableData data = dao.getData(sql, inputData);
        if (data.isData()) {
            return dataToFoodVO(data.getTableData().get(0));
        }
        return null;
    }

    public ArrayList<FoodVO> getAllFood() {
        String sql = "select * from foodTable";
        return (ArrayList<FoodVO>) dao.getData(sql).getTableData().stream()
                .map(this::dataToFoodVO)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public FoodVO dataToFoodVO(ArrayList<String> data) {
        return FoodVO.builder()
                .foodNo(Integer.parseInt(data.get(0)))
                .foodName(data.get(1))
                .foodExplain(data.get(2))
                .writer(data.get(3))
                .registerDate(dateFormat.parse(data.get(4))).build();
    }
}
