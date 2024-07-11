package com.palani.PoultryAssist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.palani.PoultryAssist.Model.UserDetail;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, Long> {

	UserDetails findByUserName(String userName);
	

}
