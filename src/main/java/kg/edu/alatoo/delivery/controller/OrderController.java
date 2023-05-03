package kg.edu.alatoo.delivery.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kg.edu.alatoo.delivery.entity.Cart;
import kg.edu.alatoo.delivery.entity.CartItem;
import kg.edu.alatoo.delivery.entity.Product;
import kg.edu.alatoo.delivery.repository.CartItemRepository;
import kg.edu.alatoo.delivery.repository.CartRepository;
import kg.edu.alatoo.delivery.repository.ProductRepository;

@Controller
public class OrderController {

    @Autowired
    CartRepository cartRepository;
    
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @GetMapping("/order")
    public String show_order(Model model){
        model.addAttribute("cartItems", cartItemRepository.findAll());
        return "order";
    }

    @PostMapping("/order")
    public String post_order(@RequestParam Long id, @RequestParam Long amount, Model model, HttpSession session){
        Cart cart = getCartFromSession(session);
        cartRepository.save(cart);
        CartItem cartItem = new CartItem();
        Product product = getProductById(id);
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setAmount(amount);
        cartItem.setPrice(product.getPrice());
        cartItem.setProduct_name(product.getProduct_name());
        cartItemRepository.save(cartItem);

        model.addAttribute("cartItems", cartItemRepository.findAll());

        return "order";
    }

    private Product getProductById(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    private Cart getCartFromSession(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            cartRepository.save(cart);
            session.setAttribute("cart", cart);
        }
        return cart;
    }
}

