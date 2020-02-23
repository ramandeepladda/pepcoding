import java.util.*;
class  Graph{

    static class Edge{
        int  w  , v;        
        Edge(int v  ,int w){
            this.v=  v;
            this.w =  w;
        }
        Edge(){}
    }

    static ArrayList<Edge>[]   graph =  new  ArrayList[7];

    static void  addEdge(int  u ,int v , int w){
        if(u>=graph.length || v>=graph.length || u<0 || v<0 )return;
            graph[u].add(new Edge(v , w));
            graph[v].add(new Edge(u , w));

        
    }

    static  void  caseI(){
        for(int  i =0 ; i< graph.length ; i++)
            graph[i] = new ArrayList<>();


        addEdge(0,1,1);
        addEdge(0,3,3);
        addEdge(1,2,2);
        addEdge(2,3,3);
        addEdge(3,4,4);
        addEdge(4,5,5);
        addEdge(4,6,6);
        addEdge(5,6,6);        
    }

    static  void  BFS(int u){
            Queue<Integer> q =   new  LinkedList<>(); 
            q.add(u);
            boolean  vis[] =  new  boolean[graph.length];
            while(!q.isEmpty()){
                int  v =  q.poll();
                if(!vis[v])
                System.out.print(v+" ");
                vis[v] =  true;

                for(Edge  edge :  graph[v]){
                    if(!vis[edge.v]){
                        q.add(edge.v);
                    }
                }
            }
    }
    

    static  void  DFS(int  u ,  boolean  vis[]){
        vis[u]=true;
        System.out.print(u+" ");
        for(Edge edge: graph[u]){
            if(!vis[edge.v])
            DFS(edge.v, vis);
        }

    }
    static void DFSUTIL(int u , boolean vis[]){
         DFS(u,vis);
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
              DFS(i,vis);
            }
        }
    }

    public static void main(String[] args) {
        caseI();     
        boolean vis[]=new boolean[graph.length];
        DFSUTIL(2,vis);
    }
}