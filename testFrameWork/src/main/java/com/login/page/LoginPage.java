package com.login.page;

import org.openqa.selenium.support.PageFactory;

import com.commonutility.page.BasePage;
import com.commonutility.page.WebPage;
import com.objectsrepo.page.LoginPageElements;

public class LoginPage extends BasePage {
	
	LoginPageElements loginPageElements =new LoginPageElements();
	
	
	public String getLoginToApp(String userName,String passw){
		String textMsg = "";
		loginPageElements = PageFactory.initElements(WebPage.getDriver(), LoginPageElements.class);
		loginPageElements.enterEmailId(userName);
		waitForSometime(50);
		loginPageElements.clickOnNextBtn();
		waitForSometime(50);
		loginPageElements.enterPassword(passw);
		waitForSometime(50);
		loginPageElements.clickOnSignBtn();
		waitForSometime(50);
		textMsg = loginPageElements.getLoginErrorMsg();
		return textMsg;
	}

}
