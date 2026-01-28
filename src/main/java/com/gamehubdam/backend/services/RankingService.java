package com.gamehubdam.backend.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.gamehubdam.backend.entities.JugadorPartida;
import com.gamehubdam.backend.repositories.JugadorPartidaRepository;
import java.util.List;
import java.util.ArrayList;
import com.gamehubdam.backend.dtos.RankingResponseDto;
import com.gamehubdam.backend.dtos.RankingQueryDto;
import com.gamehubdam.backend.mappers.RankingMapper;
import com.gamehubdam.backend.dtos.JugadorResponseDto;

@RequiredArgsConstructor // Obliga a spring a inyectar mediante el constructor
@Service
public class RankingService{
	//Inyección
	public final JugadorPartidaRepository jugadorPartidaRepository;
	public final RankingMapper rankingMapper;
    public final JugadorService jugadorService;

	// listar ranking
	public List<RankingResponseDto> listarRanking(){
		//Obtiene la lista de ranking
		List<RankingQueryDto> listRankingQueryDto =  this.jugadorPartidaRepository.obtenerRanking();
		// modifica la propiedad 'puesto' del dto de respuesta, asignandole el valor de su indice del array
		for(int i = 0; i < listRankingQueryDto.size(); i++){
			listRankingQueryDto.get(i).setPuesto(i + 1);
		}
        
        List<RankingResponseDto> listRankingResponseDto = new ArrayList<>();

        //Mapea las propiedades de ranking query dto a ranking response
        for(RankingQueryDto rankingQueryDto : listRankingQueryDto){
            JugadorResponseDto jugadorResponseDto = this.jugadorService.buscarJugadorPorId(rankingQueryDto.getJugadorId());

            listRankingResponseDto.add(this.rankingMapper.toResponse(rankingQueryDto,jugadorResponseDto));
        }
        

		return listRankingResponseDto;
	}
}
