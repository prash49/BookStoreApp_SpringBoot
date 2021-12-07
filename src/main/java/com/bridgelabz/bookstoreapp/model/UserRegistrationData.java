package com.bridgelabz.bookstoreapp.model;

import com.bridgelabz.bookstoreapp.dto.UserRegistrationDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "userregistration")
@Data
public class UserRegistrationData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column
    private String kyc;
    @Column(name = "emailId")
    private String emailId;
    @Column
    private String password;

    @Column
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dob;
    @Column(name = "registerDate")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate registerDate;
    @Column(name = "updatedDate")
    @JsonFormat(pattern = "dd-MM-yyyy")

    private LocalDate updatedDate;
    @Column
    private int otp;
    @Column(name = "purchaseDate")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date purchaseDate;
    @Column(name = "expiryDate")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date expiryDate;

    public UserRegistrationData() {

    }

    public void createUser(UserRegistrationDto userDTO) {
        this.firstName = userDTO.firstName;
        this.lastName = userDTO.lastName;
        this.kyc = userDTO.kyc;
        this.emailId = userDTO.emailId;
        this.password = userDTO.password;
        this.dob = userDTO.dob;
        this.registerDate = LocalDate.now();
        this.otp = userDTO.otp;
        this.purchaseDate = userDTO.purchaseDate;
        this.expiryDate = userDTO.expiryDate;

    }

    public void updateUser(UserRegistrationDto userDTO) {
        this.firstName = userDTO.firstName;
        this.lastName = userDTO.lastName;
        this.kyc = userDTO.kyc;
        this.emailId = userDTO.emailId;
        this.password = userDTO.password;
        this.dob = userDTO.dob;
        this.updatedDate = LocalDate.now();
        this.otp = userDTO.otp;
        this.purchaseDate = userDTO.purchaseDate;
        this.expiryDate = userDTO.expiryDate;

    }

}
