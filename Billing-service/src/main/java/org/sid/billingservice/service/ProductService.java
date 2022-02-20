package org.sid.billingservice.service;

import org.sid.billingservice.model.Customer;
import org.sid.billingservice.model.Product;
import org.sid.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class ProductService {
    @Autowired
    private ProductItemRepository productItemRepository;

    public List<Product> products = new ArrayList<>();

    @Bean
    public Consumer<Product> productConsumer(){
        return (input)->{
            products.add(input);
         /*   System.out.println("*********************");
            System.out.println(input.toString());
            System.out.println("*********************");  */
        };
    }


}
