import  java.util.*;
class  Node{
    int data;
    Node  left  , right;
    Node(int data){
        this.data=  data;
        left =  right = null;
    }
}

public  class BST{

    /*50
    /    \
   30     80
  /  \    /   \ 
 10   40  70   90
    \    /
     20 60
*/  

    static  boolean checkBST(Node node) {
            if(node==null)
                return true;
       boolean l= checkBST(node.left);
       boolean r= checkBST(node.right);
        return ((maximum1(node.left) < node.data) && (node.data < minimum1(node.right)) ) && l && r;        
    }

    static  int maximum1(Node  node){
        if(node==null)
            return  Integer.MIN_VALUE;        
        return Math.max(Math.max(minimum1(node.left), minimum1(node.right)) ,node.data); 
    }
    
    static  int minimum1(Node  node){
        if(node==null)
            return  Integer.MAX_VALUE;
        return Math.min(Math.min(minimum1(node.left), minimum1(node.right)) ,node.data); 
    }



    static  boolean  checkIfHeap(Node node){
        if(node==null){
            return  true;
        }
        boolean  left  = checkIfHeap(node.left);
        boolean  right  = checkIfHeap(node.right);
        boolean   flag =  true;
        if(node.left!=null){
            flag = node.data > node.left.data;
        }
        if(node.right!=null && flag){
            flag = node.data > node.right.data;
        }
        return   left && right && flag;
    }

    public static void main(String[] args) {
        Node  root =  new Node(3);
        root.left =  new  Node(2);
        root.right =  new  Node(4);
        root.left.left =  new  Node(1);
        root.right.right =  new  Node(6);
        root.right.left =  new  Node(5);
     //System.out.println(checkBST(root));
            // System.out.println(Integer.MAX_VALUE);
         List<Integer> l1 =  Arrays.asList(1,4,7,8);
         List<Integer> l1 =  Arrays.asList(2,3,5,9);
         List<Iterator<Integer>> ll= Arrays.asList(l1,l2);
         Iterator<Integer> ans= solve(ll);
         
        //System.out.println(sumTree(root));
        //Node  head =  new Node(50);
        //head.left =  new Node(2);
//        maxSumPath(root ,0,0);
        //makeBST();
        //levelOrder(root);
        //inorder(root);
        //System.out.println();
        //addNode(root , 12);
        //inorder(root);
        //System.out.println();
        //deleteNode(root , 30);
        //inorder(root);
        //findTarget(root  , 120);
        /*int bst1[] = {1,2,3,4,5,7,8,9};
        int bst2[] = {10,20,30,40,50,70,80,90};
        Node  node1 =  formBST(bst1 , 0 , bst1.length-1);
        Node  node2 =  formBST(bst2 , 0 , bst2.length-1);
        Node  root1 = mergeBST(node1  , node2);*/
    }

    static  Node mergeBST(Node  node1 ,Node  node2){
            LinkedList<Integer>  ar = new  LinkedList<>();
             getInorderArray(node1 , ar);
             getInorderArray(node2 , ar);             
             return  null;
    }


    static void  getInorderArray(Node  node ,LinkedList<Integer>   ll ){
            if(node==null)return ;            
            getInorderArray(node.left , ll);
            ll.add(node.data);
             getInorderArray(node.right , ll);
    }

    static  Node  formBST(int[]  arr , int  si , int ei ){
        if(si>ei )  return null;
        int  mid  = (si+ei)/2;
        Node  node =  new Node(arr[mid]);
        node.left =  formBST(arr,  si , mid-1);
        node.right =  formBST(arr,  mid+1 , ei);
        return  node; 
    }



    static  int  sumTheTree(Node  node){
        if(node==null)return  0;
        return  sumTheTree(node.left )+sumTheTree(node.right) + node.data;
    }


    static  Map<Integer , Node> view(Node  node){
        LinkedHashMap<Node , Integer> hm =  new LinkedHashMap<>();
        Map<Integer ,  Node>   res = new  HashMap<>();
        Queue<Node>  q   =  new  LinkedList<>();
        q.add(node);
        hm.put(node , 0 );
        while(!q.isEmpty()){
            int  size =  q.size();
            while(size-->0){
                Node  tmp = q.poll();
                int  hd = hm.get(tmp);
                if(!res.containsKey(hd)){
                    res.put( hd , tmp);
                }
                if(tmp.left!=null ){
                     q.add(tmp.left);
                     hm.put(tmp.left ,hd-1);
                }
                if(tmp.right!=null){
                    q.add(tmp.right);
                    hm.put(tmp.right ,hd+1);                     
                }
            }
        }
        return  res;
    }


    static  int  sumTree(Node  node){
        if(node==null)return  0;
        int l = sumTree(node.left);
        int r = sumTree(node.right);
        return (node.data + l+r);
    }

    static  void  findTarget(Node root  , int sum ){
      
    }


    static  Node  findExtremeLeft(Node  node ){
        while(node.left!=null){
            node =  node.left;
        }
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
                    return  node;
                }
            }


            node.left = deleteNode(node.left, data);            
            
            node.right = deleteNode(node.right, data);

            return  node;
    }


    static  int  maximum(Node node){
        if(node==null)
        return  Integer.MIN_VALUE;
        return Math.max( Math.max(node.data , maximum(node.right) ) , maximum(node.left ));
    }
    

    static  Node  addNode(Node  node , int data){
            if(node == null)
                return  new Node(data);

        if(data<node.data)
        node.left = addNode(node.left , data);
        
        if(data > node.data)
            node.right = addNode(node.right , data);
        return  node;
    }



   


    /*       4
           /  \
          2    6
         / \  / \
        1   3 5  7
    */

    static Node  prev  =null;
    static Node   suc =  null;
    static Node   pred =  null;

    static  void  findPreSuc(Node  curr, int data){
        if(curr == null)return ;
        findPreSuc(curr.left , data);
        if(curr.data ==data ){
            pred  =  prev;
        }
        if(pred!=null && prev.data == data){
                suc = curr;
        }
        prev   =curr;
        findPreSuc(curr.right , data);
  }

    static  int findLCA_01(Node  node , int l, int  r){
        if(node==null)
        return -1;
        if(node.data <l){
        return findLCA_01( node.left ,l, r);}
        else if(node.data  >r){
        return findLCA_01( node.right ,l, r);
        }
        else 
         return node.data;
    }

    static  boolean  findLCA(Node node , int  l, int  r){
        if(node==null)
            return  false;
            boolean  self = node.data==l ||  node.data==r;

            boolean  lt = findLCA(node.left , l,  r);
            boolean  rt = findLCA(node.right , l,  r);
            boolean  ans  =false;
            if( (lt && rt) || (lt && self )  || (rt && self ) ){
               ans = (lt && rt) || (lt && self )  || (rt && self );
                System.out.print(node.data);
        }
            return ans;
    }

   static  void  levelOrder(Node  head){
        Queue<Node>   ll =  new LinkedList<Node>();
        ll.add(head);
        while(!ll.isEmpty()){
            int size = ll.size();            
            while(size-->0){
                Node  node =  ll.poll();
                if(node!=null){
                System.out.print(node.data+" ");
                if(node.left!=null)
                ll.add(node.left);
                if(node.right!=null)
                ll.add(node.right);}
            }
            System.out.println();
        }

    }

    static  int max(Node node ){
        if(node==null) return  Integer.MIN_VALUE;
        return  Math.max(max(node.left) ,Math.max(max(node.right ),node.data) );
    }

    static  int min(Node node ){
        if(node==null) return  Integer.MAX_VALUE;
        return  Math.min(min(node.left) ,Math.min(min(node.right) ,node.data) );
    }

    static boolean   find(Node  node ,int data){
        if(node==null)return  false;
        return  (node.data==data) || find(node.left , data ) || find(node.right ,data);
    }

    static  int size(Node  node  ){
        if(node==null)return   0;
        return  size(node.left) + size(node.right)+1;
    }

    static  void traverse(Node  node ){
        if(node == null)
            return;

      
            if( node.left != null  )
                System.out.print(node.left.data +"-> ");
            else
                System.out.print(". ->");

                System.out.print( node.data );

            if(node.right !=null  )
                System.out.print("<- "+node.right.data);
                else
                System.out.println("<- . ");                
    
            System.out.println();
            traverse(node.left);            
            traverse(node.right);
    }


    static void preorder(Node  node){
        if(node==null)
        return ;
        System.out.print(node.data +" ");
        preorder(node.left);
        preorder(node.right);
    }

    static  int  height(Node  node){
        if(node==null)return  0;
        return  Math.max(height(node.left) ,height(node.right)) +1;
    }
     


    static   Node  head=null;
    static Node makeBST(int arr[] , int  si , int ei){
        if(si>ei)
        return  null;
        int  idx =  (si+ei)/2;
        Node  node =   new Node(arr[idx]);
        if(head == null)
        head  = node;

        node.left = makeBST(arr,si,idx-1);
        node.right = makeBST(arr, idx+1 , ei );
        return  node;
    }

    static   void   inorder(Node  node){
        if(node==null)
        return;
        inorder(node.left);
        System.out.print(node.data+" ");    
        inorder(node.right);
    }
    
    static  boolean  findData(Node  node , int data){
        if(node ==null)
        return  false;
        if(node.data > data){
            return findData(node.left,data);
        }else  if(node.data < data){
            return   findData(node.right,data);
        }else if(node.data ==  data){
        return  true;        }
        else return false;
    }


    static String  printPath(Node  node,  int data ,String   path){
        if(node==null)
        return  path;
        if(node.data > data){
            return   printPath(node.left ,data , path +" "+ node.data) ;
        }else if(node.data < data){
            return   printPath(node.right ,data , path + " "+node.data) ;
        }else 
            return    path +" "+ data;
    }
}