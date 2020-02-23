import  java.util.*;

class  DirectedGraph{
    static  class   Edge{
        int v ,  w;
        Edge(int v  , int  w){
            this.v = v;
            this.w =w;
        }
    }

    static ArrayList<Edge>  graph[]  =  new  ArrayList[7];

    static  void  addEdge(int  u ,  int  v   ,int  w){
        if(u>=graph.length ||  v>=graph.length ||  u<0 || v<0) return ;
        graph[u].add(new Edge(v ,w));
        graph[v].add(new Edge(u ,w));
    }

    static void  caseI(){
        for(int  i=0 ; i<  graph.length ;i++)
            graph[i] =  new ArrayList<>();
        addEdge(0,2,1);
        addEdge(0,1,2);
        addEdge(1,3,3);
        addEdge(3,2,4);
        addEdge(2,4,5);
        addEdge(4,5,7);
        addEdge(6,4,6);
        addEdge(5,6,8);
        display();
    }

    static void  display(){
        for(int i=0;i<graph.length;i++){
            System.out.print(i +" => ");
            for(Edge  edge :  graph[i]){
                System.out.print("("+ edge.v +"," + edge.w + ")");
            }
            System.out.println();
        }
    }
    static  String  path = ""; 
    static  int  len = Integer.MIN_VALUE;
    static  void  longestPath(int  src  ,  boolean  vis[] , int  l , String  tpath){
            if(l>len){
                len = l;
                path = tpath +" "+src;
            }
            vis[src] =  true;
            for(Edge  edge :  graph[src]){
                if(!vis[edge.v])
                longestPath(edge.v , vis , l+1 , tpath+" " + src);
            }
            vis[src] = false;
    }

    static int  findParent(int vtx ,  int[]  parent){
        if(parent[vtx]!= vtx)
        parent[vtx] =  findParent(parent[vtx] ,   parent );
        return  parent[vtx];
    }

    static void merge(int  p1 , int  p2 ,int[] parent ,  int size[]){
        if(size[p1]<size[p2]){
            parent[p1] = p2;
            size[p2] += size[p1];
        }else{
            parent[p2] =  p1;
            size[p1] +=  size[p2];
        }
    }

    static  void  kruskal(){
        int[] parent = new  int[graph.length];        
        int[]  size  =  new  int[graph.length];
        for(int i =0 ;i <  graph.length; i++){
            size[i] = 1;
            parent[i] = i;
        }
        class  Node{
            int  u , v , w;
            Node(int  u , int  v, int  w){
                this.u = u ;
                this.v = v ;
                this.w = w;
            }
            Node(){}
        }

        for(int  i=0 ; i<  kgraph.length ;i++)
            kgraph[i] =  new ArrayList<>();

        PriorityQueue<Node>  q =  new  PriorityQueue<>((Node  e1 , Node  e2 )->{return  e1.w  - e2.w;});
        for(int  i =0 ; i< graph.length ; i++){
            for(Edge   edge  : graph[i] )
            q.add(new  Node(i ,  edge.v , edge.w));
        }

        while(!q.isEmpty()){
            Node  node =  q.poll();
            int  p1  =  findParent(node.u , parent);
            int  p2   =  findParent(node.v ,  parent);
            if(p1==p2)continue;
            addKEdge(node.u ,  node.v ,  node.w);
            merge(p1,p2 ,parent ,size);
        }
        System.out.println("\n\n\n");
        displayKgraph(kgraph);
    }

    static  void  addKEdge(int  u , int v ,int  w){
        kgraph[u].add(new  Edge(v ,w));
        kgraph[v].add(new  Edge(u ,w));
    }

    static  void  displayKgraph(ArrayList<Edge>[]  kgraph){
        for(int  i =0  ; i< kgraph.length ;i++){
            String  str = i+"->";
            for(Edge    edge  :  kgraph[i]){
                str+= "(" + edge.v +"," + edge.w +") ,";
            }
            System.out.println(str);
        }
    }

    static  ArrayList<Edge>  kgraph[] =  new   ArrayList[graph.length];


    public static void main(String[] args) {
        caseI();
        kruskal();    

    }

   
}