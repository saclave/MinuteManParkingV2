package com.example.MinuteManParking.service;

import com.example.MinuteManParking.exceptions.EmailAlreadyExistException;
import com.example.MinuteManParking.exceptions.UserNotFound;
import com.example.MinuteManParking.exceptions.UsernameAlreadyExist;
import com.example.MinuteManParking.model.Car;
import com.example.MinuteManParking.model.Ticket;
import com.example.MinuteManParking.model.User;
import com.example.MinuteManParking.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.MinuteManParking.exceptions.ExceptionConstants.*;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        if (userRepository.existsUserByEmail(user.getEmail())) {
            throw new EmailAlreadyExistException(EMAIL_ALREADY_EXISTING);
        }
        if (userRepository.existsUserByUsername(user.getUsername())) {
            throw new UsernameAlreadyExist(USERNAME_ALREADY_EXISTING);
        }
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User retrieve(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFound(USER_NOT_FOUND));
    }

    public void delete(Integer id) {
        retrieve(id);
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
        retrievedUser.setCash(user.getCash());
        retrievedUser.setImgSrc(user.getImgSrc());
        return userRepository.save(retrievedUser);
    }

    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public List<Car> getCarsByUserId(Integer id) {
        return userRepository.findById(id)
                .map(User::getCarList)
                .orElseThrow(()-> new UserNotFound(USER_NOT_FOUND));
    }

    public List<Ticket> getTicketsByUserId(Integer id) {
        return getCarsByUserId(id)
                .stream()
                .map(Car::getTicketList)
                .collect(Collectors.toList())
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public String getImgSrc(Integer id) {
        User user = userRepository.findById(id).orElse(null);

        if(user != null){
            return user.getImgSrc();
        }
        return null;
    }
}
