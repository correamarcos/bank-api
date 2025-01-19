package correa.marcos.bank_api.adapter.repository;

import correa.marcos.bank_api.domain.model.User;
import correa.marcos.bank_api.domain.repository.UserRepository;
import correa.marcos.bank_api.infrastructure.persistence.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    @Override
    public User save(User obj) {
        return userRepositoryJpa.save(obj);
    }

    @Override
    public Optional<User> find(Long id) {
        return userRepositoryJpa.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepositoryJpa.findAll();
    }

    @Override
    public void delete(User obj) {
        userRepositoryJpa.delete(obj);
    }

    @Override
    public Boolean exists(String cpfCnpj){
        return userRepositoryJpa.existsByCpfCnpj(cpfCnpj);
    }

    @Override
    public Boolean exists(Long id) {
        return userRepositoryJpa.existsById(id);
    }

}

