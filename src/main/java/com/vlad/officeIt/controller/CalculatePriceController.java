package com.vlad.officeIt.controller;

import com.vlad.officeIt.model.Client;
import com.vlad.officeIt.model.Order;
import com.vlad.officeIt.model.Price;
import com.vlad.officeIt.model.Product;
import com.vlad.officeIt.service.ClientService;
import com.vlad.officeIt.service.PriceService;
import com.vlad.officeIt.service.ProductService;
import com.vlad.officeIt.strategy.rebate.RebateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class CalculatePriceController {

    private PriceService priceService;
    private ClientService clientService;
    private ProductService productService;

    private static final String CONTENT = "calculatePrice";

    @Autowired
    public void setPriceService(PriceService priceService) {
        this.priceService = priceService;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/calculatePrice")
    public String calculatePrice(Model model) {
        try {
            model.addAttribute(HomeController.CONTENT_ATTRIBUTE, CONTENT);
            model.addAttribute(ClientController.CLIENTS_ATTRIBUTE, clientService.getClients());
            return "home";
        } catch (Exception e) {
            model.addAttribute(HomeController.CONTENT_ATTRIBUTE, HomeController.CONTENT);
            model.addAttribute(HomeController.MESSAGE, "Application Error! Failed to load data, please contact your administrator");
            return "home";
        }
    }

    @GetMapping("/price")
    public String price(Model model) {

        try {
            Client client = clientService.getClient(1);
            List<Product> products = productService.getProducts(Arrays.asList(91, 92, 93));

            Order order = new Order(client, products);
            Price price = priceService.calculatePrice(order);
            order.setPrice(price);

            model.addAttribute(HomeController.CONTENT_ATTRIBUTE, HomeController.CONTENT);
            model.addAttribute(HomeController.MESSAGE, String.format("Total price: %s  Price with rebate: %s", order.getInitialPrice(), order.getFinalPrice()));
            return "home";

        } catch (Exception e) {
            model.addAttribute(HomeController.CONTENT_ATTRIBUTE, HomeController.CONTENT);
            model.addAttribute(HomeController.MESSAGE, "Application Error! Failed to load data, please contact your administrator");
            return "home";
        }
    }

}
