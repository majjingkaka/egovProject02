package egovframework.com.bible.main.service;

import java.io.Serializable;


@SuppressWarnings("serial")
public class SayRecord implements Serializable{
	
	private int bbSeq;
	
	private String bbSj;
	private String bbCn;
	private String useAt;
	private String ntcrId;
	private String ntcrNm;
	private String church;
	private String churchGp;
	
	private String registDt;
	private String registId;
	private String updtDt;
	private String updtId;
	
	
	public int getBbSeq() {
		return bbSeq;
	}
	public void setBbSeq(int bbSeq) {
		this.bbSeq = bbSeq;
	}
	public String getBbSj() {
		return bbSj;
	}
	public void setBbSj(String bbSj) {
		this.bbSj = bbSj;
	}
	public String getBbCn() {
		return bbCn;
	}
	public void setBbCn(String bbCn) {
		this.bbCn = bbCn;
	}
	public String getUseAt() {
		return useAt;
	}
	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}
	public String getNtcrId() {
		return ntcrId;
	}
	public void setNtcrId(String ntcrId) {
		this.ntcrId = ntcrId;
	}
	public String getNtcrNm() {
		return ntcrNm;
	}
	public void setNtcrNm(String ntcrNm) {
		this.ntcrNm = ntcrNm;
	}
	public String getChurch() {
		return church;
	}
	public void setChurch(String church) {
		this.church = church;
	}
	public String getChurchGp() {
		return churchGp;
	}
	public void setChurchGp(String churchGp) {
		this.churchGp = churchGp;
	}
	public String getRegistDt() {
		return registDt;
	}
	public void setRegistDt(String registDt) {
		this.registDt = registDt;
	}
	public String getRegistId() {
		return registId;
	}
	public void setRegistId(String registId) {
		this.registId = registId;
	}
	public String getUpdtDt() {
		return updtDt;
	}
	public void setUpdtDt(String updtDt) {
		this.updtDt = updtDt;
	}
	public String getUpdtId() {
		return updtId;
	}
	public void setUpdtId(String updtId) {
		this.updtId = updtId;
	}
	
	
}
