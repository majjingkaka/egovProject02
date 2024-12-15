package egovframework.com.bible.service.member.sec;

public class BibleBizException extends Exception {
  private static final long serialVersionUID = 4707656874967116858L;
  
  private String returnUrl = "javascript:history.back();";
  
  public BibleBizException(String msg) {
    super(msg);
  }
  
  public BibleBizException(String msg, String returnUrl) {
    super(msg);
    this.returnUrl = returnUrl;
  }
  
  public String getReturnUrl() {
    return this.returnUrl;
  }
}
