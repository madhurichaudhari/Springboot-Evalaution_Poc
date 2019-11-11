package com.evaluationtestdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.evaluationtestdemo.entities.User;



/**
 * @author MadhuriC
 *JpaRepository for creating UserRegisterationRepository
 */
@Repository
public interface UserRegisterationRepository  extends JpaRepository<User, Long> {
	/**
	 * @param mobile
	 * @param email
	 * @return User
	 */
	User findByMobileOrEmail(String mobile,String email);
	/**
	 * @param userName 
	 * @param fistName 
	 * @return User
	 */
	User findByUserName(String userName);
	
	}
