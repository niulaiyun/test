package com.nly.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.print.DocFlavor.STRING;

import org.junit.Test;

public class T2 {
	@Test
	public void test01() throws Exception {
		 List<List<Object>> list=new ArrayList<>();
		 
		List<Object> c=new ArrayList<>();
		
		List<List<String>> a=new ArrayList<>();
		List<String> b=new ArrayList<>();
		b.add("1");
		b.add("2");
		a.add(b);
		List<String> b1=new ArrayList<>();
		b1.add("12");
		b1.add("22");
		a.add(b1);
		c.add("原材料");
		c.add("货区");
		c.add(a);
		list.add(c);
      for (List<Object> list2 : list) {
			System.out.println(list2);
		}
		
		
	}
	@Test
	public void test02() {
List<Map<String, Object>> row=new ArrayList<>();
		
		List<Map<String, Object>> rows=new ArrayList<>();
		
		 Map<String, Object> map=new HashMap<String, Object>();
		 map.put("A", "12345");
		 map.put("B", "123456");
		 map.put("C", "1234567");
		 map.put("D", "1234568");
		 Map<String, Object> map2=new HashMap<String, Object>();
		 map2.put("A", "54321");
		 map2.put("B", "654321");
		 map2.put("C", "7654321");
		 map2.put("D", "87654321");
		 
		 Map<String, Object> map5=new HashMap<String, Object>();
		 map5.put("A", "543212");
		 map5.put("B", "6543213");
		 map5.put("C", "76543213");
		 map5.put("D", "876543213");
		 
		 Map<String, Object> map6=new HashMap<String, Object>();
		 map6.put("A", "54321dfsdf2");
		 map6.put("B", "6543213");
		 map6.put("C", "76543213");
		 map6.put("D", "876543213");
		 Map<String, Object> map7=new HashMap<String, Object>();
		 map7.put("A", "54321dfsdf2f");
		 map7.put("B", "6543213");
		 map7.put("C", "76543213");
		 map7.put("D", "876543213");
		 
		 Map<String, Object> map8=new HashMap<String, Object>();
		 map8.put("A", "54321dfsdf2f1");
		 map8.put("B", "6543213");
		 map8.put("C", "76543213");
		 map8.put("D", "876543213");
	     row.add(map);
	     row.add(map2);
	     row.add(map5);
	     row.add(map6);
	     row.add(map7);
	     
	     
	     rows.add(map);
	     rows.add(map2);
	     rows.add(map5);
	     rows.add(map8);
	     List<Map<String, Object>> aa=new ArrayList<>();
	     aa.addAll(row);
	     /*for(Map<String, Object> a:row) {
	    	 aa.add(a);
	     }*/
	    flag:
	    for(int i=0;i<row.size();i++) {
	    	String type=row.get(i).get("A").toString()+row.get(i).get("B").toString();
	    	for(int k=0;k<rows.size();k++) {
		    	String types=rows.get(k).get("A").toString()+rows.get(k).get("B").toString();
		    	if(type.equals(types)) {
					aa.remove(0);
					continue flag;
				}
		    }
	    }
	    System.out.println(aa);
	    
	    
	    
	  
	}


	

}
