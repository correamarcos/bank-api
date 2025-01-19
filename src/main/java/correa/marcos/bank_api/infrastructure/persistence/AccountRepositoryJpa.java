package correa.marcos.bank_api.infrastructure.persistence;

import correa.marcos.bank_api.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepositoryJpa extends JpaRepository<Account, Long> {
    Boolean existsByNumber(String number);
}
