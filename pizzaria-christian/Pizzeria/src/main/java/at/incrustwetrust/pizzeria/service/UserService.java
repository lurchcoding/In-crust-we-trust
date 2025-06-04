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

    public User update(User user, String id) {
        User userToBeUpdated= userRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("BenutzerId nicht in der Datenbank"));
        ifUsernameOrEmailAlreadyExistThrow (user, id );
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

    // make sure that Email / Username does not exit BUT don't compare it with the own User`s mail / Username
   /* private void ifUsernameOrEmailAlreadyExistThrow (User user, String userToBeUpdatedId) {
        Optional<User> userCheck = userRepository.findUserByEmail(user.getEmail());
        System.out.println(userToBeUpdatedId);
        if (userCheck.isPresent() && !userCheck.get().getUserId().equals(userToBeUpdatedId)) {
            throw new ObjectAlreadyExistsException("Es ist bereits ein Benutzer mit dieser E-Mail vorhanden");
        }
        userCheck = userRepository.findUserByUsername(user.getUsername());
        if (userCheck.isPresent() && !userCheck.get().getUserId().equals(userToBeUpdatedId)) {
            throw new ObjectAlreadyExistsException("Es ist bereits ein Benutzer mit diesem Benutzernamen vorhanden");
        }
    }*/

    private void ifUsernameOrEmailAlreadyExistThrow (User user, String userToBeUpdatedId) {
        Optional<User> userCheck = userRepository.findByEmailAndUserIdNot(user.getEmail(),userToBeUpdatedId);
        if (userCheck.isPresent()) {
            throw new ObjectAlreadyExistsException("Es ist bereits ein Benutzer mit dieser E-Mail vorhanden");
        }
        userCheck = userRepository.findUserByUsernameAndUserIdNot(user.getUsername(),userToBeUpdatedId);
        if (userCheck.isPresent()) {
            throw new ObjectAlreadyExistsException("Es ist bereits ein Benutzer mit diesem Benutzernamen vorhanden");
        }
    }



}
