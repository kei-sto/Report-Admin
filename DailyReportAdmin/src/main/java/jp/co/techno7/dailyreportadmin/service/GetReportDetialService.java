package jp.co.techno7.dailyreportadmin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import jp.co.techno7.dailyreportadmin.dao.Dao;

@Service
public class GetReportDetialService {

	// Daoクラスのインスタンス生成
	ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	Dao dao = context.getBean(Dao.class);

	public Map<String, Object> getReportDetialService(int userKey, int reportKey){
		Map<String, Object> jsonData = new HashMap<String, Object>();
		List<Map<String, Object>> resultSql = dao.getReportDetailDao(userKey, reportKey);
		for (Map<String, Object> map : resultSql) {
			jsonData.put("reportKey", (int)map.get("REPORT_KEY"));
			jsonData.put("reportTitle", map.get("REPORT_TITLE").toString());
			jsonData.put("createDate", map.get("CREATE_DATE").toString());
			jsonData.put("editDateTitle", map.get("CREATE_DATETIME").toString());
			jsonData.put("unit", map.get("COMPANY_CODE").toString());
			jsonData.put("userName", map.get("USER_NAME").toString());
			jsonData.put("contents", map.get("CONTENTS").toString());
			jsonData.put("progress", map.get("PROGRESS").toString());
			jsonData.put("job_plan", map.get("JOB_PLAN").toString());
			jsonData.put("impression", map.get("IMPRESSION").toString());
		}
		return jsonData;
	}

}
