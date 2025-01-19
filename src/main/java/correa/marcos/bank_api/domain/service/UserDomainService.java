package correa.marcos.bank_api.domain.service;

import correa.marcos.bank_api.domain.model.User;
import correa.marcos.bank_api.domain.repository.UserRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDomainService {

    @Autowired
    private UserRepository repository;

    public void validateDataToCreateUser(User user) {
        if (StringUtils.isEmpty(user.getName())
                || StringUtils.isEmpty(user.getLastName())
                || StringUtils.isEmpty(user.getCpfCnpj()))
            throw new IllegalArgumentException("Check the user data sent.");

        if (repository.exists(user.getCpfCnpj()))
            throw new IllegalArgumentException("This user already exists");

        user.setActive(true);
    }
    // Outros métodos de domínio
}
