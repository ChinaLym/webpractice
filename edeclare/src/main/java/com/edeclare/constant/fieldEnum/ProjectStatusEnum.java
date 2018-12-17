package com.edeclare.constant.fieldEnum;
/**
* Type: ProjectStatusEnum
* Description: 项目目前状态：[
* 待初审，
* 初审通过，
* 初审不通过，	（同待初审，并附加原因）
* 
* 立项评审中，
* 已立项，
* 不立项，		（结束×）
* 
* 待中期检查，	（提交完毕中期检查所需材料）
* 中期检查通过，
* 中期检查待整改，（同待中期检查，并附加原因）
* 
* 待结题，		（提交完毕结题所需材料）
* 已结题，		（结束√）
* 结题验收待整改	（同待结题，并附加原因）
* ]
* 需要附加原因的，直接更新在备注(text字段)
* @author LYM
* @date Dec 17, 2018
 */
public enum ProjectStatusEnum {
	FIRST_TRIAL_PENDING,			//待初审
	FIRST_TRIAL_PASSED,				//初审通过
	FIRST_TRIAL_NOT_PASS,			//初审不通过
	
	ESTABLISH_ON_TRIAL,				//立项评审中
	ESTABLISHED,					//立项通过
	NO_ESTABLISHMENT,				//不立项
	
	MIDDLE_TRIAL_PENDING,			//中期检查待审核
	MIDDLE_TRIAL_PASSED,			//中期检查通过
	MIDDLE_RECTIFICATION,			//中期检查待整改
	
	FINISHED_PENDING,				//结题审核中
	FINISHED,						//结题
	FINAL_RECTIFICATION				//结题待整改
}
