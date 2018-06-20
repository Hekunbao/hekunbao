package com.hkb.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {
	//传入日期或时间格式和字符，类型转换
	public static Date DateFormat(String simpleDateFormat,String dateStr) throws Exception{
		
		SimpleDateFormat sdf =new SimpleDateFormat(simpleDateFormat);
		Date date=null;
		
		date = sdf.parse(dateStr);
		
		if(date==null){
			throw new myException("时间格式错误......");
		}
		
		return date;
		
	}
	
}
