package kg.edu.alatoo.delivery.repository;

import kg.edu.alatoo.delivery.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    
}
