package com.gamehubdam.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gamehubdam.backend.entities.Partida;


// interfaz que extiende JpaRepository para que spring automaticamente genere las implementaciones de los
// métodos predefinidos de Jpa (save,findAll ...)
public interface PartidaRepository extends JpaRepository<Partida, Long>{}
