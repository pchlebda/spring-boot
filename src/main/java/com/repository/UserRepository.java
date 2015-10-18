package com.repository;

import com.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Piotr on 2015-10-10.
 */
@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, String> {

}
