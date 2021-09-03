package com.showrav.bonik;

import com.showrav.bonik.domain.Category;
import com.showrav.bonik.domain.Product;
import com.showrav.bonik.repository.CategoryRepository;
import com.showrav.bonik.service.ProductService;
import com.showrav.bonik.domain.User;
import com.showrav.bonik.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StartupData implements CommandLineRunner {
    private final UserService userService;
    private final ProductService productService;
    private final CategoryRepository categoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(StartupData.class);

    @Autowired
    public StartupData(UserService userService, ProductService productService, CategoryRepository categoryRepository) {
        this.userService = userService;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        adminAccount();
        userAccount();
        category();
        exampleProducts();
    }

    private void userAccount(){
        User user = new User();

        user.setUsername("user");
        user.setPassword("user");
        user.setPasswordConfirm("user");
        user.setGender("Female");
        user.setEmail("user@example.com");

        userService.save(user);
    }

    private void adminAccount(){
        User admin = new User();

        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setPasswordConfirm("admin");
        admin.setGender("Male");
        admin.setEmail("admin@example.com");

        userService.save(admin);
    }

    private void category(){
        Category category1 = new Category();
        category1.setId(1);
        category1.setCategoryName("Games");

        Category category2 = new Category();
        category2.setId(2);
        category2.setCategoryName("Books");

        categoryRepository.save(category1);
        categoryRepository.save(category2);

    }

    private void exampleProducts(){
        Product product1 = new Product();
        Product product2 = new Product();

        product1.setName("Horizon Hero Dawn");
        product1.setImageUrl("https://upload.wikimedia.org/wikipedia/en/9/93/Horizon_Zero_Dawn.jpg");
        product1.setDescription("PS Game");
        product1.setCategory(categoryRepository.findByCategoryName("Games"));
        product1.setPrice(BigDecimal.valueOf(4000));

        product2.setName("Programming Contest : Data Structure and Algorithms");
        product2.setImageUrl("https://raw.githubusercontent.com/showrav-ansary/Programming-Contest-Data-Structure-and-Algorithm-by-Md.-Mahbubul-Hasan/main/Cover.png");
        product2.setDescription("Programming Contest Book");
        product2.setCategory(categoryRepository.findByCategoryName("Books"));
        product2.setPrice(BigDecimal.valueOf(300));



        productService.save(product1);
        productService.save(product2);

    }
}
