package com.vlad.officeIt.strategy.uploadProduct;

import com.vlad.officeIt.strategy.uploadProduct.implementations.JsonProductFileConvert;
import com.vlad.officeIt.strategy.uploadProduct.implementations.XmlProductFileConvert;
import org.springframework.stereotype.Component;

@Component
public class ProductFileConvertFactory {

    public ProductFileConvert getProductFileImport(ProductFileConvertType type) {
        if (type == null) {
            return null;
        }

        switch (type) {
            case XML:
                return new XmlProductFileConvert();
            case JSON:
                return new JsonProductFileConvert();
            default:
                return null;
        }
    }
}
