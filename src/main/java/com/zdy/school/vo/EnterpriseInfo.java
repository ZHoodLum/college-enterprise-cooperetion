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
	private String EnterpeiseAddress;
	private String EnterpeiseTel;
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
	public String getEnterpeiseAddress() {
		return EnterpeiseAddress;
	}
	public void setEnterpeiseAddress(String enterpeiseAddress) {
		EnterpeiseAddress = enterpeiseAddress;
	}
	public String getEnterpeiseTel() {
		return EnterpeiseTel;
	}
	public void setEnterpeiseTel(String enterpeiseTel) {
		EnterpeiseTel = enterpeiseTel;
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
