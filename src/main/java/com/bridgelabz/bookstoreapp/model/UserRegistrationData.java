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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    @Column(name = "registerDate")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate registerDate;
    @Column(name = "updatedDate")
    @JsonFormat(pattern = "dd-MM-yyyy")

    private LocalDate updatedDate;
//    @Column
//    private int otp;
//    @Column(name = "purchaseDate")
//    @JsonFormat(pattern = "dd-MM-yyyy")
//    private Date purchaseDate;
//    @Column(name = "expiryDate")
//    @JsonFormat(pattern = "dd-MM-yyyy")
//    private Date expiryDate;

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
//        this.otp = userDTO.otp;
//        this.purchaseDate = userDTO.purchaseDate;
//        this.expiryDate = userDTO.expiryDate;

    }

    public void updateUser(UserRegistrationDto userDTO) {
        this.firstName = userDTO.firstName;
        this.lastName = userDTO.lastName;
        this.kyc = userDTO.kyc;
        this.emailId = userDTO.emailId;
        this.password = userDTO.password;
        this.dob = userDTO.dob;
        this.updatedDate = LocalDate.now();
//        this.otp = userDTO.otp;
//        this.purchaseDate = userDTO.purchaseDate;
//        this.expiryDate = userDTO.expiryDate;

    }


    public int getUserId() {
        return userId;
    }

    public UserRegistrationData setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegistrationData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegistrationData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getKyc() {
        return kyc;
    }

    public UserRegistrationData setKyc(String kyc) {
        this.kyc = kyc;
        return this;
    }

    public String getEmailId() {
        return emailId;
    }

    public UserRegistrationData setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationData setPassword(String password) {
        this.password = password;
        return this;
    }

    public Date getDob() {
        return dob;
    }

    public UserRegistrationData setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public UserRegistrationData setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
        return this;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public UserRegistrationData setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }
}
