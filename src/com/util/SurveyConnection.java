package com.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.json.JSONArray;
import org.json.JSONObject;

public class SurveyConnection {
	
	public static void main(String[] args) throws HttpException, IOException 
	{
			String finSurObj = "";
			String surveyObj = "";
			String api_token = "58bfc7394e02d3c46f53ee43e2694a70ea2ed4273c3ca9e8f8";
			String maxRec = "120";
			String maxRec1 = null;
			
			try {
				finSurObj = getConnection(api_token, maxRec1,"1");
				System.out.println("+++++++++++++++++++++===================================finalObject=="+finSurObj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONObject finalObj = new JSONObject(finSurObj);
			JSONObject finalArr = finalObj.getJSONObject("data");
			System.out.println("+++++++++++++++++++++===================================finalObject=="+finalObj.length());
			System.out.println("+++++++++++++++++++++===================================finalObject=="+finalArr.keySet());
			
			/*int page =0;
			//page =  Integer.parseInt(maxRec)/50;
			page = 3;
			maxRec1 = "10";
			try {
				finSurObj = getConnection(api_token, maxRec1,"1");
				//System.out.println("+++++++++++++++++++++===================================finalObject=="+finSurObj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONObject finalObj = new JSONObject(finSurObj);
			JSONArray finalArr = finalObj.getJSONArray("data");
			
			for(int j=0;j<page;j++)
			{
				try {
						String paging = ""+(j+2);
						surveyObj = getConnection(api_token, maxRec1,paging);
						//System.out.println("================================surveyObjcet=="+"page number===="+paging+"=========="+surveyObj);
						JSONObject appendObj = new JSONObject(surveyObj);
						JSONArray appendArr = appendObj.getJSONArray("data");
						//System.out.println(appendArr.length());
						for(int k=0;k<appendArr.length();k++)
						{
							//System.out.println("k=="+k+"--->"+appendArr.get(k));
							finalArr.put(k);
							finalArr.put(appendArr.get(k));
						}
					
					} catch (Exception e) {
						e.printStackTrace();
					}
			}		
		JSONObject obj = new JSONObject(response);		
		JSONArray arr = obj.getJSONArray("data");
			System.out.println(finalObj);*/
	}
	private static String getConnection(String api_token, String maxRec, String string) throws HttpException, IOException 
	{
		String targetURL = "https://restapi.surveygizmo.com/v5/account?api_token="+api_token+"&page="+string+"&resultsperpage="+maxRec;
		GetMethod get = new GetMethod(targetURL);
		HttpClient httpclient = new HttpClient();
		httpclient.executeMethod(get);
		String response = get.getResponseBodyAsString();
		
		//System.out.println(response);
		return response;
	}
}
