package com.dataprovider.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

import com.commonutility.page.BasePage;
import com.commonutility.page.WebPage;

public class DataProviderPage {
	
	BasePage basePage = new BasePage();
	@DataProvider
	public Object[][] getGSingleLanguageUrls()
	{
		basePage.openBrowser();
		List<WebElement>links = WebPage.getDriver().findElements(By.cssSelector("#_eEe>a"));
		System.out.println("+++++++++"+links.get(0).getAttribute("href"));
		String[] todaysOfferLink = {links.get(0).getAttribute("href") };
		Object [][] dataSet = new Object [][] {todaysOfferLink};		
		return dataSet;
	}
	
	
	@DataProvider
	public Object[][] getGLanguageUrls()
	{
		basePage.openBrowser();
		List<String> SocialLinks = getSocialLinks();
		System.out.println("SocialLinks----------"+SocialLinks);
		String[] strarray = new String[SocialLinks.size()];
		SocialLinks.toArray(strarray);
		Object[][] dataSet = new Object[SocialLinks.size()][0];
		int i = 0;
		for (String item : strarray)
		{
			dataSet[i] = new Object[] { item };
			i++;
		}
		return dataSet;
	}
	
	//Not supposeed to here this method .This method belog to Specific page
	public List<String> getSocialLinks()
	{
		List<String> Urls = new ArrayList<String>();
		String Url;
		List<WebElement>SocialLinks = WebPage.getDriver().findElements(By.cssSelector("#_eEe>a"));
		for (WebElement singleSocialLink : SocialLinks)
		{
			Url = singleSocialLink.getAttribute("href");
			if (null != Url)
			{
				System.out.println("Url = " + Url);
				Urls.add(Url);
			} else
			{
				System.out.println(("Element with Classname :"+ singleSocialLink.getAttribute("class") + "does not have a link in social link!!"));
			}
		}
		return Urls;
	}

}
