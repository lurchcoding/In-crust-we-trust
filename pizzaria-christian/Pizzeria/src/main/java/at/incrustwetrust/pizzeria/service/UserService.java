package at.incrustwetrust.pizzeria.service;

import at.incrustwetrust.pizzeria.entity.User;
import at.incrustwetrust.pizzeria.exception.ObjectAlreadyExistsException;
import at.incrustwetrust.pizzeria.exception.ObjectNotFoundException;
import at.incrustwetrust.pizzeria.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    // final because we only want it once
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        ifUsernameOrEmailAlreadyExistThrow (user);
        // Username nor Email exists -> new User
        return userRepository.save(user);
    }


    public User read(String id) {
       return userRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Kein Benutzer mit der ID " + id + " vorhanden"));
    }

    public List<User> readAll() {
        return userRepository.findAll();
    }
    public User delete (String id) {

        User userCheck = userRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Kein Benutzer mit der ID " + id + " vorhanden"));
        userRepository.delete(userCheck);
        return userCheck;
    }

    public User update(String id, User user) {

        User userToBeUpdated= userRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("BenutzerId nicht in der Datenbank"));
        System.out.println(userToBeUpdated.getUserId());
        user.setUserId(userToBeUpdated.getUserId());
        ifUsernameOrEmailAlreadyExistThrow (user, userToBeUpdated.getUserId() );
        return userRepository.save(user);
    }


    private void ifUsernameOrEmailAlreadyExistThrow (User user) {
        Optional<User> userCheck = userRepository.findUserByEmail(user.getEmail());
        if (userCheck.isPresent()) {
            throw new ObjectAlreadyExistsException("Es ist bereits ein Benutzer mit dieser E-Mail vorhanden");
        }
        userCheck = userRepository.findUserByUsername(user.getUsername());
        if (userCheck.isPresent()) {
            throw new ObjectAlreadyExistsException("Es ist bereits ein Benutzer mit diesem Benutzernamen vorhanden");
        }
    }

        // make sure that Email / Username does not exit BUT don't compare it with the User`s mail / Username
    private void ifUsernameOrEmailAlreadyExistThrow (User user, String userToBeUpdatedId) {
        Optional<User> userCheck = userRepository.findUserByEmail(user.getEmail());
        System.out.println(userCheck.get().getUserId());
        System.out.println(userToBeUpdatedId);
        if (userCheck.isPresent() && !userCheck.get().getUserId().equals(userToBeUpdatedId)) {
            throw new ObjectAlreadyExistsException("Es ist bereits ein Benutzer mit dieser E-Mail vorhanden");
        }
        userCheck = userRepository.findUserByUsername(user.getUsername());
        if (userCheck.isPresent() && !userCheck.get().getUserId().equals(userToBeUpdatedId)) {
            throw new ObjectAlreadyExistsException("Es ist bereits ein Benutzer mit diesem Benutzernamen vorhanden");
        }
    }





}
