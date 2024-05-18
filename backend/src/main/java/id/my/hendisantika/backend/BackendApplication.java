package id.my.hendisantika.backend;

import id.my.hendisantika.backend.model.Product;
import id.my.hendisantika.backend.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(ProductService productService) {
        return args -> {
            Product product = new Product();
            product.setTitle("iPhone");
            product.setPrice(1200D);
            product.setQuantity(99);
            productService.save(product);

            Product product2 = new Product();
            product2.setTitle("Blackberry");
            product2.setPrice(1100D);
            product2.setQuantity(55);
            productService.save(product2);
        };
    }
}
