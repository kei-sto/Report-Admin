package jp.co.techno7.dailyreportadmin.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class Dao extends JdbcDaoSupport {

	// レポートの連番を取得する
	public List<Map<String, Object>> getReportSeqDao(){
		return getJdbcTemplate().queryForList("select NEXT_VALUE from REPORT_SEQUENCE");
	}

	// レポートの連番をUpdateする
	public void updateReportSeqDao() {
		getJdbcTemplate().update("update REPORT_SEQUENCE set NEXT_VALUE = NEXT_VALUE + 1");
	}
	
	// お知らせ情報を取得する。
	public List<Map<String, Object>> getReportInfoDao() {
		return getJdbcTemplate()
				.queryForList("select * from INFORMATION where LOGICAL_DELETE_IND='N' order by INFORMATION_KEY");
	}

	// 管理情報を取得する。
	public List<Map<String, Object>> getReportAdminDao(int userKey) {
		return getJdbcTemplate()
				.queryForList("select * from USER where LOGICAL_DELETE_IND='N' and USER_KEY=?", userKey);
	}

	// レポート一覧を取得する
	public List<Map<String, Object>> getReportListDao(int userKey) {
		return getJdbcTemplate()
				.queryForList("select ov.*, us.USER_NAME "
							+ "from REPORT_OVERVIEW ov left join USER us on ov.CREATE_USER_KEY = us.USER_KEY "
							+ "where ov.LOGICAL_DELETE_IND='N' and ov.CREATE_USER_KEY = ? ", userKey);
	}

	// レポート詳細を取得する
	public List<Map<String, Object>> getReportDetailDao(int userKey, int reportKey) {
		return getJdbcTemplate()
				.queryForList("select ov.*, de.CONTENTS, de.PROGRESS, de.JOB_PLAN, de.IMPRESSION, us.COMPANY_CODE, us.USER_NAME "
							+ "from REPORT_OVERVIEW ov left join REPORT_DETIAL de on ov.REPORT_KEY = de.REPORT_KEY "
							+ "left join USER us on ov.CREATE_USER_KEY = us.USER_KEY "
							+ "where ov.LOGICAL_DELETE_IND='N' and ov.CREATE_USER_KEY = ? and ov.REPORT_KEY = ? ", userKey, reportKey);
	}

	// 利用者情報を更新する
	public void updateUserInfoDao(String userName, String defualtTitle, String unitCode, int userKey){
		getJdbcTemplate().update("update USER set USER_NAME = ?, DEFUALT_TITLE = ?, COMPANY_CODE = ? where USER_KEY = ?", 
				userName, defualtTitle, unitCode, userKey);
	}

	// レポートを作成する(レポート概要)
	public void createReportOverViewDao(int reportKey, String reportTitle, int createUserKey, String createDate) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		getJdbcTemplate().update("insert into REPORT_OVERVIEW values (?, ?, ?, ?, ?, ?)", 
				reportKey, reportTitle, createUserKey, sdf.format(calendar.getTime()), createDate, "N");
	}

	// レポートを作成する(レポート詳細)
	public void createReportDetialDao(int reportKey, String contents, String progress, String job_plan, String impression) {
		getJdbcTemplate().update("insert into REPORT_DETIAL values (?, ?, ?, ?, ?)", 
				reportKey, contents, progress, job_plan, impression);
	}

}
