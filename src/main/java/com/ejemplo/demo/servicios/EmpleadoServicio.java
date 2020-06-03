package com.ejemplo.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.persistencia.entidades.Empleado;
import com.ejemplo.demo.repositorios.EmpleadoRepositorio;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmpleadoServicio {
	
	@Autowired
	private EmpleadoRepositorio repositorio;

	public Mono<Empleado> buscarXId(Long id) {
		return repositorio.findById(id);
	}
	
	public Mono<Empleado> buscarXNombre(String nombre) {
		return repositorio.findByNombre(nombre);
	}
	
	public Mono<Empleado> guardar(Empleado employee) {
		return repositorio.save(employee);
	}

	public Mono<Empleado> actualizar(Empleado employee) {
		return repositorio.save(employee);
	}
	
	public Mono<Void> eliminar(Empleado empleado) {
		return repositorio.delete(empleado);
	}

	public void eliminar(Long empID) {
		repositorio.deleteById(empID);
	}
	
	public Flux<Empleado> listarTodos() {
		return repositorio.findAll();
	}

}
