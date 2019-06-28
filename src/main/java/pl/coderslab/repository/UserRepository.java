package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.User;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findUserByEmail(String email);
}
