package liyan.dangjian.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonObject;

/**
 * 接口请求类
 *
 */
public class HttpUtil 
{
	//不带token的post请求    
	public String post(String url,List<NameValuePair> params)
    {
    	//创建默认HttpClient
    	CloseableHttpClient httpClient = HttpClients.createDefault(); 
    	//post请求
    	HttpPost httpPost = new HttpPost(url);    	       
        String result = "";
        try {
        	//填充post实体,类型为x-www-form-urlencoded
        	StringEntity entity = new UrlEncodedFormEntity(params,Consts.UTF_8);
        	httpPost.setEntity(entity);
            try{            	
            	//获取response
                CloseableHttpResponse response = httpClient.execute(httpPost);
                try{                	
                	result = EntityUtils.toString(response.getEntity(), Consts.UTF_8);                	
                }catch (Exception e){
                    e.printStackTrace();
                    response.close();
                }finally {
                    response.close();
                }

            }catch (Exception  e){
                e.printStackTrace();
                httpClient.close();
            }finally {
                httpClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(result);
        return result;
    	
    }
    
	//带token的post请求,使用json
    public String post(String url,String token,List<NameValuePair> params)
    {
    	//创建默认HttpClient
    	CloseableHttpClient httpClient = HttpClients.createDefault();
    	//post请求
    	HttpPost httpPost = new HttpPost(url);    	
        String result="";
        try {
        	//设置header里的token  
        	httpPost.addHeader("access-token", token);
        	//填充post实体,类型为x-www-form-urlencoded, UTF-8
        	StringEntity entity = new UrlEncodedFormEntity(params,Consts.UTF_8);
        	//填充post实体
        	httpPost.setEntity(entity);            
            try{
            	//获取response
                CloseableHttpResponse response = httpClient.execute(httpPost);
                try{                	
                    result = EntityUtils.toString(response.getEntity(), Consts.UTF_8);
                }catch (Exception e){
                    e.printStackTrace();
                    response.close();
                }finally {
                    response.close();
                }

            }catch (Exception  e){
                e.printStackTrace();
                httpClient.close();
            }finally {
                httpClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    	
    }
	
	//带token的post请求,使用json
    public String post(String url,String token,JsonObject data)
    {
    	//创建默认HttpClient
    	CloseableHttpClient httpClient = HttpClients.createDefault();
    	//post请求
    	HttpPost httpPost = new HttpPost(url);    	
        String result="";
        try {
        	//设置header里的token  
        	httpPost.addHeader("access-token", token);
        	//新建String类型entity
        	StringEntity entity = new StringEntity(data.toString(),"utf-8");
        	//entity的类型为json
        	entity.setContentType("application/json");
        	//填充post实体
        	httpPost.setEntity(entity);            
            try{
            	//获取response
                CloseableHttpResponse response = httpClient.execute(httpPost);
                try{                	
                    result = EntityUtils.toString(response.getEntity(), Consts.UTF_8);
                }catch (Exception e){
                    e.printStackTrace();
                    response.close();
                }finally {
                    response.close();
                }
            }catch (Exception  e){
                e.printStackTrace();
                httpClient.close();
            }finally {
                httpClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    	
    }
    
    //get请求
    public String get(String url,String token)
    {
    	//创建默认HttpClient
    	CloseableHttpClient httpClient = HttpClients.createDefault(); 
    	//创建Get请求  
        HttpGet httpGet = new HttpGet(url); 
        CloseableHttpResponse response = null; 
        InputStream is = null; 
        String result = "";
        StringBuffer rs = new StringBuffer();        
        try {               
            
            //设置header里的token  
            httpGet.addHeader("access-token", token);
            //执行Get请求  
            response = httpClient.execute(httpGet);  
            //得到响应体  
            HttpEntity entity = response.getEntity();  
            if(entity != null){  
                is = entity.getContent();  
                //转换为字节输入流  
                BufferedReader br = new BufferedReader(new InputStreamReader(is, Consts.UTF_8));  
                String body = null;
                //根据entity内容，通过br赋值给rs
                while((body=br.readLine()) != null){  
                    rs.append(body);  
                }
                //生成结果
                result = rs.toString();
            }  
        } catch (ParseException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally{  
            //关闭输入流，释放资源  
            if(is != null){  
                try {  
                    is.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
            //释放实体  
            if(response != null){  
                try {  
                    response.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
            //释放httpClient  
            if(httpClient != null){  
                try {  
                    httpClient.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }
		return result;
    	
    }
}
