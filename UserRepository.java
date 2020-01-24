package com.workspace.repository;

import org.springframework.data.repository.CrudRepository;

import com.workspace.data.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
