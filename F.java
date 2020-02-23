import java.util.*;

class Node {
    int data;
    Node  next;
    Node(int  data){
        this.data= data;
        next = null;
    }
}


class F{

  static  Node  head ;
    public static void main(String[] args) {
        //int arr[] = {1,2,3,6,4,7,8,9};
        head = new Node(1);
        head.next  =  new Node(2);
        head.next.next  =  new Node(3);
        head.next.next.next  =  new Node(6);
        head.next.next.next.next  =  new Node(6);
        head.next.next.next.next.next  =  new Node(7);
        printList();
        removeDup();
    }

    static  void  removeDup(){
        
    }

    static  void printList(){
        System.out.println();
        for(Node  node = head ; node!=null ; node = node.next)
        System.out.print(node.data+" ");
        System.out.println();
    }


    static   void  finddup(int arr[]){
        int n = arr[0];
        for(int i = 1;i<arr.length ; i++)
           n^=arr[i];

           System.out.println(n+"ll");
    }





}