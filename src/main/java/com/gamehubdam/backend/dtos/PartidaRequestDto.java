package com.gamehubdam.backend.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@AllArgsConstructor // Constructor con todas las propiedades
@NoArgsConstructor // Constructor vacío
@Getter // Métodos Getter para todas las propiedades
@Setter // Métodos Setter para todas las propiedades
public class PartidaRequestDto{
	@NotNull(message = "El id del jugador es obligatorio.") // Valida que el valor no sea null
	private Long jugadorId;

	@NotNull(message = "El score es obligatorio.")
	private int score;

	@NotNull(message = "La duración de la partida es obligatoria.")
	private int duracion;
}
