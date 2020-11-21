package kz.gexabyte.jwtappdemo.repository;

import kz.gexabyte.jwtappdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
