package com.gamehubdam.backend.mappers;

import org.mapstruct.Mapper;
import com.gamehubdam.backend.entities.Partida;
import com.gamehubdam.backend.dtos.PartidaRequestDto;
import com.gamehubdam.backend.dtos.PartidaResponseDto;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PartidaMapper{
	Partida toEntity(PartidaRequestDto partidaRequestDto);
	PartidaResponseDto toResponse(Partida partida);
	List<PartidaResponseDto> toListResponse(List<Partida> partidas);
}
