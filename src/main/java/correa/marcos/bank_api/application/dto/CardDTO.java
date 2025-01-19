package correa.marcos.bank_api.application.dto;

import correa.marcos.bank_api.domain.model.Card;

import java.math.BigDecimal;

public record CardDTO(Long id,
                      String number,
                      BigDecimal limit,
                      String validity,
                      String cvc,
                      Boolean blocked,
                      Boolean isDigital) {

    public CardDTO(Card card){
        this(card.getId(),
                card.getNumber(),
                card.getLimit(),
                card.getValidity(),
                card.getCvc(),
                card.getBlocked(),
                card.getIsDigital());
    }

    public Card toDomain(){
        return new Card(this.id,
                this.number,
                this.limit,
                this.validity,
                this.cvc,
                this.blocked,
                this.isDigital);
    }
}
