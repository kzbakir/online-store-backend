package kz.gexabyte.jwtappdemo.repository;

import kz.gexabyte.jwtappdemo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

   Page<Product> findAll(Pageable pageable);

   void deleteById(Long id);

   Product findProductById(Long id);
}
