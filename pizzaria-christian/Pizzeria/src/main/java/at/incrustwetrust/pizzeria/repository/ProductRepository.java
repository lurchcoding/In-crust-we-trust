package at.incrustwetrust.pizzeria.repository;

import at.incrustwetrust.pizzeria.entity.Product;
import at.incrustwetrust.pizzeria.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository <Product, String> {

    Optional <Product> findProductByProductName(String productName);
    Optional <Product> findProductByProductNameAndProductIdNot(String productName, String id);

}
