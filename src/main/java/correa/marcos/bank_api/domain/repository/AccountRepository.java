package correa.marcos.bank_api.domain.repository;

import correa.marcos.bank_api.domain.model.Account;

public interface AccountRepository extends BaseRepository<Account>{
    Boolean exists(String number);
}
