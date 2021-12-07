package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.ForgotPasswordDto;
import com.bridgelabz.bookstoreapp.dto.LoginDto;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.dto.UserRegistrationDto;
import com.bridgelabz.bookstoreapp.exception.UserRegistrationException;
import com.bridgelabz.bookstoreapp.model.UserRegistrationData;
import com.bridgelabz.bookstoreapp.service.IUserRegistrationService;
import com.bridgelabz.bookstoreapp.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userregistrationservice")
@Slf4j
public class UserRegistrationController {

    @Autowired
    private IUserRegistrationService service;

    @Autowired
    private TokenUtil tokenUtil;


    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getUserData() {
        List<UserRegistrationData> usersList = service.getUserDeatils();
        ResponseDTO response = new ResponseDTO("Get call success", usersList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addUserRegistrationData(@Valid @RequestBody UserRegistrationDto userDTO) {
        UserRegistrationData userDetails = service.createUserRegistration(userDTO);
        log.debug("User Registration input detaisl: " + userDTO.toString());
        ResponseDTO response = new ResponseDTO("successfully Created/Registered the user  for", tokenUtil.createToken(userDetails.getUserId()));
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<ResponseDTO> updateContactData(@PathVariable("userId") int userId,
                                                         @Valid @RequestBody UserRegistrationDto userDTO) {
        UserRegistrationData updateUser = service.updateUserRegistrationData(userId, userDTO);
        log.debug("AddressBook Contact After Update " + updateUser.toString());
        ResponseDTO response = new ResponseDTO("Updated contact data for" + userId, updateUser);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("userId") int userId) {
        service.deleteUser(userId);
        ResponseDTO response = new ResponseDTO("Delete call success for id ", "deleted id:" + userId);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @GetMapping("/readtokendata")
    public ResponseEntity<ResponseDTO> readdata(@RequestHeader(name = "token") String token) throws UserRegistrationException {
        List<UserRegistrationData> users = null;
        users = service.getAllUsersData(token);
        if (users.size() > 0) {
            ResponseDTO responseDTO = new ResponseDTO("all user Fetched successfully", users);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        } else {
            throw new UserRegistrationException("No Data Found");
        }

    }

//

    @PostMapping("/verify/{token}")
    ResponseEntity<ResponseDTO> verifyUser(@Valid @PathVariable String token) {
        String userVerification = service.verifyUser(token);
        if (userVerification != null) {
            ResponseDTO responseDTO = new ResponseDTO("User verified :", userVerification);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            ResponseDTO responseDTO = new ResponseDTO("User Not verified data:", userVerification);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
    }

    @PutMapping("/forgotpassword")
    public ResponseEntity<ResponseDTO> forgotUserPassword(@RequestBody ForgotPasswordDto passwordDTO) {
        Optional<UserRegistrationData> forgotPassword = service.forgotPassword(passwordDTO);
        if (forgotPassword.toString() != null) {
            ResponseDTO dto = new ResponseDTO("password updated successfully:", forgotPassword);
            return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
        } else {
            ResponseDTO dto = new ResponseDTO("password  not Updated:", forgotPassword);
            return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
        }

    }

    @PostMapping("/userlogin")
    public ResponseEntity<ResponseDTO> userLogin(@RequestBody LoginDto logindto) {
        Optional<UserRegistrationData> login = service.UserLogin(logindto);
        if(login != null) {
            ResponseDTO dto = new ResponseDTO("User login successfully:",tokenUtil.createToken(login.get().getUserId()));
            return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
        }
        else {
            ResponseDTO dto = new ResponseDTO("User login not successfully:", login);
            return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);

        }
    }

}
