package com.gsdd.demo.mongo.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gsdd.demo.mongo.persistence.entities.Employee;
import com.gsdd.demo.mongo.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

  private final EmployeeService service;

  @GetMapping("/{id}")
  public Mono<ResponseEntity<Employee>> findById(@PathVariable("id") Long id) {
    return service.findById(id).map(ResponseEntity::ok)
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @GetMapping("/name/{name}")
  public Mono<ResponseEntity<Employee>> findByName(@PathVariable("name") String name) {
    return service.findByName(name).map(ResponseEntity::ok)
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @GetMapping
  public Flux<Employee> findAll() {
    return service.findAll();
  }

  @PostMapping
  public Mono<Employee> save(@Valid @RequestBody Employee employee) {
    return service.save(
        Employee.builder().employeeId(employee.getEmployeeId()).name(employee.getName()).build());
  }

  @PatchMapping("/{id}")
  public Mono<ResponseEntity<Employee>> patchName(@PathVariable("id") Long id,
      @Valid @RequestBody String name) {
    return service.findById(id).flatMap(dbEmployee -> {
      dbEmployee.setName(name);
      return service.update(dbEmployee);
    }).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<Void>> delete(@PathVariable("id") Long id) {
    return service.findById(id)
        .flatMap(dbEmployee -> service.delete(dbEmployee)
            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }
}
