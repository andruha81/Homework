package threads.Entity;

import java.math.BigDecimal;

public class Food {
    private String foodName;   // наименование продукта
    private BigDecimal price;  // цена продукта

    public Food(String foodName, BigDecimal price) {
        this.foodName = foodName;
        this.price = price;
    }

    public String getFoodName() {
        return foodName;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
