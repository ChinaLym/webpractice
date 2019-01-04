package com.edeclare.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.edeclare.constant.fieldEnum.ProjectStatusEnum;
import com.edeclare.entity.Meterial;
import com.edeclare.entity.Project;
import com.edeclare.repository.IMeterialRepository;
import com.edeclare.service.IMeterialService;
/**
* Type: MetearialServiceImpl
* Description: 实现类，
* @author LYM
* @date Dec 16, 2018
 */
@Service
public class MeterialServiceImpl implements IMeterialService{

    private IMeterialRepository meterialRepository;

    @Autowired
    public void setUserRepositry(IMeterialRepository meterialRepository) {
        this.meterialRepository = meterialRepository;
    }
    
    @Override
    public List<Meterial> listByProjectId(Integer projectId){
    	Meterial meterial = new Meterial();
    	meterial.setProjectId(projectId);
    	Example<Meterial> example = Example.of(meterial);
		return meterialRepository.findAll(example);
    }

	@Override
	public Meterial findById(Integer id) {
		try {
			Meterial meterial = meterialRepository.getOne(id);
			return meterial;
		}catch (Exception e) {
			return null;
		}
	}

	@Override
	public Meterial save(Meterial meterial) {
		return meterialRepository.save(meterial);
	}

	@Override
	public Meterial uploadMeterial(Integer meterialId, String fileName) {
		try {
			Meterial meterial = meterialRepository.getOne(meterialId);
			meterial.setCommit(true);
			meterial.setChangeTime(new Date());
			meterial.setUrl(fileName);
			return meterialRepository.save(meterial);
		}catch (Exception e) {
			return null;
		}
	}
	//错误，未开发
	@Override
	public Meterial getMeterialByProjectIdAndStage(Integer projectId) {
		Meterial meterial = meterialRepository.getOne(projectId);
		return meterial==null?null:meterial;
	}

	@Override
	public Meterial getMeterialByProject(Project project) {
		Meterial meterial = new Meterial();
    	meterial.setProjectId(project.getId());
    	Example<Meterial> example = Example.of(meterial);
    	List<Meterial> list = meterialRepository.findAll(example);
    	if (list != null && list.size() != 0) {
    		if(ProjectStatusEnum.ESTABLISHED.toString().equals(project.getStatus())||
    				ProjectStatusEnum.MIDDLE_RECTIFICATION.toString().equals(project.getStatus()))
    			return list.get(0);
    		else {
    			for(Meterial item : list) {
    				if("FINAL".equals(item.getStage()))
    					return item;
    			}
    			return createNewMeterial(meterial, project.getStatus());
    		}
		}else {
			return createNewMeterial(meterial, project.getStatus());
		}	
	}
	private Meterial createNewMeterial(Meterial meterial, String projectStatus) {
		meterial.setCreateTime(new Date());
		meterial.setChangeTime(new Date());
		meterial.setCommit(false);
		if(ProjectStatusEnum.ESTABLISHED.toString().equals(projectStatus)||
				ProjectStatusEnum.MIDDLE_RECTIFICATION.toString().equals(projectStatus))
			meterial.setStage("MID");
		else
			meterial.setStage("FINAL");
		return meterialRepository.save(meterial);
	}
}
