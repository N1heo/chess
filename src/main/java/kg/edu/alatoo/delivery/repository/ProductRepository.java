package kg.edu.alatoo.delivery.repository;

import kg.edu.alatoo.delivery.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
}