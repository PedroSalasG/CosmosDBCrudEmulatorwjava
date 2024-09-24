package com.cosmos.cosmos.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;
import com.cosmos.cosmos.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CosmosRepository<User,String> {

    @Query(value = "SELECT * FROM c")
    List<User> getAllUsers();


}
