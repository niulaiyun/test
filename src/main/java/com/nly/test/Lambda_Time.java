package com.nly.test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Test;

public class Lambda_Time {
	/**
	 * 
	 *   2.Instat

	     a.概述
	
	         时间戳，即时间轴上的一个点
	
	        从元年1970-1-1 00:00:00到现在的nanosecond数
	
	     b. Instant.now();获取当前时间

	 */
    @Test
	 public void test() {
    	//获取当前时间 
		Instant now=Instant.now();
		System.out.println(now);
    	
	 }
    //c.Instant.ofEpochMilli(new Date().getTime()); 旧日期转为新日期
    @Test
	 public void test01() {
		Instant now=Instant.ofEpochMilli(new Date().getTime());
		System.out.println(now);
   	
	 }
   // d. Instant.parse();日期文本格式转换为时间格式
    @Test
	 public void test02() {
		// 获取当前时间
		Instant instant = Instant.parse("1993-02-06T10:12:35Z");
		System.out.println(instant);
  	
	 }
    /**
     * 

       表示不带时区的日期，比如2014-01-14

    a.LocalDateTime.now();获取当前日期时间

    b.now.minusDays(2);将当前日期时间减去两天

    c.LocalDateTime.of(2016, 10, 23);构造一个指定日期时间的对象

     */
    @Test
	 public void test03() {
    	//获取当前时间
		LocalDate now=LocalDate.now();
		System.out.println(now);
		//往前推两天
		LocalDate date=now.minusDays(2);
		System.out.println(date);
		
		// 制定一个日期
		LocalDate localDate = LocalDate.of(1993, 2, 6);
		System.out.println(localDate);
	 }
    
    /**
     * 
     * 

	     表示不带时区的时间
	
	    a. LocalTime.now();当前时间
	
	    b. LocalTime.of(22, 33);确定的时间
	
	    c.LocalTime.ofSecondOfDay(4503); 一天中的第4503秒

     */
    @Test
	 public void test04() {
		// 当前时间
		LocalTime now = LocalTime.now();
		System.out.println(now);
		// 22:33
		LocalTime localTime = LocalTime.of(22, 33);
		System.out.println(localTime);
		// 一天中的4503秒
		LocalTime ofDay=LocalTime.ofSecondOfDay(4503);
		System.out.println(ofDay);
	 }
    /**
     * 
     * 

	      是LocalDate和LocalTime的组合体，表示的是不带时区的日期及时间

		a.LocalDateTime.now();当前时间
		
		b.localDateTime.plusHours(25).plusMinutes(3); 当前时间加上25小时３分钟
		
		c.LocalDateTime.of(2014, 1, 20, 3, 30, 20)；转换

     */
    @Test
	 public void test05() {
    	       // 当前时间
    			LocalDateTime now = LocalDateTime.now();
    			System.out.println(now);
    	 
    			// 当前时间加上25小时３分钟
    			LocalDateTime plusMinutes = now.plusHours(25).plusMinutes(3);
    			System.out.println(plusMinutes);
    	 
    			// 转换
    			LocalDateTime of = LocalDateTime.of(1993, 2, 6, 11, 23, 30);
    			System.out.println(of);
    	
	 }
    /**
     * 

	       格式化日期和解析日期格式字符串。DateTimeFormatter是不可变类
	
	    a.格式化：日期对象转换为格式字符串

     */
    @Test
    public void test06() {
		// 格式化
		String time = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss").format(LocalDateTime.now());
		System.out.println(time);	
		// b.解析：格式字符串转换为日期对象
		// 格式化
		LocalDateTime parse = LocalDateTime.parse("2019.08.06 09:58:46", DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
		System.out.println(parse);
		
		//4.String新增join(字符串集合或数组)方法

	   // 使用指定连接符连接多个字符串
		
		String[] str = {"a", "b", "c"};
		
		String join = String.join("-", str);
		System.out.println(join);

    }
    
}
