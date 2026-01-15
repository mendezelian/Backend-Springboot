package com.gamehubdam.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gamehubdam.backend.entities.JugadorPartida;
import com.gamehubdam.backend.dtos.RankingResponseDto;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

// Se hace una interfaz para que pueda extender a JpaRepository, permitiendo así que springboot
// genere automaticamente las clases de implementación de los métodos predefinidos en Jpa, quitando la necesidad de hacerlo manualmente
public interface JugadorPartidaRepository extends JpaRepository<JugadorPartida, Long>{
	// Método personalizado para verificar la existencia de un jugador en alguna partida mediante el id
	boolean existsByJugadorIdAndPartidaId(Long jugadorId, Long partidaId);
	
	// Consulta JPQL personalizada
	// Realiza un join entre la entidad JugadorPartida y Jugador, para luego hacer una suma de cada 'score' que tenga el jugador
	// en diferentes partidas y retornar el ranking de mayor a menor score.

	@Query("""
		SELECT new com.gamehubdam.backend.dtos.RankingResponseDto(j.id,j.nombre, SUM(jp.score))
		FROM JugadorPartida jp
	       	JOIN jp.jugador j
		GROUP BY j.id
		ORDER BY SUM(jp.score) DESC	
	""")
	List<RankingResponseDto> obtenerRanking();
}
