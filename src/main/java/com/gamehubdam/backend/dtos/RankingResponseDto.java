package com.gamehubdam.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RankingResponseDto {
	private Long jugadorId;
	private int puesto;
	private String nombre;
	private int score;
}
