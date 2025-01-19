package correa.marcos.bank_api.domain.service;

import correa.marcos.bank_api.domain.model.Card;
import correa.marcos.bank_api.domain.repository.CardRepository;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
public class CardDomainService {
    @Autowired
    private CardRepository cardRepository;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");

    public void validadeDataToCreateCard(Card card) {
        if (StringUtils.isEmpty(card.getNumber()) || card.getIsDigital() == null)
            throw new IllegalArgumentException("Check the card data sent.");

        if (cardRepository.exists(card.getNumber()))
            throw new IllegalArgumentException("This card already exists");

        if (card.getLimit() == null) card.setLimit(new BigDecimal(2500));
        if (StringUtils.isEmpty(card.getValidity()))
            card.setValidity(getExpiryMonthYear(createExpirateDate()));
        if (StringUtils.isEmpty(card.getCvc()))
            card.setCvc(Integer.toString(generateRandomCvcCard()));

        card.setBlocked(Boolean.FALSE);
    }

    public LocalDate createExpirateDate(){
        LocalDate currentDate = LocalDate.now();
        return currentDate.plusYears(5);
    }

    public String getExpiryMonthYear(LocalDate expiryDate) {
         return expiryDate.format(formatter);
    }

    public int generateRandomCvcCard() {
        Random random = new Random();
        return 100 + random.nextInt(900);
    }
}
