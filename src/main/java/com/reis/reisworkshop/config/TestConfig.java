package com.reis.reisworkshop.config;

import com.reis.reisworkshop.entities.*;
import com.reis.reisworkshop.entities.enums.OrderStatus;
import com.reis.reisworkshop.repository.*;
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

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        User use2r = new User( "Ray", "ray@gmail.com", "0343000", "123456");
        User use3r = new User( "rdzin", "rdzin@gmail.com", "05653000", "56523456");


        Order o1 = new Order(null, Instant.parse("2026-09-30T10:30:33Z"), OrderStatus.PAID, use2r);
        Order o2 = new Order(null, Instant.parse("2026-09-30T13:03:33Z"), OrderStatus.WAITING_PAYMENT,use3r);

        Category cat1 = new Category(null, "eletronicos");
        Category cat2 = new Category(null, "hardware");


        Product product1 = new Product(null, "MacBook", "macbook pro 5", 5000.0, "src/main/java/com/reis/reisworkshop/img/captura-de-tela-2026-05-07-a-s-14-53-copiar-69fcd1c79a822.jpg");
        Product product2 = new Product(null, "ryzen", "ryen5", 5000.0, "src/main/java/com/reis/reisworkshop/img/captura-de-tela-2026-05-07-a-s-14-53-copiar-69fcd1c79a822.jpg");
        Product product3 = new Product(null, "ryzen", "ryen5", 5000.0, "src/main/java/com/reis/reisworkshop/img/captura-de-tela-2026-05-07-a-s-14-53-copiar-69fcd1c79a822.jpg");
        userRepository.saveAll(Arrays.asList(use2r, use3r));
        orderRepository.saveAll(Arrays.asList(o1,o2));

        OrderItem orderItem1 = new OrderItem(o1, product1, 2,  product1.getPrice());
        OrderItem orderItem2 = new OrderItem(o1, product2, 3,  product2.getPrice());

        product1.getCategories().add(cat1);
        product2.getCategories().add(cat2);
        product3.getCategories().add(cat1);

        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(product1, product2, product3));

        orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2));

        Payment payment1 = new Payment(null, Instant.parse("2026-09-30T11:30:33Z"), o1 );
        o1.setPayment(payment1);

        orderRepository.save(o1);

    }
}
