package id.my.hendisantika.backend.service;

import id.my.hendisantika.backend.model.Product;
import id.my.hendisantika.backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * Created by IntelliJ IDEA.
 * Project : product-app
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/19/24
 * Time: 06:06
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product updateById(Long id, Product product) {
        Product managedProduct = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"));
        managedProduct.setTitle(product.getTitle());
        managedProduct.setQuantity(product.getQuantity());
        managedProduct.setPrice(product.getPrice());

        return this.save(managedProduct);
    }
}
