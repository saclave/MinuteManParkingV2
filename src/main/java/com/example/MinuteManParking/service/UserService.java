package com.example.MinuteManParking.service;

import com.example.MinuteManParking.dto.UserCreationErrorResponse;
import com.example.MinuteManParking.exceptions.ParkingLotNotFound;
import com.example.MinuteManParking.exceptions.ParkingSlotNotFound;
import com.example.MinuteManParking.exceptions.RegistrationException;
import com.example.MinuteManParking.exceptions.UserNotFound;
import com.example.MinuteManParking.model.Car;
import com.example.MinuteManParking.model.Ticket;
import com.example.MinuteManParking.model.User;
import com.example.MinuteManParking.repository.ParkingLotRepository;
import com.example.MinuteManParking.repository.ParkingSlotRepository;
import com.example.MinuteManParking.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.MinuteManParking.exceptions.ExceptionConstants.*;
import static java.util.Objects.requireNonNull;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final ParkingSlotRepository parkingSlotRepository;
    private final ParkingLotRepository parkingLotRepository;

    public UserService(UserRepository userRepository, ParkingSlotRepository parkingSlotRepository, ParkingLotRepository parkingLotRepository) {
        this.userRepository = userRepository;
        this.parkingSlotRepository = parkingSlotRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public User create(User user) {
        UserCreationErrorResponse userCreationErrorResponse = new UserCreationErrorResponse();
        if (userRepository.existsUserByEmail(user.getEmail())) {
            userCreationErrorResponse.setEmailExist(true);
        }
        if (userRepository.existsUserByUsername(user.getUsername())) {
            userCreationErrorResponse.setUsernameExist(true);
        }
        if (userCreationErrorResponse.isEmailExist() || userCreationErrorResponse.isUsernameExist()) {
            throw new RegistrationException(userCreationErrorResponse);
        }
        user.setImage("https://secureservercdn.net/160.153.138.163/752.d1a.myftpupload.com/wp-content/uploads/2017/02/blank-profile-picture-973460_1280.png");
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
        UserCreationErrorResponse userCreationErrorResponse = new UserCreationErrorResponse();
        if (userRepository.existsUserByEmail(user.getEmail()) && !retrieve(id).getEmail().equals(user.getEmail())) {
            userCreationErrorResponse.setEmailExist(true);
        }
        if (userRepository.existsUserByUsername(user.getUsername()) && !retrieve(id).getUsername().equals(user.getUsername())) {
            userCreationErrorResponse.setUsernameExist(true);
        }
        if (userCreationErrorResponse.isEmailExist() || userCreationErrorResponse.isUsernameExist()) {
            throw new RegistrationException(userCreationErrorResponse);
        }
        User retrievedUser = retrieve(id);
        retrievedUser.setFirstName(user.getFirstName());
        retrievedUser.setLastName(user.getLastName());
        retrievedUser.setEmail(user.getEmail());
        retrievedUser.setUsername(user.getUsername());
        retrievedUser.setPassword(user.getPassword());
        retrievedUser.setCash(user.getCash());
        retrievedUser.setImage(user.getImage());
        return userRepository.save(retrievedUser);
    }

    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public List<Car> getCarsByUserId(Integer id) {
        return userRepository.findById(id)
                .map(User::getCarList)
                .orElseThrow(() -> new UserNotFound(USER_NOT_FOUND));
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

    public String getParkingLotName(Integer parkingSlotId) {
        return parkingSlotRepository.findById(parkingSlotId).map(parkingSlot ->
                parkingLotRepository.findById(requireNonNull(parkingSlot).getParkingLotId())
                        .orElseThrow(() -> new ParkingLotNotFound(PARKING_LOT_NOT_FOUND))
        ).orElseThrow(() -> new ParkingSlotNotFound(PARKING_SLOT_NOT_FOUND))
                .getName();
    }

    public String getImgSrc(Integer id) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            return user.getImage();
        }
        return null;
    }
}
