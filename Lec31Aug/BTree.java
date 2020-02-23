import  java.util.*;
import  java.util.concurrent.*;




class  CharNode{
    char  data ; 
    CharNode  left , right;
    CharNode(char  data ){
        this.data = data;
        left = right = null;
    }
    
}

class Bst{
    int min = Integer.MAX_VALUE ,max = Integer.MIN_VALUE ,noOfBsts;
    boolean  isBst = true;    
}



class BinNode{
    int data;
    BinNode left ,right;
    BinNode(int  data){
        this.data = data;
        left = right = null;
    }
}

 class Node{
      int  data  ;
 Node  left , right ;
    Node(int  data){
        this.data = data; 
        left = null ;
        right = null;
    }

    Node (int  data , Node  left  , Node right ){
        this.data =  data;
        this.left = left ;
        this.right  =  right;
    }
}

class  HD{
    int  lhd , rhd;
    HD(){
        lhd = Integer.MAX_VALUE;
        rhd = Integer.MIN_VALUE;
    }
}

class BTree{


    static  Node  root = null;

    BTree(int[]   arr){
     root = generateBTree(arr);
    }


    public static void main(String[] args) {
        int arr[] = {10,20,40 ,80 , -1,-1 , 90, -1,-1,50 , 100 ,-1,-1, -1,30 ,60,-1, 110 , -1,-1 ,70 ,120 ,-1,-1,-1};
        new  BTree (arr);
      //  preorder(root);
       // System.out.println();
        
        //traverse(root);
        /*
        System.out.println();
        //iterativePreorder(root);        
        System.out.println(" size of tree : "+sizeOfTree(root ));
        System.out.println("height  of tree   " + heightOfTree(root , 0));
        System.out.println("preorder  traversal");
        preorder(root);        
        System.out.println();
        System.out.println("inorder  traversal");
        inorder(root);
        System.out.println();
        System.out.println("inorder  traversal");
        postorder(root);
        System.err.println();
*/
          //System.out.println(  countLeafNode(root));
//          System.out.println( TreeKiHeight(root ));
            //System.out.println("found "+find(root , 30));
            //System.out.println("Max  value : "+max(root ));
            //System.out.println("Min value :"+min(root ));
            //findPath(root  , 70);
            
/*
          
            Iterator<Node>  itr =  res.iterator();
            
            while(itr.hasNext()){
                Node   el =  (Node )   itr.next();
                System.out.print(el.data +"  ");
            }
            System.out.println();

        ArrayList<Node>   res  = rootToNodePath(root , 40);
            for(Node  node :  res)
            System.out.print(node.data +" ");
        ArrayList<Integer>   ar =  new ArrayList<Integer>();
        System.out.println(root2Node(root , 100 , ar));
            for(int data:  ar)
        System.out.print(data +" ");
        System.out.println();*/
       /*     levelOrder(root);
            System.out.println();
            levelOrderByLine(root);
            System.out.println();*/
          //  levelOrderBy2Queue(root);System.out.println();
          //zigzag(root);
          //allTreePaths(root ,"" , 0);
          //root = new Node(1);
          /*
              A
             /   \ 
           B       C
         /   \       \    
        D     E       F     
                     /  \    
                    K    G*/ 

        CharNode  root =  new CharNode('A');
        root.left = new CharNode('B'); 
        root.right = new CharNode('C'); 
        root.left.left =new CharNode('D'); 
        root.left.right =new CharNode('E'); 
        root.right.right =new CharNode('F'); 
        root.right.right.right =new CharNode('G'); 
        root.right.right.left =new CharNode('K');    
        //System.out.println( meetParent(root));
       /* ArrayList<Character>  f1 =  commonAncestor(root ,'E');
       ArrayList<Character>  f2 =  commonAncestor(root ,'K');
       System.out.println(f1);
       System.out.println(f2);
       char  ans = (char)-1;
        for(int  i=0;i<Math.max(f1.size() ,f2.size()) ;i++){
                if(f1.get(i)== f2.get(i)){
                    ans = f1.get(i);
                }else{
                    break;
                }

        }
        System.out.println("common  ancestor : "+ans);
      //  commonParent(root ,'G' , 'K');
        //HashMap<Character , LinkedList<Character>>  map =  new HashMap<Character ,LinkedList<Character>>();
    //    findDupTree(root , map);

    /*
            9
           /  \
          4    17
         / \   /  \
        3   6 2   22
           / \   /
          5   7  20

           50
         /    \
        30     80
       /  \    /   \ 
      10   40  70   90
         \     /
          20   60
    */  

    //min<root <max


        Node  root1 =   new Node(50);
        root1.left =  new Node(30);
        root1.left.left =  new Node(10);
        root1.left.right =  new Node(40);
        root1.left.left.right =  new Node(20);
        root1.right =  new Node(80);
        root1.right.right =  new Node(90);
        root1.right.left =  new Node(70);
        root1.right.left.left =  new Node(60);
        //Bst  o  = checkBST(root1);
        //System.out.println("IS BST : "+o.isBst);
        //System.out.println("count of BST : "+o.noOfBsts);
            //HD  o = diameter(root1 , new HD());
        //System.out.println(o.rhd - o.rhd+1);
        //DD d = diameter_2(root1);
        //System.out.print(d.d-2);
        preorder(root1);
       deleteNodeInBST(root1 , 60);
       System.out.println();
        preorder(root1);
        //boolean   ans =checkInorderBST(root1);
        //System.out.println("Is bst :"+ans);

        

        root1.right=  new Node(17);
        root1.right.right =  new Node(22);
        root1.right.left =  new Node(2);
        root1.right.right.left =  new Node(20);
        ///System.out.println(height(root1 ,6));
        //checkParent(root1 ,3,20);
        ArrayList<String>  ar =  new ArrayList<>();
        ar.add("raman");
        //System.out.print(ar.get(1));
        //test(ar);
        /*
                      1       
                    /   \ 
                  0       1
                /   \       \    
               1     0       1     
                            /  \    
                           0    1*/
//System.exit(1);
                           BinNode  binroot = new BinNode(1);
                           binroot.left  = new BinNode(0);
                           binroot.right  = new BinNode(1);
                           binroot.left.left  = new BinNode(1);
                           binroot.left.right  = new BinNode(0);
                           binroot.right.right  = new BinNode(1);
                           binroot.right.right.right  = new BinNode(1);
                           binroot.right.right.left  = new BinNode(0);
                         //  printBins(binroot ,0 ,0 );              
    } 


    static Node  deleteNodeInBST(Node  node  , int  data){
        if(node==null)return  null;
        
        if(node.left  == null &&  node.right == null )
        return   null;

        if(node.left!=null && node.right ==null && node.data==data )
        return  node.left;

        if(node.right!=null && node.left ==null && node.data == data )
            return  node.right;

          if(node.left!=null &&  node.right != null   &&  node.data ==  data)  
          {
              Node  rightMost =   findRightMost(node);
               deleteRightMost(node ,rightMost);
                return   rightMost;
          }

          node.left   =  deleteNodeInBST(node.left , data);
          node.right   =  deleteNodeInBST(node.right , data);        
          return  node;
    }


    static Node  findRightMost(Node  node){
        while(node.right!=null){
            node =  node.right;
        }
        return   node;
    }


    static void deleteRightMost(Node node  , Node  right){        
        while(node.right!=right){            
            node = node.right;            
        }
        node.right = null;
    }

    static  Node  deleteLeafNode_1(Node node ,int  data){
        if(node ==null)return  null;
        if(node.data == data)
        return null;
        node.left = deleteLeafNode_1(node.left , data);
        node.right = deleteLeafNode_1(node.right ,data);
        return  node;
    }

    static   boolean  deleteLeafNode(Node  node , int  data){
        if(node ==  null)
            return  false;

        if(node.data == data)
            return  true;
        boolean   l = deleteLeafNode(node.left ,data);
            if(l){
                node.left = null;       
                return  false;         
        }
        boolean   r = deleteLeafNode(node.right ,data);
        if(r){
            node.right = null;
            return false;
        }

        return  false;
    }

    static  int  diameter_01(Node  node){
        if(node == null)
        return   0;
        int  lht=  
        (node.left)-1;
        int  rht=  TreeKiHeight(node.right)-1;
        int  ld = diameter_01(node.left);
        int  rd = diameter_01(node.right);
        return Math.max(Math.max(ld,rd) ,lht+rht+1);
    }

    static   class DD{
        int  h ;
        int d ;
        DD(){
            h = 0;
            d = 0;
        }
    }

    static  DD  diameter_2(Node  node){
        if(node == null){
            return  new DD();
        }

        DD  l = diameter_2(node.left );
        DD  r = diameter_2(node.right );
        DD  res =  new DD();
        res.h = Math.max(l.h ,r.h)+1;
        res.d =Math.max( Math.max(l.d,r.d ) , l.h+r.h+1);
        return  res;
    }




    static  HD   diameter(Node  node ,HD  hd){
        if(node==null)
            return  hd;

        hd.lhd--;
        HD  l = diameter(node.left , hd);

        hd.lhd++;
        hd.rhd++;
        HD  r = diameter(node.right, hd);
        HD  res = new HD();
        res.lhd = Math.min(hd.lhd , l.lhd);
        res.rhd = Math.max(hd.rhd , r.rhd);
        return  res;
    }


    static  int  cur = Integer.MIN_VALUE;
     
        static  boolean   checkInorderBST(Node  root){
            if(root == null)
                return   true;

                boolean   l = checkInorderBST(root.left);
                    if(!l)return  false;
                    if(root.data  >  cur){
                            cur =  root.data;
                    }else{
                        return  false;
                    }
                boolean   r = checkInorderBST(root.right);
                if(!r)return  false;
                return   true;
        }


//BST condition
//max< root < min
    static   Bst  checkBST( Node  node){
            if(node==null)
                return  new  Bst();        
        Bst   lb1 = checkBST(node.left);
        Bst   rb1 = checkBST(node.right);
        Bst tmp = new Bst();
        tmp.isBst = false;
          if(lb1.isBst && rb1.isBst &&  lb1.max < node.data && node.data < rb1.min){
                tmp.noOfBsts = 1;
                tmp.isBst = true;                
          }
          tmp.min = Math.min(node.data , Math.min(lb1.min , rb1.min));
          tmp.max = Math.max(node.data , Math.max(lb1.max , rb1.max));
          tmp.noOfBsts +=lb1.noOfBsts + rb1.noOfBsts;
          return  tmp;          
    }
    static CharNode  LCA =null;
    /*static  boolean  LCA_1(CharNode node , char a , char  b){
        if(node == null )  return  false;
        boolean selfDone = node.data==a || node.data == b;
        boolean  l = LCA_1(node.left , a,b);
        if(LCA!=null)return true;         
        boolean  r = LCA_1(node.right , a,b);
        if((left && selfDone) || (right && selfDone) || (left && right))
                LCA = node;
        return left || selfDone || right;
    }
*/
    static boolean  commonParent(CharNode  node ,char  a ,char  b){
        if(node==null)
        return   false;
        if(node.data==a || node.data == b){
            return true;            
        }
        boolean   l = commonParent(node.left , a,b);
        boolean   r = commonParent(node.right , a,b);
            if(l && r){
                System.out.println(node.data);
            }
            return  l || r;
    }





        static  ArrayList<Character>  commonAncestor(CharNode  node , char  a  ){
            if(node==null)
            return  new  ArrayList<>() ;
            if(node.data == a){
                ArrayList<Character>   r = new  ArrayList<>();
                r.add(a);
                return r;
            }
            
            ArrayList<Character>  left = commonAncestor(node.left , a);
            ArrayList<Character>  right = commonAncestor(node.right , a);
            ArrayList<Character>  tmp =  new ArrayList<>();
            if(!left.isEmpty()){
                tmp.add(node.data);
                tmp.addAll(left);
            }

            if(!right.isEmpty()){
                tmp.add(node.data);
                tmp.addAll(right);
            }
            return   tmp;
        }

    static  void  printBins(BinNode root ,int  power ,int num){
         if(root == null) 
            return;
        if(root.left == null && root.right==null){           
            num+=root.data*(Math.pow(2,power));
          System.out.println(num);
           return;
        }
         num +=(root.data*(Math.pow(2,power)));
          
          printBins(root.left ,power+1 ,num);   
          printBins(root.right ,power+1 ,num);            

    }

    static  void  test(ArrayList<String>  ar){
        ar.add("ladda");
        ar=null;
    }

    static  boolean  checkParent(Node  node , int  a ,int b ){
        if(node==null)
        return false;

        if(node.data==a ||node.data ==b)
        return  true;
        
        boolean   l = checkParent(node.left , a,b);
        boolean   r = checkParent(node.right, a,b);
        if(l && r){
            System.out.println(node.data);
            return  false;
        }
        return l||r;
    }

    static  void  sumCover(Node  root ){
        if(root==null)
        return ;
        int  sum = 0; 
        Node  node = root.left!=null ? root.left : null;
        while(node!=null){
            sum+= node.data;
            if(node.left!=null){
                node= node.left;
            }else
             node  = node.right;
        }

        node =  root.right != null ? root.right : null;
        while(node!=null){
            sum+= node.data;
            if(node.right !=null)
             node = node.right;
             else
             node = node.left;
        }
        System.out.println("covered  sum : " + (sum+ root.data));
        int treesum =  sumTree(root);
        System.out.println("uncovered  sum : "  + (treesum - (sum+root.data)));

    }

    static int  sumTree(Node  node){
        if(node==null)
        return   0; 
        return   (sumTree(node.left) + sumTree(node.right) + node.data);
    }

    static  void  mirrorTree(Node  node){
        if(node==null)
        return;

        mirrorTree(node.left);
        mirrorTree(node.right);

        Node  tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
    


    static   void  printPathsOfTree(Node  node , int[]   arr , int  len){
        if(node ==null)
            return ;

            arr[len]= node.data;
            len++;
            if(node.left ==null && node.right == null)
            {
                System.out.println();
                for(int  i =0 ; i< len ; i++)
                System.out.print(arr[i]+" ");
                System.out.println();
                return;
            }
            
            printPathsOfTree(node.left , arr, len);
            printPathsOfTree(node.right, arr, len);
    }
    

    static  int findSubTreeWithSum(Node node , int sum ){
        if(node==null)
         return 0;
         if(node.data==sum)
             return sum;
        int   l =findSubTreeWithSum(node.left , sum );
        int    r =findSubTreeWithSum(node.right, sum );

        if(sum==l || sum==r || sum==(node.data+l+r))
        return sum;
        return  (node.data+ l+r); 
    } 




    static  void  findDupTree(CharNode  node  , HashMap<Character , LinkedList<Character>>  map ){
            if(node == null){
                return ;
            }

            if( map.containsKey(node.data) ){
                List<Character>   tmp =  map.get(node.data);
                if((node.left!=null && node.left.data == tmp.get(0)) && (node.right!=null && node.right.data == tmp.get(1)))
                  System.out.println("YES");                  
                  else
                  System.out.println("NO");
                  return;

            }else{
                LinkedList<Character>   list = new LinkedList<>();
                 list.add(node.left==null ? null: node.left.data);
                 list.add(node.right==null ? null: node.right.data);
                    map.put(node.data , list);
            }

            findDupTree(node.left , map);
            findDupTree(node.right , map);
    }


    static  void   orderT(Node   node ){
        if(node==null)return;
        System.out.print(node.data+" ");
        orderT(node.left);
        orderT(node.right);
    }

    static   void  remLeafs(Node  node ){
        if(node == null)return ; 

        if(node.left == null  && node.right == null)
        {
            node = null;
            return;
        }

        remLeafs(node.left);
        remLeafs(node.right);
    }


    // static   void  alterNums(int arr[]){
    //     int  i=0 , j =1 , k =0 ;
        
    //     while(j <arr.length && k <arr.length){

            
    //     }
    // }

    static   void  tree2Bin(Node  node , int  level, int val){
        if(node==null)
        return   ;

        if(node.left == null &&  node.right == null){
           val+= (Math.pow(2,level) * node.data);            
           System.out.print(val+" ");
            return;
        }

        val+= (Math.pow(2,level)) * node.data ;
        tree2Bin(node.left , level+1 , val);
        tree2Bin(node.right , level+1 , val);        
    }

    
    static  void  allTreePaths(Node  root , String   str){
            if(root==null){           
                    return;
                }
        if( root.left == null && root.left==null )
        {
            System.out.println(str+" "+ root.data);
            return;    
        }

        str+=" " + root.data;  
        allTreePaths(root.right , str);        
        allTreePaths(root.left, str);
    }


    static   void  zigzag(Node  root){
        if(root==null)
            return;
        Stack<Node>  st1= new Stack<>();
        Stack<Node>  st2= new Stack<>();
        st1.add(root);

        while(!st1.isEmpty()  || !st2.isEmpty()){
                while(!st1.isEmpty()){
                    Node  node  =  st1.pop();
                    System.out.print(node.data +" ");
                    if(node.left !=null)
                        st2.add(node.left);

                    if(node.right !=null)
                        st2.add(node.right);
                }

            System.out.println();
                while(!st2.isEmpty()){
                    Node  node  =  st2.pop();
                    System.out.print(node.data +" ");
                    if(node.right !=null)
                    st1.add(node.right);

                    if(node.left !=null)
                        st1.add(node.left);
                }
                System.out.println();
        }
    }


    
    static  void levelOrderBy2Queue(Node   root){
        Queue<Node>  q1  =  new LinkedList<>();
        Queue<Node>  q2 =  new LinkedList<>();
        q1.add(root);

        while(!q1.isEmpty()){
                int size1 = q1.size();
                while(size1-->0){
                    Node  node  = q1.poll();
                    System.out.print(node.data+" ");
                    if(node.right!=null)
                       q2.add(node.right);

                    if(node.left !=null)
                        q2.add(node.left);
                    
                }
                System.out.println();
                if(q1.isEmpty()){
                    Queue<Node> tmp =  q1;
                    q1 = q2;
                    q2 = tmp;
                }
              
        }

    }



    static   void levelOrderByLine(Node  node){
        if(node==null){
            return;
        }
        LinkedList<Node>  q =   new   LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int  size =  q.size();
            while(size-->0){
                Node  tmp   = q.poll();
                System.out.print(tmp.data+"  ");
                
                if(tmp.left != null)
                    q.add(tmp.left);

                if(tmp.right!= null)
                    q.add(tmp.right);    
                
            }
            System.out.println();
        }
    }


    static   void levelOrder(Node  node){
        if(node==null){
            return;
        }
        Queue<Node>  q =   new   LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int  size =  q.size();
            while(size-->0){
                Node  tmp   = q.poll();
                System.out.print(tmp.data+"  ");
                
                if(tmp.left != null)
                    q.add(tmp.left);

                if(tmp.right!= null)
                    q.add(tmp.right);    
                
            }
        }
    }



    static   void  printTreeLeafNodes(Node  node){
        if(node ==   null)
            return ;

        if(node.left == null  &&  node.right ==null){
            System.out.print( node.data +"  ");                 
        }
        printTreeLeafNodes(node.left);
        printTreeLeafNodes(node.right);
    }




    static ArrayList<Node>  rootToNodePath(Node   node,  int  data){
            if(node   ==    null){
                return   new ArrayList<>();
            }

            if(node.data  ==   data){
                ArrayList<Node> list = new  ArrayList<>();
                list.add(node);
                return   list;
            }

            ArrayList<Node>   l =   rootToNodePath(node.left ,  data);
            ArrayList<Node>   r =   rootToNodePath(node.right ,  data);

            ArrayList<Node>   res =  new ArrayList<>();
            if(!l.isEmpty()){
                res.addAll(l);
                res.add(node);
            }

            if(!r.isEmpty()){
                res.addAll(r);
                res.add(node);
            }
            return   res;
    }



    static  boolean   root2Node(Node  node  , int  data , ArrayList<Integer>   ar){
            if(node  == null){
                return   false;
            }

            if(node.data == data)            {
                ar.add(node.data);
                return   true;
            }
            
            boolean   l =  root2Node(node.left , data , ar);
            if(l){
                ar.add(node.data);
                return  true;
            }
            
            boolean   r =  root2Node(node.right , data , ar);
            if(r){
                ar.add(node.data);
                return true;
            }

        return false;
    }

    static   boolean    findPath(Node  node  ,int  n ){
            if(node == null)
                return false;

            if(node.data ==  n) {
                System.out.print(n +"  ");
                return  true;
            }
        boolean   r = findPath(node.right ,n );   
        boolean   l = findPath(node.left , n);   

            if(r||l){
                System.out.print(node.data +"  " );
            }
            return   r||  l ;
    }


    static  int  max(Node node ){
        if(node == null){
            return   Integer.MIN_VALUE;
        }
        int  left =max(node.left);
        int  right =max(node.right);        
        return Math.max( Math.max(left  , node.data) , right);        
    }

    static  boolean  find(Node node ,int  data){
        if(node == null){
            return false  ;
        }

        if(node.data == data)
            return  true;
        boolean l = find(node.left ,data);
        boolean  r = find(node.right , data);        
        return   l || r;
    }

    static  int  min(Node node ){
        if(node == null){
            return   Integer.MAX_VALUE;
        }
        int  left =min(node.left);
        int  right =min(node.right);        
        return Math.min( Math.min(left  , node.data) , right);        
    }
     
    static int  findLCA(Node  node,  int  n1 ,int n2){
        Queue<Integer>  qt1 =  new LinkedList<>();
        Queue<Integer>  qt2 = new LinkedList<>();
        qt1 =   findN1Path(node  ,  n1);
        qt2 =  findN1Path(node, n2);
        int lca =  -1;
        Iterator<Integer> itr = qt1.iterator();
        while(itr.hasNext()){
            int  i = itr.next();        
            if(qt2.contains(i)){
                lca =  i ;
                break;
            }
        }
       return   lca;
    }
     


    static   Queue<Integer>   findN1Path(Node  node , int  n1){
            if(node== null){
                return   new LinkedList<Integer>();
            }
            if(node.data ==  n1){
                Queue<Integer >   st =  new  LinkedList<>();
                st.add(node.data);
                return   st;
            }

            Queue<Integer> st2 =  findN1Path(node.left , n1);
            Queue<Integer> st3 =  findN1Path(node.right , n1);

            Queue<Integer>   st  =  new LinkedList<>();
                if(!st2.isEmpty()){
                    st.addAll(st2);
                    st.add(node.data);                
                }
                
                if(!st3.isEmpty()){
                    st.addAll(st3);
                    st.add(node.data);                
                }

                return  st;
    }


    static   int  countLeafNode(Node  node){
        if(node==null ){
            return   0 ; 
        }

        if(node.left == null   && node.right ==null)
        return   1;

        int count =0  ;
        count+= countLeafNode(node.left);
        count+= countLeafNode(node.right);

        return  count;    
    }



    
    static   void  inorder(Node  node  ){
        if(node ==null)
        return;

        inorder(node.left);
        System.out.print(node.data +" ");
        inorder(node.right);
    }

    static void  postorder(Node  node ){
        if(node ==null)
        return;

        postorder(node.left);
        postorder(node.right);

        System.out.print(node.data +"  ");
    }
    
    static   int  heightOfTree(Node node , int idx){
            if(node == null)
              return  idx;

             int  left =  0 , right =0;
             left = heightOfTree(node.left  , idx+1);
             right = heightOfTree(node.right  , idx+1);

             return   Math.max(left , right);
    }


    static  int  TreeKiHeight(Node node  ){
        if(node==null)
            return  0;
            return  Math.max(TreeKiHeight(node.left) , TreeKiHeight(node.right))+1;
    }

    static   int   sizeOfTree(Node  node ){
        if(node == null )
            return  0;

            int count = 1;
             count += sizeOfTree(node.left);
             count += sizeOfTree(node.right);

        return count;
    }


    static  void iterativePreorder(Node node){
        if(node ==null)
            return;
        Stack<Node>   st = new Stack<>();
        st.add(node);
                
        while(!st.isEmpty()){

                while(node.left!=null){
                    st.add(node.left);
                    node =node.left;
                }                 

                node =  st.pop();
                System.out.print(node.data+"    ");
                
                    if(node.right!=null){
                      st.add(node.right);
                      node = node.right;
                    }                
        }

    }

  static  void  preorder(Node  node  ){
        if(node==null)
        return  ; 

        System.out.print(node.data+ "  ");
        preorder(node.left);
        preorder(node.right);

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

    static  int  idx =0; 

    static  Node generateBTree(int  arr[] ){
        if(idx >= arr.length || arr[idx]==-1 ){                    
            idx++;
            return null ;
        }

            Node  node = new Node(arr[idx]);
            idx++;
            
            node.left  = generateBTree(arr);
            
             node.right =generateBTree(arr);
                         
             return  node;
    }

}