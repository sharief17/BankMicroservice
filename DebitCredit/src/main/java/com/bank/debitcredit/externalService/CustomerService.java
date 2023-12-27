package com.bank.debitcredit.externalService;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bank.debitcredit.entity.Customer;


@FeignClient("CUSTOMER-SERVICE")
@LoadBalancerClient(name = "CUSTOMER-SERVICE")
public interface CustomerService {

    @GetMapping(value = "/customer/viewByAccount/{accountNumber}", consumes = {"application/json"}, produces = {"application/json"})
    Customer getCustomerByAccountNumber(@PathVariable String accountNumber);

    @PutMapping(value = "/customer/update")
    void updateAndSaveCustomer(@RequestBody Customer customer);

}
