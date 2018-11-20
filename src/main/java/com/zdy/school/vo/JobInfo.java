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
	private String eCheck;
	private String wage;
	private Integer enterpriseId;
	private String informationState;
	private String enterpriseName;
	private String enterpriseAddress;
	private String enterpriseTel;
	private String email;

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

	public String geteCheck() {
		return eCheck;
	}

	public void seteCheck(String eCheck) {
		this.eCheck = eCheck;
	}

	public String getWage() {
		return wage;
	}

	public void setWage(String wage) {
		this.wage = wage;
	}

	public Integer getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Integer enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getInformationState() {
		return informationState;
	}

	public void setInformationState(String informationState) {
		this.informationState = informationState;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getEnterpriseAddress() {
		return enterpriseAddress;
	}

	public void setEnterpriseAddress(String enterpriseAddress) {
		this.enterpriseAddress = enterpriseAddress;
	}

	public String getEnterpriseTel() {
		return enterpriseTel;
	}

	public void setEnterpriseTel(String enterpriseTel) {
		this.enterpriseTel = enterpriseTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
