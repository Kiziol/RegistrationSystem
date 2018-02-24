package cn.utils;

public class StringUtils {
	
	public static boolean isEmpty(String str) {	
		if(str == null || str.trim().equals("") ) {
			return true;
		} else {
			return false;
		}	
	}
}
