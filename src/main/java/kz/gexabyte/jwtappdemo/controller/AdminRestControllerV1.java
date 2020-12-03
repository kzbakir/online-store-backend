package kz.gexabyte.jwtappdemo.controller;

import kz.gexabyte.jwtappdemo.dto.AdminUserDto;
import kz.gexabyte.jwtappdemo.dto.ProductPageDTO;
import kz.gexabyte.jwtappdemo.model.Product;
import kz.gexabyte.jwtappdemo.model.User;
import kz.gexabyte.jwtappdemo.service.ProductService;
import kz.gexabyte.jwtappdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/admin/")
public class AdminRestControllerV1 {

    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public AdminRestControllerV1(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService =  productService;
    }

    @GetMapping(value = "user/all")
    public ResponseEntity<List<AdminUserDto>> getAllUsers() {
        List<User> users = userService.getAll();
        List<AdminUserDto> result = new ArrayList<>();

        if (users == null || users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        users.forEach(user -> result.add(AdminUserDto.fromUser(user)));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(value = "user/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);
        if (user != null) {
            userService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "product/all/{page}")
    public ResponseEntity<List<ProductPageDTO>> getAllProducts(@PathVariable(name = "page") int page) {
        List<ProductPageDTO> result = new ArrayList<>();
        Page<Product> products = productService.findAll(page);

        if (products == null || products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        products.forEach(product -> result.add(ProductPageDTO.fromProduct(product)));
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @DeleteMapping(value = "product/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(name = "id") Long id){
        Product product = productService.findProductById(id);
        if (product != null) {
            productService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
