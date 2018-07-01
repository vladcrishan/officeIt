package com.vlad.officeIt.strategy.uploadProduct;

import com.vlad.officeIt.strategy.uploadProduct.implementations.CsvProductFileConvert;
import com.vlad.officeIt.strategy.uploadProduct.implementations.JsonProductFileConvert;
import com.vlad.officeIt.strategy.uploadProduct.implementations.XmlProductFileConvert;

public class ProductFileConvertFactory {

    public ProductFileConvert getProductFileImport(ProductFileConvertType type) {
        if (type == null) {
            return null;
        }

        switch (type) {
            case CSV:
                return new CsvProductFileConvert();
            case XML:
                return new XmlProductFileConvert();
            case JSON:
                return new JsonProductFileConvert();
        }

        return null;
    }
}
