package com.gamehubdam.backend.dtos;

import lombok.Getter;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

// Dto de respuesta al cliente, inmutable solo se puede consulat y crear mediante el constructor

@AllArgsConstructor // Constructor con todas las propiedades
@Getter // Métodos Getter para todas las propiedades
public class PartidaResponseDto{
	private Long partidaId;
	private Long jugadorId;
	private String nombre;
	private int score;
	private LocalDate fecha;
	private LocalTime duracion;
}
