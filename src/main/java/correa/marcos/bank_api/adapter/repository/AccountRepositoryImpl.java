package correa.marcos.bank_api.adapter.repository;

import correa.marcos.bank_api.domain.model.Account;
import correa.marcos.bank_api.domain.repository.AccountRepository;
import correa.marcos.bank_api.infrastructure.persistence.AccountRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private AccountRepositoryJpa accountRepositoryJpa;

    @Override
    public Boolean exists(String number) {
        return accountRepositoryJpa.existsByNumber(number);
    }

    @Override
    public Account save(Account obj) {
        return accountRepositoryJpa.save(obj);
    }

    @Override
    public Optional<Account> find(Long id) {
        return accountRepositoryJpa.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepositoryJpa.findAll();
    }

    @Override
    public Boolean exists(Long id) {
        return accountRepositoryJpa.existsById(id);
    }

    @Override
    public void delete(Account obj) {
        accountRepositoryJpa.delete(obj);
    }
}
