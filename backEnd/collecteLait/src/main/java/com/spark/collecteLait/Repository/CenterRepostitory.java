package com.spark.collecteLait.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.collecteLait.model.entity.Center;

@Repository 
public interface CenterRepostitory  extends CrudRepository<Center,Long> {

}
