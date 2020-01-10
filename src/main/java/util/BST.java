package util;
/**
 * @Author: Niu Lai Yun
 * @Description: 
 * @Date 2019年11月11日 下午4:34:22
 */
public class BST<E extends Comparable<E>> {
  
	
	class Node{
	  E e;//节点值
	  Node left;//左节点  也可以叫左子树的根节点
      Node right; //右节点  也可以叫右子树的根节点
	public Node(E e) {
		this.e = e;
		this.left = null;
		this.right = null;
	}
      
      
  }
}
