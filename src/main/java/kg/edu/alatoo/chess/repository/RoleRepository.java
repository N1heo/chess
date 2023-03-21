package kg.edu.alatoo.chess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kg.edu.alatoo.chess.entity.Role;;

public interface RoleRepository extends JpaRepository<Role, String> {

}
