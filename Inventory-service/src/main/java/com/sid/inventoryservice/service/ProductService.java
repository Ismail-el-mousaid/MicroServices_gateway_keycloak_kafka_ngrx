package com.sid.inventoryservice.service;

import com.sid.inventoryservice.entities.Product;
import com.sid.inventoryservice.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepostory;

    @Bean
    public Supplier<Product> productSupplier() {
        Product product1 = new Product(1L,
                Math.random() > 0.5 ? "Ordinateur" : "Iphone 13",
                new Random().nextInt(9000),
                new Random().nextInt(50));
        return () -> product1;

    }

}
