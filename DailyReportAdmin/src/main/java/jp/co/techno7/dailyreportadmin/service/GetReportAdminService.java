package jp.co.techno7.dailyreportadmin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import jp.co.techno7.dailyreportadmin.dao.Dao;

@Service
public class GetReportAdminService {
	
	// Daoクラスのインスタンス生成
	ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	Dao dao = context.getBean(Dao.class);

	public Map<String, Object> getReportAdminService(int userKey){
		Map<String, Object> mapData = new HashMap<String, Object>();
		List<Map<String, Object>> resultSql = dao.getReportAdminDao(userKey);
		for (Map<String, Object> map : resultSql) {
			mapData.put("userName", map.get("USER_NAME").toString());
			mapData.put("defualtTitle", map.get("DEFUALT_TITLE").toString());
			mapData.put("unitCode", map.get("COMPANY_CODE").toString());
		}
		return mapData;
	}

}
