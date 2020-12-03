package kz.gexabyte.jwtappdemo.repository;

import kz.gexabyte.jwtappdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);

    User findByActivationCode(String code);
}
