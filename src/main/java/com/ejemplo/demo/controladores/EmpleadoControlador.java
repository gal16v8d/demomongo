package com.ejemplo.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.persistencia.entidades.Empleado;
import com.ejemplo.demo.servicios.EmpleadoServicio;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/empleado")
public class EmpleadoControlador {

	@Autowired
	private EmpleadoServicio service;

	@GetMapping("/{nombre}")
	public Mono<ResponseEntity<Empleado>> buscarXNombre(@PathVariable("nombre") String nombre) {
		return service.buscarXNombre(nombre).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@GetMapping("/listar")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content") })
	public Flux<Empleado> listarTodos() {
		return service.listarTodos();
	}

	@PostMapping("/guardar")
	public Mono<Empleado> guardarEmpleado(@RequestParam("nombre") String nombre) {
		return service.guardar(new Empleado(nombre));
	}

	@PatchMapping("/actualizar")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content"),
			@ApiResponse(code = 409, message = "Conflict") })
	public Mono<ResponseEntity<Empleado>> actualizarEmpleado(@RequestParam("nombreViejo") String nombreViejo,
			@RequestParam("nombreNuevo") String nombreNuevo) {
		return service.buscarXNombre(nombreViejo).flatMap(empleadoExistente -> {
			empleadoExistente.setNombre(nombreNuevo);
			return service.actualizar(empleadoExistente);
		}).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/eliminar/{id}")
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Conflict") })
	public Mono<ResponseEntity<Void>> eliminarEmpleado(@PathVariable("id") Long id) {
		return service.buscarXId(id)
				.flatMap(empleadoExistente -> service.eliminar(empleadoExistente)
						.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
}
