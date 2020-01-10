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

public class Lambda_lianxi {
	public static void main(String[] args) {
		//第一个队伍
		    ArrayList<String> one=new ArrayList<>();
		    one.add("迪丽热巴");
		    one.add("宋远桥");
		    one.add("苏星河");
		    one.add("石破天");
		    one.add("石中玉");
		    one.add("老子");
		    one.add("庄子");
		    one.add("洪七公");
		    List<String> collect = one.stream().skip((2-1)*2).limit(2).collect(Collectors.toList());
		    for (String str : collect) {
				System.out.println(str);
			}
		   /* //1条件第一个队伍只要名字为3个字的成员姓名；存储到一个新的集合中
		    //2 第一个队伍只选前三个人存储到一个新的集合中
		    Stream<String> oneStream = one.stream().filter(s->s.length()==3).limit(3);
		    
		    ArrayList<String> two=new ArrayList<>();
		    two.add("古力娜扎");
		    two.add("张无忌");
		    two.add("赵丽颖");
		    two.add("张三丰");
		    two.add("尼古拉斯找死");
		    two.add("张天爱");
		    two.add("张二狗");
		    //3第二个队伍前只选姓张的成员姓名;存储到一个新的集合中
		    //4 第二个队伍之后不要2个人;存储到一个新的集合中
		    Stream<String> twoStream = two.stream().filter(s->s.startsWith("张")).skip(2);
		    //将两个队伍合并一个
		    //根据姓名创建Person对象
		    //打印整个队伍Perosn对象信息
		     Stream.concat(oneStream, twoStream).map(name->new Person(name)).forEach(p->System.out.println(p));*/
		    
	}
	
	
}
