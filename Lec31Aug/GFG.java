// Java program to find count of distinct nodes 
// on a path with maximum distinct nodes. 
import java.util.*; 
class GFG 
{ 

// A node of binary tree 
static class Node 
{ 
	int data; 
	Node left, right; 
}; 

// A utility function to create a new Binary 
// Tree node 
static Node newNode(int data) 
{ 
	Node temp = new Node(); 
	temp.data = data; 
	temp.left = temp.right = null; 
	return temp; 
} 
  
  
  static  int largestUinquePath(Node  node ,ArrayList<Integer>  ar){
  		if(node ==null)
          return   0 ;
        
    if(node.left ==null &&  node.right ==null){
        if(!ar.contains(node.data))
            ar.add(node.data);
            ArrayList<Integer> res= new ArrayList<>();
            res.addAll(ar);
        return   res.size();
    }
    
    ArrayList<Integer> res= new ArrayList<>();
    res.addAll(ar);
    if(!res.contains(node.data))
       res.add(node.data);
    
    return  Math.max(largestUinquePath(node.left , res ) ,largestUinquePath(node.right , res));
  }	

// Driver Code 
public static void main(String[] args) 
{ 
  /*  1
    /    \
   2      3
  / \    / \
 4   5  6   3
         \   \
          8   9 
          1

*/  Node root = newNode(1); 
	root.left = newNode(2); 
	root.right = newNode(3); 
	root.left.left = newNode(4); 
	root.left.right = newNode(5); 
	root.right.left = newNode(6); 
	root.right.right = newNode(7); 
	root.right.left.right = newNode(8); 
	root.right.right.right = newNode(9); 

	System.out.println(largestUinquePath(root , new ArrayList<>()));	 
} 
} 

// This code is contributed by Princi Singh 
