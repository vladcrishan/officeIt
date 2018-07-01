package com.vlad.officeIt.controller;

import com.vlad.officeIt.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    public static final String CLIENTS_ATTRIBUTE = "clients";
    public static final String CONTENT = "clientTable";

    private ClientService clientService = new ClientService();

    @GetMapping("/clients")
    public String home(Model model) {
        model.addAttribute(HomeController.CONTENT_ATTRIBUTE, CONTENT);
        model.addAttribute(CLIENTS_ATTRIBUTE, clientService.getClients());
        return "home";
    }
}
