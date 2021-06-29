package stream2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {
    public static void main( String[] args ) {
        getProduct().stream().filter(product -> product.price() > 25000f)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static List<Product> getProduct() {

        List<Product> productList = new ArrayList<>();

        productList.add(new Product(1, "Hp Laptop", 25000f));
        productList.add(new Product(2, "Dell Laptop", 30000f));
        productList.add(new Product(3, "Lenovo Laptop", 28000f));
        productList.add(new Product(4, "Sony Laptop", 28000f));
        productList.add(new Product(5, "Apple Laptop", 25000f));

        return productList;
    }
}


record Product(int id, String name, float price) {
    @Override
    public String toString() {
        return "Product id : " + id + " , product name: " + name + " ,Product price: " + price;
    }
}
