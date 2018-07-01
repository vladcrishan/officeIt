package com.vlad.officeIt.service;

import com.vlad.officeIt.dao.product.ProductDao;
import com.vlad.officeIt.dao.product.ProductDaoFactory;
import com.vlad.officeIt.dao.product.ProductDaoType;
import com.vlad.officeIt.model.Product;
import com.vlad.officeIt.strategy.uploadProduct.ProductFileConvert;
import com.vlad.officeIt.strategy.uploadProduct.ProductFileConvertFactory;
import com.vlad.officeIt.strategy.uploadProduct.ProductFileConvertType;

import java.util.List;

public class ProductService {

    private ProductDao productDao;
    private ProductFileConvert productFileConvert;
    private ProductFileConvertFactory productFileConvertFactory;

    public ProductService() {
        super();
        ProductDaoFactory productDaoFactory = new ProductDaoFactory();
        productDao = productDaoFactory.getProductDao(ProductDaoType.DATABASE);

        productFileConvertFactory = new ProductFileConvertFactory();
        productFileConvert = productFileConvertFactory.getProductFileImport(ProductFileConvertType.CSV);
    }

    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    public void setProducts(List<Product> products) {
        productDao.save(products);
    }

    public void uploadProducts(String filePath) {
        List<Product> product = productFileConvert.convert(filePath);
    }

}
