package br.sp.gov.cursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.sp.gov.cursos.dto.CursosDto;
import br.sp.gov.cursos.entity.CursosEntity;
import br.sp.gov.cursos.repository.CursosRepository;

@RestController
@RequestMapping (value = "/cursos/v1")
public class CursosController {
	
	@Autowired
	CursosRepository  repository;
	
	@GetMapping (value = "consultar_cursos")
	public ResponseEntity<?>findAllCursos(){
		
		List  <CursosEntity> listaCursos = repository.findAll(); 
		
		return ResponseEntity.ok(listaCursos);
	}
	
	@PostMapping (path = "adicionar_curso", consumes = "application/json", produces = "application/json")
		
		public ResponseEntity<?>AddCurso(@RequestBody CursosDto dto){
			
			CursosEntity entity = new CursosEntity(dto.getNome(),dto.getSigla());
			
			CursosEntity response = repository.save(entity); 
			
			return ResponseEntity.ok(response);
		}

	
	
}
