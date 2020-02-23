import java.util.*;

class  DD{
    int data;
    DD next , prev ;
    DD(int data){
        this.data = data;
        next = prev = null;
    }
}

class  Point{
    int data;
    Point  next;
    Point(int data){
        this.data  =  data;
        next =  null;
    }
}
class  Node{
    int data ;
    Node  left ,right;
    Node(int data){
        this.data = data;
        left = right=null;
    }
}

class Tree{
    /*
          1
        /    \ 
       2      3
      / \   /   \
     4   5  6   7
               /  \ 
              8   9 

                10
               /   \
             20     30
           /   \     /  \ 
          40    50  70     80
                /     \
               60      90
        int postorder[] = {40, 60 ,50,20,90,70,80,30,10};       
        int inorder[]= {40,20,60,50 ,10 ,70,90 ,30,80};
        int preorder[]= {10,20,40,50,60 ,30,70,90,80};
          */          


    public static void main(String[] args) {
         Node  root =  new Node(10);
        root.left =new Node(20);
        root.left.left =new Node(40);
        root.left.right =new Node(50);
        root.left.right.left =new Node(60);
        root.right =new Node(30);
        root.right.right =new Node(80);        
        root.right.left =new Node(70);
        root.right.left.right =new Node(90);
        //int inorder[]= {40,20,60,50 ,10 ,70,90 ,30,80};
//        int preorder[]= {10,20,40,50,60 ,30,70,90,80};
            int preorder[]= {10,20,40,50,30,70,80};
//        int postorder[] = {40 ,60, 50 ,20, 90, 70, 80, 30 ,10};
            int postorder[] = {40 ,50 ,20, 70, 80, 30 ,10};
        //Node  root1 =  formInPost(inorder , postorder , 0, postorder.length-1 , 0, inorder.length-1);
        //Node root1 = formTree(inorder,preorder , 0,preorder.length-1 , 0, inorder.length-1);
      //  preorder(root);
        //Node  root1 =  formPrePost(preorder , postorder , 0 , preorder.length-1, 0, postorder.length-1);            
        //Node n = inplace(root ,root.left, root.right);
        postOrder(root1);
        System.out.println();
        postOrder(root);
        System.out.println();

    }
    static  void inOrder(Node  node ){
        if(node==null)
        return  ;
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    static  void  postOrder(Node  root1){
        if(root1==null)
        return;
        postOrder(root1.left);
        postOrder(root1.right);
        System.out.print(root1.data+" ");
    }

    static  Node  prev = null;
    static  Node  head = null;
  /*  static void inplace(Node curr ){
            if(root==null)
                return ;

            inplace(root.left);
                if(prev==null){
                    prev  = curr;
                }else{
                    prev.right = curr;
                    curr.left = prev;
                }
                prev = curr;
            inplace(root.right);
    }*/

    static  Node  formPrePost(int pre[] , int  post[] , int  prs ,int  pree , int  pos ,int  poe){
        //int preorder[]= {10,20,40,50,30,70,80};
        //int postorder[] = {40 ,50 ,20, 70, 80, 30 ,10};
        System.exit(1);
        if(prs>pree || pos>poe)
            return  null;

        Node  node=  new Node(pre[prs]);
        int  tmp =  pre[prs+1];
        int  idx = pos;
        while(idx<=poe){
            if(tmp == post[idx])
            idx++;
        }
        int  tne = pos - idx ;
        return  node;
    }


    static Node  formInPost(int in[] , int post[] , int ps, int pe , int is, int ie){
        if(ie<is|| pe<ps)
            return null;

        Node  node =   new Node(post[pe]);
        int  idx = ie;
        while(idx>=is){
            if(in[idx] == post[pe])break;
            idx--;
        }

        //int postorder[] = {40, 60 ,50,20,90,70,80,30,10};       
        //int inorder[]= {40,20,60,50 ,10 ,70,90 ,30,80};
        int tne =  idx - is;
        node.left = formInPost( in ,post ,  ps , ps+tne-1, is, idx-1);
        node.right= formInPost( in ,post ,  ps+tne, pe-1,  idx+1, ie);
        return  node;
    }

    static  void  preorder(Node  node){
        if(node==null)
            return ;
        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
    }


    static   Node  formTree(int []in,int pre[] , int ps,int pe, int is,int ie){
            if(ie<is || pe<ps){
                return null;
            }

            Node  node  =  new Node(pre[ps]);
            int idx = is;
            while(idx<=ie){
                if(in[idx] == pre[ps]) break;
                idx++;
            }

            int tne = idx - is;
            node.left = formTree(in,pre ,ps+1 ,ps+tne ,is ,idx-1);
            node.right = formTree(in,pre , ps +tne+1 , pe , idx+1,ie);
            return node;
    }


    static  Point findIntersect( Point p1,Point p2){
            HashSet<Integer>  hs =  new HashSet<>();
            for(Point   itr =  p1 ;itr != null ;itr = itr.next)
            if(!hs.contains(itr.data))
                hs.add(itr.data);

                    Point  res = new Point(Integer.MAX_VALUE);
                    Point  tmp  = res;
            for(Point   itr =  p2 ;itr != null ;itr = itr.next){
                if(hs.contains(itr.data)){
                        res.next = new Point(itr.data);
                         res = res.next;
                }
            }
            return  tmp.next;
    }


    static   void checkTest(int arr[]){
            int  sum = arr[0],  min =arr[0] ,max =  arr[0];
            for(int  i=1;i<arr.length ;i++){
                min=arr[i] < min ? arr[i] : min; 
                max = arr[i] > max ?  arr[i] : max;
                sum+=arr[i];
            }
            int  fsum = arr.length *(min+max)/2;              
            System.out.println(fsum == sum);
    }

   static boolean    checkSubset(int []arr1 , int[] arr2){
        HashSet<Integer>   ht = new  HashSet<>();

        for(Integer i :arr1){
            ht.add(i);
        }
        for(Integer   i : arr2){
            if(!ht.contains(i))
            return  false;
        }
        return  true;
    }


    static void printVertical(Node node ,TreeMap<Integer ,ArrayList<Integer>>  hp ,int hd){
            if(node==null)return  ;
            if(!hp.containsKey(hd)){
                ArrayList<Integer>  list = new ArrayList<>();
                list.add(node.data);
                hp.put(hd ,list);
        }else{
            ArrayList<Integer>  list = hp.get(hd);
            list.add(node.data);
            hp.put(hd,list);
        }
        printVertical(node.left ,hp, hd-1);
        printVertical(node.right ,hp, hd+1);
    }

}