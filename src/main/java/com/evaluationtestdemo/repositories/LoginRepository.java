package com.evaluationtestdemo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evaluationtestdemo.entities.User;




/**
 * @author MadhuriC
 * JpaRepository for creating LoginRepository
 *
 */
@Repository
public interface LoginRepository extends JpaRepository<User, Long>{
	
    /**
     * @param email
     * @param password
     * @param otpVerifiedStatus 
   
     * @return
     */
    boolean existsByEmailAndPasswordAndOtpVerifiedStatus(String email,String password,boolean otpVerifiedStatus);
    /**
     * @param email
     * @return
     */
    boolean existsByEmail(String email);
    /**
     * @param password
     * @return
     */
    boolean existsByPassword(String password);
    /**
     * @param email
     * @return
     */
    User findByEmail(String email);
    
    
   
   
}



