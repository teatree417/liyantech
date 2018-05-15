package liyan.dangjian.testsuit;

import java.util.List;

import liyan.dangjian.dataprovider.LoginDataProvider;
import liyan.dangjian.util.HttpUtil;

import org.apache.http.NameValuePair;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * @author zz
 *post请求，登录接口，form参数
 *登录接口测试，分为正常、错误的用户名、错误密码、错误登录类型、空用户名、空密码、空登录类型7个用例。
 *每个用例对应一个方法
 */

public class LoginApi {
	//正常登录
	@Test(dataProvider = "normalLogin",dataProviderClass = LoginDataProvider.class)
	public void normalLogin(String url, List<NameValuePair> params, String expCode)
	{
		String actCode = "";
		HttpUtil httputil = new HttpUtil();
		try {
			//执行post，并返回值转换成Json
			String s = httputil.post(url, params);
			JsonObject returnData = new JsonParser().parse(s).getAsJsonObject();
			//获取返回值里的状态值			
			actCode = returnData.get("code").toString();			
			//验证返回值和期望值是否一致
			Assert.assertEquals(actCode, expCode);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
	}
	
	//错误的用户名
	@Test(dataProvider = "errorAccountLogin",dataProviderClass = LoginDataProvider.class)
	public void errorAccountLogin(String url, List<NameValuePair> params, String expCode)
	{
		String actCode = "";
		HttpUtil httputil = new HttpUtil();
		try {
			//执行post，并返回值转换成Json
			JsonObject returnData = new JsonParser().parse(httputil.post(url, params)).getAsJsonObject();
			//获取返回值里的状态值
			actCode = returnData.get("code").toString();
			//验证返回值和期望值是否一致
			Assert.assertEquals(actCode, expCode);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
	}
	
	//空用户名
	@Test(dataProvider = "nullAccountLogin",dataProviderClass = LoginDataProvider.class)
	public void nullAccountLogin(String url, List<NameValuePair> params, String expCode)
	{
		String actCode = "";
		HttpUtil httputil = new HttpUtil();
		try {
			//执行post，并返回值转换成Json
			JsonObject returnData = new JsonParser().parse(httputil.post(url, params)).getAsJsonObject();
			//获取返回值里的状态值
			actCode = returnData.get("code").toString();
			//验证返回值和期望值是否一致
			Assert.assertEquals(actCode, expCode);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
	}
	
	//错误密码
	@Test(dataProvider = "errorPasswordLogin",dataProviderClass = LoginDataProvider.class)
	public void errorPasswordLogin(String url, List<NameValuePair> params, String expCode)
	{
		String actCode = "";
		HttpUtil httputil = new HttpUtil();
		try {
			//执行post，并返回值转换成Json
			JsonObject returnData = new JsonParser().parse(httputil.post(url, params)).getAsJsonObject();
			//获取返回值里的状态值
			actCode = returnData.get("code").toString();
			//验证返回值和期望值是否一致
			Assert.assertEquals(actCode, expCode);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
	}
	
	//空密码
	@Test(dataProvider = "nullPasswordLogin",dataProviderClass = LoginDataProvider.class)
	public void nullPasswordLogin(String url, List<NameValuePair> params, String expCode)
	{
		String actCode = "";
		HttpUtil httputil = new HttpUtil();
		try {
			//执行post，并返回值转换成Json
			JsonObject returnData = new JsonParser().parse(httputil.post(url, params)).getAsJsonObject();
			//获取返回值里的状态值
			actCode = returnData.get("code").toString();
			//验证返回值和期望值是否一致
			Assert.assertEquals(actCode, expCode);
		} catch (JsonSyntaxException e) {			
			e.printStackTrace();
		}
	}
	
	//错误登录类型
	@Test(dataProvider = "errorLoginTypeLogin",dataProviderClass = LoginDataProvider.class)
	public void errorLoginTypeLogin(String url, List<NameValuePair> params, String expCode)
	{
		String actCode = "";
		HttpUtil httputil = new HttpUtil();
		try {
			//执行post，并返回值转换成Json
			JsonObject returnData = new JsonParser().parse(httputil.post(url, params)).getAsJsonObject();
			//获取返回值里的状态值
			actCode = returnData.get("code").toString();
			//验证返回值和期望值是否一致
			Assert.assertEquals(actCode, expCode);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
	}
	
	//空登录类型
	@Test(dataProvider = "nullLoginTypeLogin",dataProviderClass = LoginDataProvider.class)
	public void nullLoginTypeLogin(String url, List<NameValuePair> params, String expCode)
	{
		String actCode = "";
		HttpUtil httputil = new HttpUtil();
		try {
			//执行post，并返回值转换成Json
			JsonObject returnData = new JsonParser().parse(httputil.post(url, params)).getAsJsonObject();
			//获取返回值里的状态值
			actCode = returnData.get("code").toString();
			//验证返回值和期望值是否一致
			Assert.assertEquals(actCode, expCode);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
	}
}
