package products;

import java.util.*;

public class Recipe {
    public final static Set<Recipe> allRecipes = new HashSet<>();
    private final Set<Product> productsSet = new HashSet<>();
    private final String recipeName;

    public Recipe(String recipeName, Product... products) {
        this.recipeName = recipeName;
        addProduct(products);
        allRecipes.add(this);
    }

    public void addProductList(ProductsList productsList) {
        productsSet.addAll(productsList.getProductsSet());
    }

    public void addProduct(Product... products) {
        Collections.addAll(productsSet, products);

    }

    public Set<Product> getProductsSet() {
        return productsSet;
    }

    public int getTotalPrice() {
        int sum = 0;
        for (Product product : productsSet) {
            sum += product.getPrice();
        }
        return sum;
    }

    public String getRecipeName() {
        return recipeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        if (Objects.equals(recipeName, recipe.recipeName)) {
            throw new RuntimeException("Рецепты не могут иметь одинаковое название");
        }
        return false;
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
