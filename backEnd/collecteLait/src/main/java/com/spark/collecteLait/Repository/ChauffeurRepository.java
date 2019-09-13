package com.spark.collecteLait.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.collecteLait.model.entity.Chauffeur;

@Repository
public interface ChauffeurRepository extends CrudRepository<Chauffeur,  Long> {

}
