import java.util.Scanner;
class Table{
    static  class  Node {
        int  data;
        Node  next ; 
        Node(int data){
            this.data =  data;            
        }
    }
    public static void main(String[] args) {
        Node  node  =  new  Node(4);
        node.next =  new  Node(1);
        node.next.next =   new  Node(3);
        node.next.next.next =   new  Node(6);
        Node  root  = mergeSort(node);
        traverse(root);
    }



    static  Node  mergeSort(Node  node){
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
        return  mergeLL(node1 , node);
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
    }
}