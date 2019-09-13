package com.spark.collecteLait.Rest.Controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spark.collecteLait.Rest.Dto.AgriculteurDto;
import com.spark.collecteLait.Rest.Dto.ChauffeurDto;
import com.spark.collecteLait.SERV.serviceImp.ChauffeurServiceImp;
import com.spark.collecteLait.model.entity.Agriculteur;
import com.spark.collecteLait.model.entity.Chauffeur;

@RestController
@CrossOrigin
public class ChauffeurController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private ChauffeurServiceImp chauffeurService;
	
	
	@GetMapping("/chauffeurs/{id}")
	public ResponseEntity<ChauffeurDto> getChauffeurById(@PathVariable long id) {
		Chauffeur  chauffeur =  chauffeurService.getChauffeurById(id) ;    
		ChauffeurDto  chauffeurDto = modelMapper.map(chauffeur, ChauffeurDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(chauffeurDto);
	}

	@GetMapping("/chauffeurs")
	public ResponseEntity<List<ChauffeurDto>> getAllChauffeur() {
		List<Chauffeur>  chauffeurs = chauffeurService.getAllChauffeurs();
		Type listType = new TypeToken<List<ChauffeurDto>>() {
		}.getType();
		List<ChauffeurDto>  chauffeursDto = modelMapper.map(chauffeurs, listType);
		return ResponseEntity.status(HttpStatus.OK).body(chauffeursDto);

	}

	@PostMapping("/chauffeurs")
	public ResponseEntity<@Valid ChauffeurDto> addChauffeur(@Valid @RequestBody ChauffeurDto  chauffeurDto) {

		 Chauffeur  chauffeur = modelMapper.map(chauffeurDto,  Chauffeur.class);
		 chauffeur =  chauffeurService.saveChauffeur(chauffeur);
		 chauffeurDto = modelMapper.map(chauffeur, ChauffeurDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(chauffeurDto);

	}

	@PutMapping("/chauffeurs/{id}")
	public ResponseEntity<@Valid ChauffeurDto> updateChauffeur(@Valid @RequestBody ChauffeurDto  chauffeurDto,@PathVariable long id) {

		 Chauffeur  chauffeur = modelMapper.map(chauffeurDto,  Chauffeur.class);
		 chauffeur =  chauffeurService.updateChauffeur(id, chauffeur);
		 chauffeurDto = modelMapper.map(chauffeur, ChauffeurDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(chauffeurDto);

	}

	@DeleteMapping("/chauffeurs/{id}")
	public ResponseEntity<Void> deleteChauffeur(@PathVariable("id") Long id) {
		chauffeurService.deleteChauffeurById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}



}
