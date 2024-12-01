package egovframework.com.bible.main.service;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BibleVo implements Serializable{

	
	private String bookAf;     //구약, 신약
	private String bookSeq;    //시퀀스넘버
	private String btweenYn;   //단건, 다건 조회
	private String chapter;    //장
	private String verse;      //절
	private String chapter2;   //장
	private String verse2;     //절
	private String searchKeyword; //키워드
	
	
	
	
	
	
	
	
	
	
	
	public String getBookAf() {
		return bookAf;
	}
	public void setBookAf(String bookAf) {
		this.bookAf = bookAf;
	}
	public String getBookSeq() {
		return bookSeq;
	}
	public void setBookSeq(String bookSeq) {
		this.bookSeq = bookSeq;
	}
	public String getBtweenYn() {
		return btweenYn;
	}
	public void setBtweenYn(String btweenYn) {
		this.btweenYn = btweenYn;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public String getVerse() {
		return verse;
	}
	public void setVerse(String verse) {
		this.verse = verse;
	}
	public String getChapter2() {
		return chapter2;
	}
	public void setChapter2(String chapter2) {
		this.chapter2 = chapter2;
	}
	public String getVerse2() {
		return verse2;
	}
	public void setVerse2(String verse2) {
		this.verse2 = verse2;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	
	@Override
	public String toString() {
		return "BibleVo [bookAf=" + bookAf + ", bookSeq=" + bookSeq + ", btweenYn=" + btweenYn + ", chapter=" + chapter
				+ ", verse=" + verse + ", chapter2=" + chapter2 + ", verse2=" + verse2 + ", searchKeyword="
				+ searchKeyword + "]";
	}
	
	
}
