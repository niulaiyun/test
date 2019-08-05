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

public class Lambda_map {
	public static void main(String[] args) {
		//或缺一个String 类型的stream流
	        Stream<String> stream = Stream.of("1","2","3");	
	        //使用map方法把字符类型的，转换成Integer类型的整数
	        Stream<Integer> inte = stream.map((String s)->{return Integer.parseInt(s);});
	        inte.forEach(s->System.out.println(s));
	}
	
	
}
