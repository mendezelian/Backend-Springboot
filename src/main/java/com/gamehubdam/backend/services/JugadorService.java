package com.gamehubdam.backend.services;

import com.gamehubdam.backend.repositories.JugadorRepository;
import com.gamehubdam.backend.dtos.JugadorRequestDto;
import com.gamehubdam.backend.dtos.JugadorResponseDto;
import com.gamehubdam.backend.entities.Jugador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.gamehubdam.backend.mappers.JugadorMapper;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor // Obliga a spring que inyecte las clases mediante su constructor, alternativa al autowired
@Service
public class JugadorService{
	private final JugadorRepository jugadorRepository; // Inyecta JugadorRepository
	private final JugadorMapper jugadorMapper; // Inyecta JugadorMapper
	
	// crear un jugador
	public JugadorResponseDto crearJugador(JugadorRequestDto jugadorRequestDto){
		Jugador jugador = this.jugadorMapper.toEntity(jugadorRequestDto); // mapea el dto a la entidad 'Jugador'
		jugador.setNombre(jugador.getNombre().trim().toUpperCase()); // limpia espacios y convierte en mayúsculas
		jugador.setEmail(jugador.getEmail().trim().toLowerCase()); // limpia espacios y convierte en minúsculas
		
		// valida si el jugador ya existe
		if(this.jugadorRepository.existsByEmail(jugador.getEmail())){
			throw new IllegalStateException("El jugador con email"+ jugador.getEmail() + "ya existe");
		}
		
		Jugador jugadorSaved = this.jugadorRepository.save(jugador); // crea al jugador
		return this.jugadorMapper.toResponse(jugadorSaved); // mapea la entidad a un dto de respuesta para el cliente
	}
	// Consultar todos los jugadores
	public List<JugadorResponseDto> consultarJugadores(){
		List<Jugador> jugadores = this.jugadorRepository.findAll(); // lista todos los jugadores 
		return this.jugadorMapper.toListResponse(jugadores); // mapea la lista de entidades a una lista de dto de respuesta para el cliente
	}

	// Consultar jugador por id
	public Jugador getJugadorEntity(Long id){
		
		Jugador jugador = this.jugadorRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("El jugador no existe."));
		return jugador;		
	}
}
