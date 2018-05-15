package liyan.dangjian.util;

import java.util.ArrayList;
import java.util.List;

import liyan.dangjian.dataprovider.GetUserInfoDataProvider;





import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;




/**
 * @author zz
 *获取Token类
 */
public class GetUserInfo {
	private String token = "";
	private String orgId = "";
	private String userId = "";
	private String account = "";
	private String password = "";
	private String loginType = "";
	private String url = "";
	
	//获取token
	public String getToken()
	{
		HttpUtil re = new HttpUtil();
		GetUserInfoDataProvider tdp = new GetUserInfoDataProvider();
		account = tdp.tokenData().get("account");
		password = tdp.tokenData().get("password");
		loginType = tdp.tokenData().get("loginType");
		url = tdp.tokenData().get("url");
		//装填参数  
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("userName", account));
        params.add(new BasicNameValuePair("password", password));
        params.add(new BasicNameValuePair("loginType", loginType));
        //执行post，并截取token 
        token = StringUtils.substringBetween(re.post(url, params),"token\":\"","\",\"id");
		return token;
	}
	
	//获取userId
		public String getUserId()
		{
			HttpUtil re = new HttpUtil();
			GetUserInfoDataProvider tdp = new GetUserInfoDataProvider();
			account = tdp.tokenData().get("account");
			password = tdp.tokenData().get("password");
			loginType = tdp.tokenData().get("loginType");
			url = tdp.tokenData().get("url");
			//装填参数  
	        List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("userName", account));
	        params.add(new BasicNameValuePair("password", password));
	        params.add(new BasicNameValuePair("loginType", loginType));
	        //执行post，并截取userId
	        userId = StringUtils.substringBetween(re.post(url, params),"\",\"id\":\"","\",\"name");
			return userId;
		}
		
	//获取orgId
	public String getOrgId()
	{
		HttpUtil re = new HttpUtil();
		GetUserInfoDataProvider tdp = new GetUserInfoDataProvider();
		account = tdp.tokenData().get("account");
		password = tdp.tokenData().get("password");
		loginType = tdp.tokenData().get("loginType");
		url = tdp.tokenData().get("url");
		//装填参数  
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("userName", account));
        params.add(new BasicNameValuePair("password", password));
        params.add(new BasicNameValuePair("loginType", loginType));
        //执行post，并截取orgId
        orgId = StringUtils.substringBetween(re.post(url, params),"\",\"organizationId\":\"","\",\"orgName");
		return orgId;
	}

}
