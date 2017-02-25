package com.stemming;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class WordOccurrenceTest {
	
	String[] words = {"Friends", "are", "friendlier", "friendlies", "that", "are", "friendly", 
			"and", "classify", "the", "friendly", "classification", "class.", "Flowery", 
			"flowers", "flow", "through", "following", "the", "flower", "flows", "classes","hero","heroes"};
	
	Map<String, Integer> expectedMap = new HashMap<String, Integer>();
	{
		expectedMap.put("friends",	5); 
		expectedMap.put("are",		2); 
		expectedMap.put("that",		1); 
		expectedMap.put("and",		1); 
		expectedMap.put("classify",	1); 
		expectedMap.put("the",		2); 
		expectedMap.put("flowery",	3); 
		expectedMap.put("flowers",	3); 
		expectedMap.put("flow",		2);
		expectedMap.put("through",	1); 
		expectedMap.put("following",1); 
		expectedMap.put("flows",	2); 
		expectedMap.put("classification",1);  
		expectedMap.put("class",	2); 
		expectedMap.put("flower",	3);  
		expectedMap.put("friendlier",5); 
		expectedMap.put("friendlies",5);
		expectedMap.put("friendly",	 5);  
		expectedMap.put("classes",	 2);
		expectedMap.put("hero",	 	 2);
		expectedMap.put("heroes",	 2);
		
	};

	@Test
	public void test() {
		WordOccurrence wo = new WordOccurrence();
		Map<String, Integer> actualMap = wo.processList(words);
		assertEquals(expectedMap, actualMap);
	}

}
