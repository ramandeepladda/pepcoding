import  java.util.*;
class Node{
    int data;
    ArrayList<Node>   childs =  new ArrayList<>();
    Node (int data){
        this.data= data;
    }
}

class  GenericTree{

    public static void main(String[] args) {
           //int arr[] = {10,20 ,30 , -1 ,40 ,-1,-1 , 50,60 ,70 ,-1 ,80,-1, -1, 90,100 , -1, 110 , -1, -1 ,120 ,-1,-1,30 ,-1,-1};
            int arr[] = {10,20 ,30 , -1 ,40 ,-1,-1 , 50,60 ,70 ,-1 ,80,-1, -1, 90,-1 ,60 ,80,-1 ,70 , -1,-1,-1, 20 ,40,-1 ,30 ,-1,-1};
            //System.out.println("length : "+arr.length);
            Node  node = constructGTree(arr);
            display(node);
            //System.out.println( "Max : "+findMax(node));
            //System.out.println( "Min : "+findMin(node));
            //System.out.println( "Find   : " +find(node, 50));
            //System.out.println( "Size  : " +treesize(node));
            ///System.out.println("height : " +  height(node));            
           // System.out.println("isMirror : " + isMirror(node , node));            
            //flatten(node);
           // display(node);
            System.out.println("------------------------------------");            
             //removeLeafs(node);
           //  makeVerticalLinear(node);
            //display(node);
       /*     Node  r =  new Node(-1);
            ArrayList<Node> res =  makeSingleChild(node);
            res.remove(0);
            r.childs.clear();
            r.data =  node.data;
            r.childs.addAll(res);
            display(r);*/
        }

        static  Node  makeVerticalLinear(Node  node){
            if(node.childs.size() == 0)
            return node;
            Node  lasttail =  makeVerticalLinear(node.childs.get(node.childs.size()-1));

            for(int i =node.childs.size()-1;i>=0;i--){
                Node  secondTail = makeVerticalLinear(node.childs.get(i-1));
                secondTail.childs.add(node.childs.remove(i));
            }
            return lasttail;
        }

        
        static  void  removeLeafs(Node  node){
            for(int  i =  node.childs.size() -1; i>=0 ; i-- ){                

            } 
        }

        /*static   ArrayList<Node>  makeSingleChild(Node  node ){
            if(node.childs.size()==0) {ArrayList<Node>  r = new ArrayList<>();
                r.add(node);
                return  r;
            }
            
            
            ArrayList<Node>   ar  =  new  ArrayList<>();            
            ar.add(node);
            for(Node  next  : node.childs){
                ar.addAll(makeSingleChild(next));
            }
           return  ar; 
        }

*/
        static  void  flatten(Node node){
            ArrayList<Node>  ch =  new ArrayList<>();
            for(Node  n  : node.childs){
                flatten(n);
                ch.add(n);
                for(int i = n.childs.size() -1 ; i>=0 ;i--){
                    ch.add(n.childs.remove(n.childs.size()-1));
                }
            }
            node.childs = ch;
        }


        static  int  height(Node  node){
            if(node.childs.isEmpty())return  1;
            int  h = 0;
            for( Node  n : node.childs)
                h =Math.max( height(n) , h);
            return  h+1;
        }

        static  int  findMax(Node node){               
            ArrayList<Node>  ar = node.childs;
            int tmpmax = node.data;
            for(Node  n : ar )
                tmpmax = Math.max(findMax(n) ,tmpmax) ;                
            return  tmpmax;
        }

        static  int  treesize(Node  node){
            ArrayList<Node>   ar=  node.childs;
            int size =  0;
            for(Node  n  : ar)
                size+=treesize(n);
            return  size+1;
        }

        static  int  findMin(Node node){               
            ArrayList<Node>  ar = node.childs;
            int tmpmin = node.data;
            for(Node  n : ar )
                tmpmin = Math.min(tmpmin , n.data);
            

            for(Node  n : ar )
                tmpmin = Math.min(findMin(n) ,tmpmin) ;                
            return  tmpmin;
        }


        static  boolean  find(Node node, int data){               
            ArrayList<Node>  ar = node.childs;
            for(Node  n : ar )
                if(n.data == data)
                return true;
            
            for(Node  n : ar ){
                boolean  res =    find(n, data);       
                if(res) return  true;
            }         
            return  false;
        }

        static  void  display(Node  node){
                System.out.print(node.data +" : ");
                ArrayList<Node>  ar = node.childs;
                for(Node  n : ar )
                    System.out.print(n.data +" ");                            
                System.out.println();
                for(Node  n : ar )
                    display(n);                
        }

    static  Node  constructGTree(int  arr[] ){
            LinkedList<Node> ll = new LinkedList<>();
            for(int  i=0 ;i<=arr.length -1;i++){
                if(arr[i] != -1){
                    Node  node =  new Node(arr[i]);
                    ll.addFirst(node);
                }else{
                    Node  rnode = ll.removeFirst();
                    ll.getFirst().childs.add(rnode);
                }
            }
            return  ll.removeFirst();
    }

    static  boolean  isMirror(Node  node1 ,Node  node2){
        if(node1==null && node2!=null || node1!=null && node2==null)
        return  false;
        if(node1.childs.size()!= node2.childs.size())
        return  false;
        if(node1.data != node2.data)return  false;
            for(int  i =0 , j = node1.childs.size() -1;i<node1.childs.size() ; i++, j--){
                Node  child1 =  node1.childs.get(i);
                Node  child2 =  node2.childs.get(j);
                boolean  res = isMirror(child1 , child2);
                if(!res) return  false;
            }

        return  true;
    }
}