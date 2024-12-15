package egovframework.com.bible.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberVO extends UsersVO {

	private static final long serialVersionUID = -8000593049986438363L;


	/**
	 * 사용자타입코드
	 */
	private String userTyCd = "";

	/**
	 * 사용자이메일주소
	 */
	private String userEmad = "";

	/**
	 * 사용자휴대전화번호
	 */
	private String userCpno = "";

	/**
	 * 인증구분코드
	 */
	private String crtfcSeCd = "";

	/**
	 * 미성년자인증여부(14세미만: 'Y')
	 */
	private String chldCrtfcAt = "";

	/**
	 * 생년월일
	 */
	private String brthdy = "";

	/**
	 * 성별코드
	 */
	private String sexCd = "";

	/**
	 * 로그인일시
	 */
	private Date lastLoginDt = null;

	/**
	 * 비밀번호변경일시
	 */
	private Date passwordChangeDt = null;

	/**
	 * 약관동의일시
	 */
	private Date stplatAgreDt = null;

	/**
	 * 부서명
	 */
	private String deptNm = "";
	
	/**
	 * 직책명
	 */
	private String dutyNm = "";
	
	/**
	 * sso 로그인여부
	 */
	private String ssoLoginYn = "";
	
	
	
	
	
	
	
	
	
	
	public String getSsoLoginYn() {
		return ssoLoginYn;
	}

	public void setSsoLoginYn(String ssoLoginYn) {
		this.ssoLoginYn = ssoLoginYn;
	}

	public String getDutyNm() {
		return dutyNm;
	}

	public void setDutyNm(String dutyNm) {
		this.dutyNm = dutyNm;
	}
	
	
	
	/**
	 * 회원가입 인증 타입
	 */
	private String GlobalsSiteSe = "";

	private String mmbrTypCd;	// 회원유형코드(N:도민리포터, R:미승인, Y:지역신문기자, P:대학생정책기자단)
	private String mediaName;	// 언론사명
	private String wrtrNcknm;	// 필명
	
	
	private String simpleLoginYn = "";
	private String simpleLoginNo = "";
	

	public String getSimpleLoginYn() {
		return simpleLoginYn;
	}

	public void setSimpleLoginYn(String simpleLoginYn) {
		this.simpleLoginYn = simpleLoginYn;
	}

	public String getSimpleLoginNo() {
		return simpleLoginNo;
	}

	public void setSimpleLoginNo(String simpleLoginNo) {
		this.simpleLoginNo = simpleLoginNo;
	}

	/** 
	 * 소속 사용자 그룹 리스트  ex) [008, 022] =  도민리포터, 도민평가단
	 * */
	private List<String> userGroupCds = new ArrayList<String>();

	public String getUserTyCd() {
		return userTyCd;
	}

	public void setUserTyCd(String userTyCd) {
		this.userTyCd = userTyCd;
	}

	public String getUserEmad() {
		return userEmad;
	}

	public void setUserEmad(String userEmad) {
		this.userEmad = userEmad;
	}

	public String getUserCpno() {
		return userCpno;
	}

	public void setUserCpno(String userCpno) {
		this.userCpno = userCpno;
	}

	public String getCrtfcSeCd() {
		return crtfcSeCd;
	}

	public void setCrtfcSeCd(String crtfcSeCd) {
		this.crtfcSeCd = crtfcSeCd;
	}

	public String getChldCrtfcAt() {
		return chldCrtfcAt;
	}

	public void setChldCrtfcAt(String chldCrtfcAt) {
		this.chldCrtfcAt = chldCrtfcAt;
	}

	public String getBrthdy() {
		return brthdy;
	}

	public void setBrthdy(String brthdy) {
		this.brthdy = brthdy;
	}

	public String getSexCd() {
		return sexCd;
	}

	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}

	public Date getLastLoginDt() {
		return lastLoginDt;
	}

	public void setLastLoginDt(Date lastLoginDt) {
		this.lastLoginDt = lastLoginDt;
	}

	public Date getPasswordChangeDt() {
		return passwordChangeDt;
	}

	public void setPasswordChangeDt(Date passwordChangeDt) {
		this.passwordChangeDt = passwordChangeDt;
	}

	public Date getStplatAgreDt() {
		return stplatAgreDt;
	}

	public void setStplatAgreDt(Date stplatAgreDt) {
		this.stplatAgreDt = stplatAgreDt;
	}

	public String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

	public String getGlobalsSiteSe() {
		return GlobalsSiteSe;
	}

	public void setGlobalsSiteSe(String globalsSiteSe) {
		GlobalsSiteSe = globalsSiteSe;
	}
	
	public String getMmbrTypCd() {
		return mmbrTypCd;
	}

	public void setMmbrTypCd(String mmbrTypCd) {
		this.mmbrTypCd = mmbrTypCd;
	}

	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public String getWrtrNcknm() {
		return wrtrNcknm;
	}

	public void setWrtrNcknm(String wrtrNcknm) {
		this.wrtrNcknm = wrtrNcknm;
	}

	public List<String> getUserGroupCds() {
		return userGroupCds;
	}

	public void setUserGroupCds(List<String> userGroupCds) {
		this.userGroupCds = userGroupCds;
	}
}
