package com.spark.collecteLait.SERV.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spark.collecteLait.Repository.AgriculteurRepository;
import com.spark.collecteLait.SERV.service.AgriculteurService;
import com.spark.collecteLait.model.entity.Agriculteur;

@Service
public class AgriculteurServiceImp implements AgriculteurService{
	
	@Autowired
	private AgriculteurRepository  agriculteurRepository;

	@Override
	public Agriculteur getAgriculteurById(Long id) {
		 
		return agriculteurRepository.findById(id).get();
	}

	@Override
	public List<Agriculteur> getAllAgriculteurs() {
		 
		return (List<Agriculteur>) agriculteurRepository.findAll();
	}

	@Override
	public Agriculteur saveAgriculteur(Agriculteur agriculteur) {
		 
		return agriculteurRepository.save( agriculteur);
	}

	@Override
	public Agriculteur updateAgriculteur(Long id, Agriculteur agriculteur) {
		 agriculteur.setId(id);
		return agriculteurRepository.save(agriculteur);
	}

	@Override
	public void deleteAgriculteurById(Long id) {
		agriculteurRepository.deleteById(id);
		
	}

}
