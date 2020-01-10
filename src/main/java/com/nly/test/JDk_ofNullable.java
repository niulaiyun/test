package com.nly.test;

import java.util.Optional;

import org.junit.Test;

public class JDk_ofNullable {
    @Test
	public void test() {
		Student stu=null;
		//Student orElse = Optional.ofNullable(stu).orElse(stu=new Student(1, "张三"));
		//System.out.println(orElse);
	}
}
