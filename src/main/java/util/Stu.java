package util;
/**
 * @Author: Niu Lai Yun
 * @Description: 
 * @Date 2019年10月8日 下午12:56:27
 */

public class Stu {
  public Integer id;
  public String name;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Stu(Integer id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public Stu() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Stu [id=" + id + ", name=" + name + "]";
}
  
}
