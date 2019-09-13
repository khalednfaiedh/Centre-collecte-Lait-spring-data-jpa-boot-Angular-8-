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

import com.spark.collecteLait.SERV.serviceImp.AgriculteurServiceImp;
import com.spark.collecteLait.model.entity.Agriculteur;

@RestController
@CrossOrigin
public class AgriculteurController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AgriculteurServiceImp agriculteurService;

	@GetMapping("/agriculteurs/{id}")
	public ResponseEntity<AgriculteurDto> getAgriculteurById(@PathVariable long id) {
		Agriculteur agriculteur = agriculteurService.getAgriculteurById(id);
		AgriculteurDto agriculteurDto = modelMapper.map(agriculteur, AgriculteurDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(agriculteurDto);
	}

	@GetMapping("/agriculteurs")
	public ResponseEntity<List<AgriculteurDto>> getAllAgriculteurs() {
		List<Agriculteur> agriculteurs = agriculteurService.getAllAgriculteurs();
		Type listType = new TypeToken<List<AgriculteurDto>>() {
		}.getType();
		List<AgriculteurDto> agriculteursDto = modelMapper.map(agriculteurs, listType);
		return ResponseEntity.status(HttpStatus.OK).body(agriculteursDto);

	}

	@PostMapping("/agriculteurs")
	public ResponseEntity<@Valid AgriculteurDto> addAgriculteur(@Valid @RequestBody AgriculteurDto agriculteurDto) {

		Agriculteur agriculteur = modelMapper.map(agriculteurDto, Agriculteur.class);
		agriculteur = agriculteurService.saveAgriculteur(agriculteur);
		agriculteurDto = modelMapper.map(agriculteur, AgriculteurDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(agriculteurDto);

	}

	@PutMapping("/agriculteurs/{id}")
	public ResponseEntity<@Valid AgriculteurDto> updateAgriculteur(@Valid @RequestBody AgriculteurDto agriculteurDto,
			@PathVariable long id) {

		Agriculteur agriculteur = modelMapper.map(agriculteurDto, Agriculteur.class);
		agriculteur = agriculteurService.updateAgriculteur(id, agriculteur);
		agriculteurDto = modelMapper.map(agriculteur, AgriculteurDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(agriculteurDto);

	}

	@DeleteMapping("/agriculteurs/{id}")
	public ResponseEntity<Void> deleteAgriculteur(@PathVariable("id") Long id) {
		agriculteurService.deleteAgriculteurById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
