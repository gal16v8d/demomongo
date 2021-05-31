package co.com.gsdd.demo.mongo.services;

import org.springframework.stereotype.Service;

import co.com.gsdd.demo.mongo.persistence.entities.Employee;
import co.com.gsdd.demo.mongo.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public Mono<Employee> findById(Long id) {
		return employeeRepository.findById(id);
	}

	public Mono<Employee> findByName(String name) {
		return employeeRepository.findByName(name);
	}

	public Mono<Employee> save(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Mono<Employee> update(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Mono<Void> delete(Employee empleado) {
		return employeeRepository.delete(empleado);
	}

	public void delete(Long empID) {
		employeeRepository.deleteById(empID);
	}

	public Flux<Employee> findAll() {
		return employeeRepository.findAll();
	}

}
