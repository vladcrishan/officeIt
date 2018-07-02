package com.vlad.officeIt.strategy.uploadProduct;


import com.vlad.officeIt.model.Product;

import java.util.List;

public interface ProductFileConvert {
    List<Product> convert(String content) throws Exception;
}