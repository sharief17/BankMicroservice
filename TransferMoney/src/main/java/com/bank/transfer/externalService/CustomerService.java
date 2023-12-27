package com.bank.transfer.externalService;

import com.bank.transfer.entity.Customer;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("CUSTOMER-SERVICE")
@LoadBalancerClient(name = "CUSTOMER-SERVICE")
public interface CustomerService {

    @GetMapping(value = "/customer/viewByAccount/{accountNumber}", consumes = {"application/json"}, produces = {"application/json"})
    Customer getCustomerByAccountNumber(@PathVariable String accountNumber);

    @PutMapping(value = "/customer/update")
    void updateAndSaveCustomer(@RequestBody Customer customer);

}