package com.priyanshu.graphql.repositories;

import com.priyanshu.graphql.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    // custom query methods
    // custom finder methods

}
