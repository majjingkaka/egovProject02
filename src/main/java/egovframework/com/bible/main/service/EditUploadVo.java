package egovframework.com.bible.main.service;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class EditUploadVo implements Serializable{

	
	private MultipartFile mutipartFile;
	private String callback;
	private String callback_func;
	
	
	
	
	
	
}
