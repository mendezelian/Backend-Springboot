package com.gamehubdam.backend.services;

import lombok.RequiredArgsConstructor;
import com.gamehubdam.backend.dtos.PartidaRequestDto;
import com.gamehubdam.backend.dtos.PartidaResponseDto;
import com.gamehubdam.backend.repositories.PartidaRepository;
import com.gamehubdam.backend.entities.Partida;
import com.gamehubdam.backend.mappers.PartidaMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import com.gamehubdam.backend.services.JugadorService;
import com.gamehubdam.backend.repositories.JugadorPartidaRepository;
import com.gamehubdam.backend.entities.JugadorPartida;
import com.gamehubdam.backend.entities.Jugador;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PartidaService{
	private final PartidaRepository partidaRepository;
	private final PartidaMapper partidaMapper;
	private final JugadorService jugadorService;
	private final JugadorPartidaRepository jugadorPartidaRepository;

	@Transactional
	public PartidaResponseDto crearPartida(PartidaRequestDto partidaRequestDto){
		// Consulta el jugador
		Jugador jugador = this.jugadorService.getJugadorEntity(partidaRequestDto.getJugadorId());
			
		//Mapea el request para crear la entidad Partida
		Partida partida = this.partidaMapper.toPartidaEntity(partidaRequestDto);
		
		//Mapea el request para crear la entidad JugadorPartida
		JugadorPartida jugadorPartida = this.partidaMapper.toJugadorPartidaEntity(partidaRequestDto);
		
		//Guarda la partida en la base de datos
		Partida partidaSaved = this.partidaRepository.save(partida);
		
		//Modifica partida con la Partida guardada
		jugadorPartida.setPartida(partidaSaved);
		
		//Modifica jugador con el Jugador consultado
		jugadorPartida.setJugador(jugador);
		
		//Guarda la relación de jugador con partida en la base de datos 
		JugadorPartida jugadorPartidaSaved = this.jugadorPartidaRepository.save(jugadorPartida);

		return this.partidaMapper.toResponse(jugadorPartidaSaved);
	}

	public List<PartidaResponseDto> listarPartidas(){
		List<JugadorPartida> jugadoresPartidas = this.jugadorPartidaRepository.findAll();
		
		return this.partidaMapper.toListResponse(jugadoresPartidas);
	}
}
