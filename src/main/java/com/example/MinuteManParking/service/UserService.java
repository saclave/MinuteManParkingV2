package com.example.MinuteManParking.service;

import com.example.MinuteManParking.exceptions.UsernameAlreadyExisting;
import com.example.MinuteManParking.model.User;
import com.example.MinuteManParking.repository.UserRepository;
import com.example.MinuteManParking.exceptions.UserNotFound;
import org.springframework.stereotype.Service;
import java.util.List;
import static com.example.MinuteManParking.exceptions.UserNotFound.USER_NOT_FOUND;
import static com.example.MinuteManParking.exceptions.UsernameAlreadyExisting.USERNAME_ALREADY_EXISTING;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        if(userRepository.findByUsername(user.getUsername()) == null){
            return userRepository.save(user);
        }
        throw new UsernameAlreadyExisting(USERNAME_ALREADY_EXISTING);
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
        if(user.getFirstName() != null){
            retrievedUser.setFirstName(user.getFirstName());
        }
        if(user.getLastName() != null){
            retrievedUser.setLastName(user.getLastName());
        }
        if(user.getBirthdate() != null){
            retrievedUser.setBirthdate(user.getBirthdate());
        }
        if(user.getEmail() != null){
            retrievedUser.setEmail(user.getEmail());
        }
        if(user.getGender() != null){
            retrievedUser.setGender(user.getGender());
        }
        if(user.getUsername() != null){
            retrievedUser.setUsername(user.getUsername());
        }
        if(user.getPassword() != null){
            retrievedUser.setPassword(user.getPassword());
        }
        return userRepository.save(retrievedUser);
    }

    public User findByUsernamePassword(String username, String password) {
        return userRepository.findByPassword(password).stream()
                .filter(user -> user.getId().equals(userRepository.findByUsername(username).getId()))
                .findFirst()
                .orElseThrow(() -> new UserNotFound(USER_NOT_FOUND));
    }
}
