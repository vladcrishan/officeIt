package com.vlad.officeIt.dao.product;

import com.vlad.officeIt.model.Product;

import java.util.List;

public interface ProductDao {
    void save(Product product);

    void save(List<Product> products);

    List<Product> getProducts();
}
