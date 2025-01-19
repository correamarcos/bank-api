package correa.marcos.bank_api.application.service;

import correa.marcos.bank_api.application.dto.UserDTO;
import correa.marcos.bank_api.application.usecase.UserUseCase;
import correa.marcos.bank_api.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements BaseService<UserDTO>{
    @Autowired
    private UserUseCase userUseCase;

    @Override
    public UserDTO findById(Long id) {
        return new UserDTO(userUseCase.find(id));
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userUseCase.findAll();
        if (users.isEmpty())
            return List.of();

        return users.stream().map(UserDTO::new).toList();
    }

    public UserDTO create(UserDTO userDTO) {
        User user = userDTO.toDomain();
        User createdUser = userUseCase.create(user);

        return new UserDTO(createdUser);
    }

    @Override
    public UserDTO update(UserDTO request) {
        return null;
    }

    @Override
    public void delete(UserDTO id) {

    }
}
