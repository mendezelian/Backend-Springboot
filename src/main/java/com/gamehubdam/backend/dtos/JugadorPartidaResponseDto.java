package com.gamehubdam.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.gamehubdam.backend.entities.Jugador;
import com.gamehubdam.backend.entities.Partida;

@AllArgsConstructor
@Getter
public class JugadorPartidaResponseDto{
    private Long id;
    private String nombre;
    private Integer score;
}
