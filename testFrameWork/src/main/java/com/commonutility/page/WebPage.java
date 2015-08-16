package com.commonutility.page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WebPage {

	protected static WebDriver webDriver;


	public void openBrowser(){
		webDriver=new FirefoxDriver();
		webDriver.navigate().to("https://accounts.google.com");
	}

	public static WebDriver getDriver(){
		return webDriver;
	}

	public void waitForSometime(int waitingTimer){
		getDriver().manage().timeouts().implicitlyWait(waitingTimer, TimeUnit.SECONDS);
	}

	public void waitForSpecificElementByCssLocator(String cssLocator){
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(cssLocator)));
	}


	public void waitForSpecificElementByCssXpath(String xpath){
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(xpath)));
	}

	public Object executeJavascript(String ScripttoExecute)
	{
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		return js.executeScript(ScripttoExecute);
	}

	public void pauseForSomeTime()
	{
		new Actions(webDriver).pause(3000).perform();
	}

	public void webPageRefresh()
	{
		webDriver.navigate().refresh();
	}

	public void alertAccept()
	{
		Alert alert = webDriver.switchTo().alert();
		alert.accept();
	}

	public static String getCurrentUrl()
	{
		return webDriver.getCurrentUrl();
	}

	public void switchToPopUp()
	{
		String mainWindowHandle = webDriver.getWindowHandle();
		Set<String> allWindowHandles = webDriver.getWindowHandles();
		Iterator<String> ite = allWindowHandles.iterator();
		String singleHandle;
		while (ite.hasNext())
		{
			singleHandle = ite.next().toString();
			if (!singleHandle.equals(mainWindowHandle))
			{
				webDriver.switchTo().window(singleHandle);
			}
		}
	}


	public void waitForThrobber(String css)
	{
		new FluentWait<String>(css).withTimeout(30, TimeUnit.SECONDS)
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
					System.out.println(e.getMessage());
				}
				return !isPresentOrVisible;
			}
				});
	}

	public void waitForThrobberForXpath(String xpath)
	{
		new FluentWait<String>(xpath).withTimeout(30, TimeUnit.SECONDS)
		.pollingEvery(500, TimeUnit.MILLISECONDS)
		.withMessage("Throbber taking too long to vanish!")
		.until(new Function<String, Boolean>()
				{
			public Boolean apply(String xpath)
			{
				boolean isPresentOrVisible = true;
				System.out
				.println("Checking if throbber has vanished - "
						+ xpath);
				try
				{
					isPresentOrVisible = webDriver.findElement(
							By.xpath(xpath)).isDisplayed();
				} catch (WebDriverException e)
				{
					isPresentOrVisible = false;
					System.out.println(e.getMessage());
				}
				return !isPresentOrVisible;
			}
				});
	}

	public void waitForThrobberOnMobile(String css)
	{
		new FluentWait<String>(css).withTimeout(30, TimeUnit.SECONDS)
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
					System.out.println(e.getMessage());
				}
				return !isPresentOrVisible;
			}
				});
	}

	public void switchToOldTabAndDeleteNewTab()
	{
		String newTab = getDriver().getWindowHandle();
		ArrayList<String> oldTab = new ArrayList<String>(
				getDriver().getWindowHandles());
		oldTab.remove(newTab);
		getDriver().switchTo().window(oldTab.get(0));
		getDriver().switchTo().window(newTab);
		getDriver().close();
		getDriver().switchTo().window(oldTab.get(0));

	}

	public void swithToNewTab()
	{
		String oldTab = getDriver().getWindowHandle();

		ArrayList<String> newTab = new ArrayList<String>(
				getDriver().getWindowHandles());
		newTab.remove(oldTab);
		// change focus to new tab
		webDriver.switchTo().window(newTab.get(0));
		// Do what you want here, you are in the new tab
	}
	
	
	public static void endTest()
	{		
		if (null != webDriver)
		{
			webDriver.close();
			webDriver = null;
		}
	}


}
