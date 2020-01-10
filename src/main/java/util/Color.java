package util;
/**
 * @Author: Niu Lai Yun
 * @Description: 
 * @Date 2019年10月9日 下午12:26:20
 */
public enum Color {
	Red("红色",1),Green("绿色",2);
 public  String name;
 public int index;
	private Color(String name, int index) {
		this.name = name;
		this.index = index;
	}
  
}
