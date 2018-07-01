package com.vlad.officeIt.dao.product.implementations;

import com.vlad.officeIt.Utils.CsvFileHelperProduct;
import com.vlad.officeIt.dao.product.ProductDao;
import com.vlad.officeIt.model.Product;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

/*
    The csv file is stored in the resource folder and it's name is set in the application.properties file.
    In a production environment the csv storage path would be defined in the application.properties!
 */
public class CsvProductDao implements ProductDao {

    @Value("${productdao.csv.filename}")
    private String csvFileName;
    private CsvFileHelperProduct csvFileHelper;

    public CsvProductDao() {
        csvFileHelper = new CsvFileHelperProduct(getClass().getClassLoader().getResource("products.csv").getFile());
    }

    @Override
    public void save(Product product) {
        csvFileHelper.writeToFile(new ArrayList<Product>() {{
            add(product);
        }});
    }

    @Override
    public void save(List<Product> products) {
        csvFileHelper.writeToFile(products);
    }

    @Override
    public List<Product> getProducts() {
        return csvFileHelper.parseProducts();
    }


}
