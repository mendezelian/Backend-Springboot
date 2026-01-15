package com.gamehubdam.backend.mappers;

import org.mapstruct.Mapper;
import com.gamehubdam.backend.dtos.JugadorRequestDto;
import com.gamehubdam.backend.dtos.JugadorResponseDto;
import com.gamehubdam.backend.entities.Jugador;
import java.util.List;

// Interfaz Mapper, ayuda a mapear las entidades persistentes a DTOs, o viceversa
@Mapper(componentModel = "spring")
public interface JugadorMapper{
	Jugador toEntity(JugadorRequestDto jugadorRequestDto); // Mapea el dto 'JugadorRequestDto' a la entidad 'Jugador'
	JugadorResponseDto toResponse(Jugador jugador); // Mapea la entidad 'Jugador' al dto de respuesta al cliente 'JugadorResponseDto'
	
	// Mapea una lista de entidades 'Jugador' a una lista de dto de respuesta 'JugadorResponseDto'
	List<JugadorResponseDto> toListResponse(List<Jugador> jugadores);
    }
