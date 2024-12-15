package egovframework.com.bible.domain;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class UsersVO implements Serializable {
  private static final long serialVersionUID = 2876900063125999565L;
  
  private long userSn = 0L;
  
  private String userPin = "";
  
  private String userNm = "";
  
  private String userId = "";
  
  private String password = "";
  
  private String password2 = "";
  
  private String authorCd = "";
  
  private String mngrAt = "";
  
  private String deptId = "";
  
  public String getMngrAt() {
    return this.mngrAt;
  }
  
  public void setMngrAt(String mngrAt) {
    this.mngrAt = mngrAt;
  }
  
  public long getUserSn() {
    return this.userSn;
  }
  
  public void setUserSn(long userSn) {
    this.userSn = userSn;
  }
  
  public String getUserPin() {
    return this.userPin;
  }
  
  public void setUserPin(String userPin) {
    this.userPin = userPin;
  }
  
  public String getUserNm() {
    return this.userNm;
  }
  
  public void setUserNm(String userNm) {
    this.userNm = userNm;
  }
  
  public String getUserId() {
    return this.userId;
  }
  
  public void setUserId(String userId) {
    this.userId = userId;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getPassword2() {
    return this.password2;
  }
  
  public void setPassword2(String password2) {
    this.password2 = password2;
  }
  
  public String getAuthorCd() {
    return this.authorCd;
  }
  
  public void setAuthorCd(String authorCd) {
    this.authorCd = authorCd;
  }
  
  public String getDeptId() {
    return this.deptId;
  }
  
  public void setDeptId(String deptId) {
    this.deptId = deptId;
  }
  
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
