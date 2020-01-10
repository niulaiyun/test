package com.nly.test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class T {
	
	public static String camel2Underline(String line) {
		if (line == null || "".equals(line)) {
			return "";
		}
		line = String.valueOf(line.charAt(0)).toUpperCase()
				.concat(line.substring(1));
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			String word = matcher.group();
			sb.append(word.toUpperCase());
			sb.append(matcher.end() == line.length() ? "" : "_");
		}
		return sb.toString();
	}
	@Test
	public void test0007() {
	String	line="lineName";
		String camel2Underline = camel2Underline(line);
		System.out.println(camel2Underline);
	}
	
	@Test
	public void test00005() {
		Map<String, Integer> jsonObject1 = new HashMap<String, Integer>();
		Map<String, Integer> jsonObject2 = new HashMap<String, Integer>();
		
		
		
		//result
		
		for(int i=0;i<7;i++)//周1～周日
		{
			 int temResult = (int)(Math.random()*100);
			 jsonObject1.put(Integer.valueOf(i).toString(), temResult);
		}
		List<Integer> benWe=new ArrayList<>();
		for(int i=0;i<7;i++)//周1～周日
		{
			 int temResult = (int)(Math.random()*100);
			 jsonObject2.put(Integer.valueOf(i).toString(), temResult);
		}
		List<List<Integer>> arr=new ArrayList<>();
		
		
		for (int i = 0; i < 7; i++) {
			List<Integer> line=new ArrayList<>();
			line.add(jsonObject1.get(Integer.valueOf(i).toString()));
			line.add(jsonObject2.get(Integer.valueOf(i).toString()));
			arr.add(line);
		}
		System.out.println(arr.toString());

	
	}
	
	
	static Object[] concat(Object[] a, Object[] b) {

		Object[] c= new Object[a.length+b.length];

		  System.arraycopy(a, 0, c, 0, a.length);
		  System.arraycopy(b, 0, c, a.length, b.length);
		  return c;

		}
	
	
	
	// 获取本周的开始时间
		public static Date getBeginDayOfWeek1() {
			Date date = new Date();
			if (date == null) {
				return null;
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
			if (dayofweek == 1) {
				dayofweek += 7;
			}
			cal.add(Calendar.DATE, 2 - dayofweek);
			return getDayStartTime(cal.getTime());
		}
	@Test
	public void test0002() throws Exception {
		
		Date d1 = yyyyMMdd.parse(yyyyMMdd.format(getBeginDayOfWeek1()));
		Date d2 = yyyyMMdd.parse("2019-10-20");
		long daysBetween=(d2.getTime()-d1.getTime()+1000000)/(60*60*24*1000);
		System.out.println(daysBetween);
		
	}
	
		
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
		/*Long time = getTime("9:00");
		System.out.println(time);
		Long newTime = getNewTime();
		System.out.println(newTime);*/
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    LocalDateTime localDateTime = LocalDateTime.now();

		System.out.println(dtf.format(localDateTime));
		
     }
	@Test
	public  void test001() {
		// 使用默认时区和语言环境获得一个日历
	    Calendar cal = Calendar.getInstance();
	    // 赋值时年月日时分秒常用的6个值，注意月份下标从0开始，所以取月份要+1
	    System.out.println("年:" + cal.get(Calendar.YEAR));
	    System.out.println("月:" + (cal.get(Calendar.MONTH) + 1));       
	    System.out.println("日:" + cal.get(Calendar.DAY_OF_MONTH));
	    System.out.println("时:" + cal.get(Calendar.HOUR_OF_DAY));
	    System.out.println("分:" + cal.get(Calendar.MINUTE));
	    System.out.println("秒:" + cal.get(Calendar.SECOND));
	
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
	 @Test
	 public void test010() throws Exception{
		   String beginDate = getMONTHFirst();//开始时间
			String endDate = getMONTHLast();//结束时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(beginDate));
	      StringBuffer sbf=new StringBuffer();
			for (long d = cal.getTimeInMillis(); d <= sdf.parse(endDate).getTime(); d = get_D_Plaus_1(cal)) {
				String day=sdf.format(d);
				day=day.substring(day.lastIndexOf("-")+1,day.length());
				sbf.append("["+day+"],");
			}
			sbf = sbf.deleteCharAt(sbf.length() - 1); 
             System.out.println(sbf.toString());
	
	 }
	 //日期
	 @Test
	 public void test012() throws Exception{
		Set<String> setDate = getSetDate(getMONTHFirst(), getMONTHLast());
	   Map<String, Integer>  map=new LinkedHashMap<String, Integer>();
	    for (String arr: setDate) {
			  map.put(arr, 0);
		}
	     String[] a= {"2019-09-01","2019-09-04","2019-09-08","2019-09-11"};
	     for (String s : a) {
	    	 map.put(s, 1);
		}
	     List<Integer> num=new ArrayList<>();
	     map.forEach((k, v) -> {
	    	 num.add(v);
	    	 });
	     System.out.println(num);
	    	
	   //System.out.println(map);
	 }
	 
	 //开始时间-结束时间 获取这一段时间 数据[2019-09-01, 2019-09-02, 2019-09-03, 2019-09-04, 2019-09-05, 2019-09-06, 2019-09-07, 2019-09-08, 2019-09-09, 2019-09-10, 2019-09-11, 2019-09-12, 2019-09-13, 2019-09-14, 2019-09-15, 2019-09-16, 2019-09-17, 2019-09-18, 2019-09-19, 2019-09-20, 2019-09-21, 2019-09-22, 2019-09-23, 2019-09-24, 2019-09-25, 2019-09-26, 2019-09-27, 2019-09-28, 2019-09-29, 2019-09-30]
	 public Set<String> getSetDate(String beginDate,String endDate) throws Exception{
		 Set<String> arr=new LinkedHashSet<>();
		 Calendar cal = Calendar.getInstance();
			cal.setTime(yyyyMMdd.parse(beginDate));
			for (long d = cal.getTimeInMillis(); d <= yyyyMMdd.parse(endDate).getTime(); d = get_D_Plaus_1(cal)) {
				String day=yyyyMMdd.format(d);
				arr.add(day);
			}
			return arr;
	 }
	 public  long get_D_Plaus_1(Calendar c) {
			c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
			return c.getTimeInMillis();
		}
	 /**
		 * 获取当前月的第一天
		 * @return
		 */
		public  String getMONTHFirst() {
			//本月
			 now.add(Calendar.MONTH, 0);
			//设置为1号为本月第一天 
			 now.set(Calendar.DAY_OF_MONTH,1);
		     String first = yyyyMMdd.format(now.getTime());
			return first;
			
		}
		public  String getMONTHLast() {
			//设置当月为最后一天
			now.set(Calendar.DAY_OF_MONTH, now.getActualMaximum(Calendar.DAY_OF_MONTH));
		    String last = yyyyMMdd.format(now.getTime());
		  return last;
			
		}
		
		
		 public 	Calendar now = Calendar.getInstance();
		 
		 public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat(
					"yyyy-MM-dd");
		 
		 public static final SimpleDateFormat MMdd = new SimpleDateFormat(
					"MM-dd");
		 
		 @Test
		 public void test009() {
		        System.out.println(getYeayrFirst());
		        System.out.println(getYeayrLast());
		 }
		 
		 
		 /**
		  * 2019-01-01 获取当前年的第一天
		  * @return
		  */
		 public static String getYeayrFirst() {
			 return yyyyMMdd.format(getCurrYearFirst());
		 }
		 /**2019-12-31 获取当前年最后一天
		  * 
		  * @return
		  */
		 public static String getYeayrLast() {
			 return yyyyMMdd.format(getCurrYearLast());
		 }
		 
		 /**
		     * 获取当年的第一天
		     * @param year
		     * @return
		     */
		    public static Date getCurrYearFirst(){
		        Calendar currCal=Calendar.getInstance();  
		        int currentYear = currCal.get(Calendar.YEAR);
		        return getYearFirst(currentYear);
		    }
		     
		    /**
		     * 获取当年的最后一天
		     * @param year
		     * @return
		     */
		    public static Date getCurrYearLast(){
		        Calendar currCal=Calendar.getInstance();  
		        int currentYear = currCal.get(Calendar.YEAR);
		        return getYearLast(currentYear);
		    }
		     
		    /**
		     * 获取某年第一天日期
		     * @param year 年份
		     * @return Date
		     */
		    public static Date getYearFirst(int year){
		        Calendar calendar = Calendar.getInstance();
		        calendar.clear();
		        calendar.set(Calendar.YEAR, year);
		        Date currYearFirst = calendar.getTime();
		        return currYearFirst;
		    }
		     
		    /**
		     * 获取某年最后一天日期
		     * @param year 年份
		     * @return Date
		     */
		    public static Date getYearLast(int year){
		        Calendar calendar = Calendar.getInstance();
		        calendar.clear();
		        calendar.set(Calendar.YEAR, year);
		        calendar.roll(Calendar.DAY_OF_YEAR, -1);
		        Date currYearLast = calendar.getTime();
		         
		        return currYearLast;
		    }
		    
    /**
     * 获取上月第一天		    
     * @return
     */
	public static String getSuperiorMONTHFirst() {
		Calendar calendar=Calendar.getInstance();

		calendar.add(Calendar.MONTH, -1);

		calendar.set(Calendar.DAY_OF_MONTH, 1);
        return yyyyMMdd.format(calendar.getTime());

		
	}
	 /**
     * 获取上月最后一天		    
     * @return
     */
	public  static String getSuperiorMONTHLast() {
		Calendar calendar=Calendar.getInstance();
		int month=calendar.get(Calendar.MONTH);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
       return yyyyMMdd.format(calendar.getTime());
		
	}
	@Test
	public void test000001() {
		System.out.println("上月第一天"+getBeginDayOfWeek());
		System.out.println("上月最后一天"+getEndDayOfWeek());
	}
	
	
	
	//获取本周的开始时间
  	public static Date getBeginDayOfWeek() {
  		Date date = new Date();
  		if (date == null) {
  			return null;
  		}
  		Calendar cal = Calendar.getInstance();
  		cal.setTime(date);
  		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
  		if (dayofweek == 1) {
  			dayofweek += 7;
  		}
  		cal.add(Calendar.DATE, 2 - dayofweek);
  		return getDayStartTime(cal.getTime());
  	}
   
  	//获取本周的结束时间
  	public static Date getEndDayOfWeek(){
  		Calendar cal = Calendar.getInstance();
  		cal.setTime(getBeginDayOfWeek());  
  		cal.add(Calendar.DAY_OF_WEEK, 6); 
  		Date weekEndSta = cal.getTime();
  		return getDayEndTime(weekEndSta);
  	}
  	
  	
  //获取某个日期的开始时间
  	public static Timestamp getDayStartTime(Date d) {
  		Calendar calendar = Calendar.getInstance();
  		if(null != d){
  			calendar.setTime(d);
  		}
  		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
  		calendar.set(Calendar.MILLISECOND, 0);
  		return new Timestamp(calendar.getTimeInMillis());
  	}
  	
  	
	//获取某个日期的结束时间
  	public static Timestamp getDayEndTime(Date d) {
  		Calendar calendar = Calendar.getInstance();
  		if(null != d) {
  			calendar.setTime(d);
  		}
  		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
  		calendar.set(Calendar.MILLISECOND, 999);
  		return new Timestamp(calendar.getTimeInMillis());
  	}
  	
  	
  	@Test
  	public void testweek() {
  		System.out.println(getBeginDayOfLastWeek());
  		System.out.println(getEndDayOfLastWeek());
  	}
   // 获取上周的开始时间
 	@SuppressWarnings("unused")
 	public static Date getBeginDayOfLastWeek() {
 		Date date = new Date();
 		if (date == null) {
 			return null;
 		}
 		Calendar cal = Calendar.getInstance();
 		cal.setTime(date);
 		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
 		if (dayofweek == 1) {
 			dayofweek += 7;
 		}
 		cal.add(Calendar.DATE, 2 - dayofweek - 7);
 		return getDayStartTime(cal.getTime());
 	}
  
 	// 获取上周的结束时间
 	public static Date getEndDayOfLastWeek() {
 		Calendar cal = Calendar.getInstance();
 		cal.setTime(getBeginDayOfLastWeek());
 		cal.add(Calendar.DAY_OF_WEEK, 6);
 		Date weekEndSta = cal.getTime();
 		return getDayEndTime(weekEndSta);
 	}

 	 /**
     * 	 //获取三十天前日期
     * @return
     */
 	public static String getDate30(Date date,int num) {
 		
	
		 Calendar theCa = Calendar.getInstance();
		 theCa.setTime(date);
 		 theCa.add(theCa.DATE,-num);//最后一个数字30可改，30天的意思
 		 Date start = theCa.getTime();
 		 String startDate = yyyyMMdd.format(start);//三十天之前日
         return startDate;
 	}
 	
 	public static String getStringDate(String date) throws Exception {
 		
 		
		 Calendar theCa = Calendar.getInstance();
		 theCa.setTime(yyyyMMdd.parse(date));
		 theCa.add(theCa.DATE,+1);//最后一个数字30可改，30天的意思
		 Date start = theCa.getTime();
		 String startDate = yyyyMMdd.format(start);//三十天之前日
        return startDate;
	}
 
 	public static String getmmhhDate(String date) {
 		return date+" 23:59:59";
 	}
 	@Test
 	public void test0000001() throws Exception {
 		System.out.println(getmmhhDate("2019-09-30"));
 		/*String format = MMdd.format(yyyyMMdd.parse(getDate301()));
 		format=format.replace("-", "/");
 		System.out.println(format);
		System.out.println(getDate301());
 		System.out.println(getDate3011());
 	   System.out.println(getDate3012());*/
 	
 	}
 	//替换09-20 09/20
 	public String getReplace(String stratDate) throws Exception {
		String format = MMdd.format(yyyyMMdd.parse(stratDate));
 		format=format.replace("-", "/");
 		return format;
 	}
 	
	//前三十天
 	public static String getDate301() {
 		return getDate30(new Date(),30);
 	}
	//前三十一天
 	public static String getDate3011() {
 		return getDate30(new Date(),31);
 	}
	//前三十一天的前三十天
 	public static String getDate3012() throws Exception {
 		String date30 = getDate30(yyyyMMdd.parse(getDate3011()),30);
 		return date30;
 	}
 	
 	
 	
 	
 	
  	//
 	public static String getdate301() {
 		Calendar c = Calendar.getInstance();
 		c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
 		Date day =  c.getTime();
 		String str=  new SimpleDateFormat("yyyy-MM-dd").format(day);
		return str;

 		
 	}
	public static final SimpleDateFormat yyMMdd = new SimpleDateFormat(
			"yyMMdd");
	
	public static final SimpleDateFormat mmdd = new SimpleDateFormat(
			"MMdd");
 	
 	
 	 
	/** 
	    * 获取过去第几天的日期 从当天时间
	    * 
	    * @param past 
	    * @return 
	    */  
	   public static String getPastDate(int past) {  
	       Calendar calendar = Calendar.getInstance();  
	       calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);  
	       Date today = calendar.getTime();  
	       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	       String result = format.format(today);  
	      
	       return result;  
	   }  
	   @Test
	   public void test00008() {
		   Calendar calendar = Calendar.getInstance();  
		   Date today = calendar.getTime();  
		   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		   String format2 = format.format(today);
		   System.out.println(format2+" 23:59:59");
	   }
}



