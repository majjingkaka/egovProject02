package egovframework.com.bible.domain;

import java.util.Arrays;

public enum KORJONG {
	
	//{"","ㄱ","ㄲ","ㄳ","ㄴ","ㄵ","ㄶ","ㄷ","ㄹ","ㄺ"
	//,"ㄻ","ㄼ","ㄽ","ㄾ","ㄿ","ㅀ","ㅁ","ㅂ","ㅄ","ㅅ"
	//,"ㅆ","ㅇ","ㅈ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"};
	
	KORJONG_0000("",0),
	KORJONG_0001("ㄱ",2),
	KORJONG_0002("ㄲ",4),
	KORJONG_0003("ㄴ",2),
	KORJONG_0004("ㄷ",3),
	KORJONG_0005("ㄸ",6),
	KORJONG_0006("ㄹ",5),
	KORJONG_0007("ㅁ",4),
	KORJONG_0008("ㅂ",4),
	KORJONG_0009("ㅃ",8),
	KORJONG_0010("ㅅ",2),
	KORJONG_0011("ㅆ",4),
	KORJONG_0012("ㅇ",1),
	KORJONG_0013("ㅈ",3),
	KORJONG_0014("ㅉ",6),
	KORJONG_0015("ㅊ",4),
	KORJONG_0016("ㅋ",3),
	KORJONG_0017("ㅌ",4),
	KORJONG_0018("ㅍ",4),
	KORJONG_0019("ㅎ",3);
	
	//private final String code;
	private final String codeNm;
	private final int codeCt;
	
	private KORJONG(String codeNm, int codeCt) {
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
		for(KORJONG v : KORJONG.values()) {
			if(v.getCodeNm().equals(codeNm)) {
				r = v.getCodeCt();
			}
		}
		return r;
	}
	
	
	public static KORJONG getCt(String codeNm) {
        return Arrays.stream(values())
                    .filter(KORJONG -> KORJONG.codeNm.equals(codeNm))
                    .findFirst()
                    .orElse(KORJONG_0000);
    }
	
	
	
	//private static final Map<String, String> CODE_MAP =
    //        Stream.of(values()).collect(Collectors.toMap(KORJONG::codeNm, KORJONG::codeCt)));
	
	//public static KORJONG valueOfLabel1(String codeNm) {
    //    return KORJONG.valueOf(CODE_MAP.get(codeNm));
    //}
	
}
