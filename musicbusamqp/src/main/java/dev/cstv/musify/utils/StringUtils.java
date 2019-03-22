package dev.cstv.musify.utils;

public class StringUtils {

	/**
	 * 
	 * @param str
	 * @return true if str is a number
	 */
	public static boolean isNumeric(String str) {
		if (str == null) {
			return false;
		}
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
