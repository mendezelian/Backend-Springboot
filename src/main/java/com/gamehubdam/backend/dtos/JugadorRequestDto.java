package com.gamehubdam.backend.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JugadorRequestDto{
	@NotBlank(message = "El nombre del jugador es obligatorio.")
	private String nombre;

	@NotBlank(message = "El email del jugador es obligatorio.")
	private String email;
}
