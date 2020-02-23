import  java.util.*;
class  DirectedGraph{
    static class  Edge{
        int  v ,w;
        Edge(int v ,  int w){
            this.v = v;
            this.w = w;
        }
        Edge(){}
    }

    static  void  caseI(){
        for(int  i=0;i<graph.length ;i++){
            graph[i] =  new ArrayList<>();
            newgraph[i] =  new ArrayList<>();
        }

        addEdge(graph, 0,1,10);
        addEdge(graph, 0,3,10);
        addEdge(graph, 1,2,10);
        addEdge(graph, 2,3,40);
        addEdge(graph, 3,4,2);
        addEdge(graph, 4,6,3);
        addEdge(graph, 4,5,2);
        addEdge(graph, 5,6,8);
    }

    static  void  addEdge(ArrayList<Edge>  g[] , int  u ,int  v ,int w){
        if(u<0 || v<0 || u>=g.length || v>=g.length )return;
        g[u].add(new Edge(v,w) ) ;
        g[v].add(new Edge(u,w));
    }

    static  void  display(ArrayList<Edge>  g[]){
        for(int i=0 ; i<g.length ;i++){
            String st = i+"-> ";
            for(Edge  edge : g[i]){
                st+= "(" + edge.v +","+edge.w +"),";
            }
            System.out.println(st);
        }
    }

    static  ArrayList<Edge>[] graph =  new  ArrayList[7];
    static  ArrayList<Edge>[] newgraph =  new  ArrayList[7];
    static void dijsktra(){
        class  Node{
            int vtx ,p ,weight ,wsf ;
            Node(int vtx ,int p,int weight ,int wsf){
                this.vtx =vtx;
                this.p =p;
                this.weight = weight;
                this.wsf = wsf;
            }
            Node(){}
        }

        PriorityQueue<Node> q =  new  PriorityQueue<>(new Comparator<Node>(){
           
            public  int compare(Node o1 , Node  o2){
                return  o1.weight - o2.weight ;
            }
        });
        display(graph);
        q.add(new Node(0,-1,0,0));
        boolean vis[] =  new boolean[graph.length];
        while(!q.isEmpty()){
            Node  node = q.poll();
            
            if(!vis[node.vtx] && node.p!=-1){
                addEdge(newgraph ,node.p ,node.vtx ,node.weight  );
            }
            if(vis[node.vtx])continue;
            vis[node.vtx] = true;
            for(Edge  edge :  graph[node.vtx]){
                if(!vis[edge.v])
                q.add(new Node(edge.v , node.vtx , edge.w ,edge.w + node.weight));
            }
        }
        System.out.println("\n\n");
        display(newgraph);
    }

    public static  void test(){
        class  Node  implements  Comparable<Node>{
            int vertex , weight ,parent ,wsf;
            Node(int vertex ,int parent ,int weight , int wsf){
                this.vertex =  vertex;
                this.weight = weight;
                this.parent =  parent;
                this.wsf = wsf;
            }
            Node(){}
            public  int compareTo(Node  o){
                return  o.wsf- this.wsf ;
            }
        }
        String  ans = " ";
        PriorityQueue<Node>   q =  new  PriorityQueue<>();
        boolean  vis[] =  new boolean[graph.length];
        q.add(new Node(0,-1,0, 0 ));
        while(!q.isEmpty()){
            Node  node =  q.poll();
            if(node.vertex==6){
                ans+= node.vertex+" ";break;
            }
            ans+= node.vertex + " ";
            vis[node.vertex] =  true;
            //ans+= node.parent +"->" + node.vertex +"\n";
            for(Edge  edge :  graph[node.vertex]){
                if(!vis[edge.v])
                q.add(new Node(edge.v,node.vertex,edge.w , node.wsf + edge.w));
            }
        }
        System.out.println(ans);

    }

    public  static void  main(String a[]){
        caseI();
       // dijsktra();
       test();
    }

}