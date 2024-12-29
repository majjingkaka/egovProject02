package egovframework.com.bible.main.service;

import java.util.List;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.cop.adb.service.AddressBook;
import egovframework.com.cop.adb.service.AddressBookUser;
import egovframework.com.cop.adb.service.AddressBookUserVO;
import egovframework.com.cop.adb.service.AddressBookVO;

import org.springframework.stereotype.Repository;


@Repository("bibleMemberDAO")
public class BibleMemberDAO extends EgovComAbstractDAO{
    
	public String insertBibleMember(BibleMemberVO bibleMemberVO) throws Exception {
        return String.valueOf((int)insert("bibleMember.insertBibleMember", bibleMemberVO));
    }
	
	public String insertBibleMemberAuth(BibleMemberVO bibleMemberVO) throws Exception {
        return String.valueOf((int)insert("bibleMember.insertBibleMemberAuth", bibleMemberVO));
    }
	
	/*
	public List<AddressBookVO> selectAdressBookList(AddressBookVO adbkVO) throws Exception {
        return selectList("AdressBookDAO.selectAdressBookList", adbkVO);
    }
    
    public List<AddressBookUserVO> selectManList(AddressBookUserVO adbkUserVO) throws Exception {
        return selectList("AdressBookDAO.selectManList", adbkUserVO);
    }
    
    public List<AddressBookUserVO> selectCardList(AddressBookUserVO adbkUserVO) throws Exception {
        return selectList("AdressBookDAO.selectCardList", adbkUserVO);
    }
    
    public List<AddressBookUser> selectUserList(AddressBookVO adbkVO) throws Exception {
        return selectList("AdressBookDAO.selectUserList", adbkVO);
    }  

    public AddressBookVO selectAdressBook(AddressBookVO adbkVO) throws Exception {
        return (AddressBookVO)selectOne("AdressBookDAO.selectAdressBook", adbkVO);
    }        
    
    public void insertAdressBook(AddressBook addressBook) throws Exception {
        insert("AdressBookDAO.insertAdressBook", addressBook);
    }
    
    public void insertAdressBookUser(AddressBookUser addressBookUser) throws Exception {
        insert("AdressBookDAO.insertAdressBookUser", addressBookUser);
    }

    public void updateAdressBook(AddressBook addressBook) throws Exception {
        update("AdressBookDAO.updateAdressBook", addressBook);
    }
    
    public void deleteAdressBookUser(AddressBookUser adbkUser) throws Exception {
        delete("AdressBookDAO.deleteAdressBookUser", adbkUser);
    }    
    
    public int selectAdressBookListCnt(AddressBookVO adbkVO) throws Exception {
        return (Integer)selectOne("AdressBookDAO.selectAdressBookListCnt", adbkVO);
    }
    
    public int selectManListCnt(AddressBookUserVO adbkUserVO) throws Exception {
        return (Integer)selectOne("AdressBookDAO.selectManListCnt", adbkUserVO);
    }
    
    public int selectCardListCnt(AddressBookUserVO adbkUserVO) throws Exception {
        return (Integer)selectOne("AdressBookDAO.selectCardListCnt", adbkUserVO);
    }
    
    public AddressBookUser selectManUser(String id) throws Exception {
        return (AddressBookUser)selectOne("AdressBookDAO.selectManUser", id);
    }
    
    public AddressBookUser selectCardUser(String id) throws Exception {
        return (AddressBookUser)selectOne("AdressBookDAO.selectCardUser", id);
    }
	*/
	
	
}

