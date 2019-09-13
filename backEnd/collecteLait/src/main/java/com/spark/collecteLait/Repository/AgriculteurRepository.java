package com.spark.collecteLait.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.collecteLait.model.entity.Agriculteur;

@Repository
public interface AgriculteurRepository  extends CrudRepository<Agriculteur, Long>{

}
