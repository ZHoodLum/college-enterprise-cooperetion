package com.zdy.school.vo;

/**
 * @author Psyduck
 * EnterpriseInfo 企业表
 * 用于存放企业的相关信息
 */
public class EnterpriseInfo {
	private int EnterpriseId;
	private String EnterpriseName;
	private String EnterprisePassword;
	private String EnterpriseIntroduce;
	private String EnterpriseAddress;
	private String EnterpriseTel;
	private String Email;
	private String EnterpriseManager;
	
	public int getEnterpriseId() {
		return EnterpriseId;
	}
	public void setEnterpriseId(int enterpriseId) {
		EnterpriseId = enterpriseId;
	}
	public String getEnterpriseName() {
		return EnterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		EnterpriseName = enterpriseName;
	}
	public String getEnterprisePassword() {
		return EnterprisePassword;
	}
	public void setEnterprisePassword(String enterprisePassword) {
		EnterprisePassword = enterprisePassword;
	}
	public String getEnterpriseIntroduce() {
		return EnterpriseIntroduce;
	}
	public void setEnterpriseIntroduce(String enterpriseIntroduce) {
		EnterpriseIntroduce = enterpriseIntroduce;
	}

	public String getEnterpriseAddress() {
		return EnterpriseAddress;
	}

	public void setEnterpriseAddress(String enterpriseAddress) {
		EnterpriseAddress = enterpriseAddress;
	}

	public String getEnterpriseTel() {
		return EnterpriseTel;
	}

	public void setEnterpriseTel(String enterpriseTel) {
		EnterpriseTel = enterpriseTel;
	}

	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getEnterpriseManager() {
		return EnterpriseManager;
	}
	public void setEnterpriseManager(String enterpriseManager) {
		EnterpriseManager = enterpriseManager;
	}

}
