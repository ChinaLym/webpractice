package com.edeclare.service;

import java.util.List;

import com.edeclare.entity.Meterial;

public interface IMeterialService{

	List<Meterial> listByProjectId(Integer projectId);

	Meterial findById(Integer id);

	Meterial save(Meterial meterial);

	boolean uploadMeterial(Integer meterialId, String fileName);

	Meterial getMeterialByProjectIdAndStage(Integer projectId);

}