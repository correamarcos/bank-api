package correa.marcos.bank_api.infrastructure.persistence;

import correa.marcos.bank_api.domain.model.Account;
import correa.marcos.bank_api.domain.model.Card;
import correa.marcos.bank_api.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepositoryJpa extends JpaRepository<Card, Long> {
    Boolean existsByNumber(String number);
    List<Card> findByUser(User user);
    List<Card> findByAccount(Account account);
}
