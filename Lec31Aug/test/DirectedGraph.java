import  java.util.*;
import  java.util.LinkedList;

class  DirectedGraph{
    static class Edge {
        int  v , w;
        Edge(int  v ,  int  w){
            this.v =  v; 
            this.w = w;            
        }
    }

    static  ArrayList<Edge>[] graph =  new  ArrayList[7];
    static  ArrayList<Edge>[] newgraph =  new  ArrayList[7];
    static   void  addEdge( int  u  , int v ,  int  w){
        if(u< 0 ||  v <   0  ||   u>=graph.length ||   v >=  graph.length )  return;
        graph[u].add( new  Edge(v,w));
        graph[v].add( new  Edge(u,w));
        //inversegraph[v].add( new  Edge(u,w));
    }

    static  void  display(){
        for(int  i=0 ; i<  graph.length ;i++){
            System.out.print(i + "=> ");
            for(Edge  edge :  graph[i]){
                System.out.print( "(" + edge.v +","+edge.w +") ");
            }
            System.out.println();
        }
    }
    static  void  caseI(){
        for(int  i= 0; i<  graph.length ;i++){
            graph[i]   =  new  ArrayList<>();
            inversegraph[i] =  new ArrayList<>();
        }        
        addEdge(0, 1,4); 
        addEdge(1, 2,4); 
        addEdge(2, 3,4); 
        addEdge(3, 0,4); 
        addEdge(2, 4,4); 
        display();
    }

    static  void topologicalOrder( int  x , boolean[]  vis ,  Stack<Integer>   st ){
        vis[x] = true;
        for(Edge edge : graph[x]) {    
            if(!vis[edge.v])
                topologicalOrder(edge.v , vis , st );
        }             
        st.push(x);
    }

    static void  topologicalSorting(){
        Stack<Integer>   st =  new  Stack<>();
        boolean[]  vis =  new  boolean[graph.length];         
        for(int   i=0 ; i<  graph.length ;i++){   
            if(!vis[i])
              topologicalOrder( i , vis , st );         
        }
        
        while(st.size()!=0){
        System.out.print(st.pop()+" ");
        }
        System.out.println();
    }

    static  void   findTopologicalOrder( int x, int[] out ,String ans ,boolean vis[]){
        Queue<Integer>   q =  new  LinkedList<>();
        q.add(x);
        while(!q.isEmpty()){
            int  tmp =  q.poll();
            vis[tmp] =  true;
            ans =  ans+ " "+tmp;
            for(Edge edge :  graph[tmp]){
                out[edge.v]--;
                if(out[edge.v]==0 &&  !vis[edge.v]){
                    q.add(edge.v);
                }
            }
        }

        for(int  i =0 ; i < graph.length ;i++){ 
            if(out[i] > 0 ){
                System.out.print("Cycle  is there");
                break;
            }
        }        
        System.out.print(ans);
    }

    static  void  kahnsAlgo(){
        int []  out =  new  int[graph.length];
        for(int i =0 ; i< graph.length ;i++){
            for(Edge edge :  graph[i] )
                out[edge.v]++;
        }
        String ans ="";
        boolean []  vis =  new  boolean[graph.length];
        for(int  i = 0; i<  graph.length ;i++){
            if(out[i]==0 &&  !vis[i]){
                vis[i] =  true;
                findTopologicalOrder( i, out , ans , vis);
            }
        }
    }

    static  int checkConnectedComp(int src , boolean[]  vis){
            vis[src]  =  true;
            for(Edge   edge :   graph[src]){
                if(!vis[edge.v])
                checkConnectedComp(edge.v ,  vis);
            }
            return 1; 
    }

    static void countStrongllyConnectedComponents(){
        boolean  vis[]  =  new  boolean[graph.length];
        int count = 0 ; 
        for(int  i=0;i< graph.length ;i++){
            if(!vis[i])
              count+=checkConnectedComp(i,vis);
        }
        System.out.println( "No of  strongly  con.  comp "+count);
    }

    static void countNodesAtLevel(int src , int lev){
        Queue<Integer> q= new LinkedList<>();
        q.add(src);
        int ans =-1;
        boolean vis[]= new boolean[graph.length];
        while(!q.isEmpty()){
            int size =q.size();
            if(lev==0){
                ans = q.size();
                break;
            }
            while(size-->0){
                int i = q.poll();
                vis[i]=true;
                for(Edge edge: graph[i])
                if(!vis[edge.v])
                q.add(edge.v);
            }
            lev--;
        }
        System.out.println("size of level"+ans);
    }

    static int countPossiblePaths(int src, int dest,boolean vis[], String path){
        if(src==dest){
            System.out.println(path+" ");
            return 1;
        }
        int count=0;
        vis[src]=true;
        for(Edge edge: graph[src] ){
            if(!vis[edge.v])
            count+=countPossiblePaths(edge.v,dest,vis, path+" "+ edge.v);
        }
        vis[src] =false;
        return count;
    }

    static  int dp[] =  new  int[100];
    static  int  solve(int arr[] ,  int  idx  ,  int  jumps ,  String  path){
        if(idx>=arr.length){
            System.out.println("End->" + path);
          if(idx==arr.length-1){
            return jumps;
          }
           return   jumps; 
        }
        if(dp[idx]!=0)
        return   dp[idx];
        int count = Integer.MAX_VALUE; 
        for(int i = 1; i <= arr[idx]; i++)
        count = Math.min( count , solve(arr, idx+i , jumps+1 , path +" " +idx) );
        return   dp[idx] = count;
    }

    static  void  minimumSteps(){
        int arr[] = { 1, 3, 6, 1, 1, 9 };
        int  ans = solve(arr , 4 , 0 ,"");
        System.out.println("steps :->"+ans);
        for(int  i=0 ; i <  arr.length+5; i ++ ){
            System.out.print(dp[i]+" ");
        }
    }

    static  int  noOfTrees(int u , boolean  vis[]){
        if(vis[u])
            return 0;
        vis[u] = true;
        int ans = 1 ;
        for(Edge edge: graph[u])
         ans &= noOfTrees(edge.v ,vis);
        return ans;
    }

    static  void  counttrees(){
        int count =0;
        boolean  vis[] =  new boolean[graph.length];
        for(int  i= 0 ; i <graph.length ; i++)
            if(!vis[i]){
                count+=noOfTrees(i,vis);
            }
            System.out.println(count);
    }

    static void prims(){
        class Node  {
            int  weight;
            int  vertex;
            int wsf ;
            int  pvertex;
            String psf;
            Node(int vertex ,int  pvertex ,  int  weight ,  int  wsf , String  psf){
                this.vertex = vertex;
                this.pvertex = pvertex;
                this.weight =  weight ;
                this.wsf = wsf;
                this.psf= psf;
            }
            Node(){}
        }

        boolean  vis[] = new boolean[graph.length];
        int sum =0 ;
        PriorityQueue<Node>   q =  new  PriorityQueue<Node>(new Comparator<Node>(){            
            public  int  compare(Node o1 ,  Node  o2){
                return o1.weight - o2.weight;
            }
        });

        ArrayList<Edge>[]  pgraph =  new  ArrayList[graph.length];
        for(int  i = 0 ; i < pgraph.length ; i++)
            pgraph[i]=  new  ArrayList<>();
            q.add(new  Node(0 , -1 , 0 , 0, ""));

        while(!q.isEmpty()){
            Node  node =   q.poll();            
            if(vis[node.vertex])
            continue;

            if(!vis[node.vertex] && node.pvertex!=-1){
                sum += node.weight;
                addPrimsEdge(pgraph , node.pvertex , node.vertex, node.weight);
            }

            vis[node.vertex] =  true;
            for(Edge edge: graph[node.vertex]){
                if(!vis[edge.v])
                q.add(new Node(edge.v , node.vertex , edge.w , node.wsf + edge.w ,node.psf+" "+edge.v ));
            }
        }
        System.out.println("\n");
        System.out.println(sum);
        System.out.println("\n");
        displayGraph(pgraph);
    }

    static  void displayGraph(ArrayList<Edge> []   pgraph ){
        for(int  i =0 ;i<pgraph.length;i++){
            System.out.print(i+"=>" );
            for(Edge  edge :  pgraph[i]){
                System.out.print("(" + edge.v +","+edge.w +") " );
            }
            System.out.println();
        }

    }

    static  void addPrimsEdge(ArrayList<Edge>[] primsgraph , int  pvertex,int  vertex ,  int  weight ){
        if(pvertex<0 || vertex<0 || pvertex>=primsgraph.length ||  vertex>=primsgraph.length)return;
        primsgraph[pvertex].add(new Edge(vertex , weight));
        primsgraph[vertex].add(new Edge(pvertex , weight));
    }

    static  int getSets(int  n  , int sum ,  int  ans , String  str , int  prev){
        if((sum+n) >= ans){
            if( ((sum+n)==ans) ){
                System.out.println(str + " "+n);
                return 1;
            }
            return 0;            
        }

        int count =0 ; 
        for(int  i = n;i<=ans ;i++ ){
            count +=getSets(i+1 ,sum+i,ans , str+" "+i  , n);
        }
        return  count;
    }

    static  void  sumNumbers(String  str){
        int i = 0 ,tmp = 0 , sum = 0;
        while(i<str.length()){
            char ch = str.charAt(i);
            tmp = 0;
            while(ch>='0' && ch<='9' && i<str.length()){
                int  n = ch-'0';
                tmp = tmp*10 + n;
                i++;
                if(i<str.length())
                ch = str.charAt(i);
           }
           if(tmp > 0)
            sum+=tmp;
            i++;
        }
        System.out.println(sum);
    }

    static void  checkMerge(){
        class  Node{
            int data;
            Node  next;
            Node(int  data){
                this.data = data;                
            }            
        }

        Node  node1 =  new  Node(1);
        node1.next =  new  Node(3);
        node1.next.next =  new  Node(5);
        node1.next.next.next =  new  Node(7);
        node1.next.next.next.next =  new  Node(11);
        node1.next.next.next.next.next =  new  Node(13);

        Node  node2 =  new  Node(1);
        node2.next =  new  Node(3);  
        node2.next.next =  new  Node(5);
        node2.next.next.next =  node1.next.next;

        int l1 = 0,l2= 0;
        Node  node =  node1;
        while(node!=null){
            l1++;
            node= node.next;
        }
        node  = node2;         
        while(node!=null){
            l2++;
            node= node.next;
        }
        int  d = Math.abs(l1-l2);
        Node lnode = l1>l2 ? node1 : node2;
        Node snode = l1<l2 ? node1 : node2;
        while(d-->0)
        lnode =  lnode.next;
        Node  ans = null;
        while(lnode!=null){
            if(lnode==snode){
                ans =  snode;
                break;
            }
            snode =  snode.next;
            lnode =  lnode.next;
        }
        System.out.println(ans.data);
    }


    static int  minimumCoins(int  coins[] , int sum , int idx , int count ,String  str) {
        if(sum<=0){
            if(sum==0){
                System.out.println(str);
                return count;
            }
            return  Integer.MAX_VALUE;
        }
        //if(dp[sum]!=0){
          //  return dp[sum];
        //}
        int c = Integer.MAX_VALUE;
        for(int  i = 0 ; i< coins.length ; i++){
            c = Math.min(c,minimumCoins(coins , sum-coins[i] , i , count+1 ,str +" "+coins[i]));
        }
        return c;
    }

      static void  mergeIntervals(int  arr[]){
        class  Interval implements  Comparable{
            int  start  , end;
            Interval(int start , int  end){
                this.start =  start;
                this.end =  end;
            }
            Interval(){}
            public  int  compareTo(Object   o1){
                return  (((Interval)o1).start-this.start );
            }
        }
        Interval   intervalArr[]  =  new  Interval[arr.length/2];
        Stack<Interval>  st =  new  Stack<>();
        for(int  i =0 ; i< arr.length ; ){
            st.add(new Interval(arr[i],arr[i+1]));
            i++; i++;
        }
        int  j= st.size()-1;
        while(!st.isEmpty())
            intervalArr[j--] = st.pop();            
      
        st.add(intervalArr[0]);
        for(int i = 1 ;i<intervalArr.length ;i++){
            Interval  tmp = st.peek();
            if(intervalArr[i].start< tmp.end){
                st.pop();
                tmp.end = intervalArr[i].end;
                st.add(tmp);
            }else{
                st.add(intervalArr[i]);
            }
        }
        String  ans ="";
        while(!st.isEmpty()){
            Interval  t =  st.pop();
             ans= t.start +" " +  t.end + " "+ans;
        }
        System.out.println(ans);
    }


    static  void hamiltonianPath(boolean vis[] ,int vertex ,String  path ,int count ,int src){
        if(count==graph.length-1)
        {
            System.out.print(path);
            for(Edge edge : graph[vertex]){
                if(edge.v==src){
                    System.out.print("CYCLE" );
                }
            }   
            System.out.println();
            return;
        }

        vis[vertex] =  true;
        for(Edge  edge : graph[vertex]){
            if(!vis[edge.v])
            hamiltonianPath(vis ,edge.v , path+" "+edge.v ,count+1 ,src);
        }
        vis[vertex] =  false;
    }

    static void  checkBipart( int  vertex  ){
            class Node{
                int  vertex;
                char  color;
                Node(int vertex , char color){
                    this.vertex  = vertex ; 
                    this.color =  color;
                }
            }

            Queue<Node>  q =  new  LinkedList<>();
            q.add(new  Node(vertex , 'G'));
            boolean flag=   true;             
            char  colarr[] =  new  char[graph.length];
            Arrays.fill(colarr,'N');
            while(!q.isEmpty()){
                    Node  node  =   q.poll();
                    if(colarr[node.vertex]!='N' && colarr[node.vertex]!=node.color){
                        flag = false;
                        System.out.println("Graph is  not  bipart");
                        break;
                    }         
                
                    colarr[node.vertex] = node.color;
                for(Edge   edge :  graph[node.vertex]){
                    if(colarr[edge.v]=='N'){    
                        char  col =  node.color == 'G' ? 'R' : 'G' ;                  
                        q.add(new Node(edge.v ,  col));
                    }
                }
            }
            if(flag)
            System.out.println("Graph is  bipartite");
    }
     
    static  boolean  detectCycleUSingtopologicalSort(int  vertex , boolean vis[] , boolean cycle[]){              
        vis[vertex] =  true;
        cycle[vertex] = true;
        boolean  ans =  false;
        for(Edge  edge :  graph[vertex]){
            if(!vis[edge.v])
            ans = ans || detectCycleUSingtopologicalSort(edge.v , vis ,  cycle);
            else if(cycle[edge.v])
            return  true;
        }
        cycle[vertex] = false;
        return ans;
    }

    static void insertIndegree(int vertex ,int indegree[] ,boolean  vis[]){
        vis[vertex] = true;
        for(Edge edge :  graph[vertex]){
            indegree[edge.v]++;
            if(!vis[edge.v]){
                insertIndegree(edge.v , indegree , vis);
            }
        }
    }

    static void  kashnsAlgo(){
        int indegree[] =  new  int[graph.length] ; 
        boolean vis[] =  new  boolean[graph.length];

        for(int i  =0 ; i<  graph.length ;i++)
        if(!vis[i]){
            insertIndegree(i , indegree , vis);
        }
        
        Queue<Integer>   q  =  new  LinkedList<>();
        Stack<Integer>  st =  new  Stack<>();
        for(int  i =0 ; i<  graph.length ; i++){
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int  vertex =   q.poll();                        
                st.push(vertex);
                  
            for(Edge  edge:  graph[vertex]){
                indegree[edge.v]--;
                if(indegree[edge.v]==0){
                    q.add(edge.v);
                }
            }
        }
        boolean  iscycle =  false;
        for(int  i =0 ;i< indegree.length ;i++){
            if(indegree[i]>0 && !iscycle){
                System.out.println("CYCLE");
                iscycle = true;
            }
        }
        while(!st.isEmpty()){
            System.out.print(st.pop());
        }
    }

    static void  topologicalStack(int vertex , boolean vis[] , Stack<Integer>  st)
    {
        vis[vertex] =  true;
        for(Edge  edge:  graph[vertex]){
            if(!vis[edge.v])
            topologicalStack(edge.v , vis , st);
        }
        st.push(vertex);
    }

    static void  dfs(int vertex , boolean vis[]){
            vis[vertex] =  true;
            for(Edge edge  :  inversegraph[vertex]){
                if(!vis[edge.v])
                dfs(edge.v ,vis);
            } 
    }

    static  void  kosaRajuAlgo(){
        boolean vis[] =  new boolean[graph.length];
        Stack<Integer>  st =  new Stack<>();
        topologicalStack(0,vis,st);
        boolean visited[] =  new boolean[graph.length];
        int count =0 ;
        while(!st.isEmpty()){
            int  v =  st.pop();
            if(!visited[v]){
                dfs(v ,visited);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        caseI();
        //kashnsAlgo();
        //kosaRajuAlgo();














        //countStrongllyConnectedComponents();
        //kahnsAlgo();
        //boolean vis[] = new boolean[graph.length];
        //System.out.println("no of paths ->"+ countPossiblePaths(2,3,vis,"2"));
        //findMinChanges(1033 , 8179);
        // minimumSteps();
        //prims();
        //System.out.println( getSets(1 , 0 , 27 ,""));
        //sumNumbers("1abc122abc120");
        //getSets(1 , 0 ,  9 , "" , 0);
        //System.out.println(s);
        //checkMerge();
        //int coins[] ={1, 2, 5, 10, 20, 50, 100, 500, 1000} ;
        //System.out.println( minimumCoins(coins , 12 , 0 , 0,"") );
        //int arr[]  ={1,3,2,4,5,7,7,9};        
        //mergeIntervals(arr);        
         //hamiltonianPath(vis, 0 ,"0",0,0);
         ///checkBipart(0);

    }
}
/*  Get Strongly  connected  components
            1.topologicalOrder return  stack
            2.graph inverse
            3.DFS for gcc 

        longest  common  substring ,  longest  common  subsequence
        Distinct subsequence  
         */