package liyan.dangjian.testsuit;

import liyan.dangjian.dataprovider.WorkbenchDataProvider;
import liyan.dangjian.util.HttpUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * @author zz
 *GET请求workbench接口
 */

public class WorkbenchApi {
	
	//带token的GET请求
	@Test(dataProvider = "withToken",dataProviderClass = WorkbenchDataProvider.class)
	public void withToken(String token,String url,String expCode)
	{
		String actCode = "";
		HttpUtil httputil = new HttpUtil();

		try {
			//执行get，并返回值转换成Json
			JsonObject returnData = new JsonParser().parse(httputil.get(url, token)).getAsJsonObject();
			//获取返回值里的状态值
			actCode = returnData.get("code").toString();
			//验证返回值和期望值是否一致
			Assert.assertEquals(actCode, expCode);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
	}

	//不带token的GET请求
	@Test(dataProvider = "withoutToken",dataProviderClass = WorkbenchDataProvider.class)
	public void withoutToken(String token,String url,String expCode)
	{
		String status = "";
		HttpUtil httputil = new HttpUtil();
		try {
			//执行get，并返回值转换成Json
			JsonObject returnData = new JsonParser().parse(httputil.get(url, token)).getAsJsonObject();
			//获取返回值里的状态值
			status = returnData.get("status").toString();
			//验证返回值和期望值是否一致
			Assert.assertEquals(status, expCode);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
	}
}
