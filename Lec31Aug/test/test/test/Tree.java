
import  java.util.*;
class  Tree{

    static  class  Node{
        int  data;
        Node left ,right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right =  null;
        }
        Node(){}
    }

    static  void  display(Node  node){
        if(node==null)return;
        String  str = node.left==null ? " . <-  "+node.data : ""+node.left.data+" <-  "+node.data;
        str+= node.right==null ? "  -> ." :"  -> " +node.right.data;        
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    
    static  int  idx  = 0;

    static  Node  makeTree(int[] tree ){        
        if(idx==tree.length || tree[idx]==-1){            
            idx++;
            return  null;
        }
        Node  node =  new  Node(tree[idx]);
        idx++;
        node.left =  makeTree(tree);
        node.right =  makeTree(tree);
        return  node;
    }

    static  int  height(Node  node){
        if(node==null)return 0;
        return 1+ Math.max(height(node.left),height(node.right)); 
    }

    static  int  size(Node  node){
        if(node==null)   return 0;
        return 1+  size(node.left) + size(node.right);
    }

    static  int  max(Node node){
        if(node==null)
        return Integer.MIN_VALUE;
        return  Math.max(Math.max(max(node.left) ,  max(node.right)) ,node.data);
    }

    static  int  min(Node node){
        if(node==null)
        return Integer.MAX_VALUE;
        return  Math.min(Math.min(min(node.left) ,  min(node.right)) ,node.data);
    }

    public  static  void  main(String  s[]){
        int[] tree = {10,20,30,40,-1,-1,50,-1,-1,60,-1,70,-1,-1,80,90,100,120,-1,-1,130,-1,-1,110,-1,-1,140,-1,-1};
        Node root=makeTree(tree);
      //  display(root);        
        topView(root);
        //rightView(root);
        //leafNodePaths(root);      
        // System.out.println( "heihgt : - "+height(root));
        // System.out.println( "size :-  : - "+size(root));
        // System.out.println("max :-"  +  max(root));
        // System.out.println("min :-"  +  min(root));
        // System.out.println("find :-"  +  find(root , 40));
        // //System.out.println(l);
        // System.out.println(diameter(root));
    }


    static  void  topView(Node  root){
        if(root==null)  return ;
        LinkedList<Node>  q =  new  LinkedList<>();
        LinkedList<Integer>  hd =  new  LinkedList<>();
        HashMap<Integer , ArrayList<Integer>>   map =  new  HashMap<>();        
        q.addLast(root);
        hd.addLast(0);
        int  min = 0;
        int  max = 0;
        while(!q.isEmpty()){
            int size =  q.size();
            while(size-->0){
                Node  node  =  q.removeFirst();
                int d = hd.removeFirst();
                min =  Math.min(min , d);
                max =  Math.max(max , d);
                if(!map.containsKey(d))
                    map.put(d,  new  ArrayList<Integer>());                
                   map.get( d ).get()+node.data);
                
                if(node.left!=null)
                    {
                        q.addLast(node.left);
                        hd.addLast(d-1);
                    }
                if(node.right!=null){
                        q.addLast(node.right);
                        hd.addLast(d+1);
                }
            }
        }
        for(int  i  = min ; i<=max ;i++){
            System.out.println(map.get(i));
        }
    }


    static  void  rightView(Node  root ){
        LinkedList<Node>   q =  new  LinkedList<>();
        if(root==null)   return ;
        q.addLast(root);
        while(!q.isEmpty()){
            int  size = q.size();
            Node  prev = null;
            while(size-->0){
                Node  node  =  q.removeFirst();
                prev = node;
                if(node.left!= null)
                q.addLast(node.left);
                if(node.right!= null)
                q.addLast(node.right);
            }
            System.out.print(prev.data +" ");
        }
    }

    static  void  leftView(Node  root ){
        LinkedList<Node>   q =  new  LinkedList<>();
        if(root==null)   return ;
        q.addLast(root);
        while(!q.isEmpty()){
            int  size = q.size();
            System.out.print(q.getFirst().data+" ");
            while(size-->0){
                Node  node  =  q.removeFirst();
                if(node.left!= null)
                q.addLast(node.left);
                if(node.right!= null)
                q.addLast(node.right);
            }            
        }
    }

    static  void  zigzag(Node  node  ,   int  level   ,  int  flag ){
        if(node==null)return  ;
            System.out.print(node.data+ " ");
     
            if(flag==0){
               zigzag(node.left ,  level-1 , 1);
               zigzag(node.right ,  level-1 , 1);
            }else {
               zigzag(node.right ,  level-1 , 0);
               zigzag(node.left ,  level-1 , 0);            
            }
    }



    static int diameter(Node node){
        if(node==null)return   0 ; 
        int  lh =  height(node.left);
        int  rh =  height(node.right);
        int dl =  diameter(node.left);
        int dr =  diameter(node.right);
        return  Math.max(Math.max(dl,dr ) , lh + rh+2);
    }

    static  int  max = -1;
    static int diameter2(Node node){
        if(node==null)return   0 ; 
        
        int dl =  diameter2(node.left);
        int dr =  diameter2(node.right);
        

        return  Math.max(Math.max(dl,dr ) , max);
    }

    static  boolean  find(Node  node  ,   int  data){
        if(node==null) return  false;
        if(node.data ==  data)return  true;
        boolean  ans =  false;
        ans=   ans||  find( node.left,data);
        ans =  ans || find(node.right,data);
         return  ans;
    }

    static  ArrayList<Node>  rootToNodePath(Node  node,  int  data){
        if(node==null){return new ArrayList<>();};
        if(node.data == data){
            ArrayList<Node>  ar =  new  ArrayList<>();
            ar.add(node);return ar;
        }

        ArrayList<Node >   left=rootToNodePath(node.left , data);
        ArrayList<Node >   right=rootToNodePath(node.right , data);
        if(!left.isEmpty()){
            left.add(node);
            return  left;
        }
        if(!right.isEmpty()){
            right.add(node);
            return right;
        }
        return new ArrayList<>();
    }

    static  int  l = -1;
    static  boolean  lca(int n1, int  n2  ,  Node  node){
        if(node==null)return  false;
        if(node.data ==n1  || node.data ==  n2)return  true;

        boolean  t1 =  lca(n1,n2,node.left );
        boolean  t2 =  lca(n1,n2,node.right );
        if(t1)
        l=  node.data;
        if(t2)
        l=  node.data;
        if(t1 &&  t2){
            l =  node.data;
            return  false;
        }
        return t1 && t2;
    }

}