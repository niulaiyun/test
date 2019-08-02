package com.nly.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Row2Line {

		 @Test
		    public void test() {
		    	
		    	List<List<String>> a=new ArrayList<>();
		    	List<String> b=new ArrayList<>();
		    	             b.add("1");
		    	             b.add("2");
		    	             List<String> c=new ArrayList<>();
		    	             b.add("3");
		    	             b.add("4");
		    	a.add(b);
		    	for (List<String> str: a) {
					  for (String st : str) {
						System.out.println(st);
					}
				}
		    }
			
	}

