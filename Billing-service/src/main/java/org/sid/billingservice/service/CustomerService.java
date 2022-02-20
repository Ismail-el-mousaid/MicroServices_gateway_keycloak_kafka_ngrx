package org.sid.billingservice.service;

import org.sid.billingservice.model.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class CustomerService {
    public List<Customer> customers = new ArrayList<>();

    @Bean
    public Consumer<Customer> customerConsumer(){
        return (input)->{
            customers.add(input);
          /*  System.out.println("*********************");
            System.out.println(input.toString());
            System.out.println("*********************");  */
        };
    }
}
