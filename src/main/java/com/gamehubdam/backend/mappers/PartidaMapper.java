package com.gamehubdam.backend.mappers;

import org.mapstruct.Mapper;
import com.gamehubdam.backend.entities.Partida;
import com.gamehubdam.backend.dtos.PartidaRequestDto;
import com.gamehubdam.backend.dtos.PartidaResponseDto;
import com.gamehubdam.backend.entities.JugadorPartida;
import java.util.List;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface PartidaMapper{
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "fecha", ignore = true)
	Partida toPartidaEntity(PartidaRequestDto partidaRequestDto);
	
	@Mapping(target = "id", ignore = true)
	JugadorPartida toJugadorPartidaEntity(PartidaRequestDto partidaRequestDto);
	
	@Mapping(target = "jugadorId", source = "jugador.id")
	@Mapping(target = "partidaId", source = "partida.id")
	@Mapping(target = "nombre", source = "jugador.nombre")
	@Mapping(target = "fecha", source = "partida.fecha")
	@Mapping(target = "duracion", source = "partida.duracion")
	PartidaResponseDto toResponse(JugadorPartida jugadorPartida);

	List<PartidaResponseDto> toListResponse(List<JugadorPartida> jugadorPartida);
}
