package com.ejemplo.demo.persistencia.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ejemplo.demo.constantes.ConstantesDemo;

import lombok.Getter;
import lombok.Setter;

// por defecto se guarda en Employee 
// al ponerle @Document puedo especificar 
// un nombre de coleccion diferente
@Getter
@Setter
@Document(collection = "Empleado")
public class Empleado {

	@Id
	private Long idEmpleado;
	private String nombre;
	private String app;

	public Empleado(String nombre) {
		this.idEmpleado = System.nanoTime();
		this.nombre = nombre;
		this.app = ConstantesDemo.NO_SQL;
	}

}
