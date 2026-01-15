package com.gamehubdam.backend.mappers;

import org.mapstruct.Mapper;
import com.gamehubdam.backend.entities.Partida;
import com.gamehubdam.backend.dtos.PartidaRequestDto;
import com.gamehubdam.backend.dtos.PartidaResponseDto;
import com.gamehubdam.backend.entities.JugadorPartida;
import java.util.List;
import org.mapstruct.Mapping;

// Interfaz Mapper, ayuda a mapear las entidades persistentes a dtos o viceversa
@Mapper(componentModel = "spring")
public interface PartidaMapper{
	
	// Al mappear el dto tomará solo los atributos que coincidan con la entidad 'Partida'
	@Mapping(target = "id", ignore = true) // Ignorar el atributo id, este se crea en la base de datos
	@Mapping(target = "fecha", ignore = true) // Ignorar el atributo fecha, este se crea en la base de datos
	Partida toPartidaEntity(PartidaRequestDto partidaRequestDto); // Mapea el dto 'PartidaRequestDto' a la entidad 'Partida'
	
	// Al mappear el dto tomará solo los atributos que coincidan con la entidad 'JugadorPartida'
	@Mapping(target = "id", ignore = true) // Ignorar el atributo id, este se crea en la base de datos
	JugadorPartida toJugadorPartidaEntity(PartidaRequestDto partidaRequestDto); // Mapea el dto 'PartidaRequestDto' a la entidad 'JugadorPartida'
	
	// La propiedad 'jugadorId' del dto de respuesta tomará el valor de la propiedad 'id' de la entidad 'Jugador' almacenada en JugadorPartida
	@Mapping(target = "jugadorId", source = "jugador.id")
	// La propiedad 'partidaId' del dto de respuesta tomará el valor de la propiedad 'id' de la entidad 'Partida' almacenada en JugadorPartida
	@Mapping(target = "partidaId", source = "partida.id")
	// La propiedad 'nombre' del dto de respuesta tomará el valor de la propiedad 'nombre' de la entidad 'Jugador' almacenada en JugadorPartida
	@Mapping(target = "nombre", source = "jugador.nombre")
        // La propiedad 'fecha' del dto de respuesta tomará el valor de la propiedad 'fecha' de la entidad 'Partida' almacenada en JugadorPartida;
	@Mapping(target = "fecha", source = "partida.fecha")
	// La propiedad 'duracion' del dto de respuesta tomará el valor de la propiedad 'duracion' de la entidad 'Partida' almacenada en JugadorPartida
	@Mapping(target = "duracion", source = "partida.duracion")
	PartidaResponseDto toResponse(JugadorPartida jugadorPartida);
	
	// Por cada entidad 'JugadorPartida' de la lista se le aplicará el mapeo con el método 'toResponse'
	List<PartidaResponseDto> toListResponse(List<JugadorPartida> jugadorPartida);
}
