package correa.marcos.bank_api.application.usecase;

import correa.marcos.bank_api.domain.model.Account;
import correa.marcos.bank_api.domain.model.Card;
import correa.marcos.bank_api.domain.repository.AccountRepository;
import correa.marcos.bank_api.domain.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class AccountUseCase {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CardRepository cardRepository;

    public List<Account> findAll() { return accountRepository.findAll(); }

    public Account find(Long id) {
        return accountRepository.find(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public Account create(Account account) {
        if (accountRepository.exists(account.getNumber()))
            throw new IllegalArgumentException("This account already exists");
        return accountRepository.save(account);
    }

    public List<Card> getAccountCards(Account account) {
        if (!accountRepository.exists(account.getId()))
            throw new IllegalArgumentException("This account don't exists");
        return cardRepository.findByAccount(account);
    }
}
