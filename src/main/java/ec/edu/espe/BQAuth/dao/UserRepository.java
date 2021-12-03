package ec.edu.espe.BQAuth.dao;

import ec.edu.espe.BQAuth.model.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);

    Users findByUsernameAndPassword(String username, String password);
    

    Boolean existsByTypeAndIdentifier(String type, String identifier);
    
    Boolean existsByUsername(String username);

    Boolean existsByUsernameAndPassword(String username, String password);
}
