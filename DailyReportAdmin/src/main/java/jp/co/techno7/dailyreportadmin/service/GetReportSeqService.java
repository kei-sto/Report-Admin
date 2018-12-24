package jp.co.techno7.dailyreportadmin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.techno7.dailyreportadmin.dao.Dao;

@Service
public class GetReportSeqService {

	// Daoクラスのインスタンス生成
	ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	Dao dao = context.getBean(Dao.class);

	@Transactional
	public Map<String, Object> getReportSeqService() {
		dao.updateReportSeqDao();
		Map<String, Object> returnReportSeq = new HashMap<String, Object>();
		int nextReportKey = -1;
		List<Map<String, Object>> resultSql = dao.getReportSeqDao();
		for (Map<String, Object> map : resultSql) {
			nextReportKey = (int)map.get("NEXT_VALUE");
		}
		returnReportSeq.put("NEXT_VALUE", nextReportKey);
		return returnReportSeq;
	}
}
