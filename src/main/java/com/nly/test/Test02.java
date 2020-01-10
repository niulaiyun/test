package com.nly.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

public class Test02 {

	
	@Test
	public void test() {
		/*List<Student> li=new ArrayList<Student>();
		li.add(new Student(1, "3"));
		li.forEach(obj->obj.setName("2"));
		li.forEach(obj->System.out.println(obj.getName()));
		
		System.out.println(UUID.randomUUID());*/
	}
	
	@Test
	 public void getUUIDInOrderId(){
	        Integer orderId=UUID.randomUUID().toString().hashCode();
	        orderId = orderId < 0 ? -orderId : orderId; //String.hashCode() 值会为空
	        System.out.println(orderId);
	    }
}
