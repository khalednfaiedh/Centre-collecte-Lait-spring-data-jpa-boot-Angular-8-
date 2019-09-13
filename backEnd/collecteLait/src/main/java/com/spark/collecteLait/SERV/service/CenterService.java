package com.spark.collecteLait.SERV.service;

import java.util.List;

import com.spark.collecteLait.model.entity.Center;

public interface CenterService {

	public Center getCenterById(Long id);

	public List<Center> getAllCenters();

	public Center saveCenter(Center center);

	public Center updateCenter(Long id, Center center);

	public void deleteCenterById(Long id);

}
