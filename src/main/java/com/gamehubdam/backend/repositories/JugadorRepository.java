package com.gamehubdam.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gamehubdam.backend.entities.Jugador;

// interfaz que implementa JpaRepository para que spring genere automaticamente las implementaciones de los métodos predefinidos
// en Jpa
public interface JugadorRepository extends JpaRepository<Jugador, Long>{
	// método personalizado, verifica la existencia de un usuario mediante su email
	boolean existsByEmail(String email);
}

