import  java.util.*;
class  BTree{

    static   class  Node{
        Node  left ,  right  ;
        int  data ; 
          Node(int data){
              this.data  =  data;
              left = right =  null;
          }
    }



    static  void  bottomView(Node  root ,  HashMap<Integer , Integer> map ,Queue<Node>  q , int hd){
        if(root == null)
        return;
        while(!q.isEmpty()){
            Node  node =  q.poll();
            
        }
     
    }

    static  Node  root; 
    public static void main(String[] args) {
        root = new Node(20); 
        root.left = new Node(8); 
        root.right = new Node(22); 
        root.left.left = new Node(5); 
        root.left.right = new Node(3); 
        root.right.left = new Node(4); 
        root.right.right = new Node(25); 
        root.left.right.left = new Node(10); 
        root.left.right.right = new Node(14);
        HashMap<Integer,Integer> map =  new HashMap<>(); 
        Queue<Node>  q =  new  LinkedList<>();
        bottomView(root , map, q,0);    
        for(Map.Entry<Integer , Integer>   entry  : map.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}