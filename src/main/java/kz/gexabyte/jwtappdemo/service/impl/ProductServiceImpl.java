package kz.gexabyte.jwtappdemo.service.impl;

import kz.gexabyte.jwtappdemo.model.Product;
import kz.gexabyte.jwtappdemo.repository.ProductRepository;
import kz.gexabyte.jwtappdemo.repository.RoleRepository;
import kz.gexabyte.jwtappdemo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> findAll(int page) {
        return productRepository.findAll(PageRequest.of(page, 10));
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
        log.info("Delete Product");
    }

    @Override
    public Product findProductById(Long id) {
        log.info("Product find");
        return productRepository.findProductById(id);
    }

    @Override
    public Product create(Product product) {
        return null;
    }
}
