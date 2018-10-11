package com.zdy.school.vo;

import java.sql.Date;

/**
 * @author Psyduck
 * JobInfo 招聘信息表
 * 用于存放招聘信息的相关信息
 */
public class JobInfo {
	private int JobId;
	private String JobInfo;
	private String JobPosition;
	private Date JobDate;
	private String EnterpriseName;
	private String ECheck;
	private String Wage;

	public int getJobId() {
		return JobId;
	}

	public void setJobId(int jobId) {
		JobId = jobId;
	}

	public String getJobInfo() {
		return JobInfo;
	}

	public void setJobInfo(String jobInfo) {
		JobInfo = jobInfo;
	}

	public String getJobPosition() {
		return JobPosition;
	}

	public void setJobPosition(String jobPosition) {
		JobPosition = jobPosition;
	}

	public Date getJobDate() {
		return JobDate;
	}

	public void setJobDate(Date jobDate) {
		JobDate = jobDate;
	}

	public String getEnterpriseName() {
		return EnterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		EnterpriseName = enterpriseName;
	}

	public String getECheck() {
		return ECheck;
	}

	public void setECheck(String ECheck) {
		this.ECheck = ECheck;
	}

	public String getWage() {
		return Wage;
	}

	public void setWage(String wage) {
		Wage = wage;
	}
}
