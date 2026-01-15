package com.gamehubdam.backend.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JugadorLoginRequestDto{
    @NotBlank(message = "El email del jugador es obligatorio.")
    private String email;
}
