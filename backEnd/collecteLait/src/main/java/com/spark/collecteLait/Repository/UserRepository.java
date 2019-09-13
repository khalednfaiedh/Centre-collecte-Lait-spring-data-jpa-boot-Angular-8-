package com.spark.collecteLait.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.collecteLait.model.entity.User;

@Repository
public interface UserRepository   extends CrudRepository<User,  Long> {

}
