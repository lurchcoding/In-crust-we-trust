package at.incrustwetrust.pizzeria.controller;

import at.incrustwetrust.pizzeria.entity.Costumer;
import at.incrustwetrust.pizzeria.service.CostumerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/Benutzer")
public class CostumerController {

    private final CostumerService costumerService;

    public CostumerController(CostumerService costumerService){ this.costumerService = costumerService;}


    @GetMapping
    public List<Costumer> readAll ()
    {
        return null;
    }

    @GetMapping("/{id}")
    public Costumer read (@PathVariable String id)
    {
        return this.costumerService.read(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Costumer create (@RequestBody @Valid Costumer costumer)
    {
        return this.costumerService.create(costumer);
    }

    @PutMapping ("/{id}")
    public Costumer update (@PathVariable String id, @RequestBody Costumer costumer)
    {
        return null;
    }

    @DeleteMapping ("/{id}")
    public Costumer delete (@PathVariable String id)
    {
        return null;
    }

}
