package correa.marcos.bank_api.application.usecase;

import correa.marcos.bank_api.domain.model.Card;
import correa.marcos.bank_api.domain.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class CardUseCase {

    @Autowired
    private CardRepository cardRepository;

    public List<Card> findAll() { return cardRepository.findAll(); }

    public Card find(Long id) {
        return cardRepository.find(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public Card create(Card card) {
        if (cardRepository.exists(card.getNumber()))
            throw new IllegalArgumentException("This card already exists");
        return cardRepository.save(card);
    }
}
