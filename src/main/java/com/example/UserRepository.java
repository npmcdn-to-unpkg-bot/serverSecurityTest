package com.example;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Sebastian Börebäck on 2016-04-19.
 */
public interface UserRepository extends MongoRepository<User, Long> {

	User findOneByUsername(String username);

}
