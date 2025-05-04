package com.bridgelabz.bookstoreapp.dto;

import lombok.Data;

@Data
public class ResetPassword {

    String newPassword;
 String   confirmPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public ResetPassword setNewPassword(String newPassword) {
        this.newPassword = newPassword;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public ResetPassword setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
