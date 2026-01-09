package com.gamehubdam.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gamehubdam.backend.entities.Jugador;

public interface JugadorRepository extends JPARepository<Jugador, Long>{
	boolean existsByEmail(String email);
}

