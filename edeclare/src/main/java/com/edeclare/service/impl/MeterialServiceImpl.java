package com.edeclare.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.edeclare.entity.Meterial;
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
	public boolean uploadMeterial(Integer meterialId, String fileName) {
		try {
			Meterial meterial = meterialRepository.getOne(meterialId);
			meterial.setCommit(true);
			meterial.setChangeTime(new Date());
			meterial.setUrl(fileName);
			return meterialRepository.save(meterial) != null;
		}catch (Exception e) {
			return false;
		}
	}
}
