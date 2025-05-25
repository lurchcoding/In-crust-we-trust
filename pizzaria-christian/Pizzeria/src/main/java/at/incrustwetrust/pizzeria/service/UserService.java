package at.incrustwetrust.pizzeria.service;

import at.incrustwetrust.pizzeria.entity.User;
import at.incrustwetrust.pizzeria.exception.ObjectAlreadyExistsException;
import at.incrustwetrust.pizzeria.exception.ObjectNotFoundException;
import at.incrustwetrust.pizzeria.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    // final because we only want it once
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {

        Optional<User> userCheck = userRepository.findUserByEmail(user.getEmail());
        // userCheck.ifPresent(user.getEmail() -> throw new ObjectAlreadyExistsException("Es ist bereits ein Benutzer mit dieser E-Mail vorhanden");
        if (userCheck.isPresent()) {
            throw new ObjectAlreadyExistsException("Es ist bereits ein Benutzer mit dieser E-Mail vorhanden");
        }

        userCheck = userRepository.findUserByUsername(user.getUsername());
        if (userCheck.isPresent()) {
            throw new ObjectAlreadyExistsException("Es ist bereits ein Benutzer mit diesem Benutzernamen vorhanden");
        }

        // Username nor Email exists -> new User
        return userRepository.save(user);

    }


    public User read(String id) {
       // return userRepository.findById(id).ifPresentOrElse((String s) -> Anweisung; () -> Anweisung);
       return userRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Kein Benutzer mit der ID " + id + " vorhanden"));

      /* Optional<User> userFound = userRepository.findById(id);
        if (userFound.isEmpty()) {
            throw new ObjectNotFoundException("Kein Benutzer mit der ID " + id + " vorhanden");
        }
        return userFound.get();*/
    }

}
