package com.commonutility.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class BasePage extends WebPage {
	
	
	
	public void scrollPageBy(int x, int y)
	{
		this.executeJavascript("window.scrollBy(" + x + "," + y + ")");
		new Actions(webDriver).pause(2000).perform();
		waitForProgressBar(10);
	}
	
	public void waitForProgressBar(int timeoutInSeconds)
	{
		new FluentWait<String>(".progress-bar")
		.withTimeout(timeoutInSeconds, TimeUnit.SECONDS)
		.pollingEvery(500, TimeUnit.MILLISECONDS)
		.withMessage("Throbber taking too long to vanish!")
		.until(new Function<String, Boolean>()
				{
			public Boolean apply(String css)
			{
				boolean isPresentOrVisible = true;
				System.out
				.println("Checking if throbber has vanished - "
						+ css);
				try
				{
					isPresentOrVisible = webDriver.findElement(
							By.cssSelector(css)).isDisplayed();
				} catch (WebDriverException e)
				{
					isPresentOrVisible = false;
				}
				return !isPresentOrVisible;
			}
				});
	}
	
	
	public void hoverOverElemets(WebElement hoverElelemtLocator)
	{
		try
		{
			new Actions(getDriver()).moveToElement(hoverElelemtLocator).pause(500).perform();
		} catch (TimeoutException e)
		{

		}
	}
	
}
