import  java.io.*;
import  java.util.*;
import  java.util.Arrays;
import  java.util.concurrent.*;

class  Graph{
  int  V;
  List<Integer>  adj[];
  Graph(int v){
    V=  v;
    adj =   new LinkedList[v];
    for(int  i=0; i<v;i++)
    adj[i] = new  LinkedList<>();    
  }

  void  addEdge(int v , int  e){
      adj[v].add(e);
  }

    void  BFS(int root){
    Queue<Integer>  q=   new  LinkedList<>();
    q.add(root);
    boolean  visited[] =  new  boolean[V];
    visited[root] = true;
    while(!q.isEmpty()){
      int  n = q.poll();
      System.out.print(n+" ");
      Iterator<Integer> itr =  adj[n].listIterator();
      while(itr.hasNext()){
          int tmp =(int) itr.next();
          if(!visited[tmp]){
              q.add(tmp);
              visited[tmp] =  true;
          }
      }
    }

}

void  DFS(int root){

  Hashtable<Integer , Integer >   ht = new  Hashtable<>();
 // ht.put(null,3);

  HashMap<Integer , Integer >   hm = new  HashMap<>();
  hm.put(null,3);
    
    boolean  visited[] =  new boolean[V];
    int  i =0;
    while(i<V){
      if(!visited[i]){
        visited[i] = true;
        System.out.print(i);
      }
        Iterator  itr =adj[i].listIterator();
        while(itr.hasNext()){
          int tmp = (int) itr.next();
          if(!visited[tmp]){
            visited[tmp] = true;
            System.out.print(tmp+" ");
          }
        }
        i++;
    }
  }
}

class  ResourceLock{
   int flag ;
  ResourceLock(int flag){
    this.flag =  flag;
  }
  void printA(){
    System.out.println("*");
  }
  void printB(){
    System.out.println("** ");
  }
  void printC(){
    System.out.println("*** ");
  }
}




class T1{
  T1 left , right;
  int data;
  T1(int data){
    this.data =  data;
  }
}

class Key { 
	String key; 
	Key(String key) 
	{ 
		this.key = key; 
	} 

	@Override
	public int hashCode() 
	{ 
				return 1;//(int)(Math.random()*10); 
	} 

	@Override
	public boolean equals(Object obj) 
	{ 
		return false; 
	} 
} 

class  Task  implements  Callable<Result>{

  public  Result  call()throws  Exception{
    Result  result =  new Result(200 ,"Hello  its done");
    try {
      System.out.print("waiting  to give result...");//+Thread.currentThread.getName());
      Thread.sleep(200);  
    } catch (Exception e) {
      //TODO: handle exception
    }
    return  result;
  }
}

class  Result {
  int code;
  String  message;
  Result(int code ,  String  message){
    this.code=  code;
    this.message  = message;
  }
}

class  TH  extends  Thread{
  static TH thread1;
  public  void run(){
    try {
      synchronized(thread1){
        System.out.println(Thread.currentThread().getName()+" acquires lock");
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName()+" completed");
      }
    } catch (Exception e) {
      //TODO: handle exception
    }
  }
}


class  Node  {
  Node  left , right;
  int data;
  Node(int data){
    this.data =  data;
    left =  right =  null;
  }
}


class  Left{
  int  data;
  Left  next ;
    Left(int data){
        this.data =  data;
    }
}
class Sample{

  static  int maxSubArray(int[]  arr){
      int  max_so_far = Integer.MIN_VALUE,max_end = 0;
      for(int i=1;i<arr.length ;i++){
           max_end = arr[i]+ max_end;
          if(max_end > max_so_far){
              max_so_far = max_end;
          }
      }
      return  max_so_far;
  }

  static  void  preorder(Node  root){
    Stack<Node>   st =  new  Stack<>();
    Node  node  =  root;
    while(node!=null){
      System.out.print(node.data  +" ");
       st.add(node);
       node =  node.left;
    }
    while(!st.isEmpty()){
      Node  tmp =  st.pop();
      Node  right=   tmp.right;
      if(right!=null){
        while(right!=null){
          st.add(right);
          System.out.print(right.data+" ");
          right =  right.left;
        }
      }
    }
  }

  static  void  checkK(Left  l  ,   int k){
    if(l==null)
    return  ;
    Left  node  = l , r = l;
    while(k-->0){
       node = node.next;
     if(node==null)
      return;
  }
  while(node!=null){
  r = r.next;
  node =  node.next;
  }
  System.out.print(r.data);
  }

  static  void  findMaxSubArray(int arr[]){
      int  max_sum = 0 , max_ending  = 0; 
        for(int  i =0 ;i< arr.length ;i++){
            max_ending  = arr[i] +  max_sum;
            if(max_ending > max_sum){
               max_sum = max_ending;
            } 
        }
        System.out.println(max_sum);
  }

 /*package whatever //do not write package name here */

	public static void main (String[] args)throws Exception {
       int arr1[]= {1,2,3};
       int arr2[]= {1,2,3};
       System.out.println(arr1 instanceof  Object);
    if(arr1.equals(arr2)){
      System.out.println("same");
    }else{
      System.out.println("not same");
    }

  }


  static  String smmalestWord(String  str){
    Set<Character>  set = new  HashSet<>();
    for(int  i =0 ;i<str.length();i++){
      set.add(str.charAt(i));
    }
    int count= set.size();
    String  tmp  = str.substring(0,count);
    int  i= count;
    while(i<str.length()){
      if(check(tmp ,set) ){
        break;
      }
      tmp = str.substring(i-(count-1),i+1);
      i++;
    }
    return tmp ;

  }



  static boolean  check(String  str ,Set<Character> set){
    HashSet<Character>  tmpset  =  new  HashSet<>();
    for(int  i =0 ;i< str.length();i++){
      if(set.size() == tmpset.size()){
        return  true;
      }
        char ch =  str.charAt(i);
        if(tmpset.contains(ch)){
          return  false;
        }
            else{
              tmpset.add(ch);
            }
        
    }
    return false;
  }

  static  int  slide(int[] arr ,int k){
    int tmp =  0;
    if(arr.length<k){
      for(int i=0;i<arr.length ;i++){
        tmp += arr[i];
      }
      return  tmp;
    }

    for(int  i=0 ;i< k;i++){
      tmp+=arr[i];
    }
    int prevsum = tmp;
    for(int i=k;i<arr.length;i++){
       prevsum = prevsum-arr[i-k]+arr[i];
        tmp = Math.max(tmp , prevsum);
    }

    return tmp;
  }


  static  ArrayList<String>   printWords(String  str , String  ans ,String  alpha[]){
        
          ArrayList<String>  r  = new ArrayList<>();
          r.add(ans);
          return  r;
        
  }

  static  ArrayList<String> printPermus(String  str ,String  ans){
    if(str.length()==0){
      ArrayList<String>  ar =  new  ArrayList<>();
      ar.add(ans);
      return  ar;
    }
    String  buttonArray [] = {"_" ,"+-/" ,"abc" ,"def" ,"ghi" ,"jkl" ,"mno" ,"pqrs" ,"tuv" ,"wxyz" ,"*" ,"#"};
    String  n = ""+str.charAt(0);
    int  num =  Integer.parseInt(n);

    ArrayList<String>  res  =  new ArrayList<>();
    for(int i = 0;i<buttonArray[num].length() ;i++){      
        ArrayList<String>  an = printPermus(str.substring(1) , ans + buttonArray[num].charAt(i));
        res.addAll(an);
    }
    return  res;
  }



  static ArrayList<String> permus(String  str ){
    if(str.length()==0){
      ArrayList<String>  r =  new  ArrayList<>();
      r.add("");
      return  r;
    }

    char ch =  str.charAt(0);
    ArrayList<String>  tmp = permus(str.substring(1));
    ArrayList<String>  ans =  new ArrayList<>();
    for(String  s :  tmp){
        for(int  i=0 ;i<=s.length() ;i++){
          ans.add(s.substring(0,i) +ch + s.substring(i));
        }
    }
    return  ans;
  }

  static  int  floodFill(boolean arr[][] , int sr ,int sc ,int  er ,int ec ,String ans){
    if(sr==er && sc==ec ){
      System.out.println(ans);
      return  1;
    }
    int[][]  dir = {{1,0} ,{ 1,-1} ,{ 0, -1} ,{-1,-1},{-1 ,0} ,{-1, 1} ,{0,1},{1,1}};
    String  drname[]  = new  String[]{"H10" ,"D1-1" ,"V0-1" ,"D-1-1" ,"H-10","D-11","V01","D11"};
    int count = 0;
    for(int  i = 0 ; i< dir.length ;i++){
      int  x =  sc+dir[i][1];
      int  y =  sr+dir[i][0];
      if(isvalid(arr, y,x)){
      arr[y][x] =  true;
        count+=floodFill(arr ,  y ,x , er,ec ,ans+" "+ drname[i] );
      arr[y][x] =  false;
      }
    }
    return  count;
  }


  static  boolean  isvalid(boolean [][]arr , int  y , int  x ){
    if(x<0 || y<0 || x>=arr.length || y>=arr[0].length || arr[y][x])
    return  false;
    return  true;
  }
}
