package kg.edu.alatoo.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kg.edu.alatoo.delivery.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    
}
