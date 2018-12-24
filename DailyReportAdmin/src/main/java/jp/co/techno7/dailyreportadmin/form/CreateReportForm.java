package jp.co.techno7.dailyreportadmin.form;

import java.io.Serializable;

public class CreateReportForm implements Serializable {

	private static final long serialVersionUID = 1L;
	private String reportTitle;
	private int createUserKey;
	private String createDate;
	private String contents;
	private String progress;
	private String job_plan;
	private String impression;

	public String getReportTitle() {
		return reportTitle;
	}
	public int getCreateUserKey() {
		return createUserKey;
	}
	public void setCreateUserKey(int createUserKey) {
		this.createUserKey = createUserKey;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getJob_plan() {
		return job_plan;
	}
	public void setJob_plan(String job_plan) {
		this.job_plan = job_plan;
	}
	public String getImpression() {
		return impression;
	}
	public void setImpression(String impression) {
		this.impression = impression;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
