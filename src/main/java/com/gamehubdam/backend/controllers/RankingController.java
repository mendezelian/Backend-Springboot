package com.gamhubdam.backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import java.util.Map;
import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/ranking")
public class RankingController{
	private final RankingService rankingService;

	public ResponseEntity<?> listarRanking(){
		try{
			List<RankingResponseDto> ranking = this.rankingService.listarRanking();
			return ResponseEntity.Status(200).body(ranking);
		}catch(Exception e){
			Map<String, String> messageError = new HashMap<>();
			messageError.put("error",String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			messageError.put("message","Error interno del servidor.");
				
		}
	}
}
