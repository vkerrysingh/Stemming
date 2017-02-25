package com.stemming;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParserHelper {
	
	private static String mutations = "([l]*[ie]*s)*(lier)*([l]*y)*$";
	public static String endings = "[\\.|\\,]";
	
	//Gets rid of line 'endings'
	public static String stripEndings(String str, String regex){
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		String result = p.split(str)[0];
		return result;
	}
	
	public static int compare2Words(String word1, String word2)
	{
		String shorter = word1, longer = word2;
		if (word1.length() >= word2.length())
		{
			shorter = word2;
			longer = word1;
		}
		
		int subEnd = applyRegex(stripEndings(shorter,mutations),longer);
		if (subEnd > 0)
		{
			//we have found a match i.e shorter is in the longer.
			if (word1.length() != word2.length())
			{
				String subStr = longer.substring(subEnd, longer.length());
				String prefix = stringDiff(mutations,subStr);
				if(prefix.length() == 0)
					return 0;
				else
					return word1.compareToIgnoreCase(word2);
			}
			else return 0;
		}
		else
			return word1.compareToIgnoreCase(word2);
	}
	
	private static String stringDiff(String regexPattern, String strToMatch){
		String diff = "";
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(strToMatch);
		if ( (matcher.find()) && matcher.start() !=0 ){
			diff = strToMatch.substring(0,matcher.start());
		}
		return diff;
	}
	
	private static int applyRegex(String regexPattern, String strToMatch){
		int end = -1;
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(strToMatch);
		while (matcher.find()){
			int start = matcher.start();
			if(start == 0)
				end = matcher.end();
		}
		return end;
	}

}
