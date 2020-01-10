package thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.platform.commons.util.StringUtils;
/**
 * 使用递归查询菜单
 * @author Administrator
 *
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
          Menu menu=new Menu();
          menu.setId(1);
          menu.setPreantId(null);
      
        Menu menu1=new Menu();
        menu1.setId(2);
        menu1.setPreantId(1);
    
   
        Menu menu2=new Menu();
        menu2.setId(3);
        menu2.setPreantId(2);

     
        
        Menu menu4=new Menu();
        menu4.setId(4);
        menu4.setPreantId(3);

    
        
        List<Menu> list=new ArrayList<>();
        list.add(menu);
        list.add(menu1);
        list.add(menu2);
        list.add(menu4);
	    // 最后的结果
	    List<Menu> menuList = new ArrayList<Menu>();
	    // 先找到所有的一级菜单
	    for(int i=0;i<list.size();i++) {
			// 一级菜单没有parentId
	    	if(list.get(i).getPreantId()==null) {
	    		menuList.add(list.get(i));
	    	}
		}
		for (Menu menu3 : menuList) {
			menu3.setChildren( getChild(menu3.getId(), list));
		}
	
	
       
    }
    
    
    public static List<Menu> getChild(Integer id, List<Menu> rootMenu) {
    	//子菜单
    	List<Menu> childList=new ArrayList<>();
    	 for (Menu menu : rootMenu) {
    		  // 遍历所有节点，将父菜单id与传过来的id比较
    		 if(menu.getPreantId()!=null) {
    			 if(menu.getPreantId()==id) {
    				 childList.add(menu);
    			 }
    		 }
		}
    	 // 把子菜单的子菜单再循环一遍
    	 for (Menu menu : childList) {
			//if(menu.getUrl()==null) {
				// 递归
	            menu.setChildren(getChild(menu.getId(), rootMenu));
			//}
		}
    	// 递归退出条件
 	    if (childList.size() == 0) {
 	        return null;
 	    }
    	return childList;
    }
  
}
