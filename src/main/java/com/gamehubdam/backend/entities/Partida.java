package com.gamehubdam.backend.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor // Constructor con todas las propiedades
@NoArgsConstructor // Constructor vacío
@Getter // Métodos Getter para todas las propiedades
@Setter // Métodos Setter para todas las propiedades
@Entity // Define a la clase como una entidad persistente
@Table(name = "partidas") // Crea la tabla de la entidad en la base de datos
public class Partida{
	@Id // identificador
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Permite que elija el tipo de numeración para los Ids
	private Long id;

	@Column(nullable = false) // Define una Columna en la base de datos no null
	@CreationTimestamp // Guarda la fecha del momento en que se ha creado el registro y lo asigna a la propiedad
	private LocalDate fecha;
	
	@Column(nullable = false)
	private int duracion;
}

