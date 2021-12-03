package ec.edu.espe.BQAuth.service;

import ec.edu.espe.BQAuth.dao.UserRepository;
import ec.edu.espe.BQAuth.model.Users;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.codec.EncodingException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @NonNull
    private final UserRepository userRepository;

    public List<Users> findAll() {
        return userRepository.findAll();
    }


    public Users create(Users user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new 
                IllegalArgumentException("Este usuario ya ha sido ocupado");
        } else if (userRepository.existsByTypeAndIdentifier(user.getType(), user.getIdentifier())) {
            throw new 
                IllegalArgumentException("Ya existe una cuenta con ese número de identificación");
        } else {
            try {
                user.setEncodedPassword();
            } catch (EncodingException exception) {
                throw new IllegalArgumentException("Impossible to "
                        + "encoding password.");
            }
            userRepository.save(user);
        }
        return user;
    }

    public Users update(Users user) {
        if (userRepository.existsById(user.getUserId())) {
            Users oldUser = userRepository.getById(user.getUserId());
            if (user.getPassword() == null) {
                user.setPassword(oldUser.getPassword());
            } else {
                user.setEncodedPassword();
            }                       
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User not found.");
        }
        return user;
    }

    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            Users user = userRepository.getById(id);
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User not found.");
        }
    }
}
