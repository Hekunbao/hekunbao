package com.hkb.commons;

import java.io.File;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class uploadFileUtils {
	//创建文件名为上映时间的文件夹，将上传的文件写入
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
