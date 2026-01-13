package com.gamehubdam.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gamehubdam.backend.entities.JugadorPartida;
import com.gamehubdam.backend.dtos.RankingResponseDto;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface JugadorPartidaRepository extends JpaRepository<JugadorPartida, Long>{
	boolean existsByJugadorIdAndPartidaId(Long jugadorId, Long partidaId);
	
	@Query("""
		SELECT new com.gamehubdam.backend.dtos.RankingResponseDto(j.id,j.nombre, SUM(jp.score))
		FROM JugadorPartida jp
	       	JOIN jp.jugador j
		GROUP BY j.id
		ORDER BY SUM(jp.score) DESC	
	""")
	List<RankingResponseDto> obtenerRanking();
}
