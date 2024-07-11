package com.palani.PoultryAssist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palani.PoultryAssist.Component.JwtTokenProvider;
import com.palani.PoultryAssist.Model.UserDetail;
import com.palani.PoultryAssist.Repository.UserRepository;
import com.palani.PoultryAssist.Service.UserService;

@RestController
@RequestMapping(value="/login")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private JwtTokenProvider jwtToken;
	@Autowired
	private UserService userServie;
	
	@PostMapping("/create-user")
	public ResponseEntity<String> getUserToken(@RequestBody  UserDetail userDetails)
	{
		UserDetail saveUser = userRepo.save(userDetails);
		if(saveUser == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully");
	}
//	@PostMapping("/user")
//	public ResponseEntity<UserDetail> postUserDetails(@RequestBody UserDetail userDetails)
//	{
//		UserDetail saveUser = userRepo.save(userDetails);
//		System.out.println("A");
//		if(saveUser == null)
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
//	}
	@GetMapping ("/user-login")
	public String getUserLogin(@RequestBody UserDetail userDetails)
	{
			UserDetails userName = userServie.loadUserByUsername(userDetails.getUsername());
			if(userName == null)
				return "Not Valid User";
			return jwtToken.generateToken(userName.getUsername());
	}
}
