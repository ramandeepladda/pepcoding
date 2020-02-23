import  java.util.*;
class  Node {
    int  data ;
    int  height = -1;
    int  balance = 0;
    Node  left , right ;
    Node(int  data){
        this.data=  data;
        left =  right =  null;
        height =  0;
    }
}


class   Avl{


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        Node  root =  makeBST(arr, 0 , arr.length-1);
        levelOrder(root);
        System.out.println();    
        Node  node = insert(root, 90);                
        node = insert(node, 900);
        levelOrder(node);            
    }

    static  int  height(Node  node  ){
        return   node  ==null ? -1 : (Math.max(height(node.left) , height(node.right) ) +1);
    }

    static  int  balance(Node  node){
        return  node==null ? 0 : (height(node.left) - height(node.right));
    }

    static  Node  updateFactors(Node  node){
        if(node.balance>1){
            if(node.left.balance  > 0) {
                    rightRotation(node);
            }else{
                leftRotation(node.left);
                rightRotation(node);
            }
        }else if(node.balance<-1){
            if(node.right.balance<0){
                leftRotation(node);   
            }else{
                rightRotation(node.right);
                leftRotation(node);
            }

        }
        return node;
    }



    static  Node  rightRotation(Node  node){
        Node n =  node.left ;
        Node  a =  n.right;
        n.right = node;
        node.left = a;
        updateFactors(node);
        updateFactors(n);
        return  n;
    }

    static  Node  leftRotation(Node  node){
        Node  n =  node.right;
        Node  a = n.left ;
        n.left  = node;
        node.right  = a;
        updateFactors(node);
        updateFactors(n);
        return  n;
    }

    static  Node   insert(Node  node , int data){
        if(node==null){
        Node  base =   new  Node(data);
        return updateFactors(base);          
        }
        else if(data > node.data)
            node.right  = insert(node.right , data);
         else  if(data < node.data)   
            node.left =  insert(node.left , data);
            return   updateFactors(node);            
    }

    static  Node  makeBST(int arr[]  , int si , int ei){
        if(si>ei)
        return  null;
        int  mid =  (si+ei)/2;
        Node  node  =  new  Node(arr[mid]);
        node.left = makeBST(arr, si , mid-1);
        node.right = makeBST(arr, mid+1 , ei);
        return  node;
    }

    static  void levelOrder(Node  node){
        Queue<Node>  q=  new  LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int size =  q.size();
            while(size-->0){
            Node  tmp =  q.poll();
            System.out.print(tmp.data+" ");
            if(tmp.left!=null)
            q.add(tmp.left);
            if(tmp.right!=null)
            q.add(tmp.right);
            }
            System.out.println();            
        }
    }
}
