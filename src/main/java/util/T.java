package util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * @Author: Niu Lai Yun
 * @Description: 
 * @Date 2019年10月8日 下午12:45:02
 */
public class T {
   public static void main(String[] args) {
	/*ArrayList<String> arrayList=new ArrayList<>();
	arrayList.add("小王,98");
	arrayList.add("小李,95");
	arrayList.add("小天,87");
	List<Integer> collect = arrayList.stream().map(s->s.split(",")[1]).map(Integer::parseInt).filter(n-> n>90).collect(Collectors.toList());*/
	   
	   List<Stu> stus=new ArrayList<>();
	   stus.add(new Stu(1, "一级"));
	   stus.add(new Stu(2, "二级"));
	   stus.add(new Stu(3, "三级"));
	   stus.add(new Stu(1, "一级"));
	   stus.add(new Stu(2, "二级"));
	   stus.add(new Stu(3, "三级"));
	   String _1="一级";
	   String _2="二级";
	   String _3="三级";
	   for(int i=0;i<stus.size();i++) {
		   for(int j=0;j<stus.size();j++) {
			   if(stus.get(j).equals(_3)) {
				   for(int n=0;n<stus.size();n++) {
					   
				   }
				   }
			   }
		   }
	   
	  
	   
}
   @Test
   public void test() {
	   double num1 = 7d;  
	   double num2=9d;
	   double num3=(num2-num1)/num1*100;
	   
	   DecimalFormat decimalFormat = new DecimalFormat("0");
       decimalFormat.setRoundingMode(RoundingMode.UP); // 进一法
	   System.out.println(decimalFormat.format(num3));
	
   }
   
   
   public static String percnet(double d,double e){
		double p = d/e;
		DecimalFormat nf = (DecimalFormat) NumberFormat.getPercentInstance();
		nf.applyPattern("00%"); //00表示小数点2位
		nf.setMaximumFractionDigits(2); //2表示精确到小数点后2位
		return nf.format(p);
	}
   @Test
   public void test01() {
	   Stu st=new Stu(1, "1,2,3,4");
	   Stu st1=new Stu(1, "5,6,7,8");
	   List<Stu> list=new ArrayList<>();
	   list.add(st);
	   list.add(st1);
	   for (Stu stu : list) {
		stu.setId(2);
	}
	   System.out.println(list.toString());
	  
   }
	


}
