import  java.util.*;
import  java.io.*;
import  java.util.LinkedList;
class  Graph{
    public  static Scanner  sc =  new  Scanner(System.in);
    static ArrayList<Edge>[] graph = new  ArrayList[7];

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
	
}