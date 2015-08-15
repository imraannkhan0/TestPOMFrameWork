package com.login.test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.login.page.LoginPage;

public class LoginPageTest {
	
	LoginPage loginPage ;
	
	@BeforeClass
	public void configuartion(){
		loginPage = new LoginPage();
		loginPage.openBrowser();
	}
	
	@Test
	public void verifyLoginErrorMessage(){
	String errorTest =	loginPage.getLoginToApp("Tester@gmail.com", "123456");
	Assert.assertEquals(errorTest,"The email and password you entered don't match.","Login Error Message is not Math");
	}

}
