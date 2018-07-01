package com.vlad.officeIt.controller;

import com.vlad.officeIt.Utils.CsvFileHelperProduct;
import com.vlad.officeIt.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ProductController {

    public static final String PRODUCT_ATTRIBUTE = "products";
    public static final String CONTENT = "productTable";

    private ProductService productService = new ProductService();


    @GetMapping("/products")
    public String home(Model model) {
        model.addAttribute(HomeController.CONTENT_ATTRIBUTE, CONTENT);
        model.addAttribute(PRODUCT_ATTRIBUTE, productService.getProducts());
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
            byte[] bytes = file.getBytes();
            // ToDo write file to resource/uploads
            Path path = Paths.get("/Users/vlad/Documents/projects/play/officeIt/" + file.getOriginalFilename());
            Files.write(path, bytes);
            productService.uploadProducts("/Users/vlad/Documents/projects/play/officeIt/" + file.getOriginalFilename());
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
