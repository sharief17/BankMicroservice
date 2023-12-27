package com.bank.debitcredit.service;

import com.bank.debitcredit.entity.DebitCredit;

public interface DebitCreditService {

    String debitMoney(DebitCredit transaction);

    String creditMoney(DebitCredit transaction);

}
