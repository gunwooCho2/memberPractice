package com.busanit501.firstpractice.Food;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FoodDTO {
    private final String foodNo;
    private final String foodName;
    private final String foodDate;
}
