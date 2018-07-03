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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CalculatePriceController {

    private PriceService priceService;
    private ClientService clientService;
    private ProductService productService;

    private static final String CONTENT = "price";

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

    @GetMapping("/price")
    public String price(Model model) {
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

    @PostMapping("/calculatePrice")
    public String calculatePrice(@RequestParam("cid") String clientId, @RequestParam("pid") String productIds, Model model) {
        try {
            Client client = clientService.getClient(Integer.parseInt(clientId));

            String[] pIds = productIds.split(",");
            int[] array = Arrays.stream(pIds).mapToInt(Integer::parseInt).toArray();
            List<Integer> productIdsList = Arrays.stream(array).boxed().collect(Collectors.toList());
            List<Product> products = productService.getProducts(productIdsList);

            Order order = new Order(client, products);
            Price price = priceService.calculatePrice(order);
            order.setPrice(price);

            model.addAttribute(HomeController.CONTENT_ATTRIBUTE, HomeController.CONTENT);
            StringBuilder message = new StringBuilder(String.format("Total price: %s ", order.getInitialPrice()));
            if (order.hasDiscount()) {
                message.append(String.format(" Price with rebate: %s Rebate type: %s", order.getFinalPrice(), order.getRebate()));
            }
            model.addAttribute(HomeController.MESSAGE, message.toString());

            return "home";

        } catch (Exception e) {
            model.addAttribute(HomeController.CONTENT_ATTRIBUTE, HomeController.CONTENT);
            model.addAttribute(HomeController.MESSAGE, "Application Error! Failed to load data, please contact your administrator." + e);
            return "home";
        }
    }

}
