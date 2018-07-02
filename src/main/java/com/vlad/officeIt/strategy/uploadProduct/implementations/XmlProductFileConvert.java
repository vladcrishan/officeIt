package com.vlad.officeIt.strategy.uploadProduct.implementations;


import com.vlad.officeIt.model.Product;
import com.vlad.officeIt.strategy.uploadProduct.ProductFileConvert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

public class XmlProductFileConvert implements ProductFileConvert {
    @Override
    public List<Product> convert(String content) throws Exception {

        List<Product> products = new LinkedList<>();

        InputSource is = new InputSource(new StringReader(content));
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(is);

        NodeList productElems = doc.getElementsByTagName("product");
        for (int i = 0; i < productElems.getLength(); ++i) {
            Element productElem = (Element) productElems.item(i);
            String id = productElem.getElementsByTagName("id").item(0).getTextContent();
            String price = productElem.getElementsByTagName("price").item(0).getTextContent();
            String name = productElem.getElementsByTagName("name").item(0).getTextContent();
            String description = productElem.getElementsByTagName("description").item(0).getTextContent();
            products.add(new Product(Integer.parseInt(id), Integer.parseInt(price), name, description));
        }

        return products;
    }
}
