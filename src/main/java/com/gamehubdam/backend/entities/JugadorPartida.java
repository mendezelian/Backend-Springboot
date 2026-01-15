
package com.gamehubdam.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor // Constructor con todos las propiedades
@NoArgsConstructor // Constructor vacío
@Getter // Métodos Getter para todas las propiedades
@Setter // Métodos Setter para todas las propiedades
@Entity // Define a la clase como entidad persistente
@Table(name = "jugadores_partidas") // Crea la tabla de la entidad en la base de datos
public class JugadorPartida{
	@Id // identificador
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Permite que elija el tipo de numeración para los Ids
	private Long id;
	
	// Relación Unidireccional, Jugador no conoce a JugadorPartida, pero JugadorPartida si almacena la referencia a Jugador
	// JugadorPartida  N <- 1  Jugador
	@ManyToOne // relación N:1 con la entidad Jugador
	@JoinColumn(name = "jugador_id") // nombra a la columna dónde se almacenará la FK
	private Jugador jugador;
	
	// Relación Unidireccional, Partida no conoce a JugadorPartida, pero JugadorPartida si almacena la referencia a Partida
	// JugadorPartida  N <- 1  Partida
	@ManyToOne // relación N:1 con la entidad Partida
	@JoinColumn(name = "partida_id") // Nombra a la columna dónde se almacena la FK
	private Partida partida; 
	private int score;
}
