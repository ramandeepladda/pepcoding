import java.io.*;
import   java.util.*;


class  Node{
    int  data ; 
    Node  left ,  right;
    public  Node(int  data){
        this.data =  data;
        left    =  right   =  null;         
    }
}




class  Info{
    int minr ; 
    int maxl ;
    boolean isBst ;
    int  noOfBst;
    Info(int minr , int  maxl  , int  noOfBst , boolean  isBst ){
    this .minr =  minr;
    this.maxl =  maxl;
    this.noOfBst  =  noOfBst ; 
    this.isBst  = isBst;
    }
    Info(){}
}

public class Solution {

    public static void main(String[] args) throws Exception{
        int arr[]   = {1,3,4,6,7,8,10,13,14};
       // System.out.print((int)", m".charAt(0));
        //System.out.print(isPalindrome("0p"));
        

        //Node  root = makeBST(arr , 0 , arr.length-1);
   /*     Node  root=  new  Node(100);
        root.left =   new  Node(20);
        root.left.left =  new  Node(10);
        root.right  = new  Node(500);
        root.left.right =  new  Node(30);
        root.left.right.right =  new  Node(40);
        
        levelOrder(root);
        display(root);
        Queue<Node> q1  =  new  LinkedList<>();
        Queue<Node> q2  =  new  LinkedList<>();
        bstQueue( root.left,q1);
        bstQueue( root.right,q2);
        while(!q1.isEmpty() || !q2.isEmpty()){
            if(!q1.isEmpty()){
                System.out.print(q1.poll().data +" " );
            }
            if(!q2.isEmpty()){
                System.out.print(q2.poll().data +" " );
            }
        }
        System.out.print(root.data);
        System.out.println("-----after mirroring------");        
        Node  node =  new  Node(10);
        node.left =  new  Node(30);
        //node.left.right =  new  Node(7);        
        node.left.left =  new  Node(20);
        node.right =  new  Node(15);
        node.right.right =  new  Node(5);
        node.right.left=  new  Node(0);
        /*int size = tellSize(node);        
        int   ar[] =  new  int[size];
        inorderArray(ar,node);

        int[] res = mergeSort(ar , 0 , ar.length -1);        
        
        //inorderBST();
        Node  bstroot = makeBST(res , 0, ar.length-1);
        levelOrder(bstroot);
*/
        //display(node);
        //System.out.println(checkFullBinary(node));

    }

     static boolean isPalindrome(String s) {
        boolean  flag =  true;
         int i=0 , j=s.length()-1;       
     while(i<=j){
         char  ch1=s.charAt(i); 
         ch1 = (ch1>='A' && ch1 <= 'Z') ? (char)(ch1+ 'a' - 'A' ): ch1;
         if(!(ch1 >='a'  && ch1 <='z') && !(ch1>='0'  && ch1 <='9') ){            
             i++;
             continue;
         }
         char  ch2=s.charAt(j); 
         ch2 = (ch2>='A' && ch2 <= 'Z' )? (char)(ch2+'a' - 'A' ): ch2;
         if(!(ch2 >='a'  && ch2<='z') && !(ch2>='0'  && ch2 <='9') ){           
            j--;
            continue;
        }

         if((ch1!=ch2)){
             flag=  false;break;
         }             
         i++;j--;        
     }
         return  flag;
     }

    static  void bstQueue(Node node ,  Queue<Node>  q){
        if(node == null)
        return;
        bstQueue(node.left , q);
        q.add(node);
        bstQueue(node.right,q);
    }

    static  boolean  checkFullBinary(Node  node){
        if(node==null){
            return   true;
        }else if(node.left!=null && node.right==null){
            return  false;
        }else if(node.right!=null && node.left == null){
            return  false;            
        }
        return checkFullBinary(node.left) && checkFullBinary(node.right);
    }

    
    static  void  display(Node  node){
        if(node ==null)return;
        String  str =  node.left == null ? " .  <-  " : node.left.data +"  <- ";
        str+= node.data ;
        str+= node.right == null ? " -> ."   : " -> " +node.right.data;
        System.out.println(str);
        display(node.left);
        display(node.right);         
    }

    static  int[] mergeSort(int arr[] , int si , int ei){
        if(si==ei){
            int[]  rr =  new  int[1];
            rr[0] = arr[ei];
            return rr;              
        }
        int mid = (si+ei)/2;
        int[]  left = mergeSort(arr , si , mid);
        int[]  right = mergeSort(arr , mid+1, ei);
        return   mergeArrays(left, right);
    }    

    static int[] mergeArrays(int ar1[] , int ar2[]){
        int  i =0 , j=0 , k =0 ;
        int res[] =  new int[ar1.length + ar2.length];
        while(i<ar1.length  || j<ar2.length){
            if(i<ar1.length && j<ar2.length){
                res[k++] = ar1[i] < ar2[j] ? ar1[i++] : ar2[j++];
            }else if(i>=ar1.length){
                res[k++] = ar2[j++];
            }else if(j>=ar2.length){
                res[k++] =  ar1[i++];
            }
        }
        return  res;
    }

    static   int  tellSize(Node  node  ){
        if(node==null)
        return  0;
       return  tellSize(node.left) +  tellSize(node.right) +1;
    }

    static  int  idx ;

    static void  inorderArray( int arr[] ,Node  node ){
        if(node==null)
            return;
        inorderArray(arr, node.left ); 
        arr[idx++]  =  node.data;               
        inorderArray(arr, node.right );

    }

    static void  mirror(Node  node){
        if(node==null)
        return;
         mirror(node.left);
         mirror(node.right);
        Node  tmp =  node.left;
        node.left =  node.right;
        node.right =  tmp;
    }

    static  void  levelOrder(Node  node){
        if(node==null)return;
        Queue<Node>  q =  new  LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int size =  q.size();
            while(size-->0){
                Node  tmp =  q.poll();
                System.out.print(tmp.data +" ");                
                if(tmp.left != null)
                    q.add(tmp.left);
                if(tmp.right != null)
                    q.add(tmp.right);                   
            }
            System.out.println();
        }
    }
    static  Info  countBSTs(Node  node){
            if(node==null)
            return  new  Info(Integer.MAX_VALUE , Integer.MIN_VALUE  , 0 , false);


        Info  i1 = countBSTs(node.left);            
        Info  i2 = countBSTs(node.right);

        Info i = new Info(); 
        i.isBst = i1.maxl < node.data &&  i2.minr > node.data ;
        i.noOfBst = i.isBst ?  i1.noOfBst+i2.noOfBst +1: i1.noOfBst+i2.noOfBst;
        i.maxl = Math.max(i1.maxl  , node.data ) ;
        i.minr = Math.max(i2.minr  , node.data) ;
        return  i;
    }

    static  int  countBST(Node  node){
            if(node==null)
            return  0;
        int count = 0 ;
        count+=countBST(node.left);
        count+=countBST(node.right);        
        if((node.left==null &&  node.right==  null))
                return   count+1;
        if(maximum(node.left) <  node.data && minimum( node.right) > node.data) {
                return  count+1;
        }

        return  count;
    }

    static  int  minimum(Node  node  ){
        return   node==null ? Integer.MAX_VALUE : Math.min( Math.min(node.data , minimum(node.left)) , minimum(node.right) );
    }

    static  int  maximum(Node  node){
        return  node==null ? Integer.MIN_VALUE : Math.max( Math.max(node.data , maximum(node.left) ) , maximum(node.right));
    }

    static  void  inorder(Node  node){
        if(node==null)
        return;
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }




    static Node  makeBST(int  arr[] , int  si ,  int  ei ){
            if(ei<si)return  null;
                int mid  =  (si+ei)>>1;
            Node  node  =   new  Node(arr[mid]);
            node.left = makeBST(arr, si , mid-1);
            node.right = makeBST(arr, mid+1 , ei);
            return  node;
    }
}

class  Dog implements Serializable{
    int age  ; 
    String  name;
    Dog(int age  ,  String   name){
        this.age  =  age;
        this.name=  name;
    }

    public  int  getAge(){
        return  age;
    }

    public  String  getName(){
        return  name;
    }
}

class  Cat implements Serializable{
    int age  ; 
    String  name;
    Cat(int age  ,  String   name){
        this.age  =  age;
        this.name=  name;
    }

    public  int  getAge(){
        return  age;
    }

    public  String  getName(){
        return  name;
    }
}
