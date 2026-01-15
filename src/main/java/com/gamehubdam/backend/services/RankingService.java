package com.gamehubdam.backend.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.gamehubdam.backend.entities.JugadorPartida;
import com.gamehubdam.backend.repositories.JugadorPartidaRepository;
import java.util.List;
import com.gamehubdam.backend.dtos.RankingResponseDto;

@RequiredArgsConstructor // Obliga a spring a inyectar mediante el constructor
@Service
public class RankingService{
	//Inyección
	public final JugadorPartidaRepository jugadorPartidaRepository;
	
	// listar ranking
	public List<RankingResponseDto> listarRanking(){
		//Obtiene la lista de ranking
		List<RankingResponseDto> rankingResponseDto =  this.jugadorPartidaRepository.obtenerRanking();
		// modifica la propiedad 'puesto' del dto de respuesta, asignandole el valor de su indice del array
		for(int i = 0; i < rankingResponseDto.size(); i++){
			rankingResponseDto.get(i).setPuesto(i + 1);
		}

		return rankingResponseDto;
	}
}
