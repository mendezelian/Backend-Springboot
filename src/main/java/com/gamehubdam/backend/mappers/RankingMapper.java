package com.gamehubdam.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.gamehubdam.backend.dtos.RankingQueryDto;
import com.gamehubdam.backend.dtos.RankingResponseDto;
import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import com.gamehubdam.backend.dtos.JugadorResponseDto;
import java.util.List;

//DTO de respuesta, mutable 
@Mapper(componentModel = "spring")
public interface RankingMapper{
    @Mapping(target = "puesto", source = "rankingQueryDto.puesto")
    @Mapping(target = "score", source = "rankingQueryDto.score")
    @Mapping(target = "jugadorId", source = "jugadorResponseDto.id")
    @Mapping(target = "nombre", source = "jugadorResponseDto.nombre")
    RankingResponseDto toResponse(RankingQueryDto rankingQueryDto, JugadorResponseDto jugadorResponseDto);
    
}
