package com.nly.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class Lambda {
	/**
	 * 使用1.8使用Stream流的方式，遍历集合，对集合中的数据进行过滤
	 * Stream是1.8以后出现的
	 * 关注的是做什么，而不是怎么做
	 * 使用 .collect(Collectors.toList())返回过滤之后的集合
	 */
	@Test
   public void test() {
	  List<String> list=new ArrayList<String>();
	  list.add("张三");
	  list.add("李四");
	  list.add("王五五");
	  list.add("张三丰");
	  //对list集合中的元素过滤,只要以张开头的元素，存储到一个新的集合中
	  //对list集合进行过滤，只要为长度3的人，存储到新的集合中
	  List<String> collect = list.stream().
	     filter(name->name.startsWith("张"))
	    .filter(name->name.length()==3)
	    .collect(Collectors.toList());
			       
	  collect.forEach(name->System.out.println(name));
   }
	@Test
	public void test2() {
		
		List<Student> list=new ArrayList<>();
		list.add(new Student(1,"张三",19));
		list.add(new Student(2,"李四",18));
		list.add(new Student(3,"王五",17));
		//List<Student> collec = list.stream().filter(student->student.getName().equals("张三")).collect(Collectors.toList());
		
		List<List<Object>>  str=new ArrayList<>();
		
		list.stream().collect(Collectors.toList()).forEach(s-> {
			List<Object>  st=new ArrayList<>();
			st.add(s.getId());
			st.add(s.getName());
		      str.add(st);      
	    });
		
           for (List<Object> list2 : str) {
        	    System.out.print(list2.get(0)+""+ list2.get(1));
			    System.out.println();
		     }
		
		
		/* Map<Integer, List<Student>> map = list.stream().filter(student->student.getName().equals("张三"))
				.collect(Collectors.groupingBy(Student::getId));*/
		 //获取map的键用set接收
		//Set<Integer> keySet = map.keySet();
		//keySet.stream();
		 //获取value
		 //Collection<List<Student>> values = map.values();
	      //  values.stream().collect(Collectors.toList());
	       //获取键值对的映射关系
	    // Set<Entry<Integer, List<Student>>> entrySet = map.entrySet();
	       // entrySet.stream();
		//获取
		 //返回对象的某一个集合属性
		// List<String> collect = list.stream().map(Student::getName).collect(Collectors.toList());
		// collect.stream().forEach(obj->System.out.println(obj));
	   //collect.stream().forEach(Student::getName);
	}
	@Test
	public void test3() {
		//数组转换stream流转换程集合
		Stream<Integer> of = Stream.of(1,2,3,4,5);
		List<Integer> collect = of.collect(Collectors.toList());
	}
	/*@Test
	public void test4() {
		List<Student> list=new ArrayList<>();
		list.add(new Student(1,"张三"));
		list.add(new Student(2,"李四"));
		list.add(new Student(3,"王五"));
		list.stream().forEach(s->{
			if(s.getName().equals("张三")) {
				s.setName("流");
				System.out.println(s.getName());
			}
			
		});
	}*/
}
