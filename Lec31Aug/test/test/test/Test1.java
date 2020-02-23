     class  Node<E>{
        E  data;
        Node  left ,  right;
        Node(E  data){
            this.data = data;
        }
        Node(){}
    }


class  Test1<E>{


      //size ,find   

     int size(Node  node){
        if(node==null)return  0;
        return   size(node.left)+size(node.right)+1;
    }
    
     int height(Node  node){
        if(node==null)return  0;
        return   Math.max(height(node.left),height(node.right))+1;
    }

     boolean find(Node  node ,  E  data){
        if(node==null)return  false;
        if(node.data==data)return  true;
        boolean  ans =  false;
        ans = ans || find(node.left, data);
        ans = ans ||  find(node.right, data);
        return  ans;
    }

    static  int  idx = 0 ;

     Node makeTree( E arr[]){
        if(arr[idx]==null){ idx++;return  null;}

        Node  newNode  =   new  Node(arr[idx]);
        idx++;
        newNode.left =  makeTree( arr);
        newNode.right=  makeTree(arr);
        return  newNode;
    }

      void  display(Node  node ){

        if(node==null)return  ;
        String  s = node.left ==null  ? " . <- " +node.data +" -> ": node.left.data +" <- "+ node.data +" -> " ;
        s +=  node.right==null ? " . "  : node.right.data;
        System.out.println(s);
        display(node.left);
        display(node.right);        
    }
    

    public static void main(String[] args) {
        int  start =  System.
        Integer  arr[] ={1,2,3, null,null ,4 ,9, null,null,null,5,6,null,8,null,null,7,null,null};
        Test1  t =  new  Test1();
        Node  root = t.makeTree(arr);
        System.out.println("size : -- "+t.size(root));
        System.out.println("size : -- "+t.height(root));
        System.out.println("size : -- "+t.rootToNodepath(root , ));
        t.display(root);
    }

    ArrayList<Node>  rootToNodepath(Node  node  ,E  data ){
        if(node==null)return  new  ArrayList<Node>();
        if(node.data ==   data)
            {
                ArrayList<Node>   a  =  new  ArrayList<>();
                a.add(node);
                return a;
            }
        ArrayList<E> l = rootToNodepath(node.left , data);
        if(!l.isEmpty()){
            l.add(node);
            return  l ;
        }
        ArrayList<E> r = rootToNodepath(node.right , data);
        if(!r.isEmpty()){
            r.add(node);
            return  r ;
        }
        return  new  ArrayList<Node>();
    }


}