package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.ForgotPasswordDto;
import com.bridgelabz.bookstoreapp.dto.LoginDto;
import com.bridgelabz.bookstoreapp.dto.UserRegistrationDto;
import com.bridgelabz.bookstoreapp.exception.UserRegistrationException;
import com.bridgelabz.bookstoreapp.model.UserRegistrationData;
import com.bridgelabz.bookstoreapp.repository.UserRegistrationRepository;
import com.bridgelabz.bookstoreapp.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserRegistrationService implements IUserRegistrationService {
    @Autowired
    UserRegistrationRepository userRepo;


    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<UserRegistrationData> getUserDeatils() {
        return userRepo.findAll();
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
        return userRepo.save(userData);
    }

    @Override
    public void deleteUser(int userId) {
        UserRegistrationData userData = this.getUserById(userId);
        userRepo.delete(userData);

    }

    @Override
    public List<UserRegistrationData> getAllUsersData(String token) {

        Long id = tokenUtil.decodeToken(token);
        Optional<UserRegistrationData> usersData = userRepo.findById(Math.toIntExact((id)));
        if (usersData.isPresent()) {
            List<UserRegistrationData> usersList = userRepo.findAll();
            return usersList;
        }
        return null;
    }

//    @Override
//    public UserRegistrationData userLogin(@Valid LoginDto logindto) {
//        Optional<UserRegistrationData> emailId = userRepo.findByEmailId(logindto.getEmailId());
//        if (emailId.isPresent()) {
//            System.out.println(emailId.get().toString());
//            if ((logindto.getPassword() == emailId.get().getPassword())) {
//                System.out.println(emailId.get().getPassword());
//                return emailId.get();
//            }
//        }
//        return null;
//    }

    @Override
    public String verifyUser(String token) {
        int id = Math.toIntExact(tokenUtil.decodeToken(token));
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);

        if (isPresent.isPresent()) {
            return isPresent.toString();
        } else
            return null;
    }

    @Override
    public Optional<UserRegistrationData> forgotPassword(ForgotPasswordDto passwordDto) {
        if (passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword())) {
            Optional<UserRegistrationData> user = userRepo.findByEmailId(passwordDto.getEmailId());
            if (user.isPresent()) {
                user.get().setPassword(passwordDto.getNewPassword());
                userRepo.save(user.get());
                return user;
            } else {
                log.error("User not found Exception:");
            }
            return null;
        } else {
            log.error("Entered password is not correct:");
            return null;
        }
    }

    @Override
    public Optional<UserRegistrationData> UserLogin(LoginDto logindto) {

        Optional<UserRegistrationData> userLogin = userRepo.findByEmailIdAndPassword(logindto.emailId, logindto.password);

        if (userLogin.isPresent()) {
            log.info("user logged in successfully");
            return userLogin;
        } else {
            log.error("User not Found Exception:");

            return null;
        }
    }
}


//    @Override
//    public Optional<UserRegistrationData> userLogin(LoginDto logindto) {
//            Optional<UserRegistrationData> userLogin = userRepo.findByEmailIdAndPassword(logindto.emailId, logindto.password);
//
//            if (userLogin.isPresent())
//            {
//                log.info("user logged in successfully");
//            }
//            else
//            {
//                log.error("User not Found Exception:");
//            }
//            return null;
//        }


