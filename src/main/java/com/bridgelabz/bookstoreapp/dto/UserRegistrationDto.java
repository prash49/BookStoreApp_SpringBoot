package com.bridgelabz.bookstoreapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;

@Data
@ToString
public class UserRegistrationDto {
    @Pattern(regexp = "^[A-Z]{1,}[a-zA-z\\s.]{2,}$", message = "FirstName is invalid")
    @NotEmpty(message = "Name can not be NULL")
    public String firstName;
    @Pattern(regexp = "^[A-Z]{1,}[a-zA-z\\s.]{2,}$", message = "LastName is invalid")
    @NotEmpty(message = "Name can not be NULL")
    public String lastName;
    public String kyc;
    public String emailId;
    public String password;

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date dob;
//    public int otp;
//    @JsonFormat(pattern = "dd-MM-yyyy")
//    public Date purchaseDate;
//    @JsonFormat(pattern = "dd-MM-yyyy")
//    public Date expiryDate;


    public @Pattern(regexp = "^[A-Z]{1,}[a-zA-z\\s.]{2,}$", message = "FirstName is invalid") @NotEmpty(message = "Name can not be NULL") String getFirstName() {
        return firstName;
    }

    public UserRegistrationDto setFirstName(@Pattern(regexp = "^[A-Z]{1,}[a-zA-z\\s.]{2,}$", message = "FirstName is invalid") @NotEmpty(message = "Name can not be NULL") String firstName) {
        this.firstName = firstName;
        return this;
    }

    public @Pattern(regexp = "^[A-Z]{1,}[a-zA-z\\s.]{2,}$", message = "LastName is invalid") @NotEmpty(message = "Name can not be NULL") String getLastName() {
        return lastName;
    }

    public UserRegistrationDto setLastName(@Pattern(regexp = "^[A-Z]{1,}[a-zA-z\\s.]{2,}$", message = "LastName is invalid") @NotEmpty(message = "Name can not be NULL") String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getKyc() {
        return kyc;
    }

    public UserRegistrationDto setKyc(String kyc) {
        this.kyc = kyc;
        return this;
    }

    public String getEmailId() {
        return emailId;
    }

    public UserRegistrationDto setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public Date getDob() {
        return dob;
    }

    public UserRegistrationDto setDob(Date dob) {
        this.dob = dob;
        return this;
    }
}