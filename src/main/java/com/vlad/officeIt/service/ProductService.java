package com.vlad.officeIt.service;

import com.vlad.officeIt.dao.product.ProductDao;
import com.vlad.officeIt.model.Product;
import com.vlad.officeIt.strategy.uploadProduct.ProductFileConvert;
import com.vlad.officeIt.strategy.uploadProduct.ProductFileConvertFactory;
import com.vlad.officeIt.strategy.uploadProduct.ProductFileConvertType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    private ProductDao productDao;
    private ProductFileConvertFactory productFileConvertFactory;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Autowired
    public void setProductFileConvertFactory(ProductFileConvertFactory productFileConvertFactory) {
        this.productFileConvertFactory = productFileConvertFactory;
    }

    public List<Product> getProducts() throws Exception {
        return productDao.getProducts();
    }

    public List<Product> getProducts(List<Integer> ids) throws Exception {
        return productDao.getProducts(ids);
    }

    public void setProducts(List<Product> products) throws Exception {
        productDao.save(products);
    }

    public void uploadProducts(MultipartFile file) throws Exception {
        ProductFileConvertType type = ProductFileConvertType.convert(file.getOriginalFilename());
        ProductFileConvert productFileConvert = productFileConvertFactory.getProductFileImport(Objects.requireNonNull(type));
        List<Product> products = productFileConvert.convert(new String(file.getBytes()));
        productDao.save(products);
    }

}
