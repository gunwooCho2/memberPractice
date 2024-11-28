package com.busanit501.firstpractice.Food.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodViewDTO {
    private int foodNO;
    private String foodName;
}
