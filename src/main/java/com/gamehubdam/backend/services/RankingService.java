package com.gamehubdam.backend.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.gamehubdam.backend.entities.JugadorPartida;
import com.gamehubdam.backend.repositories.JugadorPartidaRepository;
import java.util.List;
import com.gamehubdam.backend.dtos.RankingResponseDto;

@RequiredArgsConstructor
@Service
public class RankingService{
	public final JugadorPartidaRepository jugadorPartidaRepository;
	
	public List<RankingResponseDto> listarRanking(){
		List<RankingResponseDto> rankingResponseDto =  this.jugadorPartidaRepository.obtenerRanking();
		for(int i = 0; i < rankingResponseDto.size(); i++){
			rankingResponseDto.get(i).setPuesto(i + 1);
		}

		return rankingResponseDto;
	}
}
