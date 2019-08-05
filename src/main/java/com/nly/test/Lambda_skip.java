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

public class Lambda_skip {
	public static void main(String[] args) {
		     //或缺一个String 类型的stream流
	        Stream<String> stream = Stream.of("张三丰","张无忌","周芷若");
	        //skip跳过前几位
	        Stream<String> skip = stream.skip(2);
	        skip.forEach(s->System.out.println(s));
	       // System.out.println(limit.count());
	        
	}
	
	
}
