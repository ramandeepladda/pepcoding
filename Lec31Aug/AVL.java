import java.util.*;
class  Node {
    Node  left ,right;
    int  height =-1, data =0,balance =0;

    Node(int  data ){
        this.data =  data;
        this.height =  0;
    }
}
class  AVL{

    /*
                    50
                  /    \  
                 30     80
                /  \    /  \
               10   40 70    90
                 \     /
                  20  60
    */ 
    public static void main(String[] args) {
        Node  root =  new Node(50);
        root.left =new Node(30);
        root.left.left =new Node(10);
        root.left.right =new Node(40);
        root.left.left.right =new Node(20);
        root.right =new Node(80);
        root.right.right =new Node(90);        
        root.right.left =new Node(70);
        root.right.left.left=new Node(60);
        traversal(root);
        display(root);
        System.out.println();
        inorder(root);
        System.out.println();
    }
        static  void  inorder(Node node){
            if(node==null)return ;
            inorder(node.left);
            System.out.print(node.data +" ");
            inorder(node.right);
        }

        static  int  getHeight(Node  node){                        
                return  node==null ? -1 : (Math.max( (node.left!=null ? node.left.height : -1) , (node.right!=null ? node.right.height : -1 ))  +1);
        }

        static  int  getBalance(Node  node){
            if(node==null)return 0;
              int  lb =   node.left!=  null ? node.left.height  : -1; 
              int  rb =   node.right!=  null ? node.right.height  : -1; 
              return  lb-rb;
        }

        static  void  updateFactor(Node  node  ){
            node.height =  getHeight(node);
            node.balance = getBalance(node);
        }

        static  Node  rightRotation(Node node){
            Node  n =  node.left ;
            Node a = n.right;
            n.right  =  node;
            node.left = a;
            updateFactor(node);
            updateFactor(n);
            return   n;
        }

        static  Node  leftRotation(Node  node){
            Node  n = node.right ;
            Node  a = n.left ;
            n.left = node;
            node.right = a;
            updateFactor(node);
            updateFactor(n);
            return  n;
        }


        static Node construct(int arr[]  , int  si , int  ei){
                if(si>ei)
                return  null;
                int  mid = (si+ei)/2;
                Node  node =  new  Node (arr[mid]);
                node.left  = construct(arr, si , mid-1);
                node.right =  construct(arr, mid +1 , ei);
                return   node;
        }

    static Node balanceFactors(Node  node){
            if(getBalance(node) >1){//ll lr
                if(getBalance(node.left)>0) {//ll
                      rightRotation(node);  
                }  else{ //lr
                    leftRotation(node.left);
                    rightRotation(node);
                }
            }else if(getBalance(node) <-1){
                    if(getBalance(node.right)< 0)  // rr or  rl 
                        leftRotation(node);
                        else{
                            rightRotation(node.right);
                            leftRotation(node);
                        }
            }
            return  node;
        }    

    static  Node  addNode(Node  node , int data){
        if(node == null){

        Node  base =   new  Node(data);
        updateFactor(base);
        return  base;
        }
        if(node.data > data)
            node.left  =  addNode(node.left , data);
         else
         node.right =  addNode(node.right ,  data);   
         updateFactor(node);
         node = balanceFactors(node);
         return  node;
    }    
    
    static  void  display(Node  node){
        if(node==null)return;
        Queue<Node>  st =   new  LinkedList<>();
        st.add(node);
        while(!st.isEmpty()){
            int  size=   st.size();
            while(size-->0){
                Node  tmp =   st.poll();
                System.out.print(tmp.data+" ");
                if(tmp.left !=null)
                    st.add(tmp.left);
                if(tmp.right!=null)
                    st.add(tmp.right);                                
            }
            System.out.println();            
        }
    }

    static Node  deleteNode(Node  node,int  data){
        if(node==null)return  null;
        if(node.left==null && node.right==null && node.data== data)
            return null;

        if(node.data == data){
            if(node.right == null){
                return   node.left;
            }

            if(node.left == null){
                return   node.right;
            }

            if(node.right != null && node.left!=null ){   
                int  max = maximum(node.left);
                node.data = max;
                deleteLeafNode(node.left , max);
                updateFactor(node);
                node = balanceFactors(node);
                return  node;
            }
        }


        node.left = deleteNode(node.left, data);            
        
        node.right = deleteNode(node.right, data);

        return  node;
}
    static  Node  deleteLeafNode(Node node,int  del){ 
        if(node==null)return  null;       
        if(node.data == del ){
            return  null;
        }

        node.left = deleteLeafNode( node.left,del);
        node.right = deleteLeafNode( node.right,del);
        return  node;
    }

    static  int  maximum(Node node){
        if(node==null)
        return  Integer.MIN_VALUE;
        return Math.max( Math.max(node.data , maximum(node.right) ) , maximum(node.left ));
    }

    static  void  traversal(Node  node){
        if(node==null)
            return ;
            String  str= "";
        str+= node.left ==null ? " . -> " : node.left.data +" -> ";
        str+= node.data;
        str+= node.right==null ? " <- . " :" <- " + node.right.data ;
        System.out.println(str);
        traversal(node.left);
        traversal(node.right);
    }

}