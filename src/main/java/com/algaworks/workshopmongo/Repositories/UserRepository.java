package com.algaworks.workshopmongo.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
