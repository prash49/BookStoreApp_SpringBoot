package com.bridgelabz.bookstoreapp.dto;

import lombok.Data;

@Data
public class ForgotPasswordDto {
    public String emailId;

    public String newPassword;

    public String confirmPassword;

}
