package com.gamehubdam.backend.dtos;

import lombok.Getter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
public class JugadorConScoreResponseDto{
    private Long id;
    private String name;
    private Long puntosAcumulados;
}
