package com.gamehubdam.backend.services;

import com.gamehubdam.backend.repositories.JugadorRepository;
import com.gamehubdam.backend.dtos.JugadorRequestDto;
import com.gamehubdam.backend.dtos.JugadorResponseDto;
import com.gamehubdam.backend.entities.Jugador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.gamehubdam.backend.mappers.JugadorMapper;
import jakarta.persistence.EntityNotFoundException;


@RequiredArgsConstructor
@Service
public class JugadorService{
	private final JugadorRepository jugadorRepository;
	private final JugadorMapper jugadorMapper;

	public JugadorResponseDto crearJugador(JugadorRequestDto jugadorRequestDto){
		Jugador jugador = this.jugadorMapper(jugadorRequestDto);
		jugador.setNombre(jugador.getNombre().trim().toUpperCase());
		jugador.setEmail(jugador.getEmail().trim().toLowerCase());
		
		if(!this.jugadorRepository.existsByEmail(jugador.getEmail())){
			throw new IllegalStateException("El jugador con email"+ jugador.getEmail() + "ya existe");
		}

		JugadorSaved jugadorSaved = this.jugadorRepository.save(jugador);
		return this.jugadorMapper.toResponse(jugadorSaved);
	}
}
