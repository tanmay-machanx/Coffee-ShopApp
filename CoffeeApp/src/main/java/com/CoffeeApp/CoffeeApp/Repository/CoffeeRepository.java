package com.CoffeeApp.CoffeeApp.Repository;

import com.CoffeeApp.CoffeeApp.Entity.CoffeeAppEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoffeeRepository extends MongoRepository<CoffeeAppEntity,String> {
}
