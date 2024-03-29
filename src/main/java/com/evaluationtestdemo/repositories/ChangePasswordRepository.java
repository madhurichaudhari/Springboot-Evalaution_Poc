package com.evaluationtestdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.evaluationtestdemo.entities.User;




/**
 * @author MadhuriC
 * JpaRepository for creating ChangePasswordRepository
 *
 */
@Repository
public interface ChangePasswordRepository extends JpaRepository<User, Long>{
	
	
	  /**
	 * @param password
	 * @param id
	 * @return 0/1 if password will be update
	 */
	@Modifying
	  @Query("update User u set u.password = :password where u.id = :id")
	  public int UpdateUserById(@Param("password") String password, @Param("id") long id);
	  
	  
	  /**
	 * @param changePasswordStatus
	 * @param id
	 * @return 0/1 if changePasswordStatus will be update
	 */
	@Modifying
	  @Query("update User u set u.changePasswordStatus = :changePasswordStatus where u.id = :id")
	  public int updateChangePasswordStatusrById(@Param("changePasswordStatus") boolean changePasswordStatus, @Param("id") long id);
	 
	   /**
	 * @param id
	 * @return UserID
	 */
	@Modifying
	  @Query(value = "SELECT * FROM users_tbl WHERE UserID = ?id", nativeQuery =true) public int finduserByIdUser(@Param("id") long id);
	
	/**
	 * @param email
	 * @return User
	 */
	public User findByEmail(String email); 	
		
}

