package jp.co.techno7.dailyreportadmin.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.techno7.dailyreportadmin.dao.Dao;

@Service
public class CreateReportService {

	// Daoクラスのインスタンス生成
	ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	Dao dao = context.getBean(Dao.class);

	@Autowired
	GetReportSeqService grss;
	
	@Transactional
	public Map<String, Object> createReportService(String reportTitle, int createUserKey, String createDate, 
			String contents, String progress, String job_plan, String impression){
		int reportKey = (int) grss.getReportSeqService().get("NEXT_VALUE") ;
		dao.createReportOverViewDao(reportKey, reportTitle, createUserKey, createDate);
		dao.createReportDetialDao(reportKey, contents, progress, job_plan, impression);
		Map<String, Object> returnValue = new HashMap<String, Object>();
		returnValue.put("returnValue", "success");
		return returnValue;
	}
	
}
