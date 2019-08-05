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

public class Lambda_concat {
	public static void main(String[] args) {
		     //或缺一个String 类型的stream流
	        Stream<String> stream = Stream.of("张三丰","张翠山","赵敏","周芷若","张无忌");
	        String[] arr= {"美羊羊","喜洋洋","懒洋洋","灰太狼","红太狼"};
	        Stream<String> steam2 = Stream.of(arr);
	        //把两个流合并到一个流
	        Stream<String> concat = Stream.concat(stream, steam2);
	        //遍历concat流
	        concat.forEach(s->System.out.println(s));
	}
	
	
}
