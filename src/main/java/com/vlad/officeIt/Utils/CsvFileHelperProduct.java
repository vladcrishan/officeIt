package com.vlad.officeIt.Utils;

import com.vlad.officeIt.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CsvFileHelperProduct extends CsvFileHelper {

    public CsvFileHelperProduct(String filePath) {
        super(filePath);
    }

    public List<Product> parseProducts() {
        List<Product> products = new ArrayList<>();
        List<String> lines = read();
        for (String cursor : lines) {
            String[] split = cursor.split(CsvFileHelper.COMMA_DELIMITER);
            products.add(new Product(
                    Integer.parseInt(split[0]),
                    Integer.parseInt(split[1]),
                    split[2],
                    split[3]));
        }
        return products;
    }

    public void writeToFile(List<Product> product) {
        StringBuilder stringBuffer = new StringBuilder();
        for (Product cursor : product) {
            stringBuffer.append(String.valueOf(cursor.getId()));
            stringBuffer.append(CsvFileHelper.COMMA_DELIMITER);
            stringBuffer.append(cursor.getPrice());
            stringBuffer.append(CsvFileHelper.COMMA_DELIMITER);
            stringBuffer.append(cursor.getName());
            stringBuffer.append(CsvFileHelper.COMMA_DELIMITER);
            stringBuffer.append(cursor.getDescription());
        }

        write(stringBuffer.toString());
    }
}
