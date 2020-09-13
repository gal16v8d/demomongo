package co.com.gsdd.demo.mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.gsdd.demo.mongo.persistence.entities.Employee;
import co.com.gsdd.demo.mongo.repositories.EmployeeRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
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
