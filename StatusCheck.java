package com.workspace.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workspace.model.CreateUserModel;
import com.workspace.model.ResponseModel;
import com.workspace.service.UserService;
import com.workspace.shared.UserDto;

@RestController
@RequestMapping("/users")
public class StatusCheck {
	
	@Autowired
	public Environment env;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/status/check")
	public String getStatus() {
		return "OK from"+env.getProperty("local.server.port");
	}
	
	@PostMapping("/")
	public ResponseEntity<ResponseModel> createUser(@Valid @RequestBody CreateUserModel crm) {
		ModelMapper modelmapper=new ModelMapper();
		modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		//(model to dto)mapping model object with dto object
		UserDto userdto=modelmapper.map(crm, UserDto.class);	
		UserDto createdUser=userService.createUser(userdto);
		
		//(entity to modelresp)mapping entity object with Response Model.
		ResponseModel returnValue=modelmapper.map(createdUser,ResponseModel.class);
		return  ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
		
	}

}
