package com.sid.customerservice.service;

import com.sid.customerservice.entities.Customer;
import com.sid.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.function.Supplier;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Bean
    public Supplier<Customer> customerSupplier(){
        return ()-> new Customer(
                1L,
                Math.random()>0.5?"Ismail":"EL MOUSAID",
                Math.random()>0.5?"elmousaidismail@gmail.com":"ismail@gmail.com");
    }
}
