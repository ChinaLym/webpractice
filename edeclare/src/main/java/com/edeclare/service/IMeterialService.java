package com.edeclare.service;

import java.util.List;

import com.edeclare.entity.Meterial;
import com.edeclare.entity.Project;

public interface IMeterialService{

	List<Meterial> listByProjectId(Integer projectId);

	Meterial findById(Integer id);

	Meterial save(Meterial meterial);

	Meterial uploadMeterial(Integer meterialId, String fileName);

	Meterial getMeterialByProjectIdAndStage(Integer projectId);

	Meterial getMeterialByProject(Project project);

}