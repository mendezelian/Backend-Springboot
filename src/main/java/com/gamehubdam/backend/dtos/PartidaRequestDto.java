package com.gamehubdam.backend.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PartidaRequestDto{
	@NotNull(message = "El id del jugador es obligatorio.")
	private Long jugadorId;
	@NotNull(message = "El score es obligatorio.")
	private int score;	
	@NotNull(message = "La duración de la partida es obligatoria.")
	private int duracion;
}
