package com.vlad.officeIt.dao.product;

import com.vlad.officeIt.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface ProductDao {
    void save(Product product) throws Exception;

    void save(List<Product> products) throws Exception;

    List<Product> getProducts() throws Exception;

    default List<Product> getProducts(List<Integer> ids) throws Exception {
        List<Product> selectedProducts = new ArrayList<>();

        List<Product> products = getProducts();
        for (Product cursor : products) {
            if (ids.contains(cursor.getId())) {
                selectedProducts.add(cursor);
            }
        }
        return selectedProducts;
    }
}
