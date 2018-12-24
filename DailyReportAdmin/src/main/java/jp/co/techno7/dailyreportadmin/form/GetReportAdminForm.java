package jp.co.techno7.dailyreportadmin.form;

import java.io.Serializable;

public class GetReportAdminForm implements Serializable{

	private static final long serialVersionUID = 1L;
	private int userKey;
	private String unitCode;
	private String name;
	private String defualtTitle;
	
	public int getUserKey() {
		return userKey;
	}
	public void setUserKey(int userKey) {
		this.userKey = userKey;
	}
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDefualtTitle() {
		return defualtTitle;
	}
	public void setDefualtTitle(String defualtTitle) {
		this.defualtTitle = defualtTitle;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
