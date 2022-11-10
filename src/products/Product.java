package products;

import java.util.Objects;

public class Product {
    private final String name;
    private final int price;
    private final double amount;
    private boolean checked;

    public Product(String name) {
        this(name, 0, 0);
    }

    public Product(String name, int price, double amount) {
        if (name == null | price == 0 | amount == 0) {
            throw new RuntimeException("Заполните карточку товара полностью");
        }
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.checked = false;

    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked() {
        this.checked = true;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return "{" +name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", checked=" + checked +
                "}";
    }
}
