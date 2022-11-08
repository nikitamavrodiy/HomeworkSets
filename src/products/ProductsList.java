package products;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ProductsList {
    private final Set<Product> productsSet = new HashSet<>();
    private final String name;

    public ProductsList(String name) {
        this.name = name;
    }

    public void addProduct(Product... products) {
        Collections.addAll(productsSet, products);
    }

    public void checkProduct(String name) {
        for (Product product : this.productsSet) {
            if (product.getName().equals(name)) {
                product.setChecked();
            }
        }
    }

    public void removeProduct(Product product) {
        productsSet.remove(product);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsList that = (ProductsList) o;
        return Objects.equals(productsSet, that.productsSet);
    }

    public int hashCode() {
        return Objects.hash(productsSet);
    }

    public Set<Product> getProductsSet() {
        return productsSet;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name +
                productsSet;
    }
}
