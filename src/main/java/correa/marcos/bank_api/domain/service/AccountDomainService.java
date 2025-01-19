package correa.marcos.bank_api.domain.service;

import correa.marcos.bank_api.domain.model.Account;
import correa.marcos.bank_api.domain.repository.AccountRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountDomainService {
    @Autowired
    private AccountRepository repository;

    public void validateDataToCreateAccount(Account account) {
        if(StringUtils.isEmpty(account.getNumber())
                || StringUtils.isEmpty(account.getAgency()))
            throw new IllegalArgumentException("Check the account data sent.");

        if (repository.exists(account.getNumber()))
            throw new IllegalArgumentException("This account already exists");

        if (account.getBalance() == null) account.setBalance(BigDecimal.ZERO);
        if (account.getLimit() == null) account.setLimit(new BigDecimal(5000));
    }
}
