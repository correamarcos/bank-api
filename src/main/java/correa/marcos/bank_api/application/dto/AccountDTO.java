package correa.marcos.bank_api.application.dto;

import correa.marcos.bank_api.domain.model.Account;

import java.math.BigDecimal;

public record AccountDTO(Long id,
                         String number,
                         String agency,
                         BigDecimal balance,
                         BigDecimal limit) {

    public AccountDTO(Account account){
        this(account.getId(),
                account.getNumber(),
                account.getAgency(),
                account.getBalance(),
                account.getLimit());
    }

    public Account toDomain(){
        return new Account(this.id,
                this.number,
                this.agency,
                this.balance,
                this.limit);
    }
}





