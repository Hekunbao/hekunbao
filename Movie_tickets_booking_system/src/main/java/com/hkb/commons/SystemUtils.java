package com.hkb.commons;

public class SystemUtils {
	//�жϸ�target�Ƿ�Ϊ��
	public static String notNullMessage(String target,String message){
		if(target==null||(target.trim()).length()==0){
			throw new myException(message);
		}
		return target;
	}
}
