package com.evaluationtestdemo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
     * @param isOtpVerified
     * @return
     */
    boolean existsByEmailAndPasswordAndIsOtpVerified(String email,String password,String isOtpVerified);
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



