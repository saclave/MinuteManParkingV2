package com.example.MinuteManParking.service;

import com.example.MinuteManParking.exceptions.EmailAlreadyExistException;
import com.example.MinuteManParking.exceptions.UserNotFound;
import com.example.MinuteManParking.exceptions.UsernameAlreadyExist;
import com.example.MinuteManParking.model.User;
import com.example.MinuteManParking.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import static com.example.MinuteManParking.exceptions.ExceptionConstants.*;


@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        if (isUniqueUsernameAndEmail(user)) {
            return userRepository.save(user);
        }
        if (user.getUsername() != null) {
            throw new UsernameAlreadyExist(USERNAME_ALREADY_EXISTING);
        }
        throw new EmailAlreadyExistException(EMAIL_ALREADY_EXISTING);
    }

    private boolean isUniqueUsernameAndEmail(User user) {
        return userRepository.findByUsername(user.getUsername()) == null
                && userRepository.findByEmail(user.getEmail()) == null;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User retrieve(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFound(USER_NOT_FOUND));
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public User update(Integer id, User user) {
        User retrievedUser = retrieve(id);

        retrievedUser.setFirstName(user.getFirstName());
        retrievedUser.setLastName(user.getLastName());
        retrievedUser.setBirthdate(user.getBirthdate());
        retrievedUser.setEmail(user.getEmail());
        retrievedUser.setGender(user.getGender());
        retrievedUser.setUsername(user.getUsername());
        retrievedUser.setPassword(user.getPassword());
        return userRepository.save(retrievedUser);
    }

    public User findByUsernamePassword(String username, String password) {
        User userRequest = userRepository.findByUsername(username);
        if (userRequest.getPassword().equals(password)) {
            return userRequest;
        }
        return null;
    }

    public User findByEmailPassword(String email, String password) {
        User userRequest = userRepository.findByEmail(email);
        if (userRequest.getPassword().equals(password)) {
            return userRequest;
        }
        return null;
    }
}
