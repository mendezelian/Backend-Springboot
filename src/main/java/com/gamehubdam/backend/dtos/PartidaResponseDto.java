package com.gamehubdam.backend.dtos;

import lombok.Getter;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;
import com.gamehubdam.backend.dtos.JugadorPartidaResponseDto;
import com.gamehubdam.backend.entities.Partida;
import java.util.List;

// Dto de respuesta al cliente, inmutable solo se puede consular y crear mediante el constructor

@AllArgsConstructor // Constructor con todas las propiedades
@Getter // Métodos Getter para todas las propiedades
public class PartidaResponseDto{
	private Partida partida;
	private List<JugadorPartidaResponseDto> jugadores;
}
