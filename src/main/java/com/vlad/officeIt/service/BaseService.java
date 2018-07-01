package com.vlad.officeIt.service;

import com.vlad.officeIt.dao.client.ClientDao;
import com.vlad.officeIt.dao.client.ClientDaoFactory;
import com.vlad.officeIt.dao.client.ClientDaoType;
import com.vlad.officeIt.dao.product.ProductDao;
import com.vlad.officeIt.dao.product.ProductDaoFactory;
import com.vlad.officeIt.dao.product.ProductDaoType;
import com.vlad.officeIt.strategy.uploadProduct.ProductFileConvert;
import com.vlad.officeIt.strategy.uploadProduct.ProductFileConvertFactory;
import com.vlad.officeIt.strategy.uploadProduct.ProductFileConvertType;


/**
 * To keep or not to keep.
 */
public class BaseService {

    protected ClientDao clientDao;
    protected ProductDao productDao;
    protected ProductFileConvert productFileConvert;

    public BaseService() {
        ClientDaoFactory clientDaoFactory = new ClientDaoFactory();
        clientDao = clientDaoFactory.getClientDao(ClientDaoType.DATABASE);

        ProductDaoFactory productDaoFactory = new ProductDaoFactory();
        productDao = productDaoFactory.getProductDao(ProductDaoType.DATABASE);

        ProductFileConvertFactory productFileConvertFactory = new ProductFileConvertFactory();
        productFileConvert = productFileConvertFactory.getProductFileImport(ProductFileConvertType.JSON);
    }
}
