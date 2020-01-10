package util;

import java.sql.Timestamp;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;

/**
 * 封装时间类型组件
 * @author Administrator
 *
 */
public class DateUtil {
	
	
	public static final SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat EEEMMMddHHmmss = new SimpleDateFormat(
			"EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
	public static final SimpleDateFormat yMdHms = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat(
			"yyyy-MM-dd");
	public static final SimpleDateFormat yyyyMM = new SimpleDateFormat(
			"yyyy-MM");
	public static final SimpleDateFormat yyyyMMdd_NOCHAR = new SimpleDateFormat(
			"yyyyMMdd");
	public static final SimpleDateFormat yyMMdd = new SimpleDateFormat(
			"yyMMdd");
	
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
    public static final String HOUR_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String MONTH_PATTERN = "yyyy-MM";
    public static final String YEAR_PATTERN = "yyyy";
    public static final String MINUTE_ONLY_PATTERN = "mm";
    public static final String HOUR_ONLY_PATTERN = "HH";
    
    /**
	 * 分钟转换天、小时、分钟
	 * @param mss
	 * @return
	 */
	public static String formatDateToDHM(long minu) {
		String DateTimes = null;
		long days = minu / ( 60 * 60 * 24);
		long hours = (minu % ( 60 * 60 * 24)) / (60 * 60);
		long minutes = (minu % ( 60 * 60)) /60;
		long seconds = minu % 60;
		
		if(days > 0){
			DateTimes= days + "天" + hours + "小时" + minutes + "分钟"+ seconds + "秒";
		} else if(hours>0){
			DateTimes=hours + "小时" + minutes + "分钟" + seconds + "秒";
		} else if(minutes>0){
			DateTimes=minutes + "分钟"+ seconds + "秒";
		} else{
			DateTimes=seconds + "秒";
		}
		
		return DateTimes;
	}
    
    /**
     * 获取指定年月的第一天
     * @param month
     * @return
     */
    public static Date getMonthStartDate(int year, int month){
        Calendar cal = Calendar.getInstance();    
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
        return cal.getTime();
    }
    /**
     * 获取指定年月的最后一天
     * @param month
     * @return
     */
    public static Date getMonthEndDate(int year, int month){
    	Calendar cal = Calendar.getInstance();    
    	cal.set(Calendar.YEAR, year);
    	cal.set(Calendar.MONTH, month - 1);
    	cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));  
        return cal.getTime();
    }
    /**
     * 获取本周开始时间（以周一为开始时间）
     * @param weekOfDay Calendar 周
     * @param dateStr
     * @return
     * @throws ParseException 
     */
    public static Date getWeekStartDate(String dateStr) throws ParseException{
		Calendar week = Calendar.getInstance();
		week.setTime(DateUtil.yyyyMMdd.parse(dateStr));
		week.setFirstDayOfWeek(Calendar.MONDAY);
		// 周一为开始时间
		week.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return week.getTime();
    }
    
    /**
     * 获取本周结束时间（以周日为结束时间）
     * @param weekOfDay Calendar 周
     * @param dateStr
     * @return
     * @throws ParseException 
     */
    public static Date getWeekEndDate(String dateStr) throws ParseException{
		Calendar week = Calendar.getInstance();
		week.setTime(DateUtil.yyyyMMdd.parse(dateStr));
		week.setFirstDayOfWeek(Calendar.MONDAY);
		// 周一为开始时间
		week.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return week.getTime();
    }
    
    /**
     * 日期相加减天数
     * @param date 如果为Null，则为当前时间
     * @param days 加减天数
     * @param includeTime 是否包括时分秒,true表示包含
     * @return
     * @throws ParseException 
     */
    public static Date dateAdd(Date date, int days, boolean includeTime) throws ParseException{
        if(date == null){
            date = new Date();
        }
        if(!includeTime){
            SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.DATE_PATTERN);
            date = sdf.parse(sdf.format(date));
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
    
    /**
     * 时间格式化成字符串
     * @param date Date
     * @param pattern StrUtils.DATE_TIME_PATTERN || StrUtils.DATE_PATTERN， 如果为空，则为yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static synchronized String dateFormat(Date date, String pattern) throws ParseException{
        if(date == null){
        	return "";
        }
    	if(StringUtils.isBlank(pattern)){
            pattern = DateUtil.DATE_PATTERN;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
    
    /**
     * 字符串解析成时间对象
     * @param dateTimeString String
     * @param pattern StrUtils.DATE_TIME_PATTERN || StrUtils.DATE_PATTERN，如果为空，则为yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static synchronized Date dateParse(String dateTimeString, String pattern) throws ParseException{
    	if("".equals(dateTimeString) || dateTimeString == null){
    		return null;
    	}
    	if(StringUtils.isBlank(pattern)){
            pattern = DateUtil.DATE_PATTERN;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateTimeString);
    }
    
    /**
     * 将日期时间格式成只有日期的字符串（可以直接使用dateFormat，Pattern为Null进行格式化）
     * @param dateTime Date
     * @return
     * @throws ParseException
     */
    public static String dateTimeToDateString(Date dateTime) throws ParseException{
        String dateTimeString = DateUtil.dateFormat(dateTime, DateUtil.DATE_TIME_PATTERN);  
        return dateTimeString.substring(0, 10); 
    }
    
    /**
     * 当时、分、秒为00:00:00时，将日期时间格式成只有日期的字符串，
     * 当时、分、秒不为00:00:00时，直接返回
     * @param dateTime Date
     * @return
     * @throws ParseException
     */
    public static String dateTimeToDateStringIfTimeEndZero(Date dateTime) throws ParseException{
        String dateTimeString = DateUtil.dateFormat(dateTime, DateUtil.DATE_TIME_PATTERN);
        if(dateTimeString.endsWith("00:00:00")){
            return dateTimeString.substring(0, 10);
        }else{
            return dateTimeString;
        }
    }
    
    /**
     * 将日期时间格式成日期对象，和dateParse互用
     * @param dateTime Date
     * @return Date 2019-07-26 00:00:00
     * @throws ParseException
     */
    public static Date dateTimeToDate(Date dateTime) throws ParseException{
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    
    /**
     * 将日期时间格式成日期对象，和dateParse互用
     * @param Date 2019-07-26
     * @return dateTime Date 2019-07-26 23:59:59
     * @throws ParseException
     */
    public static Date dateToMaxDateTime(Date dateTime) throws ParseException{
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }
    
    /** 
     * 时间加减小时
     * @param startDate 要处理的时间，Null则为当前时间 
     * @param hours 加减的小时 
     * @return Date 
     */  
    public static Date dateAddHours(Date startDate, int hours) {  
        if (startDate == null) {  
            startDate = new Date();  
        }  
        Calendar c = Calendar.getInstance();  
        c.setTime(startDate);  
        c.set(Calendar.HOUR, c.get(Calendar.HOUR) + hours);  
        return c.getTime();  
    }
    
    /**
     * 时间加减分钟
     * @param startDate 要处理的时间，Null则为当前时间 
     * @param minutes 加减的分钟
     * @return
     */
    public static Date dateAddMinutes(Date startDate, int minutes) {  
        if (startDate == null) {  
            startDate = new Date();  
        }  
        Calendar c = Calendar.getInstance();  
        c.setTime(startDate);  
        c.set(Calendar.MINUTE, c.get(Calendar.MINUTE) + minutes);  
        return c.getTime();  
    }
    
    /**
     * 时间加减秒数
     * @param startDate 要处理的时间，Null则为当前时间 
     * @param minutes 加减的秒数
     * @return
     */
    public static Date dateAddSeconds(Date startDate, int seconds) {  
        if (startDate == null) {  
            startDate = new Date();  
        }  
        Calendar c = Calendar.getInstance();  
        c.setTime(startDate);  
        c.set(Calendar.SECOND, c.get(Calendar.SECOND) + seconds);  
        return c.getTime();  
    }

    /** 
     * 时间加减天数 
     * @param startDate 要处理的时间，Null则为当前时间 
     * @param days 加减的天数 
     * @return Date 
     */  
    public static Date dateAddDays(Date startDate, int days) {  
        if (startDate == null) {  
            startDate = new Date();  
        }  
        Calendar c = Calendar.getInstance();  
        c.setTime(startDate);  
        c.set(Calendar.DATE, c.get(Calendar.DATE) + days);  
        return c.getTime();  
    }
    
    /** 
     * 时间加减月数
     * @param startDate 要处理的时间，Null则为当前时间 
     * @param months 加减的月数 
     * @return Date 
     */  
    public static Date dateAddMonths(Date startDate, int months) {  
        if (startDate == null) {  
            startDate = new Date();  
        }  
        Calendar c = Calendar.getInstance();  
        c.setTime(startDate);  
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) + months);  
        return c.getTime();  
    }
    
    /** 
     * 时间加减年数
     * @param startDate 要处理的时间，Null则为当前时间 
     * @param years 加减的年数 
     * @return Date 
     */  
    public static Date dateAddYears(Date startDate, int years) {  
        if (startDate == null) {  
            startDate = new Date();  
        }  
        Calendar c = Calendar.getInstance();  
        c.setTime(startDate);  
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) + years);  
        return c.getTime();  
    }  
    
    /** 
     * 时间比较（如果myDate>compareDate返回1，<返回-1，相等返回0） 
     * @param myDate 时间 
     * @param compareDate 要比较的时间 
     * @return int 
     */  
    public static int dateCompare(Date myDate, Date compareDate) {  
        Calendar myCal = Calendar.getInstance();  
        Calendar compareCal = Calendar.getInstance();  
        myCal.setTime(myDate);  
        compareCal.setTime(compareDate);  
        return myCal.compareTo(compareCal);  
    }
    
    /**
     * 获取两个时间中最小的一个时间
     * @param date
     * @param compareDate
     * @return
     */
    public static Date dateMin(Date date, Date compareDate) {
        if(date == null){
            return compareDate;
        }
        if(compareDate == null){
            return date;
        }
        if(1 == dateCompare(date, compareDate)){
            return compareDate;
        }else if(-1 == dateCompare(date, compareDate)){
            return date;
        }
        return date;  
    }
    
    /**
     * 获取两个时间中最大的一个时间
     * @param date
     * @param compareDate
     * @return
     */
    public static Date dateMax(Date date, Date compareDate) {
        if(date == null){
            return compareDate;
        }
        if(compareDate == null){
            return date;
        }
        if(1 == dateCompare(date, compareDate)){
            return date;
        }else if(-1 == dateCompare(date, compareDate)){
            return compareDate;
        }
        return date;  
    }
    
    /**
     * 获取两个日期（不含时分秒）相差的天数，不包含今天
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException 
     */
    public static int dateBetween(Date startDate, Date endDate) throws ParseException {
        Date dateStart = dateParse(dateFormat(startDate, DATE_PATTERN), DATE_PATTERN);
        Date dateEnd = dateParse(dateFormat(endDate, DATE_PATTERN), DATE_PATTERN);
        return (int) ((dateEnd.getTime() - dateStart.getTime())/1000/60/60/24); 
    }
    
    /**
     * 获取两个日期（不含时分秒）相差的天数，包含今天
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException 
     */
    public static int dateBetweenIncludeToday(Date startDate, Date endDate) throws ParseException {  
        return dateBetween(startDate, endDate) + 1;
    }
    
    /**
     * 获取日期时间的年份，如2017-02-13，返回2017
     * @param date
     * @return
     */
    public static int getYear(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }
    
    /**
     * 获取日期时间的月份，如2017年2月13日，返回2
     * @param date
     * @return
     */
    public static int getMonth(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }
    
    /**
     * 获取日期时间的第几天（即返回日期的dd），如2017-02-13，返回13
     * @param date
     * @return
     */
    public static int getDate(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);
        return cal.get(Calendar.DATE);
    }
    
    /**
     * 获取日期时间当月的总天数，如2017-02-13，返回28
     * @param date
     * @return
     */
    public static int getDaysOfMonth(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DATE);
    }
    
    /**
     * 获取日期时间当年的总天数，如2017-02-13，返回2017年的总天数
     * @param date
     * @return
     */
    public static int getDaysOfYear(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
    }
    
    /**
     * 根据时间获取当月最大的日期
     * <li>2017-02-13，返回2017-02-28</li>
     * <li>2016-02-13，返回2016-02-29</li>
     * <li>2016-01-11，返回2016-01-31</li>
     * @param date Date
     * @return
     * @throws Exception 
     */
    public static Date maxDateOfMonth(Date date) throws Exception {
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);
        int value = cal.getActualMaximum(Calendar.DATE);
        return dateParse(dateFormat(date, MONTH_PATTERN) + "-" + value, null);
    }
    
    /**
     * 根据时间获取当月最小的日期，也就是返回当月的1号日期对象
     * @param date Date
     * @return
     * @throws Exception 
     */
    public static Date minDateOfMonth(Date date) throws Exception {
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);
        int value = cal.getActualMinimum(Calendar.DATE);
        return dateParse(dateFormat(date, MONTH_PATTERN) + "-" + value, null);
    }
    
    /** 
     * 获取当前日期是星期几<br> 
     *  
     * @param dt 
     * @return 当前日期是星期几 
     */  
    public static String getWeekOfDate(Date dt) {  
        String[] weekDays = {"日", "一", "二", "三", "四", "五", "六"};  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(dt);  
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;  
        if (w < 0)  
            w = 0;  
        return weekDays[w];  
    }
    
    
    /**
     * 获取2个日期之间周六，周日的天数
     * @param startDate
     * @param endDate
     * @param format
     * @return
     * @author zhaigx
     * @date 2013-3-13
     */
    public static int getSundayNum(String startDate, String endDate, String format) {
        List yearMonthDayList = new ArrayList();
        Date start = null, stop = null;
        try {
            start = new SimpleDateFormat(format).parse(startDate);
            stop = new SimpleDateFormat(format).parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (start.after(stop)) {
            Date tmp = start;
            start = stop;
            stop = tmp;
        }
        //将起止时间中的所有时间加到List中
        Calendar calendarTemp = Calendar.getInstance();
        calendarTemp.setTime(start);
        while (calendarTemp.getTime().getTime() <= stop.getTime()) {
            yearMonthDayList.add(new SimpleDateFormat(format)
            .format(calendarTemp.getTime()));
            calendarTemp.add(Calendar.DAY_OF_YEAR, 1);
        }
        Collections.sort(yearMonthDayList);
        int num=0;//周六，周日的总天数
        int size=yearMonthDayList.size();
        int week=0;
        for (int i = 0; i < size; i++) {
            String day=(String)yearMonthDayList.get(i);
            week=getWeek(day, format);
            if (week==0) {//周六，周日
                num++;
            }
        }
        return num;
    }
    /**
     * 获取某个日期是星期几
     * @param date
     * @param format
     * @return 0-星期日
     * @author zhaigx
     * @date 2013-3-13
     */
    public static int getWeek(String date, String format) {
        Calendar calendarTemp = Calendar.getInstance();
        try {
            calendarTemp.setTime(new SimpleDateFormat(format).parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int i = calendarTemp.get(Calendar.DAY_OF_WEEK);
        int value=i-1;//0-星期日
        //        System.out.println(value);
        return value;
    }
    
    public static void main(String[] args) throws Exception {
//    	int sundays = getSundayNum("2018-05-10", "2019-06-23", "yyyy-MM-dd");
//    	System.out.println(sundays);
//    	Date nowDate = yyyyMMdd.parse("2018-05-20");
//    	Calendar cal = Calendar.getInstance();
//    	cal.setTime(nowDate);
//    	if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
//            System.out.println("true");
//        } else {
//        	System.out.println("false");
//        }
//    	Date startDate = yyyyMMdd.parse("2018-05-19");
//    	Date endDate = yyyyMMdd.parse("2018-05-19");
//    	if(startDate.getTime() == endDate.getTime()){
//    		System.out.println("相等");
//    	} else {
//    		System.out.println("不想等");
//    	}
//    	if(nowDate.after(startDate) && nowDate.before(endDate)){
//			System.out.println("在范围内");
//		} else {
//			System.out.println("不在范围内");
//		}
    	
//    	System.out.println(yyyyMMdd.format(getFirstSundayOfMonth(2018, 7)));
    	
//    	//当前日期
//		Date nowTime = new Date();
//    	Calendar cal = Calendar.getInstance();
//    	cal.setTime(nowTime);
//    	cal.set(Calendar.MONTH, 11 - 1);
//    	cal.set(Calendar.DAY_OF_MONTH, 1);
//    	System.out.println("当前日期：" + yyyyMMdd.format(cal.getTime()));
//    	System.out.println("当前月有"+ cal.getActualMaximum(Calendar.DAY_OF_MONTH) +"天");
//		//获取当前日期所在的四个周的周日，其中当前日期的周日是第三个，第四个是下周周日
//		List<String> weekList = get4Or5Weeks(cal.getTime());
//		for (String week : weekList) {
//			System.out.println(week);
//		}
		
    	Calendar cal = Calendar.getInstance();
    	int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    	int weekNo = 0;
    	if((cal.get(Calendar.DAY_OF_MONTH) + 6) <= maxDay){
    		weekNo = cal.get(Calendar.WEEK_OF_MONTH);
		} else {
			weekNo = cal.get(Calendar.WEEK_OF_MONTH) - 1;
		}
    	System.out.println(weekNo);
    }
    
    public static synchronized List<String> get4Or5Weeks(Date time) throws ParseException {
    	List<String> weekList = new ArrayList<String>();
    	Calendar currentDate = Calendar.getInstance();
    	currentDate.setTime(time);
    	int maxDay = currentDate.getActualMaximum(Calendar.DAY_OF_MONTH);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置时间格式
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.setFirstDayOfWeek(Calendar.SATURDAY);//设置一个星期的第一天，这是设为星期天，但是按中国的习惯一个星期的第一天是星期一
		int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		cal.add(Calendar.DATE, -7);
		String firstSunday = sdf.format(cal.getTime());
		cal.add(Calendar.DATE, 7);
		String currentSunday = sdf.format(cal.getTime());
		cal.add(Calendar.DATE,7);
		String lastSunday =sdf.format(cal.getTime());
		cal.add(Calendar.DATE,7);
		String lastSunday2 =sdf.format(cal.getTime());
		cal.add(Calendar.DATE,7);
		String lastSunday3 =sdf.format(cal.getTime());
		String lastSunday4 = null;
		if((cal.get(Calendar.DAY_OF_MONTH) + 6) <= maxDay){
			cal.add(Calendar.DATE, 7);
			lastSunday4 = sdf.format(cal.getTime());
			cal.add(Calendar.DATE, 7);
		}

		weekList.add(firstSunday);
		weekList.add(currentSunday);
		weekList.add(lastSunday);
		weekList.add(lastSunday2);
		weekList.add(lastSunday3);
		if(lastSunday4 != null){
			weekList.add(lastSunday4);
		}
		return weekList;
	}
    
    /**
     * 获取每个月第一个星期日的日期
     * 
     * @param year 年份
     * @param month 月份
     * @return Date 日期
     */
    public static Date getFirstSundayOfMonth(int year, int month)
    {
        Calendar cal = Calendar.getInstance();
     
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, 1); // 设为第一天
     
        while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY)
        {
            cal.add(Calendar.DATE, 1);
        }
     
        return cal.getTime();
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
	
	
  public static	Calendar now = Calendar.getInstance();
	
   /**
    * 获取当前时间前30天 从 0:00:00开始
    * @return
    */
	public static String getDate30() {
		
		String endDate = yyyyMMdd.format(now.getTime());
	        now.add(Calendar.DAY_OF_MONTH, -30);
		/*LocalDateTime now = LocalDateTime.now();
        now = now.minus(30, ChronoUnit.DAYS);*/
        return endDate+" 0:00:00";
	}
	/**
	 * 获取当前时间的前7天 从 0:00:00开始
	 * @return yyyyMMddHHmmss
	 */
	public static String getDate7() {
		    now.setTime(new Date());
		    now.add(Calendar.DATE, - 7);
	        Date date = now.getTime();
	        String day = yyyyMMdd.format(date);
	        return day+" 0:00:00";
	}
	/**
	 * 获取当前时间 年月日 时分秒
	 * @return yyyyMMddHHmmss
	 */
	public static String getDateYyyyMMddHHmmss() {
		String date = yyyyMMddHHmmss.format(new Date());
		return date;
	}
	/**
	 * 获取当前时间 年月日
	 * @return
	 */
	public static String getDateYyyyMMdd() {
		String date = yyyyMMdd.format(new Date());
		return date;
	}
	/**
	 * 获取当前时间的后一天
	 * @return yyyyMMddHHmmss
	 */
	public static String getDateAdd(){
		now.add(Calendar.DAY_OF_MONTH, 1);
		String dateAdd = yyyyMMdd.format(now.getTime());
		return dateAdd;
	}
	/**
	 * 过去一个月
	 * @return yyyyMMdd
	 */
	public static String getDateMONTHOne() {
		now.setTime(new Date());
		now.add(Calendar.MONTH, -1);
        Date m = now.getTime();
        String mon  = yyyyMMdd.format(m);
        return mon ;
	}
	/**
	 * 过去一年
	 * @return
	 */
	public static String getDateYEAR() {
		now.setTime(new Date());
		now.add(Calendar.YEAR, -1);
        Date y =now.getTime();
        String year = yyyyMMdd.format(y);
        return year;
        
	}
	/**
	 * 获取当前时间
	 * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	 * @throws ParseException 
	 */
	public static Date getNowDateYyyyMMddHHmmss() throws ParseException {
		String date = yyyyMMddHHmmss.format(new Date());
		Date parse = yyyyMMddHHmmss.parse(date);
		return parse;
	}
	
	/**
	 * 获取当前时间
	 * @return 返回时间类型 yyyy-MM-dd 
	 * @throws ParseException 
	 */
	public static Date getNowDateYyyyMMdd() throws ParseException {
		String date = yyyyMMdd.format(new Date());
		System.out.println(date);
		Date parse = yyyyMMdd.parse(date);
		return parse;
	}
	/**
	 * 获取当前月的第一天
	 * @return
	 */
	public static String getMONTHFirst() {
		//本月
		 now.add(Calendar.MONTH, 0);
		//设置为1号为本月第一天 
		 now.set(Calendar.DAY_OF_MONTH,1);
	     String first = yyyyMMdd.format(now.getTime());
		return first;
		
	}
	public static String getMONTHLast() {
		//设置当月为最后一天
		now.set(Calendar.DAY_OF_MONTH, now.getActualMaximum(Calendar.DAY_OF_MONTH));
	    String last = yyyyMMdd.format(now.getTime());
	  return last+" 23:59:59";
		
	}
	
	
}
