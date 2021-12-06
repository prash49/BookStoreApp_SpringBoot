package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.dto.UserRegistrationDto;
import com.bridgelabz.bookstoreapp.model.UserRegistrationData;
import com.bridgelabz.bookstoreapp.service.IUserRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/userregistrationservice")
@Slf4j
public class UserRegistrationController {

    @Autowired
    private IUserRegistrationService service;

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getUserData() {
        List<UserRegistrationData> contactList = service.getUserDeatils();
        ResponseDTO response = new ResponseDTO("Get call success", contactList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addUserRegistrationData(@Valid @RequestBody UserRegistrationDto userDTO) {
        UserRegistrationData userDetails = service.createUserRegistration(userDTO);
        log.debug("User Registration input detaisl: " + userDTO.toString());
        ResponseDTO response = new ResponseDTO("Created contact data for", userDetails);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<ResponseDTO> updateContactData(@PathVariable("userId") int userId,
                                                         @Valid @RequestBody UserRegistrationDto userDTO) {
        UserRegistrationData updateUser = service.updateUserRegistrationData(userId, userDTO);
        log.debug("AddressBook Contact After Update " + updateUser.toString());
        ResponseDTO response = new ResponseDTO("Updated contact data for"+userId ,updateUser);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("userId") int userId) {
        service.deleteUser(userId);
        ResponseDTO response = new ResponseDTO("Delete call success for id ", "deleted id:" + userId);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

}
