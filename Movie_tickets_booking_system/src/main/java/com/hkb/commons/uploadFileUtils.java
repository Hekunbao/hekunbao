package com.hkb.commons;

import java.io.File;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class uploadFileUtils {
	//�����ļ���Ϊ��ӳʱ����ļ��У����ϴ����ļ�д��
	public static String uploadFile(CommonsMultipartFile file,String startToShow) throws Exception{
		
			 String dir="D:\\hkbmovie\\"+startToShow+"\\";
//			 String dir="D:\\hkbmovie\\"+startToShow+"\\";
	         String fileName = file.getOriginalFilename();
		        File newFiledir=new File(dir);
		        File newFile=new File(dir,fileName);
		        System.out.println(newFiledir.getAbsolutePath());
//		        System.out.println(newFile.getAbsolutePath());
		        
		        
		        if(!newFiledir.exists()){
		        	newFiledir.mkdir();
		        }
		        if(!newFile.exists()){ 
		        	newFile.createNewFile();
		        }
		        file.transferTo(newFile);
		        return dir+fileName;
	}
}
