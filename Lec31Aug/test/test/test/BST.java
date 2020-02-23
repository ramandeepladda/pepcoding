import  java.util.*;

class  BST{

    static class Node {
        int data , height = -1 ,  bf = 0;
        Node  left ,  right; 
        Node(int data ){
            this.data = data;
        }
    }

    static  void  display(Node  node){
        if(node==null)return;
        String  str = node.left==null ? " . <-  "+node.data : ""+node.left.data+" <-  "+node.data;
        str+= node.right==null ? "  -> ." :"  -> " +node.right.data;        
        System.out.println(str);
        display(node.left);
        display(node.right);
    }


    static  void  iterativeInorderPostOrderPreOrder(Node  head){
        class  Pair{
            boolean  selfDone ;
            boolean  leftDone;
            boolean  rightDone;
            Node  node ;
            Pair(Node  node){
                this.node =  node;
            }
            Pair(){}
        }

        Stack<Pair>  st =  new  Stack<>();
        st.add(new  Pair(head));
                
        while(!st.isEmpty()){
            Pair  pair  =   st.peek();
            if(!pair.selfDone){
                System.out.println(pair.node.data +" ");
                pair.selfDone = true;
            }else if(!pair.leftDone){
                if(pair.node.left!=null){
                    st.add(new  Pair(pair.node.left));
                }
                pair.leftDone =  true;
            }else if(!pair.rightDone){
                if(pair.node.right!=null){
                    st.add(new  Pair(pair.node.right));
                }
                pair.rightDone =  true;
            }else{
                st.pop();
            }
        }
    }


    static  void  printVertical(Node  node){
        class  Pair{
            Node  node ; 
            int hd;
            Pair(Node  node ,  int  hd){
                this.node =  node;
                this.hd =  hd;
            }
        }
        Queue<Pair>  q =  new  LinkedList<>();
        q.add(new  Pair(node , 0));        
        while(!q.isEmpty()){
            
        }
    }

    static  Node  pred =  null;
    static  Node  succ =  null;
    static void predSuccInBst(Node  head , int  data){
        Node  node =  head;
        while(node!=null &&  node.data!=data){
            if(node.data ==  data){
                break;
            }
            pred =  node;            
            if(data<node.data){
                node=   node.left;
            }else if(data >  node.data){
                node =   node.right;
            }
        }

            while(pred.left!=null){
                pred =  pred.left;            
            }
            while(pred.right!=null){
                pred =  pred.right;
            }
    System.out.print("predecessor  " :   pred.data);
    }


    static  void  width(Node  node ,   int  hd ,  int  ar[]){
        if(node==null) return ;
        ar[0] = Math.min(ar[0] ,hd);
        ar[1] = Math.max(ar[1] ,hd);
        width(node.left ,  hd-1  , ar):
        width(node.right ,  hd+1  , ar):
    }

    static  void  topView(Node  node ){
        int  ar[] =  new  int[2];
        width(node,  0 , ar);    
        int wide  =  ar[1] - ar[0]+1;
        ArrayList<ArrayList<Node>>  ll =  new  ArrayList<>();
        for(int  i =0 ; i <  wide ;   i++)
            ll.add(new  ArrayList<Integer>);
        Queue<Node>    q =  new  LinkedList<>();
        q.add(node);

    }


    public static void main(String[] args) {
        int arr[] ={10,20,30,40,50,60,70,80,90};
        //Node  head = makeBST(arr , 0, arr.length-1);
        Node  head = null;
        for(int  i = 1; i<9;i++ ){
            head =  addData(head , i*10);
        }
        //printVertical(head);

        display(head);
        predSuccInBst(head , 60);
       // System.out.println();
       // System.out.println(find(head ,  90));
       // System.out.println(findIterative(head , 90));
       ////head = removeData(head ,  70);
        //System.out.println("\n\n  After removing  data--");
        //display(head);
       // iterativeInorderPostOrderPreOrder(head);
    }

    static  int maxData(Node node){
        if(node.right !=null){
            Node  n =  node.right;
            while(n.right !=null){
                n =  n.right;
            }
            return  n.data;
        }
        return node.data;
    }

    static  Node  removeData(Node node  , int  data){
        if(node==null)return  null;
        if(node.data ==  data){
            if(node.right==  null ||   node.left ==  null){
                return  node.right ==  null  ?   node.left :  node.left;
            }

            int  maxData  =    maxData(node.left);
            node.data =  maxData;
            node.left =  removeData(node.left ,  maxData);
        }else  if(node.data < data){
            node.right  = removeData(node.right ,  data);
        }else if(node.data >  data){
            node.left =  removeData(node.left ,  data);
        }

        return  balanceAvl(node);
    }



    static  boolean find(Node  node,  int data){
        if(node==null)return false;
        
         if(data==node.data){
            return true;
        }else if(node.data < data){
            return find(node.right , data);
        }else if(data < node.data){
            return  find(node.left , data);
        }
        return  false;
    }

    static  Node addData(Node  node,  int data){
        if(node==null)
        return  new  Node(data);
          if(node.data < data){
            node.right  = addData(node.right , data);
        }else if(data < node.data){
            node.left = addData(node.left , data);
        }
        return balanceAvl(node);
    }

    
    static  boolean  findIterative(Node  root , int data){
        Queue<Node>  q =  new  LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node  node  =   q.poll();
            if(node.data==data)
            return  true;
            else if(node.data <  data  && node.right!= null){
                q.add(node.right);
            }else if(node.data >  data &&  node.left !=null) {
                q.add(node.left);
            }
        }
        return  false;
    }

    static Node  predecessor(Node  node , int data ){
        Node  succ =  null;
        Node  pred =  null;
        while(node!=null){
            if(node.data==data){
                if(node.right!=null){
                    succ =  node.right;
                    while(succ.left!=null){
                        succ =  succ.left;
                    }
                }

                if(node.left!=null){
                    pred =  node.left;
                    while(pred.right!=null){
                        pred =  pred.right;
                    }
                }
            }else if(node.data <  data){
                pred =  node;
                node =  node.right;
            }else if(node.data >  data){
                pred =  node;
                node = node.left;                
            }
        }
        return pred;
    }

    //####################Implement Floor  ans  ceil in BST iterative  and  using Pair class

    static Node  successor(Node  node , int data ){
      
        return null;
    }



    static  void  inorder(Node  head ){
        if(head ==  null)return;
        inorder(head.left);
        System.out.print(head.data+" ");
        inorder(head.right);
    }

    static  Node  makeBST(int arr[],  int   l ,int r){
           if(l>r)
            return null;
            int mid =  (l+r)/2;
            Node node  = new Node(arr[mid]);
            node.left =  makeBST(arr , l ,  mid-1);
            node.right =  makeBST(arr ,  mid+1 , r);
            
            return  node;
    }




    //############AVL -----------
    static  Node  ll(Node  x){
        Node  y = x.left;
        x.left =  y.right;
        y.right =  x;
        updateBalanceFactorAndHeight(x);
        updateBalanceFactorAndHeight(y);
        return  y;
    }

    static  Node  rr(Node  x){
        Node  y = x.right;
        x.right=  y.left;
        y.left =  x;
        updateBalanceFactorAndHeight(x);
        updateBalanceFactorAndHeight(y);
        return  y;
    }


    static  void  updateBalanceFactorAndHeight(Node node){
        int  lh =  -1;
        int  rh =  -1;
        if(node.left!=null)
            lh  = node.left.height;
        if(node.right!=null)
            rh  = node.right.height;
        node.height =  Math.max(lh , rh) +1;
        node.bf =  lh-rh;
    }

    static  Node  balanceAvl(Node  node  ){
            updateBalanceFactorAndHeight(node);
        if(node.bf==2){//ll,lr         
            if(node.left.bf==1){//ll
                return ll(node);
            }else{//lr
                node.left =  rr(node.left);
                return  ll(node);
            }
        }else if(node.bf==-2){
            if(node.right.bf==-1){//rr
                return rr(node);
            }else{//rl
                node.right =  ll(node.right);
                return  rr(node);
            }
        }
        return  node;
    }
}