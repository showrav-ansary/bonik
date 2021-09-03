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

        Category category3 = new Category();
        category3.setId(3);
        category3.setCategoryName("Electronics");

        Category category4 = new Category();
        category4.setId(4);
        category4.setCategoryName("Arts");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);
    }

    private void exampleProducts(){
        final String NAME = "Example Name";
        final String IMAGE_URL = "https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX7389458.jpg";
        final String DESCRIPTION = "Example Description";
        final BigDecimal PRICE = BigDecimal.valueOf(1000);

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();

        product1.setName(NAME);
        product1.setImageUrl(IMAGE_URL);
        product1.setDescription(DESCRIPTION);
        product1.setCategory(categoryRepository.findByCategoryName("Games"));
        product1.setPrice(PRICE);

        product2.setName(NAME);
        product2.setImageUrl(IMAGE_URL);
        product2.setDescription(DESCRIPTION);
        product2.setCategory(categoryRepository.findByCategoryName("Books"));
        product2.setPrice(PRICE);

        product3.setName(NAME);
        product3.setImageUrl(IMAGE_URL);
        product3.setDescription(DESCRIPTION);
        product3.setCategory(categoryRepository.findByCategoryName("Electronics"));
        product3.setPrice(PRICE);

        product4.setName(NAME);
        product4.setImageUrl(IMAGE_URL);
        product4.setDescription(DESCRIPTION);
        product4.setCategory(categoryRepository.findByCategoryName("Arts"));
        product4.setPrice(PRICE);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);
    }
}
