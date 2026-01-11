package com.gamehubdam.backend.services;

import lombok.RequiredArgsConstructor;
import com.gamehubdam.backend.dtos.PartidaRequestDto;
import com.gamehubdam.backend.dtos.PartidaResponseDto;
import com.gamehubdam.backend.repositories.PartidaRepository;
import com.gamehubdam.backend.entities.Partida;
import com.gamehubdam.backend.mappers.PartidaMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PartidaService{
	private final PartidaRepository partidaRepository;
	private final PartidaMapper partidaMapper;

	public PartidaResponseDto crearPartida(PartidaRequestDto partidaRequestDto){
		Partida partida = this.partidaMapper.toEntity(partidaRequestDto);
		Partida partidaSaved = this.partidaRepository.save(partida);
		return this.partidaMapper.toResponse(partidaSaved);
	}

	public List<PartidaResponseDto> listarPartidas(){
		List<Partida> partidas = this.partidaRepository.findAll();
		return this.partidaMapper.toListResponse(partidas);
	}
}
