package jdk8date;
/**
 * @Author: Niu Lai Yun
 * @Description: 
 * @Date 2019年10月24日 下午4:06:11
 */


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TestNewDate {
//当前时间	
public static LocalDateTime dateTime=LocalDateTime.now();
public static LocalDate date=LocalDate.now();

//转换格式
public static final DateTimeFormatter  yyyyMMdd=DateTimeFormatter.ofPattern("yyyy-MM-dd");

public static final DateTimeFormatter  yyyyMMddHHmmss=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


public static final DateTimeFormatter  yMdHms=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

public static final DateTimeFormatter  yyyyMM=DateTimeFormatter.ofPattern("yyyy-MM");

public static final DateTimeFormatter  yyyyMMdd_NOCHAR=DateTimeFormatter.ofPattern("yyyyMMdd");

public static final DateTimeFormatter  yyMMdd=DateTimeFormatter.ofPattern("yyMMdd");

public static final DateTimeFormatter  MMdd=DateTimeFormatter.ofPattern("MM-dd");

 public static void main(String[] args) {
	 
	 LocalDateTime parse = LocalDateTime.parse("2017-01-01 13:00:00", yyyyMMddHHmmss);


	System.out.println(parse.toString());
}
}
