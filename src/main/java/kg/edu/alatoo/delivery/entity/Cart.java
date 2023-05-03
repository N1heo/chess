package kg.edu.alatoo.delivery.entity;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="t_cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long cart_id;

    @OneToMany(mappedBy="cart")
    private Set<CartItem> cartItem;

    public Long getCart_id() {
        return cart_id;
    }

    public void setCart_id(Long cart_id) {
        this.cart_id = cart_id;
    }

    public Set<CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(Set<CartItem> cartItem) {
        this.cartItem = cartItem;
    }
}
