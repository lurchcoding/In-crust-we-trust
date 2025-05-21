package at.incrustwetrust.pizzeria.controller;

import at.incrustwetrust.pizzeria.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/Benutzer")
public class UserController {

    @GetMapping
    public List<User> readAll ()
    {
        return null;
    }

    @GetMapping("/{id}")
    public User read (@PathVariable String id)
    {
        return null;
    }

    @PostMapping
    public User create (@RequestBody User user)
    {
        return null;
    }

    @PutMapping ("/{id})"
    public User update (@PathVariable String Id, @RequestBody User user)
    {
        return null;
    }

    @DeleteMapping ("/{id}")
    public User delete (@PathVariable String id)
    {
        return null;
    }

}
