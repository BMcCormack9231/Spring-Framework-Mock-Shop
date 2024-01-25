package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BuyProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") int theID, Model theModel){
        Optional<Product> productOptional = productRepository.findById((long)theID);

        if(productOptional.isPresent()){
            Product product = productOptional.get();
            product.setInv(product.getInv() - 1);
            productRepository.save(product);

            theModel.addAttribute("product", product);

            return "confirmationbuyproduct";
        }
        else
            return "errorbuyproduct";
    }
}
