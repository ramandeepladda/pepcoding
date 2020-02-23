import  java.util.*;

abstract class A{};
abstract class B extends A{
     B(){
        System.out.println("B constructor");
        draw();
    }
   abstract void draw();
}



class AVL {
    int m(){
        System.out.println("m initial");
        return  4;
    } 

 
    AVL(){
        radius = 2;
        System.out.println("constructor");
    }
       int  radius = m();

    void  draw(){
        System.out.println("radius ->" +radius);
    }

   static class Node{
        int  data ,height = -1 , bal = 0;
        Node  left ,right;
        Node(int data ){
            this.data =  data;
        }
    }

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
            int arr[] = {10,20,30,40,50,60,70,80,90};
            //Node  root = makeTree(arr , 0, arr.length-1);
            Integer  a =  new  Integer(1);
            Integer  b =  new  Integer(2);
            //test(a,b);
            System.out.println(a + " " +b);
 new  AVL();


    }   

    static  Node makeTree(int arr[] ,  int l , int  r){
            if(l>r)return null;
            int  mid = l+((r-l)/2);
            Node  node  =  new  Node(arr[mid]);
            node.left = makeTree(arr,l ,mid-1 );
            node.right = makeTree(arr, mid+1 , r);
            return  node;
    }

    
    static  Node  addData(Node  node ,  int  data){
        if(node==null)
            return  new  Node(data);
        if(node.data >  data){
            node.left =  addData(node.left ,data);
        }else if(node.data <  data){
            node.right =  addData(node.right , data);
        }
        return  node;
    }


    static  Node  removeData(Node  node  ,  int data){
        if(node == null)  return  null;
        if(node.data > data){
            node.left =  removeData(node.left ,data);
        }else if(node.data <  data){
            node.right =  removeData(node.right ,data);
        }else{
                if(node.left!=null ||  node.right ==null)
                return  node.left!=null ? node.left : node.right;
                Node maxNode =  maxNode(node.left);
                node.data =  maxNode.data;
                node.left =  removeData(node.left , node.data);
        }
        return  node;
    }

    static  Node  maxNode(Node  node){
        while(node.right!=null){
            node =  node.right;
        }
        return  node;
    }

    static  void updateBalFactorAndHeight(Node   node){
        int  lh = -1;
        int  rh = -1;
        if(node.left !=null)
         lh =  node.left.height;
         if(node.right !=null)
         rh =   node.right.height;
         node.height =   Math.max(lh,rh)+1;
         node.bal =  lh-rh;
    }

   static void  test(Integer a ,  Integer b){
            Integer  x = a ;
            a  = b;
            b = x;
    }

}