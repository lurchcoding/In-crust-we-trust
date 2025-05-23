package at.incrustwetrust.pizzeria.repository;

import at.incrustwetrust.pizzeria.entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CostumerRepository extends JpaRepository<Costumer, String> {

    Optional <Costumer> findCostumerByEmail(String email);
    Optional <Costumer> findCostumerByCostumerName(String username);

}
