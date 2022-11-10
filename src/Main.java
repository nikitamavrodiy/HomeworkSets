import multiply.MultiplicationTable;
import multiply.Task;
import passport.Passport;
import products.Product;
import products.ProductsList;
import products.Recipe;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Product banana = new Product("бананы", 550, 1.5);
        Product apples = new Product("яблоки", 700, 1.9);
        Product pears = new Product("груши", 900, 1.2);
        ProductsList productsList1 = new ProductsList("productList1");
        productsList1.addProduct(banana, apples);
//        productsList1.addProduct(banana);
//        productsList1.checkProduct("бананы");
//        productsList1.removeProduct(apples);
       System.out.println(productsList1);

        Recipe recipe1 = new Recipe("Рецепт салата", pears);
        Recipe recipe2 = new Recipe("Рецепт салата2", banana);
        recipe1.addProductList(productsList1);
        System.out.println(recipe1);
        System.out.println(recipe2);
        System.out.println(Recipe.allRecipes);

        MultiplicationTable multiplicationTable = new MultiplicationTable();
//        System.out.println(multiplicationTable);

//        Passport passport1 = new Passport(2412, "Medvedev", "Maksim", "Alekseevich", null);

        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(0, 1000));
        }
        System.out.println(numbers);
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next % 2 != 0) {
                iterator.remove();
            }
        }
        System.out.println(numbers);

        System.out.println("В последнем задании ответ HashSet. " +
                "В коллекции HashSet метод contains на самом деле сравнивает хэш-коды," +
                " , что намного быстрее.");
    }
}