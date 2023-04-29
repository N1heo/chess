package kg.edu.alatoo.delivery.repository;

import kg.edu.alatoo.delivery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
