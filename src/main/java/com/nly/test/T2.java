package com.nly.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	     row.add(map);
	     row.add(map2);
	     row.add(map5);
	     rows.add(map);
	     rows.add(map2);
	     row.removeAll(rows);
	     System.out.println(row);

	}

}
