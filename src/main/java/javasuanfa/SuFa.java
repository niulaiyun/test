package javasuanfa;
/**
 * @Author: Niu Lai Yun
 * @Description: 
 * @Date 2019年10月25日 下午2:45:34
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class SuFa {
public static void main(String[] args) {
	List<String> users=new ArrayList<>();
	users.add("张三");
	users.add("李四");
	users.add("王五");
	List<String> tasks=new ArrayList<>();
	tasks.add("1");
	tasks.add("2");
	tasks.add("3");
	tasks.add("4");
	tasks.add("5");
	tasks.add("6");
	     Map<String, List<String>> allotOfProportion = allotOfRandom(users, tasks);
	     allotOfProportion.forEach((k, v) -> {
				System.out.println(k+"分配的任务"+v.toString());
			});
}
/* 
 * 随机分配 
 */  
	public static Map<String, List<String>> allotOfRandom(List<String> users,List<String> tasks){
		Map<String, List<String>> allot=new ConcurrentHashMap<>();//保存分配信息
		if(users!=null&&users.size()>0&&tasks!=null&&tasks.size()>0) {
			for(int i=0;i<tasks.size();i++) {
				int r_user=new Random().nextInt(users.size());
				if(allot.containsKey(users.get(r_user))) {
					List<String> list=allot.get(users.get(r_user));
					list.add(tasks.get(i));
					allot.put(users.get(r_user), list);
				}else {
					List<String> list=new ArrayList<String>();
					list.add(tasks.get(i));
					allot.put(users.get(r_user), list);
				}
			}
		}
		return allot;
	}
	 /* 
     * 平均分配 
     */  
    public Map<String,List<String>> allotOfAverage(List<String> users,List<String> tasks){  
        Map<String,List<String>> allot=new ConcurrentHashMap<String,List<String>>(); //保存分配的信息  
        if(users!=null&&users.size()>0&&tasks!=null&&tasks.size()>0){  
            for(int i=0;i<tasks.size();i++){  
                int j=i%users.size();  
                if(allot.containsKey(users.get(j))){  
                    List<String> list=allot.get(users.get(j));  
                    list.add(tasks.get(i));  
                    allot.put(users.get(j), list);  
                }else{  
                    List<String> list=new ArrayList<String>();  
                    list.add(tasks.get(i));  
                    allot.put(users.get(j), list);  
                }  
            }  
        }  
        return allot;  
    }  
    /* 
     * 权重分配 
     */  
    public Map<String,List<String>> allotOfProportion(Map<String,String> users,List<String> tasks){  
            Map<String,List<String>> allot=new ConcurrentHashMap<String,List<String>>(); //保存分配的信息  
            if(users!=null&&users.size()>0&&tasks!=null&&tasks.size()>0){  
                int a=0;//总权重   
                for(Entry<String, String> entry:users.entrySet()){    
                   a+=Integer.parseInt(entry.getValue());    
                }  
                int start=0,end=0;//起始下标 ,结束下标   
                if(a>0){  
                    for(Entry<String, String> entry:users.entrySet()){    
                        List<String> allotTask=new ArrayList<String>();    
                        end+=Integer.parseInt(entry.getValue());//权重累计    
                        for(;start<tasks.size()*end/a;start++){    
                            allotTask.add(tasks.get(start));    
                        }    
                        allot.put(entry.getKey(),allotTask);    
                    }   
                }  
            }  
        return allot;  
    }  

	
}
