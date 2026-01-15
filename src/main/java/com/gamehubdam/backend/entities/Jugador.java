package com.gamehubdam.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor // Constructor con todas las propiedades
@NoArgsConstructor // Constructor vacío
@Getter // Métodos Getters para todas las propiedades
@Setter // Métodos Setters para todas las propiedades
@Entity // Define a esta clase como una entidad persistente
@Table(name = "jugadores") // Crea la tabla en la base de datos
public class Jugador{
	@Id // Define el identificador
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Permite que elija el tipo de numeración de los Ids
	private Long id; 

	@Column(nullable = false) // Define una columna en la base de datos no nula
	private String nombre;

	@Column(nullable = false)
	private String email;
}
