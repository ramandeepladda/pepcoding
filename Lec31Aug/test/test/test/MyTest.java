import  java.util.*;
class MyTest{

    static  Node  head; 
    static  Node  tail;
    static  int  size;
  static class Node {
        int   data;
        Node  next;
        Node(int data){
            this.data =  data;
            this.next =  next;
        }
        Node(){}
    }

    static  boolean  isEmpty(){
        return  head==null;
    }

    static  int  size(){
        /*int  c = 0;
        for(Node  node  =  head  ; node!=null ;  node= node.next)c++;       */
        return  size;
    }

    static  void  addFirst(int  data){
        Node  newNode =  new  Node(data);
        if(head==null){
            head =  newNode;
            tail =  newNode;
            size++;
            return;
        }
        newNode.next =  head;
        head = newNode;
        size++;
    }

    static  void  addLast(int data){
        Node  newNode =  new  Node(data);
        if(tail == null){
            tail = newNode;
            head =  newNode;
            size++;
            return ; 
        }
        tail.next =  newNode;
        tail  =  newNode;
        size++;
    }

    static  void  traverse(Node head){
        System.out.println();
        for(Node  node =  head ; node!=  null ; node=  node.next)
        System.out.print(node.data+" ");
        System.out.println();
    }

    static  int  get(int  position){
        Node  node =  head;
        for(int  i = position ; i>0 && node != null;i--){
            node =  node.next;
        }
        return  node.data;
    }


    static  int first(){
        return  head.data;
    }

    static  void  removeLast(){
        if(head==tail || tail ==null ||  head==null){
            head = tail = null ;
            size=0;
            return;
        }
        Node  node =  head;
        for(; node.next!=tail ; node= node.next);
        node.next = null;
        tail =  node;
        size--;
    }


    static void  addAt(int  idx , int  data){
        idx--;
        size++;
        Node  newNode =  new  Node(data);
        if(head == null   ||   tail ==null){
            head = tail =  newNode;
            return;
        }
        Node  node  =  head;
        for( ; idx>0 ; node=  node.next ){
           if(node==null)return;
            idx--;
        }

        Node  tmp  =  node.next;
        node.next =  newNode;
        newNode.next = tmp;
    }

    static  void  removeAt(int  idx, int  data){
        if(idx<=0){
            if(idx==0 ){head = head.next;return;}
            return;
        }
            Node  node =  head;
        for(;node!=null && idx>0 ; node=  node.next)idx--;
        node.next = node.next.next;

    }

 


    static  void  removeFirst(){
        if(head==tail  ||  head ==null){
            head = tail = null;
            return;
        }
        Node  tmp  =  head;
        tmp =  null;
        head  =  head.next;
        size--;
    }

    static Node  findMid(Node  head){
            Node  slow  =  head;
            Node  fast =  head;
            while(fast!=null &&  fast.next!=null &&  fast.next.next!=null){
                slow =  slow.next;
                fast = fast.next.next;                
            }
            return   slow;
    }

    static  Node  reverse(Node  head){
        Node  prev  = null ,  next = null ,curr = head ;tail = head;
        while(curr!=null){
            next =  curr.next;
            curr.next = prev;
            prev =  curr;
            curr =  next;
        }
        head =  prev;
        return  head;
    }

    static  Node reverseRec(Node  node ){
        if(node==tail){
            head = node;
            return head;
        }
        Node  tmp =  reverseRec(node.next);
          tmp.next =  node;
          return  node;
    }

    static  void  reverseData(){
        Node mid =  findMid(head);
        Node node =  mid.next;
        Node  tmp  = mid;        
        mid.next = null;
        Node sechead = reverse(node);
        Node  n1 =   head ,  n2= sechead;
        while(n1!=null &&  n2!=null){
            int data =  n1.data;
            n1.data  = n2.data;
            n2.data = data;

            n1 =n1.next;
            n2 = n2.next;
        }

        Node  nhead = reverse(sechead);
        tmp.next =  nhead;
        traverse(head);
    }

    static  boolean checkPalindrome(){
        Node  mid =  findMid(head);
        Node  shead = mid.next;
        mid.next =  null;
        Node nhead = reverse(shead);
        boolean  ans =  true;
        Node  n1 = head , n2 = nhead;
        while(n1!=null && n2!=null){
            if(n1.data != n2.data){
                ans =  false;
                break;
            }
            n1= n1.next;
            n2 =n2.next;
        }
        mid.next = reverse(nhead);        
        return ans;
    }

    static  Node  fold(){
        Node  fhead =  head;
        Node  mid =  findMid(fhead);
        Node  shead = mid.next;  
        mid.next =  null;
        Node nshead =   reverse(shead);
        Node dummy =  new  Node(-1);
        Node ans =  dummy;
        Node  n1 = fhead , n2 = nshead; 
        while(n1 != null || n2!=null){
            if(n1!=null){
                dummy.next =  n1;
                n1 =  n1.next;
                dummy  =  dummy.next;
            }
            if(n2!=null){
                dummy.next =  n2;
                n2 = n2.next;
                dummy  =  dummy.next;
            }
        }
        tail = dummy;
        return  ans.next;        
    }

    static  Node  unfold(){
        Node  node  =  head;
        
        Node  fdummy =  new  Node(-1);
        Node  sdummy =  new  Node(-1);
        Node  fh =  fdummy;
        Node  sh =  sdummy;
        
        while(node!= null){
            fdummy.next = node;
            fdummy = fdummy.next;
            node=  node.next;
            if(node!= null){
                sdummy.next = node;
                sdummy =  sdummy.next;
                node =   node.next;
            }
        
        }
        sdummy.next =  null;
        tail = sh.next;
        Node  snhead = reverse(sh.next);
        fdummy.next =  snhead;
        return  fh.next;
    }

    static  void  checkCycleAndPoint(Node  head){
        Node  snode  =   head;
        Node  fnode  =   head;
        fnode =  fnode.next.next;
        boolean  ans =   false;
        while(fnode!=null && fnode.next!=null){
            if(fnode==snode){
                ans = true;
                break;                                 
            }
            snode = snode.next;
            fnode =  fnode.next.next;
        }

        Node  node  =   head;
        while(snode!=node){
            snode =   snode.next;
            node =  node.next;
        }

        System.out.println("cycle -> "+ans);
        System.out.println("cycle  at  "+node.data);

    }


    static  Node  reverseKPair(Node  head , int  k ){
        Node  node  =   head;
        Node  dummy = null;
        int  n = k;
        Node cur =  node ;
        Node  tail =  node;
        while(node!=null){
            Node prev =  null , next =  null;
            while(n-->0 &&  cur!=null){
                next = cur.next;
                cur.next =  prev ;
                prev = cur;
                cur =  next;
            }
            if(dummy==null)
            dummy  =  prev;
            tail.next = prev;
            n= k;
        }
        return  dummy.next;
    }
    

  
    public static void main(String[] args) {
        addFirst(1);
        addLast(2);
        addLast(3);
        addLast(4);
        addLast(5);
        addLast(6);
        addLast(7);
        LinkedList<Integer> l = new  LinkedList<>();

        l.add(1);
        l.add(2);
        l.add(4);
        l.add(3);
        System.out.println(l.remove(3));
        System.out.println(l);

/*
        Node hhead =  new  Node(1);
        hhead.next =  new  Node(2);
        hhead.next.next =  new  Node(3);
        hhead.next.next.next =  new  Node(4);
        hhead.next.next.next.next  =  hhead.next.next;
        checkCycleAndPoint(hhead);
        LRUCache();
        //addLast(8);
       // addLast(7);
        //addLast(3);

       /// tail = reverseRec(head);
        //tail.next =  null;
        //System.out.println(findMid());
        traverse(head);
        head = fold();
        System.out.print("folding");
        traverse(head);
        Node  head= unfold();
        System.out.print("unfolding");
        traverse(head);

        //reverseKPair(head , 3);

        
       // unfold();
        //System.out.println("is Palindrome :--" +checkPalindrome());
       // reverseData();
        /*removeFirst();
        removeFirst();
        traverse();
        removeLast();
        removeLast();
        traverse();
        System.out.println(size());
        System.out.println(findMid());*/
    }
}  