package com.gamehubdam.backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class JugadorController{	
	public ArrayList<Map<String,String>> generatePlayers(){
		Map<String, String> jk1 = new HashMap<>();
		jk1.put("id","1");
		jk1.put("nombre","Yahir Méndez");
		jk1.put("email","ikyemendez24@lhusurbil.eus");
		Map<String, String> jk2 = new HashMap();
		jk2.put("id","2");
		jk2.put("nombre","Oier Albizu");
		jk2.put("email","ikoalbizu24@lhusurbil.eus");
		Map<String,String> jk3 = new HashMap();
		jk3.put("id","3");
		jk3.put("nombre","Aitor Mindeguia");
		jk3.put("email","ikamindeguia24@lhusurbil.eus");
		ArrayList<Map<String,String>> array = new ArrayList<>();
		array.add(jk1);
		array.add(jk2);
		array.add(jk3);

		return array;
	}
		
	public ArrayList<Map<String,String>> generateRanking(){
		Map<String, String> jk1 = new HashMap<>();
		jk1.put("puesto","2");
		jk1.put("nombre","Yahir Méndez");
		jk1.put("score","500");
		Map<String, String> jk2 = new HashMap();
		jk2.put("puesto","3");
		jk2.put("nombre","Oier Albizu");
		jk2.put("score","300");
		Map<String,String> jk3 = new HashMap();
		jk3.put("puesto","1");
		jk3.put("nombre","Aitor Mindeguia");
		jk3.put("score","550");
		ArrayList<Map<String,String>> array = new ArrayList<>();
		array.add(jk1);
		array.add(jk2);
		array.add(jk3);

		return array;
	}
  	
	
	public ArrayList<Map<String,String>> generatePartidas(){
		Map<String, String> jk1 = new HashMap<>();
		jk1.put("nombre","Yahir Méndez");
		jk1.put("score","500");
		jk1.put("duracion","10");
		jk1.put("fecha","2025-01-08");
		Map<String, String> jk2 = new HashMap();
		jk2.put("nombre","Oier Albizu");
		jk2.put("score","300");
		jk2.put("duracion","5");
		jk2.put("fecha","2025-01-08");
		Map<String,String> jk3 = new HashMap();
		jk3.put("nombre","Aitor Mindeguia");
		jk3.put("score","550");
		jk3.put("duracion","15");
		jk3.put("fecha","2025-01-08");
		ArrayList<Map<String,String>> array = new ArrayList<>();
		array.add(jk1);
		array.add(jk2);
		array.add(jk3);

		return array;
	}

	@GetMapping("/jugadores")
	public ResponseEntity<?> getJugadores(){
		ArrayList<Map<String,String>> jk = this.generatePlayers();	
		return ResponseEntity.status(HttpStatus.OK).body(jk);
	}

	@GetMapping("/ranking")
	public ResponseEntity<?> getRanking(){
		ArrayList<Map<String,String>> jk = this.generateRanking();
		return ResponseEntity.status(HttpStatus.OK).body(jk);
	}
	@GetMapping("/partidas")
	public ResponseEntity<?> getPartidas(){
		ArrayList<Map<String,String>> jk = this.generatePartidas();
		return ResponseEntity.status(HttpStatus.OK).body(jk);
	}
}
