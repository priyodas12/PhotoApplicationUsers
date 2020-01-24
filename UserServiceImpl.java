package com.workspace.service;

import java.util.Random;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.workspace.data.UserEntity;
import com.workspace.repository.UserRepository;
import com.workspace.shared.UserDto;

@Service
public class UserServiceImpl implements UserService{
	
	UserRepository userrepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userrepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userrepository = userrepository;
		this.bCryptPasswordEncoder=bCryptPasswordEncoder;
	}
	
	//without encrypting password
//	@Autowired
//	public UserServiceImpl(UserRepository userrepository) {
//		this.userrepository = userrepository;
//	}
//	

	@Override
	public UserDto createUser(UserDto usrdto) {
		
		//with this unique id HTTP communication will be done.
		usrdto.setUserid(UUID.randomUUID().toString());
		//encode password
		usrdto.setEncryptedpassword(bCryptPasswordEncoder.encode(usrdto.getPassword()));
		ModelMapper modelmapper=new ModelMapper();
		modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);//check all field strictly.
		
		//map fields from userdto to userentity(both field should match)
		UserEntity userentity=modelmapper.map(usrdto, UserEntity.class);
		
		//create random encrypted password(without spring security:uncomment below with no bcrypt const)
		//userentity.setEncryptedpassword(new Random().nextInt()+"test"+UUID.randomUUID().toString());
		
		//save entity
		userrepository.save(userentity);
		
		//fetching Response:transfer to model
		UserDto returnValue=modelmapper.map(userentity, UserDto.class);
		return returnValue;
	}


}
