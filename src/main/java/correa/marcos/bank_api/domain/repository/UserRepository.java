package correa.marcos.bank_api.domain.repository;

import correa.marcos.bank_api.domain.model.User;

public interface UserRepository extends BaseRepository<User>{
    Boolean exists(String cpfCnpj);
}
