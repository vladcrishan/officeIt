package com.vlad.officeIt.strategy.uploadProduct.implementations;

import com.vlad.officeIt.model.Product;
import com.vlad.officeIt.strategy.uploadProduct.ProductFileConvert;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonProductFileConvert implements ProductFileConvert {
    @Override
    public List<Product> convert(String content) {

        List<Product> products = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(content);
        JSONArray jsonArray = jsonObject.getJSONArray("products");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject group = jsonArray.getJSONObject(i);

            products.add(new Product(group.getInt("id"),
                    group.getInt("price"),
                    group.getString("name"),
                    group.getString("description")));
        }

        return products;
    }
}
