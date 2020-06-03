package com.ejemplo.demo.constantes;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConstantesDemo {

	public static final String ROL_ADMIN = "ROLE_ADMIN";
	public static final String ROL_USER = "ROLE_USER";
	
	public static final String SQL = "SQL";
	public static final String NO_SQL = "NoSQL";
	
	public static final String PAQUETE_BASE = "com.ejemplo.demo";
	public static final String PAQUETE_CONFIG = PAQUETE_BASE + ".config";
	public static final String PAQUETE_COMPONENTE = PAQUETE_BASE + ".componentes";
	public static final String PAQUETE_CONTROLADOR = PAQUETE_BASE + ".controladores";
	public static final String PAQUETE_REPOSITORIO = PAQUETE_BASE + ".repositorios";
	public static final String PAQUETE_SERVICIO = PAQUETE_BASE + ".servicios";

}
