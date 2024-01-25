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

        if(productOptional.isPresent()) {
            Product product = productOptional.get();

            if (product.getInv() > 0) {
                product.setInv(product.getInv() - 1);
                productRepository.save(product);

                theModel.addAttribute("product", product);
                System.out.println("successful purchase");

                return "confirmationbuyproduct";
            } else {
                System.out.println("Error buying product");
                return "errorbuyproduct";
            }
        }
        else {
            System.out.println("error buying product");
            return "errorbuyproduct";
        }
    }
}
