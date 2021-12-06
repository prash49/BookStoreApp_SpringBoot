package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.UserRegistrationData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRegistrationRepository extends JpaRepository<UserRegistrationData , Integer> {

}
