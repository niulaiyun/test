package com.nly.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
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
		list.add(new Student(1,"张三"));
		list.add(new Student(2,"李四"));
		list.add(new Student(3,"王五"));
		 Map<Integer, List<Student>> collects = list.stream().filter(student->student.getName().equals("张三"))
				.collect(Collectors.groupingBy(Student::getId));
		 //获取map的键用set接收
		 Set<Integer> keySet = collects.keySet();
		 keySet.stream();
		 //获取value
		 Collection<List<Student>> values = collects.values();
	       //  values.stream().collect(Collectors.tol);
	       
		/*  for (Integer integer : keySet) {
			System.out.println(integer);
		}*/
		//获取
		 //返回对象的某一个集合属性
		 /*List<String> collect = list.stream().map(Student::getName).collect(Collectors.toList());
		 collect.stream().forEach(obj->System.out.println(obj));*/
	   //collect.stream().forEach(Student::getName);
	}
	
}
