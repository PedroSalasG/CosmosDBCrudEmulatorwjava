package com.cosmos.cosmos.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import com.cosmos.cosmos.models.User;

public interface UserRepository extends CosmosRepository<User,String> {
}
