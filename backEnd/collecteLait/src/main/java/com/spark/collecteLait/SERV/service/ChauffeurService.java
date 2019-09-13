package com.spark.collecteLait.SERV.service;

import java.util.List;

import com.spark.collecteLait.model.entity.Chauffeur;

public interface ChauffeurService {

	public Chauffeur getChauffeurById(Long id);

	public List<Chauffeur> getAllChauffeurs();

	public Chauffeur saveChauffeur(Chauffeur chauffeur);

	public Chauffeur updateChauffeur(Long id, Chauffeur chauffeur);

	public void deleteChauffeurById(Long id);

}
