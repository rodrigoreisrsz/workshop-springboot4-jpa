package com.reis.reisworkshop.config;

import com.reis.reisworkshop.entities.Category;
import com.reis.reisworkshop.entities.Order;
import com.reis.reisworkshop.entities.Product;
import com.reis.reisworkshop.entities.User;
import com.reis.reisworkshop.entities.enums.OrderStatus;
import com.reis.reisworkshop.repository.CategoryRepository;
import com.reis.reisworkshop.repository.OrderRepository;
import com.reis.reisworkshop.repository.ProductRepository;
import com.reis.reisworkshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    // popular banco de dados para testes
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        User use2r = new User( "Ray", "ray@gmail.com", "0343000", "123456");
        User use3r = new User( "rdzin", "rdzin@gmail.com", "05653000", "56523456");


        Order o1 = new Order(null, Instant.parse("2026-09-30T10:30:33Z"), OrderStatus.PAID, use2r);
        Order o2 = new Order(null, Instant.parse("2026-09-30T13:03:33Z"), OrderStatus.WAITING_PAYMENT,use3r);

        Category cat1 = new Category(null, "eletronicos");
        Category cat2 = new Category(null, "hardware");

        Product product1 = new Product(null, "MacBook", "macbook pro 5", 5000.0, "src/main/java/com/reis/reisworkshop/img/captura-de-tela-2026-05-07-a-s-14-53-copiar-69fcd1c79a822.jpg");
        userRepository.saveAll(Arrays.asList(use2r, use3r));
        orderRepository.saveAll(Arrays.asList(o1,o2));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(product1));
    }
}
