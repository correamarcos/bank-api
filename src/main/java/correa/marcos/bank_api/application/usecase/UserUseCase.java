package correa.marcos.bank_api.application.usecase;

import correa.marcos.bank_api.domain.model.Account;
import correa.marcos.bank_api.domain.model.Card;
import correa.marcos.bank_api.domain.model.User;
import correa.marcos.bank_api.domain.repository.AccountRepository;
import correa.marcos.bank_api.domain.repository.CardRepository;
import correa.marcos.bank_api.domain.repository.UserRepository;
import correa.marcos.bank_api.domain.service.AccountDomainService;
import correa.marcos.bank_api.domain.service.CardDomainService;
import correa.marcos.bank_api.domain.service.UserDomainService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class UserUseCase {
    @Autowired
    private AccountDomainService accountDomainService;
    @Autowired
    private CardDomainService cardDomainService;
    @Autowired
    private UserDomainService userDomainService;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User find(Long id){
        return userRepository.find(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public User create(User user) {
        userDomainService.validateDataToCreateUser(user);
        accountDomainService.validateDataToCreateAccount(user.getAccount());;
        user.getAccount().setUser(user);
        user.getCards().forEach(c -> {
            cardDomainService.validadeDataToCreateCard(c);
            c.setUser(user);
            c.setAccount(user.getAccount());
        });
        return userRepository.save(user);
    }

    public List<Card> getUserCards(User user) {
        if (!userRepository.exists(user.getId()))
            throw new IllegalArgumentException("This user don't exists");
        return cardRepository.findByUser(user);
    }
}
