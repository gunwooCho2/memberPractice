package Food;

import com.busanit501.firstpractice.Utill.DAO;
import com.busanit501.firstpractice.Utill.TableData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FoodDAO {

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
        for (ArrayList<String> rowData: data.getTableData()) {
            foodData.add(new FoodDTO(rowData.get(0), rowData.get(1),rowData.get(2)));
        }
        return foodData;
    }
    public String getSql(String ca) {
        if (!SQL_MAP.containsKey(ca)) {
            throw new IllegalArgumentException("Invalid comparison operator: " + ca);
        }
        return SQL_MAP.get(ca);
    }

    public static void main(String[] args) {
        FoodDAO dao = new FoodDAO();
        for (FoodDTO foodDTO: dao.getFood(">", 0)) {
            foodDTO.introduce();
        }
    }
}
