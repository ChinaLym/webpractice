package com.edeclare.controller;


import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.edeclare.annotation.LoginRequired;
import com.edeclare.config.WebMvcConfig;
import com.edeclare.constant.responseBody.BaseResponse;
import com.edeclare.entity.Meterial;
import com.edeclare.entity.Project;
import com.edeclare.service.IMeterialService;
import com.edeclare.utils.FileUtil;
/**
* Type: UserController
* Description: 与User相关
* 	不要在Controller层进行数据安全性校验，移步至service层校验
* @author LYM
* @date Dec 16, 2018
 */
@Controller
public class MeterialController {
	
    @Autowired
    private IMeterialService meterialService;
    
    //新建材料
    @RequestMapping("/meterial/save")
    @ResponseBody
    public BaseResponse roleSave(Meterial meterial) {
    	meterialService.save(meterial);
    	return new BaseResponse().setMessage("success");
    }
    
    
	//查询
    @GetMapping(value = "/meterial/list")
    public String listAllMeterialByProjectId(Integer projectId,Model model) throws Exception {
    	List<Meterial> meterialList = meterialService.listByProjectId(projectId);
    	model.addAttribute("meterialList", meterialList);
    	return "manager/system_setting/role/role_list";
    }

   //查询
    @GetMapping(value = "/meterial/find")
    public String findMeterialById(Integer id,Model model) throws Exception {
    	Meterial meterial = meterialService.findById(id);
    	model.addAttribute("meterial", meterial);
    	return "manager/system_setting/role/role_list";
    }
    
/*
    待开发
    @GetMapping(value = "/zqcl")
    public String zqcl(@RequestParam(value = "project")Project project) {
    	meterialService.getMeterialByProjectIdAndStage(project.getId());
    	return "staff/material/middle_material";
    
    }*/
    @GetMapping(value = "/zqcl")
    public String zqcl(@RequestParam(value = "project")Project project) {
    	meterialService.getMeterialByProjectIdAndStage(project.getId());
    	return "staff/material/middle_material";
    }
    

    
    @GetMapping(value = "/jtcl")
    public String jtcl() {
    	return "staff/material/final_material";
    }
    
    @RequestMapping("/meterial/upload")
    @LoginRequired
    @ResponseBody
    public BaseResponse upload(@RequestParam("cover") MultipartFile uploadFile,
    		@RequestParam("meterialId") Integer meterialId,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        byte[] content = uploadFile.getBytes();
        // 保存文件到具体目录，此处为D:/book/upload
        String path = WebMvcConfig.FILE_DIR;
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        // 获取文件后缀
        String fileSuffix = FileUtil
                .getSuffix(uploadFile.getOriginalFilename());
        // 设置文件名
        File file = new File(folder.getAbsolutePath() + File.separator
                + UUID.randomUUID().toString() + fileSuffix);
        file.createNewFile();
        // 写到服务器文件
        FileUtil.writeFile(file, content);
        if(!meterialService.uploadMeterial(meterialId, file.getName())) {
        	file.deleteOnExit();
        	return new BaseResponse().setMessage("fail");
        }
        return new BaseResponse().setMessage("success");
    }
}
