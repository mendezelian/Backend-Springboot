package com.gamehubdam.backend.dtos;

import lombok.Getter;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class PartidaResponseDto{
	private Long id;
	private LocalDate fecha;
	private int duracion;
}
