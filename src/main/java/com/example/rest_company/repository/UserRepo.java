package com.example.rest_company.repository;

import com.example.rest_company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.ValidationException;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    @Query("select o from User o where o.email = :email")
    Optional<User> getByEmail(String email);

    default User finByEmail(String email){
        Optional<User> optionalUser = getByEmail(email);
        if (optionalUser.isEmpty()){
            throw new ValidationException("not found by email : "+email);
        }
        return optionalUser.get();
    }
}
