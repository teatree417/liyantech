package liyan.dangjian.dataprovider;

/**
 * @author zz
 *工作台数据准备
 */

import liyan.dangjian.util.GetUserInfo;
import org.testng.annotations.DataProvider;

public class WorkbenchDataProvider {
	private String url = "http://192.168.30.141:8769/admin//workbench/workbench";
	private String token = "";	
	private String successCode = "\"rest.success\"";
	private String failCode = "401";

	GetUserInfo gt = new GetUserInfo();	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@DataProvider(name = "withToken")  
	public Object[][] withToken()
	{		
		try {
			token = gt.getToken();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new Object[][]{
			{token,url,successCode}	
		};
	}
	
	@DataProvider(name = "withoutToken")  
	public Object[][] withoutToken()
	{	
		try {
			setToken("");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object[][]{
			{token,url,failCode}	
		};
	}

}
