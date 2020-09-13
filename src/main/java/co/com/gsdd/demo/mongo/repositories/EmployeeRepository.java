package co.com.gsdd.demo.mongo.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import co.com.gsdd.demo.mongo.persistence.entities.Employee;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {

	Mono<Employee> findByName(String name);
}
