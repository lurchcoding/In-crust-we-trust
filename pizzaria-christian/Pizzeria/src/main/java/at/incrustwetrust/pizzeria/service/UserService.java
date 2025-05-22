package at.incrustwetrust.pizzeria.service;

import at.incrustwetrust.pizzeria.entity.User;
import at.incrustwetrust.pizzeria.exception.ObjectAlreadyExcistsExeception;
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

        Optional<User> userCheck = userRepository.findUsersByEmail(user.getEmail());
        // userCheck.ifPresent(user.getEmail() -> throw new ObjectAlreadyExcistsExeception("Es ist bereits ein Benutzer mit dieser E-Mail vorhanden");
        if (userCheck.isPresent()) {
            throw new ObjectAlreadyExcistsExeception("Es ist bereits ein Benutzer mit dieser E-Mail vorhanden");
        }

        userCheck = userRepository.findUsersByUsername(user.getUsername());
        if (userCheck.isPresent()) {
            throw new ObjectAlreadyExcistsExeception("Es ist bereits ein Benutzer mit diesem Benutzernamen vorhanden");
        }

        // Username nor Email exists -> new User
        return userRepository.save(user);

    }


    public User read(String id) {
        //return userRepository.findById(id).ifPresentOrElse();
        // return userRepository.findById(id).orElseThrow();

        Optional<User> userFound = userRepository.findById(id);
        System.out.println("fuck it");
        if (userFound.isEmpty()) {
            System.out.println("fuck it");
            throw new ObjectNotFoundException("Kein Benutzer mit der ID" + id + "vorhanden");
        }
        return userFound.get();
    }

}
