package com.gamehubdam.backend.mappers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JugadorMapper{
	Jugador toEntity(JugadorRequestDto jugadorRequestDto);
	JugadorResponseDto toResponse(Jugador jugador);
}
