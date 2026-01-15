package com.gamehubdam.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

//Dto de respuesta al cliente, inmutable solo se consulta y se crea mediante el constructor
@AllArgsConstructor // Constructor con todas las propiedades
@Getter // Métodos para todas las propiedades
public class JugadorResponseDto{
	private Long id;
	private String nombre;
	private String email;
}
