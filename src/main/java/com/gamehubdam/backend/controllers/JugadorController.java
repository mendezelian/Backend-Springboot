package com.gamehubdam.backend.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.gamehubdam.backend.dtos.JugadorRequestDto;
import com.gamehubdam.backend.dtos.JugadorResponseDto;
import com.gamehubdam.backend.services.JugadorService;
import com.gamehubdam.backend.dtos.JugadorLoginRequestDto;
import jakarta.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/jugadores")
public class JugadorController{
    //inyecta el service
	private final JugadorService jugadorService;
    
    //Crear un jugador
	@PostMapping
	public ResponseEntity<?> crearJugador(@Valid @RequestBody JugadorRequestDto jugadorRequestDto){
		try{
			JugadorResponseDto jugadorResponseDto = this.jugadorService.crearJugador(jugadorRequestDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(jugadorResponseDto);
		}catch(IllegalStateException e){
			Map<String,Object> messageError = new HashMap<>();
			messageError.put("error",HttpStatus.CONFLICT.getReasonPhrase());
			messageError.put("message",e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(messageError);
		}catch(Exception e){
			Map<String,String> messageError = new HashMap<>();
			messageError.put("error",String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			messageError.put("message","Error interno del servidor.");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageError);
		}
	}
    
    // Inicio de sesión de jugador
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody JugadorLoginRequestDto jugadorLoginRequestDto){
        try{
            JugadorResponseDto jugadorResponseDto = this.jugadorService.login(jugadorLoginRequestDto);
            return ResponseEntity.status(HttpStatus.OK).body(jugadorResponseDto);
        }catch(EntityNotFoundException e){ // manejo de errores
            Map<String, Object> messageError = new HashMap<>();
            messageError.put("error",HttpStatus.NOT_FOUND);
            messageError.put("message",e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageError);
        }catch(Exception e){
            Map<String, String> messageError = new HashMap<>();
            messageError.put("error",String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
            messageError.put("message","Error interno del servidor");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageError);
        }
    }
    // lista todos los jugadores
	@GetMapping
	public ResponseEntity<?> consultarJugadores(){
		try{
			List<JugadorResponseDto> jugadores = this.jugadorService.consultarJugadores();
			return ResponseEntity.status(HttpStatus.OK).body(jugadores);
		}catch(Exception e){
			Map<String,String> messageError = new HashMap<>();
			messageError.put("error",String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			messageError.put("message","Error interno del servidor");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageError);
		}
	}
}
