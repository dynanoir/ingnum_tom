package com.ingnum.rentalservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BonjourController {

    @Value("${customer.service.url}")
    private String customerServiceUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/bonjour")
    public String bonjour() {
        return "bonjour";
    }

    @GetMapping("/customer/{name}")
    public String getCustomer(@PathVariable String name) {
        try {
            // Appel du service PHP
            String phpResponse = restTemplate.getForObject(customerServiceUrl, String.class);
            return "Customer: " + name + "\n" + 
                   "PHP Service says: " + phpResponse;
        } catch (Exception e) {
            return "Error calling PHP service: " + e.getMessage();
        }
    }
}