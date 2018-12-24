package jp.co.techno7.dailyreportadmin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import jp.co.techno7.dailyreportadmin.dao.Dao;

@Service
public class GetReportListService {

	// Daoクラスのインスタンス生成
	ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	Dao dao = context.getBean(Dao.class);

	public List<Map<String, Object>> getReportListService(int userKey){
		List<Map<String, Object>> jsonData = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> resultSql = dao.getReportListDao(userKey);
		for (Map<String, Object> map : resultSql) {
			Map<String, Object> mapData = new HashMap<String, Object>();
			mapData.put("reportKey", (int)map.get("REPORT_KEY"));
			mapData.put("reportTitle", map.get("REPORT_TITLE").toString());
			mapData.put("createDate", map.get("CREATE_DATE").toString());
			mapData.put("editDateTitle", map.get("CREATE_DATETIME").toString());
			mapData.put("userName", map.get("USER_NAME").toString());
			jsonData.add(mapData);
		}
		return jsonData;
	}

}
