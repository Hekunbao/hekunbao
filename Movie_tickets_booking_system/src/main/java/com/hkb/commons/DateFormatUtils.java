package com.hkb.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {
	//�������ڻ�ʱ���ʽ���ַ�������ת��
	public static Date DateFormat(String simpleDateFormat,String dateStr) throws Exception{
		
		SimpleDateFormat sdf =new SimpleDateFormat(simpleDateFormat);
		Date date=null;
		
		date = sdf.parse(dateStr);
		
		if(date==null){
			throw new myException("ʱ���ʽ����......");
		}
		
		return date;
		
	}
	
}
