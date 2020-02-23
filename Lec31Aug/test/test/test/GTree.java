import  java.util.*;
class  GTree{

static  class Node{
    int data;
    ArrayList<Node>  child ;
    Node(int data){
        this.data = data;
        child =  new  ArrayList<>();
    }
}

    public static void main(String[] args) {
         int arr[] = {10,20,30,-1,80,-1,40 ,-1,-1,50,100,-1,90,-1,-1,60,110,-1,120,-1,130,200,-1,-1};
         Node  head = makeTree(arr);
         display(head);  
       // removeLeafNodes(head);
        display(head);  
    }


    static  boolean  isSymmetric(Node  node1 ,  Node  node2){
        if(node1.child.size()!=  node2.child.size() ||  node1.data!=node2.data)return  false;
        for(int  i =0 , j =  node1.child.size()-1 ;i<j;i++,j--){
            Node  ch1 =node1.child.get(i);
            Node  ch2 =node2.child.get(j);
            if(!isSymmetric(ch1 , ch2))return  false;
        }
        return  true;
    }

    static  boolean  isMirror(Node  node1 ,  Node  node2){
        if((node1.child.size()!=node2.child.size()) ||  (node1.data!=node2.data ))return  false;
            boolean  ans =   true;
        for(int  i=0,j=node2.child.size()-1;i<node1.child.size()-1 &&  j>=0 ;j--,i++)
        {
            Node  c1 =  node1.child.get(i);
            Node  c2 =  node2.child.get(j);
            if( (c1.data !=  c2.data )  || !isMirror(c1 , c2)) return  false;
        }
     return   true;     
    }

    static  Node    removeLeafNodes(Node  node){
        if(node!=  null &&  node.child.size()==0) return  null;
        
        ArrayList<Node>   ch =  new  ArrayList<>();

        for(Node  cnode : node.child){              
                Node  an =  removeLeafNodes(cnode);
                if(an!=null)
                ch.add(an);
        }
        node.child.addAll(ch);
        return node; 
    }


    

    static  void  zigzagTraversal(Node  node ){
        Stack<Node>  st1 =  new  Stack<>();
        Stack<Node>  st2 =  new  Stack<>();
        st1.add(node);
        while(!st1.isEmpty() || !st2.isEmpty() ){
            while(!st1.isEmpty()){
                Node  node =  st1.pop();
                System.out.print(node.data);
                for(int  i = node.child.size()-1 ; i>=0 ; i--)
                    st2.add(node.child.get(i));                
            }
            while(!st2.isEmpty()){
                Node  node =  st2.pop();
                System.out.print(node.data);
                for(int  i = 0 ; i<node.child.size()-1 ; i++)
                    st1.add(node.child.get(i));                
            }
            System.out.println();
        }
    }

    //1.distance  between  nodes 2.LCA 3.Ceil 4. floor  value  5.Zigzag  traversal  in  Generic Tree
    //Heihgt  of  BST from preorder  array ,  inorder  ,postorder 
    // Form  BST from  inorder  , preorder ,postorder  array
    //99. Recover Binary Search Tree

    static  Node  makeTree(int[]  arr){
        Stack<Node>  st=  new  Stack<>();
        int  i =0 ;
        while(st.size()!=0){
            if(arr[i]!=-1){
                
                st.add(new  Node(arr[i]));
            }else{
                Node  node =  st.pop();
                System.out.print(node.data);
                node.child.add(st.peek());
            }
            i++;
        }
        return  null;
    }


    
        

    static  void  display(Node  node){
        if(node == null)return;
        System.out.println(node.data);
        for(Node  n :  node.child){
            display(n);
        }        
    }


}
