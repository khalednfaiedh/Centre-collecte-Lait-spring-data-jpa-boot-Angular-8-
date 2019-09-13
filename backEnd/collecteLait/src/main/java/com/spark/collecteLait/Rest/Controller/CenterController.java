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

import com.spark.collecteLait.Rest.Dto.CenterDto;

import com.spark.collecteLait.SERV.serviceImp.CenterServiceImp;
import com.spark.collecteLait.model.entity.Center;

@RestController
@CrossOrigin
public class CenterController {

	@Autowired
	private CenterServiceImp centerService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/test")
	public String test() {
		return "test  collect lait";
	}

	@GetMapping("/centers/{id}")
	public ResponseEntity<CenterDto> getCenterById(@PathVariable long id) {
		Center center = centerService.getCenterById(id);
		CenterDto centerDto = modelMapper.map(center, CenterDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(centerDto);
	}

	@GetMapping("/centers")
	public ResponseEntity<List<CenterDto>> getAllsCenters() {
		List<Center> centers = centerService.getAllCenters();
		Type listType = new TypeToken<List<CenterDto>>() {
		}.getType();
		List<CenterDto> centerDto = modelMapper.map(centers, listType);
		return ResponseEntity.status(HttpStatus.OK).body(centerDto);

	}

	@PostMapping("/centers")
	public ResponseEntity<@Valid CenterDto> addCenter(@Valid @RequestBody CenterDto centerDto) {

		Center center = modelMapper.map(centerDto, Center.class);
		center = centerService.saveCenter(center);
		centerDto = modelMapper.map(center, CenterDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(centerDto);

	}

	@PutMapping("/centers/{id}")
	public ResponseEntity<@Valid CenterDto> updateCenter(@Valid @RequestBody CenterDto centerDto,
			@PathVariable long id) {

		Center center = modelMapper.map(centerDto, Center.class);
		center = centerService.updateCenter(id, center);
		centerDto = modelMapper.map(center, CenterDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(centerDto);

	}

	@DeleteMapping("/centers/{id}")
	public ResponseEntity<Void> deleteCenter(@PathVariable("id") Long id) {
		centerService.deleteCenterById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
