package liyan.dangjian.dataprovider;

import java.util.ArrayList;
import java.util.List;
import liyan.dangjian.util.GetUserInfo;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.DataProvider;

/**
 * @author zz
 *组织ID数据准备
 */

public class SelectDetailByOrgIdDataProvider {

	private static String url = "http://192.168.30.141:8766//collectRank/selectDetailByOrgId";		
	private static String successCode = "\"rest.success\"";
	private static String failCode = "401";
	private String token = "";	
	private String year = "";
	private String orgId = "";
	
	List<NameValuePair> params = new ArrayList<NameValuePair>();
	GetUserInfo gt = new GetUserInfo();
			
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	@DataProvider(name = "normal")  
	public Object[][] normal()
	{
		try {
			setYear("2018");
			setOrgId(gt.getOrgId());			
			token = gt.getToken(); 
			params.add(new BasicNameValuePair("year", year));
			params.add(new BasicNameValuePair("orgId", orgId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object[][]{
			{url, token, params, successCode}	
		};
	}
	
	@DataProvider(name = "nullYear")  
	public Object[][] nullYear()
	{		
		try {			
			setOrgId(gt.getOrgId());			
			token = gt.getToken(); 
			params.add(new BasicNameValuePair("year", year));
			params.add(new BasicNameValuePair("orgId", orgId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object[][]{
			{url, token, params, failCode}	
		};
	}
	
	@DataProvider(name = "nullOrgId")  
	public Object[][] nullOrgId()
	{		
		try {
			setYear("2018");			
			token = gt.getToken(); 
			params.add(new BasicNameValuePair("year", year));
			params.add(new BasicNameValuePair("orgId", orgId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object[][]{
			{url, token, params, failCode}	
		};
	}
	
	@DataProvider(name = "nullToken")  
	public Object[][] nullToken()
	{		
		try {
			setYear("2018");
			setOrgId(gt.getOrgId());
			params.add(new BasicNameValuePair("year", year));
			params.add(new BasicNameValuePair("orgId", orgId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object[][]{
			{url, token, params, failCode}	
		};
	}
}
