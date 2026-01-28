package com.gamehubdam.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Dto de respuesta al cliente, mutable, se puede consultar y modificar, además de crear mediante su constructor
@AllArgsConstructor // Constructor con todas las propiedades
@Getter // Métodos Getter para todas las propiedades
@Setter // Métodos Setter para todas las propiedades
public class RankingQueryDto {
	private Long jugadorId;
	private String nombre;
	private Long score;
	private int puesto;
	
	// Constructor sin la propiedad puesto
	// Permite el mapeo automático de las consultas sql correspondientes
	// ya que estas no pueden definir el puesto sino que se calcula y se modifica en el service de Ranking
	public RankingQueryDto(Long jugadorId, String nombre, Long score){
		this.jugadorId = jugadorId;
		this.nombre = nombre;
		this.score = score;
	}
}
