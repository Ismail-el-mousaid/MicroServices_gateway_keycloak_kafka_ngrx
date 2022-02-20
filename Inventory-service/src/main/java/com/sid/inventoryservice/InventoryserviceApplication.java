package com.sid.inventoryservice;

import com.sid.inventoryservice.entities.Product;
import com.sid.inventoryservice.dao.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryserviceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ProductRepository productRepostory, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepostory.save(new Product(null, "Ordinateur", 3000, 7));
            productRepostory.save(new Product(null, "Imprimant", 453, 65));
            productRepostory.save(new Product(null, "Smartphone", 231, 7));
            productRepostory.findAll().forEach(product -> {
                System.out.println(product.getName());
            });
        };

    }

}
