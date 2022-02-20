package org.sid.billingservice;

import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.entities.ProductItem;
//import org.sid.billingservice.feign.CustomerRestClient;
//import org.sid.billingservice.feign.ProductItemRestClient;
import org.sid.billingservice.model.Customer;
import org.sid.billingservice.model.Product;
import org.sid.billingservice.repository.BillRepository;
import org.sid.billingservice.repository.ProductItemRepository;
import org.sid.billingservice.service.CustomerService;
import org.sid.billingservice.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients  //Activer feign
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(
            BillRepository billRepository,
            ProductItemRepository productItemRepository,
            ProductService productService,
            CustomerService customerService
    ) {
        return args -> {
            Customer customer = customerService.customers.get(0);
            Bill bill1 = billRepository.save(new Bill(null, new Date(), null, customer.getId(), null));
            productService.products.forEach(product -> {
                ProductItem productItem = new ProductItem();
                productItem.setProductId(product.getId());
                productItem.setPrice(product.getPrice());
                productItem.setQuantity(1+new Random().nextInt(100));
                productItem.setBill(bill1);
                productItemRepository.save(productItem);
            });
        };
    }




}
