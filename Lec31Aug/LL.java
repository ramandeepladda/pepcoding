import  java.util.*;
import  VCODE.TestT;

  
 class A   {
    int  a = 20;
}

class B  extends  A {
    int  b = 20;
}

class C   extends B  {
    int  c = 20;
}

class LL extends  C implements  Cloneable {

    static  class  Node{
        int  data;
        Node  next;
        Node(int  data){
            this.data  =  data;

        }
    }

     int  ll = 20;
 
     public  String toString(){
        return "a :" + a + " b :" + b +" c :" + c +" ll:" +ll;
     }

     static void m1(Integer i){
        System.out.println("int-arg: "+i);
     }
    public static void main(String[] args)  throws  CloneNotSupportedException {
        //m1((byte)50);
       //m1('a');
        //m1(60);
       //m1(70L);
        //m1(80.75);
        //m1(new Byte((byte)50));
        //m1(new Character('a'));
       // m1(new Integer(60));
       //m1(new Long(70L));
         m1(new Double(80.45));
         //t =  new  TestT();
        //
        /*LL  l =   new  LL();
        l.test();
        A  l1 =  new  A();

        //l1.method();
        l1.x = 5 ;
        l1.y = 6 ;
         A l2 =(A) l1;
        System.out.println(l1==l2);
        System.out.println(l1.hashCode()==l2.hashCode() );

        System.out.println(l1.x +" "+ l1.y);
        System.out.println(l2.x +" "+ l2.y);
        l2.x = 40;
        l2.y = 80;
        //l2.method();
        System.out.println(l1.x +" "+ l1.y);
        System.out.println(l2.x +" "+ l2.y);

*/

        /*Node  node  =  new  Node(4);
        node.next =  new  Node(1);
        node.next.next =   new  Node(3);
        node.next.next.next =   new  Node(6);
        node.next.next.next.next =   new  Node(8);*/
    //    node.next.next.next.next.next =   new  Node(9);
        //Node  root  = mergeSort(node);
       // Integer i = new Integer(7);
        //System.out.print(Integer.bitCount(9));
        //traverse(root);
    }

    static  Node  findMid(Node  node){
        int c =0 ;        
        for(Node  tmp =  node  ; tmp !=  null ; tmp=tmp.next , c++ );
        Node  tmp =  node;
        c>>>=1;
        for(;c>0 ; c-- , tmp =  tmp.next);
        return  tmp;
    }



    static  Node  mergeSort(Node  node){
        if(node==null || node.next == null)
        return  node;
        int  c =0 ;
        Node  node1 = node;
        while(node1!=null){
            c++;
            node1 =  node1.next;
        }
        c>>=1;
        node1 =  node;
        while(c-->0){
            node1 =  node1.next;
        }   
        Node  tmp =  node;        
        while(tmp.next != node1){
            tmp =  tmp.next;
        }
        tmp.next =  null;
        Node  n1 = mergeSort(node);
        Node  n2 = mergeSort(node1);
        return  mergeLL(n1 , n2);
    }
     
    static  Node  mergeLL(Node  node1   ,Node  node2){
        Node  tmp =  new Node(-1);
        Node  node =  tmp;
        while(node1!=null ||  node2!=null){
            if(node1!=null && node2!=null){
                if(node1.data < node2.data){
                    node.next =  node1;
                    node =  node.next;
                    node1=  node1.next;
                }else{
                    node.next  = node2;
                    node =  node.next;
                    node2 =  node2.next;
                }
            }else if(node1!=null &&  node2== null){
                node.next =  node1;
                node=  node.next;
                node1 =  node1.next;
            }else if(node2!=null &&  node1== null){
                node.next =  node2;
                node =  node.next;
                node2 =  node2.next;
            }
        }
        return  tmp.next;
    }

    static  void  traverse(Node  node){
        System.out.println();
        for(Node  tmp = node ; tmp!=null ; tmp  = tmp.next)
        System.out.print(tmp.data+" ");
        System.out.println();
    }
}