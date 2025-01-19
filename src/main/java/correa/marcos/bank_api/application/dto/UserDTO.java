package correa.marcos.bank_api.application.dto;

import correa.marcos.bank_api.domain.model.Account;
import correa.marcos.bank_api.domain.model.Card;
import correa.marcos.bank_api.domain.model.Feature;
import correa.marcos.bank_api.domain.model.User;
import org.apache.commons.lang3.BooleanUtils;

import java.util.ArrayList;
import java.util.List;

public record UserDTO(Long id,
        String name,
        String lastName,
        String cpfCnpj,
        Boolean active,
        AccountDTO account,
        List<CardDTO> cards,
        List<FeatureDTO> features) {

    public UserDTO(User user){
        this(user.getId(),
                user.getName(),
                user.getLastName(),
                user.getCpfCnpj(),
                user.getActive(),
                new AccountDTO(user.getAccount()),
                user.getCards().stream().map(CardDTO::new).toList(),
                user.getFeatures().stream().map(FeatureDTO::new).toList());
    }

    public User toDomain(){
        return new User(this.id(),
                this.name(),
                this.lastName(),
                this.cpfCnpj(),
                this.active(),
                this.account().toDomain(),
                this.cards().stream().map(CardDTO::toDomain).toList(),
                this.features().stream().map(FeatureDTO::toDomain).toList());
    }
}
