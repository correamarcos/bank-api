package correa.marcos.bank_api.adapter.repository;

import correa.marcos.bank_api.domain.model.Account;
import correa.marcos.bank_api.domain.model.Card;
import correa.marcos.bank_api.domain.model.User;
import correa.marcos.bank_api.domain.repository.CardRepository;
import correa.marcos.bank_api.infrastructure.persistence.CardRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CardRepositoryImpl implements CardRepository {

    @Autowired
    private CardRepositoryJpa cardRepositoryJpa;

    @Override
    public Boolean exists(String number) {
        return cardRepositoryJpa.existsByNumber(number);
    }

    @Override
    public List<Card> findByUser(User user) {
        return cardRepositoryJpa.findByUser(user);
    }

    @Override
    public List<Card> findByAccount(Account account) {
        return cardRepositoryJpa.findByAccount(account);
    }

    @Override
    public Card save(Card obj) {
        return cardRepositoryJpa.save(obj);
    }

    @Override
    public Optional<Card> find(Long id) {
        return cardRepositoryJpa.findById(id);
    }

    @Override
    public List<Card> findAll() {
        return cardRepositoryJpa.findAll();
    }

    @Override
    public Boolean exists(Long id) {
        return cardRepositoryJpa.existsById(id);
    }

    @Override
    public void delete(Card obj) {
        cardRepositoryJpa.delete(obj);
    }
}
