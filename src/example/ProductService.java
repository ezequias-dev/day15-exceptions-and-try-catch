package example;

import java.util.ArrayList;

public class ProductService {
    private final ArrayList<ProductRecord> products = new ArrayList<>();

    public boolean addProduct(ProductRecord product) {
        products.add(product);
        return true;
    }

    public ProductRecord findById(int id) {
        for (ProductRecord product : products) {
            if (id == product.getId()) {
                return product;
            }
        }

        return null;
    }
}
