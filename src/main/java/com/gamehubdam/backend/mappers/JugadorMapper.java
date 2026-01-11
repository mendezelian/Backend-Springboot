package com.gamehubdam.backend.mappers;

import org.mapstruct.Mapper;
import com.gamehubdam.backend.dtos.JugadorRequestDto;
import com.gamehubdam.backend.dtos.JugadorResponseDto;
import com.gamehubdam.backend.entities.Jugador;
import java.util.List;

@Mapper(componentModel = "spring")
public interface JugadorMapper{
	Jugador toEntity(JugadorRequestDto jugadorRequestDto);
	JugadorResponseDto toResponse(Jugador jugador);
	List<JugadorResponseDto> toListResponse(List<Jugador> jugadores);
}
