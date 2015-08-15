package com.objectsrepo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageElements {
	private  WebDriver driver;
	public void LoginPage(WebDriver driver)
	{
		this.driver = driver;
	} 

	@FindBy(how=How.ID,using="Email")
	@CacheLookup
	private WebElement login_emailEditBox;

	@FindBy(how=How.ID,using="Passwd")
	@CacheLookup
	private WebElement login_passwEditBox;

	@FindBy(how=How.ID,using="next")
	@CacheLookup
	private WebElement login_nextBtn;

	@FindBy(how=How.ID,using="signIn")
	@CacheLookup
	private WebElement login_signInBtn;

	@FindBy(how=How.ID,using="errormsg_0_Passwd")
	@CacheLookup
	private WebElement login_errorTest;


	public WebElement getLoginEmailEBox(){
		return login_emailEditBox;
	}

	public WebElement getLoginPasswEBox(){
		return login_passwEditBox;
	}
	public WebElement getkNextBtn(){
		return  login_nextBtn;
	}
	public WebElement getSignInBtn(){
		return login_signInBtn;
	}
	public WebElement getLoginErrorText(){
		return login_errorTest;
	}

	public void enterEmailId(String emailId){
		getLoginEmailEBox().clear();
		getLoginEmailEBox().sendKeys(emailId);
	}
	public void enterPassword(String passowrd){
		getLoginPasswEBox().clear();
		getLoginPasswEBox().sendKeys(passowrd);
	}

	public void clickOnNextBtn(){
		getkNextBtn().click();
	}

	public void clickOnSignBtn(){
		getSignInBtn().click();
	}
	
	public String getLoginErrorMsg(){
		return getLoginErrorText().getText().trim();
	}
}
