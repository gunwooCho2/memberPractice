package com.busanit501.firstpractice.Food.VO;

import lombok.*;

import java.util.Date;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodVO {
    private int foodNo;
    private String foodName;
    private String foodExplain;
    private String writer;
    private Date registerDate;
}
