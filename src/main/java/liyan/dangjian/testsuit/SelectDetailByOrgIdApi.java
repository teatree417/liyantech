package liyan.dangjian.testsuit;

import java.util.List;

import liyan.dangjian.dataprovider.SelectDetailByOrgIdDataProvider;
import liyan.dangjian.util.HttpUtil;
import org.apache.http.NameValuePair;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * @author zz
 *post请求，selectDetailByOrgId接口，list参数
 *
 */

public class SelectDetailByOrgIdApi {

	//正常请求
	@Test(dataProvider = "normal",dataProviderClass = SelectDetailByOrgIdDataProvider.class)
	public void normal(String url, String token, List<NameValuePair> params, String expCode)
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
	@Test(dataProvider = "nullYear",dataProviderClass = SelectDetailByOrgIdDataProvider.class)
	public void nullYear(String url, String token, List<NameValuePair> params, String expCode)
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
	@Test(dataProvider = "nullOrgId",dataProviderClass = SelectDetailByOrgIdDataProvider.class)
	public void nullOrgId(String url, String token, List<NameValuePair> params, String expCode)
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
	@Test(dataProvider = "nullToken",dataProviderClass = SelectDetailByOrgIdDataProvider.class)
	public void nullToken(String url, String token, List<NameValuePair> params, String expCode)
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
