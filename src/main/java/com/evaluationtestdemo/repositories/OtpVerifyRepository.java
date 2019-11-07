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
public interface OtpVerifyRepository extends JpaRepository<User, Long>{
	
	 /**
	 * @param isOtpVerified
	 * @param id
	 * @return
	 */
	  @Modifying
	  @Query("update User u set u.otpVerifiedStatus = :otpVerifiedStatus where u.id = :id")
	  public int updateisOtpVerifiedById(@Param("otpVerifiedStatus") boolean isOtpVerified, @Param("id") long id);
	  
	
	
   
}



