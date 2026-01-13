package com.gamehubdam.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RankingResponseDto {
	private Long jugadorId;
	private String nombre;
	private Long score;
	private int puesto;
	
	public RankingResponseDto(Long jugadorId, String nombre, Long score){
		this.jugadorId = jugadorId;
		this.nombre = nombre;
		this.score = score;
	}
}
