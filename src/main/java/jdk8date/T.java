package jdk8date;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @Author: Niu Lai Yun
 * @Description: 
 * @Date 2019年10月28日 下午3:50:18
 */
public class T {
    public static void main(String[] args) {
   List<String> list=new ArrayList<String>();
    list.add("a");
    System.out.println(isNotEmptyCollection(list));
    Set<String> set=new HashSet<>();
    set.add("a");
    System.out.println(isNotEmptyCollection(set));
      
	}
    
    /**
     * 判断集合是否为空 适用List set 不为空
     * @param list
     * @return
     */
    public static boolean isNotEmptyCollection(Collection<?> list) {
    	return !isEmptyCollection(list);
    }
    /**
     * 判断集合是否为空 适用List set 为空
     * @param list
     * @return
     */
    public static boolean isEmptyCollection(Collection<?> list) {
    	boolean flag=false;
    	if(list==null||list.size()==0||"[]".equals(list)) {
    		flag=true;
    	}
    	return flag;
    }
}
