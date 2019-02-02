package com.zdy.school.vo;

/**
 * @author Psyduck
 * EnterpriseInfo 企业表
 * 用于存放企业的相关信息
 */
public class EnterpriseInfo {
	private int enterpriseId;
	private String enterpriseName;
	private String enterprisePassword;
	private String enterpriseIntroduce;
	private String enterpriseAddress;
	private String enterpriseTel;
	private String email;
	private String enterpriseManager;
	private int pageNo;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getEnterprisePassword() {
		return enterprisePassword;
	}

	public void setEnterprisePassword(String enterprisePassword) {
		this.enterprisePassword = enterprisePassword;
	}

	public String getEnterpriseIntroduce() {
		return enterpriseIntroduce;
	}

	public void setEnterpriseIntroduce(String enterpriseIntroduce) {
		this.enterpriseIntroduce = enterpriseIntroduce;
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

	public String getEnterpriseManager() {
		return enterpriseManager;
	}

	public void setEnterpriseManager(String enterpriseManager) {
		this.enterpriseManager = enterpriseManager;
	}
}
