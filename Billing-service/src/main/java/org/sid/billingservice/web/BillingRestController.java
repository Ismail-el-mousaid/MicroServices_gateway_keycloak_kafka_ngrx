package org.sid.billingservice.web;


import org.sid.billingservice.entities.Bill;
//import org.sid.billingservice.feign.CustomerRestClient;
//import org.sid.billingservice.feign.ProductItemRestClient;
import org.sid.billingservice.model.Customer;
import org.sid.billingservice.model.Product;
import org.sid.billingservice.repository.BillRepository;
import org.sid.billingservice.repository.ProductItemRepository;
import org.sid.billingservice.service.CustomerService;
import org.sid.billingservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin("*") //Autoriser les requetes
public class BillingRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id){
        Bill bill = billRepository.findById(id).get();
        Customer customer = customerService.customers.get(0);
        bill.setCustomer(customer);
        bill.getProductItems().forEach(productItem -> {
            Product product1 = productService.products.get(0);
            Product product2 = productService.products.get(1);
            productItem.setProduct(product1);
            productItem.setProduct(product2);
        });
        return bill;
    }

}

