package ec.edu.espe.BQAuth.service;

import ec.edu.espe.BQAuth.dao.UserRepository;
import ec.edu.espe.BQAuth.model.Users;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @NonNull
    private final UserRepository userRepository;

    public Users login(String username, String password) {
        if (userRepository.existsByUsernameAndPassword(username, password)) {
            Users identifiedUser;
            identifiedUser = userRepository
                    .findByUsernameAndPassword(username, password);
            return identifiedUser;
        } else {
            throw new IllegalArgumentException("Credenciales inválidas.");
        }
    }
}
