package egovframework.com.bible.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum KORCHO {
	
	//{"ㄱ","ㄲ","ㄴ","ㄷ","ㄸ","ㄹ","ㅁ","ㅂ","ㅃ","ㅅ"
	//,"ㅆ","ㅇ","ㅈ","ㅉ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"};
	
	KORCHO_0000("",0),
	KORCHO_0001("ㄱ",2),
	KORCHO_0002("ㄲ",4),
	KORCHO_0003("ㄴ",2),
	KORCHO_0004("ㄷ",3),
	KORCHO_0005("ㄸ",6),
	KORCHO_0006("ㄹ",5),
	KORCHO_0007("ㅁ",4),
	KORCHO_0008("ㅂ",4),
	KORCHO_0009("ㅃ",8),
	KORCHO_0010("ㅅ",2),
	KORCHO_0011("ㅆ",4),
	KORCHO_0012("ㅇ",1),
	KORCHO_0013("ㅈ",3),
	KORCHO_0014("ㅉ",6),
	KORCHO_0015("ㅊ",4),
	KORCHO_0016("ㅋ",3),
	KORCHO_0017("ㅌ",4),
	KORCHO_0018("ㅍ",4),
	KORCHO_0019("ㅎ",3);
	
	//private final String code;
	private final String codeNm;
	private final int codeCt;
	
	private KORCHO(String codeNm, int codeCt) {
		//this.code = code;
		this.codeNm = codeNm;
		this.codeCt = codeCt;
	}
	
	/*public String getCode() {
		return code;
	}*/
	
	public String getCodeNm() {
		return codeNm;
	}
	public int getCodeCt() {
		return codeCt;
	}
	
	
	public static int getCodeCt(String codeNm) {
		int r = 0;
		for(KORCHO v : KORCHO.values()) {
			if(v.getCodeNm().equals(codeNm)) {
				r = v.getCodeCt();
			}
		}
		return r;
	}
	
	
	public static KORCHO getCt(String codeNm) {
        return Arrays.stream(values())
                    .filter(KORCHO -> KORCHO.codeNm.equals(codeNm))
                    .findFirst()
                    .orElse(KORCHO_0000);
    }
	
	
	
	//private static final Map<String, String> CODE_MAP =
    //        Stream.of(values()).collect(Collectors.toMap(KORCHO::codeNm, KORCHO::codeCt)));
	
	//public static KORCHO valueOfLabel1(String codeNm) {
    //    return KORCHO.valueOf(CODE_MAP.get(codeNm));
    //}
	
	
}
