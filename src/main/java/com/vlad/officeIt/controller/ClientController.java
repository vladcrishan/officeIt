package com.vlad.officeIt.controller;

import com.vlad.officeIt.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    public static final String CLIENTS_ATTRIBUTE = "clients";
    private static final String CONTENT = "clientTable";

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public String home(Model model) {

        try {
            model.addAttribute(HomeController.CONTENT_ATTRIBUTE, CONTENT);
            model.addAttribute(CLIENTS_ATTRIBUTE, clientService.getClients());
        } catch (Exception e) {
            model.addAttribute(HomeController.CONTENT_ATTRIBUTE, HomeController.CONTENT);
            model.addAttribute(HomeController.MESSAGE, "Application Error! Failed to load data, please contact your administrator");
        }
        return "home";
    }
}
