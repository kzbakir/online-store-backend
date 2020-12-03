package kz.gexabyte.jwtappdemo.service;

import kz.gexabyte.jwtappdemo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {
    Page<Product> findAll(int page);

    void deleteById(Long id);

    Product findProductById(Long id);

    Product create(Product product);
}
