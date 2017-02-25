package com.stemming;

import java.util.HashMap;
import java.util.Map;

public class WordOccurrence {
	
	Map<String, Integer> dictionary = new HashMap<String, Integer>();
	
	public void addEntry(String word){
		int val = compareToEntries(word);
		dictionary.put(word, val);
	}
	
	private int compareToEntries(String word){
		int val = 1;
		for (String key : dictionary.keySet()){
			if (ParserHelper.compare2Words(key,word) == 0){
				dictionary.put(key, dictionary.get(key) + 1);
				++val;
			}
		}
		return val;
	}
	
	public Map<String, Integer> getDictionary(){
		return dictionary;
	}
	
	public void printEntries(){
		System.out.format("20%s%20s","Search Term", "Occurrence");
		System.out.println();
		for(String key: dictionary.keySet()){
			System.out.format("%20s%10d", key, dictionary.get(key));
			System.out.println();
		}
		
	}
}
