package com.gamehubdam.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gamehubdam.backend.entities.JugadorPartida;

public interface JugadorPartidaRepository extends JpaRepository<JugadorPartida, Long>{
	boolean existsByJugadorIdAndPartidaId(Long jugadorId, Long partidaId);
}
