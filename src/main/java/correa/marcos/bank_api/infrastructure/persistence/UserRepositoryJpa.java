package correa.marcos.bank_api.infrastructure.persistence;

import correa.marcos.bank_api.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<User, Long> {
    Boolean existsByCpfCnpj(String cpfCnpj);

    // Métodos adicionais de consulta podem ser definidos aqui, se necessário
}
