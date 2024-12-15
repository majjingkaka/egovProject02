package egovframework.com.bible.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.bible.domain.KORCHO;

public class NameGameController {

	
	public static void main(String[] args) {
		
		System.out.println("11");
		
		String[] CHO = {"ㄱ","ㄲ","ㄴ","ㄷ","ㄸ","ㄹ","ㅁ","ㅂ","ㅃ","ㅅ","ㅆ","ㅇ","ㅈ","ㅉ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"};
		String[] JOONG = {"ㅏ","ㅐ","ㅑ","ㅒ","ㅓ","ㅔ","ㅕ","ㅖ","ㅗ","ㅘ","ㅙ","ㅚ","ㅛ","ㅜ","ㅝ","ㅞ","ㅟ","ㅠ","ㅡ","ㅢ","ㅣ"};
		String[] JONG = {"","ㄱ","ㄲ","ㄳ","ㄴ","ㄵ","ㄶ","ㄷ","ㄹ","ㄺ","ㄻ","ㄼ","ㄽ","ㄾ","ㄿ","ㅀ","ㅁ","ㅂ","ㅄ","ㅅ","ㅆ","ㅇ","ㅈ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"};
		
		
		String text = "홍길동";
		
		for(int i = 0; i < text.length(); i++) {
			char uniVal = text.charAt(i);
			
			// 한글일 경우만 시작해야 하기 때문에 0xAC00부터 아래의 로직을 실행한다
			if(uniVal >= 0xAC00) {
				System.out.print(uniVal + "=>");
				uniVal = (char)(uniVal - 0xAC00);
				
				char cho = (char)(uniVal/28/21);
				char joong = (char) ((uniVal)/28%21);
				char jong = (char) (uniVal % 28);	// 종성의 첫번째는 채움이기 때문에
						
				System.out.println(CHO[cho] + JOONG[joong] + JONG[jong]);
			} else {
				System.out.println(uniVal + "=>" + uniVal);
			}
		}
		
		
		KORCHO v = KORCHO.getCt("ㄱ");
		
		System.out.println(v.getCodeCt());
		System.out.println(KORCHO.getCodeCt("ㄱ"));
		
		
	}
	
}
