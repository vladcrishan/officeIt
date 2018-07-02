package com.vlad.officeIt.strategy.uploadProduct;


public enum ProductFileConvertType {
    JSON,
    XML;

    public static ProductFileConvertType convert(String filename) {
        if (filename.contains(".json")) {
            return JSON;
        } else if (filename.contains(".xml")) {
            return XML;
        }
        return null;

    }
}
