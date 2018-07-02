package com.vlad.officeIt.controller;

import com.vlad.officeIt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {

    private static final String PRODUCT_ATTRIBUTE = "products";
    private static final String CONTENT = "productTable";

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String home(Model model) {
        try {
            model.addAttribute(HomeController.CONTENT_ATTRIBUTE, CONTENT);
            model.addAttribute(PRODUCT_ATTRIBUTE, productService.getProducts());
        } catch (Exception e) {
            model.addAttribute(HomeController.CONTENT_ATTRIBUTE, HomeController.CONTENT);
            model.addAttribute(HomeController.MESSAGE, "Application Error! Failed to load data, please contact your administrator");
        }
        return "home";
    }

    @PostMapping("/products/upload")
    public String uploadProducts(@RequestParam("file") MultipartFile file, Model model) {

        // Validate for empty file
        if (file.isEmpty()) {
            model.addAttribute(HomeController.CONTENT_ATTRIBUTE, HomeController.CONTENT);
            model.addAttribute(HomeController.MESSAGE, "Please select a file to upload");
            return "home";
        }

        // Get file, save it and validate if correct format
        try {
            productService.uploadProducts(file);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute(HomeController.CONTENT_ATTRIBUTE, HomeController.CONTENT);
            model.addAttribute(HomeController.MESSAGE, "Error. Something happened");
            return "home";
        }

        model.addAttribute(HomeController.CONTENT_ATTRIBUTE, HomeController.CONTENT);
        model.addAttribute(HomeController.MESSAGE, "You successfully uploaded '" + file.getOriginalFilename() + "'");
        return "home";
    }

}
