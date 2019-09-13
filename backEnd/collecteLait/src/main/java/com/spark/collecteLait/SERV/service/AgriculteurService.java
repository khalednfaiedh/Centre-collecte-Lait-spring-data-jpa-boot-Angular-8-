package com.spark.collecteLait.SERV.service;

import java.util.List;

import com.spark.collecteLait.model.entity.Agriculteur;
 

public interface AgriculteurService {

	public  Agriculteur getAgriculteurById(Long id);

	public List<Agriculteur> getAllAgriculteurs();

	public Agriculteur saveAgriculteur(Agriculteur  agriculteur);

	public Agriculteur updateAgriculteur(Long id, Agriculteur  agriculteur);

	public void deleteAgriculteurById(Long id);
}
