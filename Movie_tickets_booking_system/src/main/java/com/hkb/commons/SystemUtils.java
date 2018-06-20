package com.hkb.commons;

public class SystemUtils {
	//ÅÐ¶Ï¸ÃtargetÊÇ·ñÎª¿Õ
	public static String notNullMessage(String target,String message){
		if(target==null||(target.trim()).length()==0){
			throw new myException(message);
		}
		return target;
	}
}
