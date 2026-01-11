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

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/jugadores")
public class JugadorController{

	private final JugadorService jugadorService;

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
