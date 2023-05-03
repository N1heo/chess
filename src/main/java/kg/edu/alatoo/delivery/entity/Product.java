package kg.edu.alatoo.delivery.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="t_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    private String product_name;
    
    private Long price;

    @OneToMany(mappedBy="product")
    private Set<CartItem> cartItem;

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Set<CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(Set<CartItem> cartItem) {
        this.cartItem = cartItem;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

}
