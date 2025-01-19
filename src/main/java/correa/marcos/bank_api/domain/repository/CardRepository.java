package correa.marcos.bank_api.domain.repository;

import correa.marcos.bank_api.domain.model.Account;
import correa.marcos.bank_api.domain.model.Card;
import correa.marcos.bank_api.domain.model.User;

import java.util.List;

public interface CardRepository extends BaseRepository<Card> {
    Boolean exists(String number);
    List<Card> findByUser(User user);
    List<Card> findByAccount(Account account);
}
