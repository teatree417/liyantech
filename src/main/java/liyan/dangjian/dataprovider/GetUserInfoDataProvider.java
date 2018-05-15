package liyan.dangjian.dataprovider;

import java.util.HashMap;
import java.util.Map;


/**
 * @author zz
 *Token数据准备
 */

public class GetUserInfoDataProvider {
	
	private static String account = "黄一宁171735";
	private static String password = "admin";
	private static String loginType = "web";
	private static String url = "http://192.168.30.141:8769/auth/login";
	
	public Map<String, String> tokenData()
	{
		HashMap<String,String> tokenData = new HashMap<String,String>();
		tokenData.put("account", account);
		tokenData.put("password", password);
		tokenData.put("loginType", loginType);
		tokenData.put("url", url);
		return tokenData;
	}

}
