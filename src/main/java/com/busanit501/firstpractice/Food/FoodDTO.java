package Food;

import lombok.Getter;

@Getter
public class FoodDTO {
    private final String foodINo;
    private final String foodName;
    private final String foodDate;

    public FoodDTO(String foodINo, String foodName, String foodDate) {
        this.foodINo = foodINo;
        this.foodName = foodName;
        this.foodDate = foodDate;
    }

    public void introduce() {
        System.out.print(foodINo + " ");
        System.out.print(foodName + " ");
        System.out.println(foodDate);
    }
}
