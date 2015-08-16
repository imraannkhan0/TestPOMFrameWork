package com.commonutility.page;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ToolBox {

	public int getHTTPResponseCode(String url)
	{
		String USER_AGENT = "Mozilla/5.0";
		String requestSendMethod = "GET";
		return getHTTPResponseCode(url, USER_AGENT, requestSendMethod);
	}
	
	
	public int getHTTPResponseCode(String url, String useragent,
			String requestSendMethod)
	{
		int returnvalue = 0;
		try
		{

			String USER_AGENT = useragent;
			Thread.sleep(500);
			// System.out.println(url);
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod(requestSendMethod);
			con.setRequestProperty("User-Agent", USER_AGENT);
			// con.setRequestProperty("Accept","application/json");
			// for
			returnvalue = con.getResponseCode();

		} catch (InterruptedException | IOException e)
		{
			e.printStackTrace();
			// return false;
		}
		return returnvalue;
	}
}
