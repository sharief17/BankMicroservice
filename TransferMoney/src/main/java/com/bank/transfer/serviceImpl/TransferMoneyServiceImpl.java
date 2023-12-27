package com.bank.transfer.serviceImpl;

import java.util.UUID;

import com.bank.transfer.externalService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.transfer.entity.Customer;
import com.bank.transfer.entity.TransferMoney;
import com.bank.transfer.repository.TransferMoneyRepository;
import com.bank.transfer.service.TransferMoneyService;

@Service
public class TransferMoneyServiceImpl implements TransferMoneyService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransferMoneyRepository transferMoneyRepository;

    @Override
    public String transferMoney(TransferMoney transfer) {
        transfer.setTransactionId(UUID.randomUUID().toString());
        if (transfer.getAmount() < 0) {
            return "Please add a valid amount";
        }

        Customer tobeDebited = customerService.getCustomerByAccountNumber(transfer.getFromAccount());
        Customer tobeCredited = customerService.getCustomerByAccountNumber(transfer.getToAccount());

        if (tobeDebited != null && tobeCredited != null) {
            if (tobeDebited.getAmount() >= transfer.getAmount()) {
                tobeDebited.setAmount(tobeDebited.getAmount() - transfer.getAmount());
                tobeCredited.setAmount(tobeCredited.getAmount() + transfer.getAmount());

                customerService.updateAndSaveCustomer(tobeCredited);
                customerService.updateAndSaveCustomer(tobeDebited);
                transferMoneyRepository.save(transfer);

                return "Transaction Successful !!";
            } else {
                return "Insufficient amount in the account for transfer";
            }
        } else {
            return "Debitter/Crediter account not found";
        }
    }

}
