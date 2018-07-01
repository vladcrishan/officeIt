package com.vlad.officeIt.dao.product;

import com.vlad.officeIt.dao.product.implementations.CsvProductDao;
import com.vlad.officeIt.dao.product.implementations.DatabaseProductDao;

public class ProductDaoFactory {

    public ProductDao getProductDao(ProductDaoType productDaoType) {

        if (productDaoType == null) {
            return null;
        }

        switch (productDaoType) {
            case DATABASE:
                return new DatabaseProductDao();
            case CSV:
                return new CsvProductDao();
        }

        return null;
    }
}
