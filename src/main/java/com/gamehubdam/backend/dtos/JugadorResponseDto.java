package com.gamehubdam.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JugadorResponseDto{
	private Long id;
	private String nombre;
	private String email;
}
