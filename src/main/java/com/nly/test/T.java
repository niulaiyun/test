package com.nly.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import cn.com.WebXml.WeatherWebService;
import cn.com.WebXml.WeatherWebServiceLocator;
import cn.com.WebXml.WeatherWebServiceSoap;

public class T {
	@Test
     public void test() throws Exception {
		/*Date date =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("HH:mm:ss");//只有时分秒
		//SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//完整的时间
		String time=sdf.format(date);
		Date newDate = sdf.parse(time);
		long times = newDate.getTime();
		
		SimpleDateFormat sdfm =new SimpleDateFormat("HH:mm");//只有时分秒
		Date start = sdfm.parse("9:00");
		long starts = start.getTime();
		System.out.println((times-starts)/15); */
		Long time = getTime("9:00");
		System.out.println(time);
		Long newTime = getNewTime();
		System.out.println(newTime);
		
     }
	public Long getNewTime() throws Exception {
		Date date =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("HH:mm:ss");//只有时分秒
		String time=sdf.format(date);
		Date newDate = sdf.parse(time);
		long times = newDate.getTime();
		return times;
	}
	
	public Long getTime(String time) throws Exception{
		SimpleDateFormat sdfm =new SimpleDateFormat("HH:mm");//只有时分秒
		Date start = sdfm.parse(time);
		long starts = start.getTime();
		return starts;
	}
	@Test
	public void test01() throws Exception {
		System.out.println(BigDecimal.valueOf(Double.parseDouble("10.00000"))
										.stripTrailingZeros().toPlainString());
		 /*String item="abcd";
		 Object obj = item.substring(0, 1);
		 System.out.println(obj);
		WeatherWebService service =new WeatherWebServiceLocator();
		WeatherWebServiceSoap soap = service.getWeatherWebServiceSoap();
	
		  String[] weatherbyCityName = soap.getWeatherbyCityName("周口");
		for (String string : weatherbyCityName) {
			System.out.println(string);
			System.out.println("----------------------");
		}*/
		String orElse = Optional.ofNullable("n").orElse("a");
		System.out.println(orElse);

	}
	 public static String nowTime() {
		 Date currentTime = new Date();// 获取当前时间
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");// 格式化时间
		int ran= (int)(1000*Math.random()+50);
		 String dateString = formatter.format(currentTime)+ran;// 转换为字符串
		 
		 return dateString;
    }
	 
	 public static String getNewDate() {
			Date date=new Date();
			String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			return dateString;
		}
	 public static Date getDate(String time) throws Exception {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
		}
}
