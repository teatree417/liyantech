/**
 * 
 */
package liyan.dangjian.dataprovider;

import liyan.dangjian.util.GetUserInfo;

import org.testng.annotations.DataProvider;

import com.google.gson.JsonObject;

/**
 * @author zz
 *
 */
public class SelectDetailByUserIdDataProvider {
	private static String url = "http://192.168.30.141:8766//collectRank/selectDetailByOrgId";		
	private static String successCode = "\"rest.success\"";
	private static String failCode = "401";
	private String token = "";	
	private String year = "";
	private String userId = "";
	
	JsonObject params = new JsonObject();
	GetUserInfo gt = new GetUserInfo();
			
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String orgId) {
		this.userId = orgId;
	}

	@DataProvider(name = "normal")  
	public Object[][] normal()
	{
		try {
			setYear("2018");
			setUserId(gt.getUserId());			
			token = gt.getToken(); 
			params.addProperty("year", year);
			params.addProperty("userId", userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object[][]{
			{url,token,params,successCode}	
		};
	}
	
	@DataProvider(name = "nullYear")  
	public Object[][] nullYear()
	{		
		try {			
			setUserId(gt.getUserId());			
			token = gt.getToken(); 
			params.addProperty("year", year);
			params.addProperty("userId", userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object[][]{
			{url,token,params,failCode}	
		};
	}
	
	@DataProvider(name = "nullOrgId")  
	public Object[][] nullOrgId()
	{		
		try {
			setYear("2018");			
			token = gt.getToken(); 
			params.addProperty("year", year);
			params.addProperty("userId", userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object[][]{
			{url,token,params,failCode}	
		};
	}
	
	@DataProvider(name = "nullToken")  
	public Object[][] nullToken()
	{		
		try {
			setYear("2018");
			setUserId(gt.getUserId());
			params.addProperty("year", year);
			params.addProperty("userId", userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object[][]{
			{url,token,params,failCode}	
		};
	}

}
