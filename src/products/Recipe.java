package products;

import java.util.*;

public class Recipe {
    public final static Set<Recipe> allRecipes = new HashSet<>();
    private final Map<Product, Integer> productsSet = new HashMap<>();
    private final String recipeName;

    public Recipe(String recipeName, Product... products) {
        this.recipeName = recipeName;
        addProductOrUpdate(products);
        if (allRecipes.contains(this)) {
            throw new RuntimeException("Рецепты не могут иметь одинаковое название");
        }
        allRecipes.add(this);
    }

    public void addProductOrUpdate(Product... products) {
        this.addProductOrUpdate(1, products);
    }
    public void addProductOrUpdate(int count, Product... products) {
        for (Product product : products) {
            this.productsSet.put(product, count);
        }
    }

    public int getTotalPrice() {
        int sum = 0;
        for (Map.Entry<Product, Integer> entry : productsSet.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        return sum;
    }

    public String getRecipeName() {
            return recipeName;
    }

    public String getProductsSet() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Product, Integer> entry : this.productsSet.entrySet()) {
            builder.append(entry.getKey()).append(" --> ").append(entry.getValue()).append(",\n");
        }
        builder.append("TotalPrice = " + getTotalPrice() + " ,");
        return String.valueOf(builder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(recipeName, recipe.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeName);
    }

    @Override
    public String toString() {
        return recipeName +
                ", totalPrice=" + getTotalPrice() +
                productsSet +
                '}';
    }
}


