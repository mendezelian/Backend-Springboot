package com.gamehubdam.backend.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor // Constructor con todas las propiedades
@NoArgsConstructor // Constructor vacío
@Getter // Métodos Getter para todas las propiedades
@Setter // Métodos Setter para todas las propiedades
public class JugadorRequestDto{
	@NotBlank(message = "El nombre del jugador es obligatorio.") // Valida que el valor del atributo exista y no sea nulo
	private String nombre;

	@NotBlank(message = "El email del jugador es obligatorio.")
	private String email;
}
