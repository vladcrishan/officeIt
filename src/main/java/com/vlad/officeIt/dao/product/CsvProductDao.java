package com.vlad.officeIt.dao.product;

import com.vlad.officeIt.utils.FileHelper;
import com.vlad.officeIt.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*
    The csv file is stored in the resource folder and it's name is set in the application.properties file.
    In a production environment the csv storage path would be defined in the application.properties!
 */
@Component
public class CsvProductDao implements ProductDao {

    @Override
    public void save(Product product) throws Exception {
        writeToFile(new ArrayList<Product>() {{
            add(product);
        }});
    }

    @Override
    public void save(List<Product> products) throws Exception {
        writeToFile(products);
    }

    @Override
    public List<Product> getProducts() throws Exception {
        return parseProducts();
    }

    private String getFileName() throws Exception {
        return getClass().getClassLoader().getResource("storage/products.csv").getFile();
    }

    private List<Product> parseProducts() throws Exception {
        List<Product> products = new ArrayList<>();
        List<String> lines = FileHelper.read(getFileName());
        for (String cursor : lines) {
            String[] split = cursor.split(FileHelper.COMMA_DELIMITER);
            products.add(new Product(
                    Integer.parseInt(split[0]),
                    Integer.parseInt(split[1]),
                    split[2],
                    split[3]));
        }
        return products;
    }

    private void writeToFile(List<Product> product) throws Exception {
        StringBuilder stringBuffer = new StringBuilder();
        for (Product cursor : product) {
            stringBuffer.append(String.valueOf(cursor.getId()));
            stringBuffer.append(FileHelper.COMMA_DELIMITER);
            stringBuffer.append(cursor.getPrice());
            stringBuffer.append(FileHelper.COMMA_DELIMITER);
            stringBuffer.append(cursor.getName());
            stringBuffer.append(FileHelper.COMMA_DELIMITER);
            stringBuffer.append(cursor.getDescription());
            stringBuffer.append("\n");
        }

        FileHelper.write(getFileName(), stringBuffer.toString());
    }

}
