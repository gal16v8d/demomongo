package com.ejemplo.demo.repositorios;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.demo.persistencia.entidades.Empleado;

import reactor.core.publisher.Mono;

@Repository
public interface EmpleadoRepositorio extends ReactiveCrudRepository<Empleado, Long> {

	Mono<Empleado> findByNombre(String nombre);
}
