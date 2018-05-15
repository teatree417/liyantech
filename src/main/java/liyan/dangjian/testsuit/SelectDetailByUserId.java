/**
 * 
 */
package liyan.dangjian.testsuit;
import liyan.dangjian.dataprovider.SelectDetailByUserIdDataProvider;
import liyan.dangjian.util.HttpUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * @author zz
 *selectDetailByUserId接口，参数是json格式
 */
public class SelectDetailByUserId {
	//正常请求
	@Test(dataProvider = "normal",dataProviderClass = SelectDetailByUserIdDataProvider.class)
	public void normal(String url, String token, JsonObject params, String expCode)
	{
		String actCode = "";
		HttpUtil httputil = new HttpUtil();
		
		try {
			//执行post，并返回值转换成Json
			JsonObject returnData = new JsonParser().parse(httputil.post(url, token, params)).getAsJsonObject();
			//获取返回值里的状态值
			actCode = returnData.get("code").toString();
			//验证返回值和期望值是否一致
			Assert.assertEquals(actCode, expCode);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
	}

	//year为空
	@Test(dataProvider = "nullYear",dataProviderClass = SelectDetailByUserIdDataProvider.class)
	public void nullYear(String url, String token, JsonObject params, String expCode)
	{
		String actCode = "";
		HttpUtil httputil = new HttpUtil();
		try {
			//执行post，并返回值转换成Json
			JsonObject returnData = new JsonParser().parse(httputil.post(url, token, params)).getAsJsonObject();
			//获取返回值里的状态值
			actCode = returnData.get("code").toString();
			//验证返回值和期望值是否一致
			Assert.assertEquals(actCode, expCode);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
	}
		
	//orgId为空
	@Test(dataProvider = "nullOrgId",dataProviderClass = SelectDetailByUserIdDataProvider.class)
	public void nullOrgId(String url, String token, JsonObject params, String expCode)
	{
		String actCode = "";
		HttpUtil httputil = new HttpUtil();
		try {
			//执行post，并返回值转换成Json
			JsonObject returnData = new JsonParser().parse(httputil.post(url, token, params)).getAsJsonObject();
			//获取返回值里的状态值
			actCode = returnData.get("code").toString();
			//验证返回值和期望值是否一致
			Assert.assertEquals(actCode, expCode);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
	}
			
	//token为空
	@Test(dataProvider = "nullToken",dataProviderClass = SelectDetailByUserIdDataProvider.class)
	public void nullToken(String url, String token, JsonObject params, String expCode)
	{
		String actCode = "";
		HttpUtil httputil = new HttpUtil();
		try {
			//执行post，并返回值转换成Json
			JsonObject returnData = new JsonParser().parse(httputil.post(url, token, params)).getAsJsonObject();
			//获取返回值里的状态值
			actCode = returnData.get("code").toString();
			//验证返回值和期望值是否一致
			Assert.assertEquals(actCode, expCode);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
	}
}
