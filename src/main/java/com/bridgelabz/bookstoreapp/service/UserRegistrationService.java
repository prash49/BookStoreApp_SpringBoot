package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.UserRegistrationDto;
import com.bridgelabz.bookstoreapp.exception.UserRegistrationException;
import com.bridgelabz.bookstoreapp.model.UserRegistrationData;
import com.bridgelabz.bookstoreapp.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRegistrationService implements  IUserRegistrationService{
    @Autowired
    UserRegistrationRepository userRepo;

    @Override
    public List<UserRegistrationData> getUserDeatils() {
        return userRepo.findAll() ;
    }

    @Override
    public UserRegistrationData createUserRegistration(UserRegistrationDto userDTO) {
       UserRegistrationData userData = new UserRegistrationData();
       userData.createUser(userDTO);
        return userRepo.save(userData);
    }

    @Override
    public UserRegistrationData getUserById(int userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new UserRegistrationException("User  with id " + userId + " does not exist in database..!"));
    }

    @Override
    public UserRegistrationData updateUserRegistrationData(int userId, UserRegistrationDto userDTO) {
       UserRegistrationData userData = this.getUserById(userId);
        userData.updateUser(userDTO);
        return userRepo.save(userData) ;
    }

    @Override
    public void deleteUser(int userId) {
        UserRegistrationData userData = this.getUserById(userId);
        userRepo.delete(userData);

    }


}
