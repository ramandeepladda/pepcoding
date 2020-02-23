
// Java program to illustrate 
// overriding of equals and 
// hashcode methods 
import java.io.*; 
import java.util.*; 


class TestT {


  static class  Node{
	  Node  left  , right;
	  int data; 
	  Node(int data){
		this.data =  data ; 
		right  =  left =  null;
	  }
  }



  static  int maxDepth(Node  node){
	  if(node==null)
	  return  0 ; 
	  return  Math.max(maxDepth(node.left) ,maxDepth(node.right)) +1;
  }
  /* Driver program to test above functions */
  public static void main(String[] args)  
  { 
	  Node  root = new Node(1); 
	  root.left = new Node(2); 
	  root.right = new Node(3); 
	  root.left.left = new Node(4); 
	  root.left.right = new Node(5); 
 
	  System.out.println("Height of tree is : " +  maxDepth(root)); 
  }

}