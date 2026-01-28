package com.gamehubdam.backend.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.time.LocalTime;
import com.gamehubdam.backend.dtos.JugadorScoreRequestDto;
import java.util.List;

@AllArgsConstructor // Constructor con todas las propiedades
@NoArgsConstructor // Constructor vacío
@Getter // Métodos Getter para todas las propiedades
@Setter // Métodos Setter para todas las propiedades
public class PartidaRequestDto{
	@NotNull(message = "Los datos de los jugadores son obligatorios.") // Valida que el valor no sea null
	private List<JugadorScoreRequestDto> jugadores;

	@NotNull(message = "La duración de la partida es obligatoria.")
	private LocalTime duracion;
}
