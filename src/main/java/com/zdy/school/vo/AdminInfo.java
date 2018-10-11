package com.zdy.school.vo;

/**
 * @author Psyduck
 * AdminInfo 管理员表
 * 用于存放管理员的相关信息
 */
public class AdminInfo {
	private int AdminId;
	private String AdminName;
	private String AdminPassword;
	
	public int getAdminId() {
		return AdminId;
	}
	public void setAdminId(int adminId) {
		AdminId = adminId;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public String getAdminPassword() {
		return AdminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}
	
	
}
