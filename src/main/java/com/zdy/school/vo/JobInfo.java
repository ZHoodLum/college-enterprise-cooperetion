package com.zdy.school.vo;

import java.sql.Date;

/**
 * @author Psyduck
 * JobInfo 招聘信息表
 * 用于存放招聘信息的相关信息
 */
public class JobInfo {
	private int jobId;
	private String jobInfo;
	private String jobPosition;
	private Date jobDate;
	private String enterpriseName;
	private String ECheck;
	private String wage;

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobInfo() {
		return jobInfo;
	}

	public void setJobInfo(String jobInfo) {
		this.jobInfo = jobInfo;
	}

	public String getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

	public Date getJobDate() {
		return jobDate;
	}

	public void setJobDate(Date jobDate) {
		this.jobDate = jobDate;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getECheck() {
		return ECheck;
	}

	public void setECheck(String ECheck) {
		this.ECheck = ECheck;
	}

	public String getWage() {
		return wage;
	}

	public void setWage(String wage) {
		this.wage = wage;
	}
}
