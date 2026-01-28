package com.gamehubdam.backend.services;


import lombok.RequiredArgsConstructor;
import com.gamehubdam.backend.dtos.PartidaRequestDto;
import com.gamehubdam.backend.dtos.PartidaResponseDto;
import com.gamehubdam.backend.repositories.PartidaRepository;
import com.gamehubdam.backend.entities.Partida;
import com.gamehubdam.backend.mappers.PartidaMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import com.gamehubdam.backend.services.JugadorService;
import com.gamehubdam.backend.repositories.JugadorPartidaRepository;
import com.gamehubdam.backend.entities.JugadorPartida;
import com.gamehubdam.backend.entities.Jugador;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import com.gamehubdam.backend.dtos.JugadorScoreRequestDto;
import com.gamehubdam.backend.dtos.JugadorRequestDto;
@RequiredArgsConstructor // Obliga a spring a inyectar mediante el constructor, alternativa a autowired
@Service
public class PartidaService{
	private final PartidaRepository partidaRepository;
	private final PartidaMapper partidaMapper;
	private final JugadorService jugadorService;
	private final JugadorPartidaRepository jugadorPartidaRepository;
	
	//crear partida
	@Transactional //si falla algo que revierta los cambios
	public PartidaResponseDto crearPartida(PartidaRequestDto partidaRequestDto){
		
        //Mapea el request para crear la entidad Partida
		Partida partida = this.partidaMapper.toPartidaEntity(partidaRequestDto);
		
        //Guarda la partida en la base de datos
		Partida partidaSaved = this.partidaRepository.save(partida);
		    
        //Se inicializa para ocuparla dentro del for
        List<JugadorPartida> jugadoresPartida = new ArrayList<>();

        // Consulta los jugadores
        for(JugadorScoreRequestDto j : partidaRequestDto.getJugadores()){
            //Consultar el jugador
            Jugador jugador = this.jugadorService.getJugadorEntity(j.getId());
            
            //Mapea el request para crear la entidad JugadorPartida
		    JugadorPartida jugadorPartida = this.partidaMapper.toJugadorPartidaEntity(partida,jugador,j);
			
		    //Guarda la relación de jugador con partida en la base de datos 
		    JugadorPartida jugadorPartidaSaved = this.jugadorPartidaRepository.save(jugadorPartida);
            
            //Se le agrega a la lista
            jugadoresPartida.add(jugadorPartidaSaved);
        }
        
        //retorna la relacion jugador-partida
		return this.partidaMapper.toResponse(partidaSaved, jugadoresPartida);
	}
	
	// listar partidas
	public List<PartidaResponseDto> listarPartidas(){
		List<Partida> partidas = this.partidaRepository.findAll();

        List<List<JugadorPartida>> listJugadoresPartidas = new ArrayList<>();
        
        for(Partida p : partidas){
            List<JugadorPartida> jugadoresPartida = this.jugadorPartidaRepository.findByPartidaId(p.getId())
                .orElseThrow(() -> new EntityNotFoundException("No existe la relación de partida con id "+p.getId()+" con la entidad jugador"));
            listJugadoresPartidas.add(jugadoresPartida);
        } 
        
		
		return this.partidaMapper.toListResponse(partidas, listJugadoresPartidas);
	}
}
