package com.gamehubdam.backend.mappers;

import org.mapstruct.Mapper;
import com.gamehubdam.backend.entities.Partida;
import com.gamehubdam.backend.dtos.PartidaRequestDto;
import com.gamehubdam.backend.dtos.PartidaResponseDto;
import com.gamehubdam.backend.entities.JugadorPartida;
import java.util.List;
import java.util.ArrayList;
import org.mapstruct.Mapping;
import com.gamehubdam.backend.entities.Jugador;
import com.gamehubdam.backend.entities.Partida;
import com.gamehubdam.backend.dtos.JugadorPartidaResponseDto;
import com.gamehubdam.backend.dtos.JugadorScoreRequestDto;

// Interfaz Mapper, ayuda a mapear las entidades persistentes a dtos o viceversa
@Mapper(componentModel = "spring")
public interface PartidaMapper{
	
	// Al mappear el dto tomará solo los atributos que coincidan con la entidad 'Partida'
	@Mapping(target = "id", ignore = true) // Ignorar el atributo id, este se crea en la base de datos
	@Mapping(target = "fecha", ignore = true) // Ignorar el atributo fecha, este se crea en la base de datos
	Partida toPartidaEntity(PartidaRequestDto partidaRequestDto); // Mapea el dto 'PartidaRequestDto' a la entidad 'Partida'
	
	// Al mappear el dto tomará solo los atributos que coincidan con la entidad 'JugadorPartida'
	@Mapping(target = "id", ignore = true) // Ignorar el atributo id, este se crea en la base de datos
	JugadorPartida toJugadorPartidaEntity(Partida partida, Jugador jugador, JugadorScoreRequestDto jugadorScoreRequestDto); // Mapea el dto 'PartidaRequestDto' a la entidad 'JugadorPartida'
	
    @Mapping(target = "id",source = "jugadorPartida.jugador.id")
    @Mapping(target = "nombre", source = "jugadorPartida.jugador.nombre")
    @Mapping(target = "score", source = "jugadorPartida.score")
    JugadorPartidaResponseDto jugadorPartidaResponseDto (JugadorPartida jugadorPartida);

	// Mapeo de la propiedad jugador de Jugador Partida a la propiedad jugador del dto
	@Mapping(target = "jugadores", source = "jugadoresPartida")
    @Mapping(target = "partida", source = "partida")//Mapeo de la propiedad partida de Partida de Jugador Partida a partida del dto
	PartidaResponseDto toResponse(Partida partida,List<JugadorPartida> jugadoresPartida);
	 
    default List<PartidaResponseDto> toListResponse(List<Partida> partidas, List<List<JugadorPartida>> listJugadoresPartidas){
        List<PartidaResponseDto> listPartidaResponseDto = new ArrayList<>();
        
        for(int i = 0; i < listJugadoresPartidas.size(); i++){
            listPartidaResponseDto.add(this.toResponse(partidas.get(i),listJugadoresPartidas.get(i)));
        }
        return listPartidaResponseDto;
    }
}
