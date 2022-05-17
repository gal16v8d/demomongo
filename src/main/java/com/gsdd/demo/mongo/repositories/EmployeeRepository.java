package com.gsdd.demo.mongo.repositories;

import com.gsdd.demo.mongo.persistence.entities.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {

  Mono<Employee> findByName(String name);
}
