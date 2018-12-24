package jp.co.techno7.dailyreportadmin.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.techno7.dailyreportadmin.dao.Dao;

@Service
public class UpdateReportInfoService {

	// Daoクラスのインスタンス生成
	ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	Dao dao = context.getBean(Dao.class);

	@Transactional
	public Map<String, Object> updateReportInfoService(String userName, String defualtTitle, String unitCode, int userKey) {
		dao.updateUserInfoDao(userName, defualtTitle, unitCode, userKey);
		Map<String, Object> returnValue = new HashMap<String, Object>();
		returnValue.put("returnValue", "success");
		return returnValue;
	}

}
