package liyan.dangjian.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.DataProvider;

/**
 * @author zz
 *登录数据准备
 */

public class LoginDataProvider {

	private static String url = "http://192.168.30.141:8769/auth/login";
	private static String successCode = "\"rest.success\"";
	private static String failCode = "\"msg.user.userNotExist\"";
	private  String account = "";
	private  String password = "";
	private  String loginType = "";
	List<NameValuePair> params = new ArrayList<NameValuePair>();

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	@DataProvider(name = "normalLogin")  
	public Object[][] normalLoginData()
	{		
		try {
			setAccount("admin");
			setPassword("admin");
			setLoginType("web");
			params.add(new BasicNameValuePair("userName", account));
			params.add(new BasicNameValuePair("password", password));
			params.add(new BasicNameValuePair("loginType", loginType));
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new Object[][]{
			{url, params, successCode}	
		};
	}
	
	@DataProvider(name = "errorAccountLogin")  
	public Object[][] errorAccountLoginData()
	{
		try {			 
			setAccount("error");
			setPassword("admin");
			setLoginType("web");
			params.add(new BasicNameValuePair("userName", account));
			params.add(new BasicNameValuePair("password", password));
			params.add(new BasicNameValuePair("loginType", loginType));
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return new Object[][]{
			{url, params, failCode}	
		};
	}
	
	@DataProvider(name = "nullAccountLogin")  
	public Object[][] nullAccountLoginData()
	{
		try {
			setAccount("");
			setPassword("admin");
			setLoginType("web");
			params.add(new BasicNameValuePair("userName", account));
			params.add(new BasicNameValuePair("password", password));
			params.add(new BasicNameValuePair("loginType", loginType));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object[][]{
			{url, params, failCode}	
		};
	}
	
	@DataProvider(name = "errorPasswordLogin")  
	public Object[][] errorPasswordLoginData()
	{
		try {
			setAccount("admin");
			setPassword("error");
			setLoginType("web");
			params.add(new BasicNameValuePair("userName", account));
			params.add(new BasicNameValuePair("password", password));
			params.add(new BasicNameValuePair("loginType", loginType));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object[][]{
			{url, params, failCode}	
		};
	}
	
	@DataProvider(name = "nullPasswordLogin")  
	public Object[][] nullPasswordLoginData()
	{
		try {
			setAccount("admin");
			setPassword("");
			setLoginType("web");
			params.add(new BasicNameValuePair("userName", account));
			params.add(new BasicNameValuePair("password", password));
			params.add(new BasicNameValuePair("loginType", loginType));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object[][]{
			{url, params, failCode}	
		};
	}
	
	@DataProvider(name = "errorLoginTypeLogin")  
	public Object[][] errorLoginTypeLoginData()
	{
		try {
			setAccount("admin");
			setPassword("admin");
			setLoginType("error");
			params.add(new BasicNameValuePair("userName", account));
			params.add(new BasicNameValuePair("password", password));
			params.add(new BasicNameValuePair("loginType", loginType));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object[][]{
			{url, params, failCode}	
		};
	}
	
	@DataProvider(name = "nullLoginTypeLogin")  
	public Object[][] nullLoginTypeLoginData()
	{
		try {
			setAccount("admin");
			setPassword("admin");
			setLoginType("");
			params.add(new BasicNameValuePair("userName", account));
			params.add(new BasicNameValuePair("password", password));
			params.add(new BasicNameValuePair("loginType", loginType));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object[][]{
			{url, params, failCode}	
		};
	}

	
}
