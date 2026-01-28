package com.gamehubdam.backend.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

//Dto para juntar Jugador y score

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class JugadorScoreRequestDto{
    @NotNull(message = "El id del jugador es obligatorio.")
    @Min(value = 1, message = "El id del jugador debe de ser igual o mayor a 1.")
    private Long id;
    @NotNull(message = "El score del jugador es obligatorio.")
    @Min(value = 0, message = "El score debe de ser igual o mayor a 0.")
    private Integer score;
}
