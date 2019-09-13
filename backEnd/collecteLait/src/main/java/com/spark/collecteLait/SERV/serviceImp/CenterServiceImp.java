package com.spark.collecteLait.SERV.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spark.collecteLait.Repository.CenterRepostitory;
import com.spark.collecteLait.SERV.service.CenterService;
import com.spark.collecteLait.model.entity.Center;

@Service
public class CenterServiceImp  implements CenterService{
	
	@Autowired
	private CenterRepostitory  centerRepostitory ;

	@Override
	public Center getCenterById(Long id) {
	
		return centerRepostitory.findById(id).get();
				}

	@Override
	public List<Center> getAllCenters() {
		 
		return (List<Center>) centerRepostitory.findAll();
	}

	@Override
	public Center saveCenter(Center center) {
		 
		return centerRepostitory.save(center);
	}

	@Override
	public Center updateCenter(Long id, Center center) {
		 center.setId(id);
		return centerRepostitory.save(center);
	}

	@Override
	public void deleteCenterById(Long id) {
		centerRepostitory.deleteById(id);
		
	}

}
