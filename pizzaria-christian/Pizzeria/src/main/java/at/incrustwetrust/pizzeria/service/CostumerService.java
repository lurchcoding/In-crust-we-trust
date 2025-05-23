package at.incrustwetrust.pizzeria.service;

import at.incrustwetrust.pizzeria.entity.Costumer;
import at.incrustwetrust.pizzeria.exception.ObjectAlreadyExistsException;
import at.incrustwetrust.pizzeria.exception.ObjectNotFoundException;
import at.incrustwetrust.pizzeria.repository.CostumerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CostumerService {

    // final because we only want it once
    private final CostumerRepository costumerRepository;

    public CostumerService(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    public Costumer create(Costumer costumer) {

        Optional<Costumer> userCheck = costumerRepository.findCostumerByEmail(costumer.getEmail());
        // userCheck.ifPresent(user.getEmail() -> throw new ObjectAlreadyExistsException("Es ist bereits ein Benutzer mit dieser E-Mail vorhanden");
        if (userCheck.isPresent()) {
            throw new ObjectAlreadyExistsException("Es ist bereits ein Benutzer mit dieser E-Mail vorhanden");
        }

        userCheck = costumerRepository.findCostumerByCostumerName(costumer.getCostumerName());
        if (userCheck.isPresent()) {
            throw new ObjectAlreadyExistsException("Es ist bereits ein Benutzer mit diesem Benutzernamen vorhanden");
        }

        // Username nor Email exists -> new User
        return costumerRepository.save(costumer);

    }


    public Costumer read(String id) {
       // return costumerRepository.findById(id).ifPresentOrElse((String s) -> Anweisung; () -> Anweisung);
       return costumerRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Kein Benutzer mit der ID " + id + " vorhanden"));

      /* Optional<Costumer> userFound = costumerRepository.findById(id);
        if (userFound.isEmpty()) {
            throw new ObjectNotFoundException("Kein Benutzer mit der ID " + id + " vorhanden");
        }
        return userFound.get();*/
    }

}
