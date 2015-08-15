package com.objectsrepo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageElements {
	
	@FindBy(how=How.ID,id="Email")
	@CacheLookup
	private WebElement login_emailEditBox;
	@FindBy(how=How.ID,id="Passwd")
	@CacheLookup
	private WebElement login_passwEditBox;
	@FindBy(how=How.ID,id="next")
	@CacheLookup
	private WebElement login_nextBtn;
	@FindBy(how=How.ID,id="signIn")
	@CacheLookup
	private WebElement login_signInBtn;
	@FindBy(how=How.ID,id="errormsg_0_Passwd")
	@CacheLookup
	private WebElement login_errorTest;
	

}
