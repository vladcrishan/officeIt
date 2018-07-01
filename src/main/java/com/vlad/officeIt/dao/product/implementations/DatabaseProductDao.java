package com.vlad.officeIt.dao.product.implementations;

import com.vlad.officeIt.dao.product.ProductDao;
import com.vlad.officeIt.model.Product;

import java.util.ArrayList;
import java.util.List;

public class DatabaseProductDao implements ProductDao {

    // Hardcoded values
    List<Product> products = new ArrayList<Product>() {{
        add(new Product(1, 11, "Scaun", "blabla"));
        add(new Product(2, 12, "Birou", "hapciu"));
        add(new Product(3, 13, "Etajeră", "123"));
        add(new Product(4, 14, "Suport Picioare", "blabla"));
        add(new Product(5, 15, "Suport Monitor", "hapciu"));
        add(new Product(6, 16, "Suport Lombar", "123"));
        add(new Product(7, 17, "Plasă cabluri", "blabla"));
        add(new Product(8, 18, "Stand Laptop", "hapciu"));
        add(new Product(9, 19, "Stand Monitor", "123"));
        add(new Product(10, 100, "Stand Tastatură", "hapciu"));
    }};

    @Override
    public void save(Product product) {
        // Simulate connection to database and execute insert query
        products.add(product);
    }

    @Override
    public void save(List<Product> products) {
        // Simulate connection to database and execute insert query
        this.products.addAll(products);
    }

    @Override
    public List<Product> getProducts() {
        // Simulate connection to database and execute select query
        return products;
    }
}
