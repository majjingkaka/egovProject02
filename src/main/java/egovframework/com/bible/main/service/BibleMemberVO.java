package egovframework.com.bible.main.service;

import java.io.Serializable;

import egovframework.com.cmm.LoginVO;

public class BibleMemberVO extends LoginVO implements Serializable{
	
	private String userId;
	private String password;
	private String nickName;
	private String churchName;
	private String zipCode;
	private String addr1;
	private String addr2;
	private String phone;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getChurchName() {
		return churchName;
	}
	public void setChurchName(String churchName) {
		this.churchName = churchName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
