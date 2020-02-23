import  java.util.*;
import  java.io.*;
import  java.util.LinkedList;
class  Graph{
    public  static Scanner  sc =  new  Scanner(System.in);
    static ArrayList<Edge>[] graph = new  ArrayList[7];
    static ArrayList<Edge>[] graph3 = new  ArrayList[3];
    static  ArrayList<ArrayList<Edge>>  graph1 =  new  ArrayList<>();

    public static class Edge{
            int v = 0;
            int  w=0;
            Edge(){}

            Edge(int v ,  int  w){
                this.v =  v;
                this.w = w;
            }
    }

    public  static  void caseI(){
        for(int  i =0;i<graph.length;i++)
            graph[i] = new  ArrayList<Edge>();    

         addEdge(0,1,10);
         addEdge(0,3,10);        
         addEdge(1,2,10);        
         addEdge(2,3,40);        
         addEdge(3,4,2);
         addEdge(4,5,2);
            addEdge(4,6,8);
        // //addEdge(5,2,1);//for hamiltonian  path
       // addEdge(2,5,1);//for hamiltonian  path
        addEdge(5,6,3);
        display();            
    }

    public  static  void caseII(){
        for(int  i =0;i<7;i++){
            graph1.add(new  ArrayList<Edge>());
        }
        addEdge1(0,1,10);
        addEdge1(0,3,10);
        addEdge1(1,2,10);
        addEdge1(2,3,40);
        addEdge1(3,4,2);
        addEdge1(4,5,2);
        addEdge1(4,6,8);
        addEdge1(5,6,3);
        display1();        
    }


    public  static  void caseIII(){//for  creating disconnected graphs
       for(int  i =0;i<graph.length;i++)
            graph[i] = new  ArrayList<Edge>();    

        addEdge(0,1,10);
        addEdge(0,3,10);
        addEdge(1,2,10);
        addEdge(2,3,40);
        
        addEdge(4,5,2);
        addEdge(4,6,8);
        addEdge(5,6,3);
        display();        
    }

    static  void  addEdge1(int u ,int  v ,  int  w){
        if(u<0 || v<0 || w< 0  ||  u>=graph1.size() || v>graph1.size() ||  w < 0  )return;
            graph1.get(u).add(new  Edge(v, w));
    }

    static  void  display1(){
        for(int  i =0 ; i < graph1.size() ; i++ ){
            System.out.print(i+"=> ");
            for(Edge edge :  graph1.get(i)){
                System.out.print(  "("+edge.v +"," + edge.w +") " );
            }
            System.out.println(  "");
        }
    }

    static  void addEdgeDij(int  u  , int v,  int w){
            if(u>=0 && v>=0 && w>=0 && u<arr.length && v<arr.length ){
                arr[u].add(new Edge(v,w));
                arr[v].add(new Edge(u,w));
            }
    }    

    static  void addEdge(int  u  , int v,  int w){
            if(u>=0 && v>=0 && w>=0 && u<graph.length && v<graph.length ){
                graph[u].add(new Edge(v,w));
                graph[v].add(new Edge(u,w));
            }
    }

    static   void  displayDij(){
        for(int  i =0 ;i< arr.length ; i++){
            System.out.print( i +"=>" +"");
            for(int  j =0  ;j< arr[i].size() ;j++){
                System.out.print(  "("+arr[i].get(j).v +"," +arr[i].get(j).w +") " );
            }
            System.out.println("");
        }
    }

    static   void  display(){
        for(int  i =0 ;i< graph.length ; i++){
            System.out.print( i +"=>" +"");
            for(int  j =0  ;j< graph[i].size() ;j++){
                System.out.print(  "("+graph[i].get(j).v +"," +graph[i].get(j).w +") " );
            }
            System.out.println("");
        }
    }

    static  void removeVertex(int u){            
        for(int  i =0;i<graph.length ;i++){
            ArrayList<Edge>  rem =  new  ArrayList<>();
            for(Edge   edge  :   graph[i]){
                    if(edge.v==u){
                        rem.add(edge);
                    }
            }
            graph[i].removeAll(rem);
        }
        graph[u] =  new ArrayList<>();
    }


    static  int  findPath(int u ,  int v ,boolean vis[],  String  ans){
        if(vis[u])
            return 0;
        if(u==v){
            System.out.println(ans);
            return 1;
        }   
        int count = 0 ;
        vis[u] =  true;
        for(Edge  edge  : graph[u]){              
              count+=findPath( edge.v , v , vis,   ans+"" );
        }
        return  count;
    }

       static  void removeVertex1(int u){            
        for(int  i =0;i<graph1.size() ;i++){
            ArrayList<Edge>  rem =  new  ArrayList<>();
            for(Edge   edge  :   graph[i]){
                    if(edge.v==u){
                        rem.add(edge);
                    }
            }
            graph[i].removeAll(rem);
        }
        graph[u] =  new ArrayList<>();
    }

    static  void  removeEdge(int u ,  int v){
         Edge  tmp =  null;
        for(Edge  edge  : graph[u]){
            if(edge.v==v){
                tmp = edge;
            }
        }
         graph[u].remove(tmp);
        for(Edge  edge  : graph[v]){
            if(edge.v==u){
                tmp = edge;
            }
        }
         graph[v].remove(tmp);
    }


    static    void  preOrder(int   u , boolean  vis[] , String   ans  , int max){                      
            vis[u] =  true;
            System.out.println(u+"->"+ans + " " + "@" + max);
            for(Edge  edge  :  graph[u]){
                if(!vis[edge.v])
                {
                    preOrder(edge.v  ,  vis ,   ans+" " + edge.v , max + edge.w);
                }
            }            
            vis[u] =  false;
    }


    static  int fwt  =Integer.MAX_VALUE ;
    static  String  str = "";
    static  void  lightweight(int   u , int v ,  boolean  vis[] , String   ans  , int min){                      
        if(u==v){
            if(min <   fwt){
                 fwt =  min;
                 str =  ans;  
            }
        }
            vis[u] =  true;
            for(Edge  edge  :  graph[u]){
                if(!vis[edge.v])
                {

                    lightweight(edge.v  , v,  vis ,   ans+" " + edge.v , min + edge.w);
                }
            }            
            vis[u] =  false;
    }

    static  int fwtMax  =Integer.MIN_VALUE ;
    static  String  strmax = "";

    static  void  heaviestweight(int   u , int v ,  boolean  vis[] , String   ans  , int max){                      
        if(u==v){
            if(max >   fwtMax){
                 fwtMax =  max;
                 strmax =  ans;  
            }
        }
            vis[u] =  true;
            for(Edge  edge  :  graph[u]){
                if(!vis[edge.v])
                {

                    heaviestweight(edge.v  , v,  vis ,   ans+" " + edge.v , max + edge.w);
                }
            }            
            vis[u] =  false;
    }
    static  int printAllPaths(int  u , int  v, boolean [] vis,String  ans){
        vis[u] =  true;
        int count =0;
        for(Edge  edge :  graph[u]){
            if(!vis[edge.v]){
            count+= printAllPaths(edge.v, v , vis ,  ans+"->"+edge.v);
            }
        }   
        vis[u] = false;         
        return count;
    }

    static void  printAllPossiblePaths(int   u ){    
        for(int  i =0 ;i< graph.length ; i++){
            boolean vis[] = new  boolean[graph.length];
            System.out.print(i +": --:");
             printAllPaths(0 ,  i  , vis ,   "0");
        }
    }

    static   void  hamiltonianPath(int  u ,   int  count ,   int  w   , boolean   vis[] ,  String  ans  ,  int  org){
        if(count==graph.length-1){
            System.out.print(ans);
            if(graph[u].size()!=0){
                for(Edge  edge : graph[u]){
                    if(edge.v ==   org){
                           System.out.print("->CYCLE");
                    }
                }
            }
            System.out.println();
        }

        vis[u] = true;
        for(Edge edge :  graph[u]){
            if(!vis[edge.v]){
                hamiltonianPath(edge.v ,count+1 ,  w+ edge.w  , vis  ,  ans + " "+  edge.v ,  org);
            }
        }
        vis[u] = false;
    }



    static  class  Info{
        int vertex;
        String  path;
        int weight;
        Info(int vertex ,String  path , int weight){
            this.vertex = vertex;
            this.path = path;
            this.weight = weight;
        }
        Info(){}
    }

    static  void  BFS(int src ,  int dest){
        LinkedList<Info> q =  new  LinkedList<>();
        Info  tinfo = new  Info(src ,src+"" ,0);
        q.addFirst(tinfo);                
        int countCycle = 0;        
        boolean  vis[] = new  boolean[graph.length];
        boolean  isShortPathFound = false;
        int  level = 1;

        while(!q.isEmpty()){                
                int size =   q.size();
            while(size-->0){
                Info  tmp =  q.removeFirst();
                if(vis[tmp.vertex]){
                    System.out.println("Cycle:"+countCycle+" ->"+ tmp.path);
                    countCycle++;
                }
                vis[tmp.vertex] =  true;
                if(tmp.vertex==dest && !isShortPathFound){
                    System.out.println("Short patwh ->" +tmp.path +" with level:"+level);
                    isShortPathFound =  true;
                }

                for(Edge  edge  :  graph[tmp.vertex]){
                    if(!vis[edge.v]){                        
                            Info  info = new  Info(  edge.v ,tmp.path+ edge.v,tmp.weight+ edge.w );
                            q.addLast(info);
                    }
                }
        }
            level++;       
        }   
        System.out.print("no of  cycle "+countCycle);
    }

    static  void  BFS01(int src ,  int dest){
        LinkedList<Info> q =  new  LinkedList<>();
        Info  tinfo = new  Info(src ,""+src ,0);
        q.addFirst(tinfo);  
        q.addLast(null);    
        int  countCycle = 0;                    
        boolean  vis[] = new  boolean[graph.length];
        boolean  isShortPathFound = false;
        int  level = 1;

        while(q.size()!=1){
                Info  tmp =  q.removeFirst();                
                if(vis[tmp.vertex]){
                    countCycle++;
                    System.out.println("Cycle:"+countCycle+" ->"+ tmp.path);
                }
                vis[tmp.vertex] =  true;
                if(tmp.vertex==dest && !isShortPathFound){
                    System.out.println("Short path ->" +tmp.path +" with level:"+level + "  Weight: " +tmp.weight);
                    isShortPathFound =  true;
                }

                for(Edge  edge  :  graph[tmp.vertex]){
                    if(!vis[edge.v]){                        
                            Info  info = new  Info(  edge.v,""+tmp.path+ edge.v, tmp.weight+ edge.w );
                            q.addLast(info);
                    }
                }
               if(q.getFirst()==null) {
                   q.removeFirst();
                   q.addLast(null);
                   level++;
               }                
        }   
        System.out.print("no of  cycle "+countCycle);
    }

    static  class  Marker{
        int vertex;
        char color;
        Marker(int vertex ,  char  color ){
            this.vertex  =  vertex ;
            this.color  =  color;
        }
        Marker(){}
    }

        static  boolean   checkBiPartGraphs01(int  u ,  char  vis[] ){
            Queue<Marker>   q =  new  LinkedList<>();
            q.add(new  Marker(u , 'R' ));  
            boolean  ans  =   true;
            while(!q.isEmpty()){
                int  size =  q.size();
                while(size-->0){
                    Marker  tmp =  q.poll();
                    if(vis[tmp.vertex] != 'N' ){ 
                        if(vis[tmp.vertex]!=tmp.color){
                            System.out.println("Graph  is  not  bipart at vertex : " + tmp.vertex+"  ");                       
                            ans = false;
                        }else {
                            System.out.println("Graph  is  bipart at vertex : " + tmp.vertex+"  ");                       
                            ans=  true;
                        }
                    }
                    vis[tmp.vertex] =  tmp.color;
                    for(Edge   edge  :  graph[tmp.vertex]){
                        if(vis[edge.v]=='N'){
                        char  ch =  tmp.color == 'R' ? 'G' : 'R';                        
                        q.add(new Marker(edge.v , ch ));                        
                        }
                    }
                }
            }
        return  ans;
    }
        
    static  ArrayList<Edge> arr[] =  new ArrayList[graph.length];

    static void dijkstra(int src ,  int dest){
        
     class  PNode{
        int vertex ;
        int pvertex ;
        int weight ;
        int  wsf ;
        String  psf;
        PNode(int vertex , int pvertex ,  int weight ,  int wsf , String psf){
            this.vertex = vertex;
            this.pvertex =  pvertex;
            this.weight =  weight;
            this.wsf =  wsf;
            this.psf =  psf;
        }
            PNode(){}
        }  

        boolean vis[]=  new boolean[graph.length];

        for(int  i=0;i<arr.length ;i++){
            arr[i]= new ArrayList<>();
        }

        PriorityQueue<PNode>  q =  new PriorityQueue<>(new Comparator(){
            public int compare(Object o1  ,  Object o2){
                PNode p1= (PNode)o1;
                PNode p2= (PNode)o2;
                return p1.wsf - p2.wsf;
            }
        });
        boolean  isPathFound=false;
        q.add(new PNode(src,-1,0,0,""+src));            
    while(!q.isEmpty()){
        PNode  node =  q.poll();        
        if(vis[node.vertex])
            continue;

        
        if(node.pvertex!=-1  ){            
            addEdgeDij(node.pvertex, node.vertex , node.weight);
        }
        if(node.vertex== dest){
            isPathFound = true;
            System.out.println("Path So far : --"+node.psf);
            isPathFound =  true;
        }
        vis[node.vertex] =  true;
        for(Edge edge  :   graph[node.vertex]){
            if(!vis[edge.v])
            q.add(new PNode(edge.v , node.vertex , edge.w , node.wsf+edge.w,node.psf+"->"+edge.v));
        }
    }
    System.out.println("\n\n\n");    
    displayDij();
    }

    static  void prims(int src){
        class PNode{
            int vertex;
            int  pvertex;
            int weight ;

            PNode(int vertex ,  int  pvertex , int weight ){
                this.vertex =  vertex;
                this.pvertex =  pvertex;
                this.weight =  weight;
            }
            PNode(){}
        }
        for(int  i=0 ;i< arr.length ;i++)
            arr[i] =  new  ArrayList<>();
                        
        PriorityQueue<PNode>  q =  new  PriorityQueue(new Comparator(){
            public  int  compare(Object  o1 , Object  o2){
                PNode p1 =  (PNode )o1;
                PNode p2 =  (PNode)o2;
                return  p1.weight - p2.weight;
            }
        });
        q.add(new PNode(src,-1,0));
        boolean  vis[] =  new  boolean[graph.length];
        while(!q.isEmpty()){
            PNode  node =  q.poll();
                if(vis[node.vertex])
                    continue;
                if(!vis[node.vertex]){
                    addEdgeDij(node.vertex ,  node.pvertex , node.weight);
                }
            vis[node.vertex] =  true;
            for(Edge  edge :  graph[node.vertex]){
                if(!vis[edge.v])
                q.add(new PNode(edge.v,  node.vertex ,  edge.w));
            }
        }
        System.out.print("\n\n\n");
        displayDij();
    }

    static  int find( int vtx ,int [] parent){
        if(parent[vtx]!=vtx){
            parent[vtx] = find(parent[vtx] , parent);
            return parent[vtx];
        }
        return vtx;
    }

    static  void union(int p1 , int p2 ,int parent[] , int[] size){
        if(size[p1]<=size[p2]){
            parent[p1] = p2;
            size[p1]+=size[p2];
        }else{
            parent[p2] = p1;
            size[p2]+=size[p1];
        }
    }

    static  void addEdge12(int u , int v , int  w){     
        if(u<0 ||  v < 0 || u>=kgraph.length ||  v>= kgraph.length)return;
        kgraph[u].add(new Edge(v,w));
        kgraph[v].add(new Edge(u,w));
    }

    static  void kruskal(){
        class  KEdge{
            int u ,  v ,   w;
            KEdge(int  u,  int  v , int  w){
                this.u  =  u;
                this.v = v;
                this.w =  w;
            }
            KEdge(){}
        }

        for(int  i=0 ;i< kgraph.length ;i++)
         kgraph[i] =  new ArrayList<>();

        int size[]  =  new int[graph.length];
        int parent[]  =  new int[graph.length];
        
        for(int i=0;i<graph.length ;i++){
            size[i] = 1;parent[i] = i;
        }

        PriorityQueue<KEdge> q = new  PriorityQueue<>(new Comparator(){
            public  int compare(Object  o1  ,  Object  o2){
                    KEdge  e1 = (KEdge)o1;
                    KEdge  e2 = (KEdge)o2;
                    return e1.w-e2.w;
            }
        });

        for(int i=0;i<graph.length ;i++){
            for(Edge  edge :  graph[i])
                q.add(new KEdge(i , edge.v, edge.w));
        }

           while(!q.isEmpty()){
                KEdge  edge = q.poll();                
                int p1 = find(edge.u , parent);
                int p2 = find(edge.v , parent);
                if(p1!=p2){
                    addEdge12( edge.u ,edge.v ,edge.w);
                    union(p1,p2 , parent , size);
                }                
           }   
           System.out.println("\n\n\n");              
        display12();
    }

    static ArrayList<Edge>[]  kgraph =  new  ArrayList[7];
    static  void  display12(){
        for(int  i =0 ; i < kgraph.length ; i++ ){
            System.out.print(i+"=> ");
            for(Edge edge :  kgraph[i]){
                System.out.print(  "("+edge.v +"," + edge.w +") " );
            }
            System.out.println(  "");
        }
    }

    // static  void  ArticulationPoint(){
    //     int parent[] =  new  int[graph.length];
    //     int dis[] =  new  int[graph.length];
    //     int low[] =  new  int[graph.length];
    //     int time = 0;
    //     DFS(parent , dis ,   low ,  time);        
    // }

    // static  void  DFS(int  vertex, int  dis[] ,  int  parent[]   ,  int  low[] , int  time){
    //     dis[vertex] =  low[vertex]  =  time; 
    //     for(Edge  edge :  graph[vertex]){
    //         if(dis[vertex]!=-1){
    //             DFS(edge.v ,  dis ,  parent ,   low ,  time+1);
    //         }
    //     }
    // }
    static   String minCountPath = "";
    static  int minCountLength= Integer.MAX_VALUE;

    static int  minimumPaths(int[]  arr  ,  int  idx ,   String  path , int countLength){
        if(idx>=arr.length-1 ){
            if(countLength <  minCountLength){
                minCountPath =   path;
                minCountLength =  countLength;
                return 1;             
            }
            return   0; 
        }

        int count =0;
        for(int  i = 1;i<=arr[idx];i++){            
            count+=minimumPaths(arr,  idx+i , path+" "+ arr[idx] ,   countLength +1);
        }
        return  count;
    }
    
    static int  minimumPathsMem(int[]  arr  ,  int  idx , String  path , int countLength ){
        if(idx>= arr.length){
            return  countLength;
        }
        if(dp[idx]!= 0){
            return  dp[idx];
        }

        int count =0;
        for(int  i = 1;i<=arr[idx];i++){            
            dp[idx] = Math.min( minimumPaths(arr,  idx+i , path+" "+ arr[idx] ,   countLength +1) , dp[idx+i]);
        }
        return  dp[idx]+1;
    }

    static  void  minlen(int arr[] ){
        int count = 0; 
        int dp[] =  new  int[arr.length];
        for(int  i =0 ;i<  dp.length ;i++)
            dp[i] =  Integer.MAX_VALUE/2;
            dp[arr.length-1] = 0;
        for(int i = arr.length -2 ; i>=0 ;i--){
            int  min = Integer.MAX_VALUE /2;
            for(int  j=1;j< arr[i] && i+j<arr.length; j++){
                    min = Math.min(dp[i+j] ,min );
            }
            dp[i] = min+1;
        }
        System.out.print("Steps >" +dp[0]);
    }

    static  int  pairForPicnic(int countPair ,String  pattern){
        if(countPair<=0){
            if(countPair==0){
                System.out.println(pattern);
                return 1;
             }
            return 0;
        }
        int count = 0;
        if(dp[countPair] !=0)
        return  dp[countPair];
        count += pairForPicnic(countPair-1 , pattern+"s ");
        count += pairForPicnic(countPair-2 , pattern+"p ") * (countPair-1);
        return  dp[countPair] = count;
    }
    static  int dp[][] =  new int[5][5] ;

    static  int  distributeIntoSetTabulation(int n , int  k ){
        int dp[][] =  new int[5][3];

        for(int  i=1; i< n;i++){
            for(int  j =1 ; j<  k;j++){
                dp[i][j] +=  dp[][] = 
            }   
        }
        return dp[n][k] ;
    }

    static  int  distributeIntoSetMemoization(int n , int  k ,  String set ){
            if(n==0 ||  k==0)
                return 0;
            
            if(k==n)return1;

            if(dp[n][k]!=0)
            return  dp[n][k]; 

            int count =  0;
            count+=distributeIntoSet(n-1 ,  k ,set+" " + n-1) * k;
            count+=distributeIntoSet(n-1 ,  k-1 ,set+" " + n-1) ;
            return  dp[n][k] = count;
    }


    static  void countPairForPicnic(int  n ){
        int dp[] =  new  int[n+2];
        dp[0] = dp[1]= 1;
        for(int i =2;i<dp.length; i++)
            dp[i] = dp[i-1] + (dp[i-2]* (i-1)); 
        System.out.print(dp[n]);
    }


    static  int[]   dp = new int[100];
    public static void main(String[] args) {     
        //caseII();
    caseI();
    int arr[]  = { 1,3,0,4,0,0,2,1,1,0};
    ///for(int  i =0 ; i<   dp.length ;i++)
       // dp[i] = Integer.MAX_VALUE/2;
     dp[1] =dp[0] =1;     
     dp[2] =2;
    System.out.println( pairForPicnic(5 , "") );
    //System.out.println( minimumPathsMem(arr ,  0 , "" , 0) );
    //minlen(arr);
    //System.out.println( pairForPicnic(3,""));
    //System.out.println(minCountLength );
    //tarjansAlgo();
    //kruskal();

    //prims(2);
    //dijkstra(0 ,6);
       // removeVertex(4);
        //System.out.println("--------After removing Vertex");          
         //System.out.print("VALUE->"+vis[0]);
         //System.out.println(printAllPaths(0, 6,vis,"0"));
         //preOrder(0 ,vis , "0" , 0);
         //System.out.println(longestWeightPath(0 ,vis  ,  "0" ,  0));
         //heaviestweight(0 ,6 ,  vis , "0" ,0);
         //hamiltonianPath(2,   0,  0  , vis , "2"  , 2);
         //KthLargest();
         //System.out.print(strmax +"  "+  fwtMax );
         //BFS01(0,6);
         //caseIII();
         //BSF_findDisconnectedGraphs(0);
         
         /*for(int  i =0;i <graph.length ;i++){
             if(vis[i]=='N'){
                 System.out.println( checkBiPartGraphs01( i, vis));
             }
         }*/    
        // System.out.println(((PNode)q.remove()).vertex);
         //System.out.println(((PNode)q.remove()).vertex);
         //System.out.print( checkBiPartGraphs01(0 ,  vis));
         //System.out.print(info.weight);
         //System.out.print(info.weight);
         
    }
}

/*
cycle ,shortest  path , length
*/
//preorder , postorder ,  lognest weight path ,  smallest  weight  path ,   ceil  value  of a weight , floor  value of   weight  number   ,  hamisltonian path ,hamisltonian  cycle  ,  Kth  largest  path , journey to  the moon , BFS ,count cycles , count disconnected  graphs.
//isConnected :   GCC = 1
//Tree :- cycle=0 ,  Graph  Connected components(GCC)  = 1 
//Forest :- cycle=0 ,  Graph  Connected components(GCC)  >1
//PriorityQueue top()-->O(1) , push()-->O(klogk)
//Articulation point is a point in graph  removing which increases the number of  components in graph.
//Articulation Bridge is  an edge  removing which  increases the number of  components in  graph.