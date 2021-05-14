package com.launch;



import org.testng.annotations.Test;

import com.KeywordEngine.keywordEngine;

public class LoginTest {
	
	
	public keywordEngine keyword;
	
	@Test
	
	public void loginTest() {
		
		keywordEngine keyword = new keywordEngine();
		keyword.StartExecution("login");
	
	}
	
	
	

}
