package io.github.oaschi.paperwarp;

public class PWUtils {
	
	public static String stripLeadingHyphens(String str){
		if(str == null) return null;
		if(str.startsWith("-")){
			return str.substring(1);
		}
		if(str.startsWith("--")){
			return str.substring(2);
		}
		return str;
	}
	
	public static String combineStringArray(String[] args, char seperator){
		if(args.length == 0) return null;
		String combinedString = "";
		for(String str : args){
			combinedString += str + seperator;
		}
		return combinedString.substring(0, combinedString.length() - 1);
	}

}
