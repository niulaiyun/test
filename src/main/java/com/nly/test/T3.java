package com.nly.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @Author: Niu Lai Yun
 * @Description:
 * @Date 2019年11月1日 下午5:24:05
 */
public class T3 {
	public static void main(String[] args) {
		// 定义天气信息哈希映射
        HashMap<String, String> weather = new HashMap<>();
        String cityName="周口";
        try {
            // 获取城市代码
            String cityCode = getCityCode(cityName);
            // 定义url字符串
            String strUrl = "http://t.weather.sojson.com/api/weather/city/" + cityCode;
            // 创建URL对象
            URL url = new URL(strUrl);
            // 创建http连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 建立连接
            connection.connect();
            // 获取响应码
            int code = connection.getResponseCode();
            // 判断是否连接成功
            if (code == 200) {
                // 获取字节输入流
                InputStream is = connection.getInputStream();
                // 创建字节数组用于保存响应信息
                byte[] buffer = new byte[is.available()];
                // 读取字节输入流全部信息
                is.read(buffer);
                // 获取响应信息字符串
                String response = new String(buffer, "utf-8");
                // 将json字符串转换成json对象
                JSONObject weatherInfoJsonObj = new JSONObject(response);
                System.out.println(weatherInfoJsonObj);
                JSONObject cityInfoJsonObj = new JSONObject(weatherInfoJsonObj.getString("cityInfo"));
                weather.put("城市：", cityInfoJsonObj.getString("parent") + " " + cityInfoJsonObj.getString("city") + "[" + cityCode + "]");
                JSONArray forcastJsonArr = new JSONArray(new JSONObject(weatherInfoJsonObj.getString("data")).getString("forecast"));
                weather.put("时间：", weatherInfoJsonObj.getString("time") + " " + forcastJsonArr.getJSONObject(0).getString("week"));
                weather.put("温度：", forcastJsonArr.getJSONObject(0).getString("high") + " " + forcastJsonArr.getJSONObject(0).getString("low"));
                weather.put("天气：", forcastJsonArr.getJSONObject(0).getString("type"));
            } else {
                weather.put("错误：", "[" + cityName + "]不存在！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        weather.forEach((k, v) ->{System.out.println(k+"/t"+v);});

	}
	
	
	
	 public static String getCityCode(String cityName) {
	        // 定义城市代码
	        String cityCode = "";
	        try {
	            // 定义url字符串
	            String strUrl = "http://toy1.weather.com.cn/search?cityname=" + URLEncoder.encode(cityName, "utf-8");
	            // 创建URL对象
	            URL url = new URL(strUrl);
	            // 利用URL对象获取HTTP连接
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            // 建立物理连接
	            conn.connect();
	            // 获取响应码
	            int responseCode = conn.getResponseCode();
	            // 判断连接是否成功
	            if (responseCode == HttpURLConnection.HTTP_OK) { // 200
	                // 获取字节输入流
	                InputStream is = conn.getInputStream();
	                // 定义字节数组用于保存字节输入流的全部内容
	                byte[] buffer = new byte[is.available()];
	                // 判断城市是否存在
	                if (is.available() > 4) {
	                    // 读取字节输入流全部信息，保存到buffer
	                    is.read(buffer);
	                    // 获取响应信息字符串
	                    String response = new String(buffer, "utf-8");
	                    // 截取出城市代码
	                    cityCode = response.substring(10, 19);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 
	        // 返回城市代码
	        return cityCode;
	    }
	
}
