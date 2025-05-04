package com.bridgelabz.bookstoreapp.dto;

import lombok.Data;

@Data
public class ForgotPasswordDto {
    public String emailId;

    public String getEmailId() {
        return emailId;
    }

    public ForgotPasswordDto setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }
}
