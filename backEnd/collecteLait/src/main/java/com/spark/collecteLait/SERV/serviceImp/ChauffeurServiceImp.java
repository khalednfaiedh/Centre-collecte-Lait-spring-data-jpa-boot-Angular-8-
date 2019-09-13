package com.spark.collecteLait.SERV.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spark.collecteLait.Repository.ChauffeurRepository;
import com.spark.collecteLait.SERV.service.ChauffeurService;
import com.spark.collecteLait.model.entity.Chauffeur;

@Service
public class ChauffeurServiceImp implements ChauffeurService {

	@Autowired
	private ChauffeurRepository chauffeurRepository;

	@Override
	public Chauffeur getChauffeurById(Long id) {
		// TODO Auto-generated method stub
		return chauffeurRepository.findById(id).get();
	}

	@Override
	public List<Chauffeur> getAllChauffeurs() {
		// TODO Auto-generated method stub
		return (List<Chauffeur>) chauffeurRepository.findAll();
	}

	@Override
	public Chauffeur saveChauffeur(Chauffeur chauffeur) {
		// TODO Auto-generated method stub
		return chauffeurRepository.save(chauffeur);
	}

	@Override
	public Chauffeur updateChauffeur(Long id, Chauffeur chauffeur) {
		chauffeur.setId(id);
		return chauffeurRepository.save(chauffeur);
	}

	@Override
	public void deleteChauffeurById(Long id) {
		chauffeurRepository.deleteById(id);
	}

}
