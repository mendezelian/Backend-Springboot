package com.gamehubdam.backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.RequiredArgsConstructor;
import com.gamehubdam.backend.services.PartidaService;
import com.gamehubdam.backend.dtos.PartidaRequestDto;
import com.gamehubdam.backend.dtos.PartidaResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/partidas")
public class PartidaController{
	private final PartidaService partidaService;
	
	@PostMapping
	public ResponseEntity<?> crearPartida(@Valid @RequestBody PartidaRequestDto partidaRequestDto){
		try{
			PartidaResponseDto partida = this.partidaService.crearPartida(partidaRequestDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(partida);
		}catch(Exception e){
			Map<String, String> messageError = new HashMap<>();
			messageError.put("error",String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			messageError.put("message","Error interno del servidor.");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageError);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> listarPartidas(){
		try{
			List<PartidaResponseDto> partidas = this.partidaService.listarPartidas();
			return ResponseEntity.status(HttpStatus.OK).body(partidas);
		}catch(Exception e){
			Map<String,String> messageError = new HashMap<>();
			messageError.put("error",String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			messageError.put("message","Error interno del servidor.");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageError);
		}
	}
}
