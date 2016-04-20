package com.example;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sebastian Börebäck on 2016-04-19.
 */
@Repository
public interface UserRepository extends MongoRepository<User, Long> {

	User findOneByUsername(String username);

}
