import  java.util.*;
import  java.io.*;
import java.util.concurrent.*;

class  Node{
    int data;
    Node  left , right; 
     Node(int data){
         this.data = data;
         this.left = this.right = null;
     }
}



  class TTT{
    public  int  age;
      public String  name ;
  public   TTT(int age , String  name){
         this.age = age;
         this.name = name;
     }


     static  void fun(){
         System.out.println("static");
     }
}


class  T  {

    static   Scanner sc =  new Scanner(System.in);
   String  arr[]  =   {"abc"  , "def" , "ghi" ,"jkl" ,"mno" ,"pqrs" ,"tuv","wx","yz" };
    public static void main(String[] args) throws  IOException{
        
      //  Node  head1=   new Node(sc.nextInt());
        //createdLinekdList(head1);
       // sortLinkedList(head1);
        //reverseLinkedListStack(head1);
        //traverseLinkedList(head1);
        ///mergeLinkedList(head1,head2);
        //shiftKBits();
       // printBinary(1<<2);
       //countCommonChars();
        //checkIfAllSet();
        //unique();
        //removechars();    
        //findMaxPath();
        //int  arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
         //System.out.println( mazepath(0 ,0,2 ,2 ,""));
         //System.out.println( mazediagonal(0,0,2,2,0));

      //   System.out.println(diceMoves( 0 , 10 ,""));

        //buttonCombinations(235);         
//       boolean [][]  isDone= new boolean[3][3];       
       //findSecondMax(arr);
      // int pos[] =  {0,1,2};
    //   int queens[]  ={0,1,2};;

        //boolean  block []  = new boolean[arr.length];
//        int arr[]={1,2,5,10,20,50,100,500,1000};
  //     int c= minvalsum(arr ,0,70, 0 , "");
     //  int  c =findQueenPos(queens , pos  , 0 , 0 , "");
          
            
            //int c = findQueenPosPermus(0 , 5 , 1 ,3 ,1, "");
            //boolean block[][]  = new boolean[3][3];
            String  str = "ilikesamsungmobile";
            String dict[] = {"mobile","samsung","sam","sung", 
            "man","mango", "icecream","and", 
            "go","i","like","ice","cream"}; 
            //wordBreak(  str ,  "", String  dic[], int  i ,  String  ans);
            //System.out.println(  wordBreakA(dict, str, ""));
              //  realspiralmat( mat,mat.length*mat[0].length, 0,0 , mat[0].length-1 ,mat.length-1 );
             // fibonacci(5);
        //     T tree =  new T();
        //      tree.root = new Node(1); 
        //      tree.root.left = new Node(2); 
        //      tree.root.right = new Node(3); 
        //      tree.root.left.left = new Node(4); 
        //      tree.root.left.right = new Node(5); 
        //      tree.root.right.left = new Node(6); 
        //      tree.root.right.right = new Node(7); 
       
        //      System.out.println("LCA(4, 5): " + tree.findLCA(4,5)); 
       /*Node  root =  new Node(0);
       root.left  =  new Node(1);
       root.right  =  new Node(3);
       root.left.right  =  new Node(4);
       root.left.left  =  new Node(5);
       System.out.println(secMax(root , Integer.MIN_VALUE , Integer.MIN_VALUE));*/
      //referece ke conflict ko  javac dekhta h
      // T o1 = new TTT(10 ,"ten");

      Scanner sc= new Scanner(System.in);
 //       BufferedReader   bf =  new  BufferedReader(new InputStreamReader(System.in));
      //  System.out.print(bf.readLine());
      System.out.print(Integer.MAX_VALUE);
    }
    @Override
    public  void  finalize()throws Throwable{
        super.finalize();
        System.out.println("destroying : "+this);
    }

    /*

    static  block 
    static  data  memebers 
    static  method
    space/memory  allocation for ojbects /instances/data members  memory  allocated  with default values
    parsing ( 
         class M{
             int i = 10; ///parsing
         }
    )
    constructor 
    return  this
    main



    // 
    class  Person{
    final  int  i;
    } 
    if  final(if not static) is  not initialized  in class  space .only  constructor  has  power to  initialize 

    class  Person {
        static  final int i;
    }
    if final variable is  not initialized  and if its static  then  only  static block  has power to initialize it.



    finalize : --GC :--Mark and swipe algo 
    GC scan stack and check if all the stack  nodes  have pointer to  heap  memory ,if  some stack nodes dont point to heap memory  then GC will destroy them from  stack.
    if some resource is  loaded  in file , then  finalize() method will  call 
    */




    static  int  secMax(Node  root , int fmax ,int secmax){
        if(root ==null)
        return -1;

        if(root==null)
            return  Integer.MIN_VALUE;

          
            if(root.data>fmax ){
                fmax = root.data ;
                secmax = fmax;
            }else if(root.data<fmax && root.data > secmax){
                secmax = root.data;
            }

            int  r = secMax(root.right , fmax , secmax);
            int  l = secMax(root.left , fmax , secmax);

           
        int  tmp =    Math.max(secmax , r);
        return   Math.max(tmp, secmax);
    }


    static  int  pop(Stack<Integer> st ){
        if(st.size()==0)
        return -1;
        if(st.size()==1){
            return st.pop();
        }
        int dt  =  st.pop();
        int res = pop(st);
        st.add(dt);
        return  res;
    }





        static   int  findLCA(int  a ,int  b , Node root){
                if(root==null){
                    return   0;
                }
                    return 1;
        }


            Node  root = null;

        static  int maxXor(int []   arr , int  K , int t, int vidx , int ans, String str){
            if( (t==K-1) || (arr.length<K)){                
                System.out.println(ans);
                return  ans;
            }

            int count =0;
            int xor=0;
            for(int  i = vidx;i<arr.length ;i++){
                   if(t<K)
                  xor=Math.max(xor, maxXor(arr, K , t+1 , i+1 ,ans^arr[i] , str +" " + arr[i] ));                
            }
            return  xor;
        }


        static   void  isPrime(int n){
            boolean isprime[] = new boolean[n+1];

            for(int  i  =0 ; i<=n ; i++)
                isprime[i] = true;

            for(int  i =2 ; i*i<=n ;i++){
                if(isprime[i]){
                    for(int p=i*i; p<=n;p+=i)
                        isprime[p] =false;
                }                                 
            }

            for(int  i =2 ; i<=n;i++){
                if(isprime[i])
                System.out.print(i+" ");
            }
            System.out.println();
             
        }

        static  void    fibonacci(int n){
            int  a =0 ,b =1;
            if(a==0)
            System.out.println(a);
            if(b==1)
            System.out.println(b);
            
            n=n-2;

            for(int  i =0 ;i<=n ;i++)
            {
                int  tmp = b;
                b = a+b;
                a= tmp;                            
                System.out.println(b);
            }
        }


        static  void   mergeSort(int arr[] , int  l , int  r){
            if(l>=r){
               
                return ;
            }

            int mid =l+ (r-l)/2;
           
            mergeSort(arr, l ,mid );
            mergeSort(arr, mid+1 ,r);
                    
            merger(arr , l , mid , r);
            }


        
        static  void  merger(int arr[],int l,int mid , int r  ){
            int  itr1   = l ,itr2 = mid+1 ,itr=l;

            while(itr1<=mid  && itr2<=r){
                if(itr1<=mid){
                    if(arr[itr1] >= arr[itr2]){
                        int tmp = arr[itr1];
                        arr[itr1] = arr[itr2];
                        arr[itr2] =tmp;
                        
                    }   
                    itr1++;                 
                }
                if(itr2<=r){
                    if(arr[itr2] <= arr[itr1]){
                        int tmp = arr[itr1];
                        arr[itr1] = arr[itr2];
                        arr[itr2] =tmp;
                        
                    }   
                    itr2++;                 
                }

            }
            
        }


        static  void mergeSort(int arr[][] , int  l , int r , int mid){}


        static   int   matCombs(int mat[][] , int r, int c , String   ans){
            if((r>=mat.length-1) && (c>=mat[0].length-1)){
                System.out.println( ans);
                return  1;
            }

            int count =0 ;

            int dir[][] = {{0,1},{1,0}};
            for(int d =0 ; d<dir.length ;d++){
                int row = r+dir[d][0];
                int col = c +dir[d][1];
                if(isValidSpot(mat ,row, col))
                count+=matCombs(mat,row ,col , ans+" " + mat[row][col]);
            }

            return   count;
        }

        static  boolean  isValidSpot(int [][]  mat , int  r ,int c){
            if(r>=mat.length || c>=mat[0].length || r<0 || c<0){
                return  false ;
            }
            return  true;            
        }


        static  int breakWords(String str ,String dic[] , int vidx , String  ans){
            if( (str.length()<=0)  ){
                System.out.println(ans);
                return  1;
            }            
            
            String  tmpstr = str.substring(0, vidx);
            int count=0;
            if(ifpresent(tmpstr,dic)){
                count+=breakWords(str.substring(vidx) , dic , 0 , ans+" " + tmpstr );
            }else{
                count+=breakWords(str , dic , vidx+1 , ans );
            }
            return count;
        }

        static  boolean  ifpresent(String tmpstr,String[]  dic){
            for(int  i =0 ;i< dic.length ;i++){
                if(tmpstr.equals(dic[i]))
                return  true;
            }
            return  false;
        }

        static void  displayArray(int mat[][]){
            for(int i=0;i<mat.length; i++){
                for(int c =0; c<mat[0].length;c++){
                    if((c+i==mat.length-1)|| (i==0)||(i==mat.length-1))
                        System.out.print("*"+" ");
                        else
                        System.out.print("  ");
                }

                System.out.println();
            }
        }

        static void  diagonal(int mat[][] , int r ,int  c){            
            for(int i=0;i<mat.length;i++){
                        for(int col = i;col<=c;col++){
                            int tmp = mat[i][col];
                            mat[i][col] = mat[col][i]; 
                            mat[col][i] = tmp;
                        }
                }                
        }


        static  void realspiralmat(int mat[][] , int tne , int minr ,int minc ,int maxc ,int maxr ){
            int  count = 0;
            while(count<tne){
                    for(int c= minc ; c<=maxc ; c++){
                        System.out.print(mat[minr][c]+" ");
                        count++;
                    }
                    minr++;

                    for(int r= minr ; r<=maxr ; r++){
                        System.out.print(mat[r][maxc]+" ");
                        count++;
                    }
                    maxc--;


                    for(int c= maxc ; c>=minc ; c--){
                        System.out.print(mat[maxr][c]+" ");
                        count++;
                    }
                    maxr--;

                    for(int r= maxr ; r>=minr ; r--){
                        System.out.print(mat[r][minc]+" ");
                        count++;
                    }
                    minc++;
            }
            
        }

        static  void spiral1(int mat[][]){
                for(int r = 0  ;r< mat.length ;r++){
                    for(int  c = ((r&1)==0) ? 0 : mat.length-1 ;c<mat[0].length && c>=0;c=((r&1)==0)? c+1 :c-1){
                    System.out.print(mat[r][c]+" ");                    
                }
            }
        }

        static  void spiral(int mat[][] , int tne , int minr ,int minc ,int maxc ,int maxr ){
            int count=0;
            while(count<tne){
              for(int c=minc;c<maxc && count<tne ;c++){
                  System.out.print(mat[minr][c]+" ");
                  count++;
              }              
              minr++;

              for(int c=maxc-1;c>=minc && count<tne ;c--){
                System.out.print(mat[minr][c]+" ");
                count++;
              }
            minr++;             
            }
        }

        static  String pluswords(String  s1  ,String  s2){
            int maxL =   Math.max(s1.length() , s2.length());
            String ans ="";
            int  i1 = -1 , i2 =-1,carry=0;
            for(int i = maxL-1 ; i >=0 ;i--){                
                i1= (i<s1.length()) ?  s1.charAt(i)-'a':0;                
                i2= (s2.length()>i) ? s2.charAt(i)-'a':0;                
                int sum = i1+i2+carry;
                int num = sum %10;
                carry = sum/10;
                ans=(char)(num+'a')+ans;
            }
            ans =carry>0?(char)(carry+'a')+ans:ans;
           return ans;
        }

        static  int[]  freqMap(String  ...m1){
            String  r = "";
            for(int  i =0 ; i<m1.length ;i++){
                r+= m1[i];
            }
            int  res[]  = new int[26];
            for(int  i  =0 ; i< r.length() ;i++){                
                    res[r.charAt(i)-'a']++;
            }
            return  res;
        }

/*
        int getNumber(String   str , int numberAgainstChar[]){
            int x= str.charAt();
        }


        static   int  crypto(String ques , int vidx , int isTaken ){

            if(vidx == ques.length ){
                int   num1 = getNumber(st1 , numberAgainstChar);
                int   num2 = getNumber(st2 , numberAgainstChar);
                int   num3 = getNumber(st3 , numberAgainstChar);
//
                if((num1+num2)== num3){
                    System.out.println(num1);
                    System.out.println(num2);
                    System.out.println(num3);
                }                                    
            }

            int count  =0 ;
            for(int  i  =0; i< 10 ; i++){
                int mask = 1<<i;
                if((isTaken & mask) ==0){
                    isTaken |=mask;
                    numberAgainstChar[ques[vidx] -'a']  =i;
                    count+= crypto(ques, vidx+1 , numberAgainstChar ,isTaken);
                    numberAgainstChar[ques[vidx] -'a']  =-1;
                    isTaken ^=mask;
                }

            }


        }


  */        

        static String  addWords(String  st1 , String   st2 , String  ans){
            int carry = 0;
            for(int  i =(Math.max(st1.length() , st2.length())); i>=0 ;i--){
                char c1 ='a',c2 ='a';
                    if(i<st1.length())
                    c1= st1.charAt(i);

                    if(i<st2.length())
                     c2 = st2.charAt(i);
                    int  r =  c1 -'a' + (c2-'a');
                     int chr  = r%10+carry;
                          carry = (r/10);                          
                        ans+= carry >0 ? (char)(chr+carry)  : (char)chr  ;
            }

          return ans;
            
        }

        static  int wordBreakA(String  dic[] , String   str , String   ans){
          
            if(str.length() == 0){
                System.out.println(ans);
                return   1;
            }


            int count = 0; 
            for(int  i =1 ; i<= str.length() ;i++){
                String   tmpstr = str.substring(0,i);
                if(ispresent(dic, tmpstr )){           
                    count += wordBreakA(dic, str.substring(i), ans + tmpstr +" ");
                }
            }

            return  count;
        }

        static  boolean  ispresent(String dic[] , String  str ){
	       
            for(int  i =0 ; i< dic.length ;i++){
                if(dic[i].equals(str)){
                    return  true;
                }
            }
            return  false;
        }


        static  void  sudokoTest(){
            int  boxes [][] =
            {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},  
            {5, 2, 0, 0, 0, 0, 0, 0, 0},  
            {0, 8, 7, 0, 0, 0, 0, 3, 1},  
            {0, 0, 3, 0, 1, 0, 0, 8, 0},  
            {9, 0, 0, 8, 6, 3, 0, 0, 5},  
            {0, 5, 0, 0, 9, 0, 6, 0, 0},  
            {1, 3, 0, 0, 0, 0, 2, 5, 0},  
            {0, 0, 0, 0, 0, 0, 0, 7, 4},  
            {0, 0, 5, 2, 0, 6, 3, 0, 0}};  
            int rowM[] = new int[9];
            int colM[] = new int[9];
            int mat[][]  = new  int[3][3]; 
            
            sudoko_mask(boxes  ,rowM , colM , mat);

            int tell = sudoko2( boxes , 0 , rowM , colM, mat);

//            boolean   tell  =  checkNum( boxes , 4, 1 , 1);
            System.out.println(" "+tell);            

        }
static int  sudoko2(int  boxes[][]  ,  int vidx, int  rowM[]  ,int  colM[]  , int  mat[][]){
    if(vidx == 81){
        display(boxes);
        return   1 ;                    
    }
    
    int count   =0 ;
    int  row  =  vidx / 9; 
    int  col =   vidx  % 9 ;

    if(boxes[row][col]  ==  0){
            
        for(int   i =1 ; i <=9 ; i++){
                    int mask  = 1<<i;
                if(((rowM[row] & mask)==0) && ((colM[col] & mask)==0) && ((mat[row/3][col/3] & mask)==0))
                {
                    rowM[row] |= mask;
                    colM[col] |= mask;
                    mat[row/3][col/3]  |= m ask;
                    boxes[row][col] = i;
                    count+= sudoko2(boxes , vidx+1, rowM , colM , mat);
                    rowM[row] ^= mask;
                    colM[col] ^= mask;
                    mat[row/3][col/3] ^= mask;       
                    boxes[row][col] = 0;

                }

        }


    }else{
            count+=sudoko2(boxes , vidx+1 , rowM , colM , mat);
    }
    

    return  count; 
}



        static   void sudoko_mask(int  boxes[][] , int  rowMask[]   , int  colMask[]  , int mat[][]){
            for(int  i =0 ; i< 9 ; i++){
                for(int  j =0 ;   j< 9 ; j++){
                    int  mask  =  1<<boxes[i][j];
                    rowMask[i] |= mask ;
                    colMask[j] |= mask ;
                    mat[i/3][j/3] |= mask; 
                }
            }
        }

        static   void  display(int  boxes[][]){
            for(int  r =0 ; r<boxes.length ;r++){
                for(int  c =0 ; c<boxes[0].length ;c++){
                    System.out.print(boxes[r][c] +  " ");
            }
            System.out.println();
        }
        System.out.println();
    }

        static  int  sudoko(int boxes[][] ,  int vidx ){
            if(vidx==81){
                display(boxes);
                return  1;
            }

            int  row = vidx /9;
            int col  = vidx % 9;
            int count= 0 ;
            if(boxes[row][col] ==0){
            for(int  t = 1 ; t<=9 ;t++){
                if(checkNum(boxes ,t  , row ,col )){                    
                    boxes[row][col] = t;
                    count+=sudoko(boxes , vidx+1 );
                    boxes[row][col] = 0;
                }
            }
        }else{
            count+= sudoko(boxes , vidx+1);
        }
            return  count;
        }

        static   boolean   checkNum(int boxes[][] , int n ,   int  r ,int c ){
           for(int  tr = 0 ; tr<9 ;tr++)
           if(boxes[tr][c]==n)
           return  false;

           for(int  tc = 0 ; tc<9 ;tc++)
           if(boxes[r][tc]==n)
           return  false;

            int nr = (r/3)*3;
            int nc = (c/3)*3;

            for(int  i =0 ; i< 3 ;i++){
                for(int  j  =0 ; j< 3 ;j++){
                    if(boxes[i+nr][j+nc] == n)
                    return  false;
                }
            }
            return   true;
        }


/*
        static int  queens2DSubsequence(boolean boxes[][] , int idx , int tnq , int  q , String ans){
           if(q==tnq ||  idx>= boxes.length * boxes[0].length){
                System.out.println(ans);
                return     1;
            }

                
            int count = 0;
            int r = idx / boxes.length;
            int c =  idx % boxes.length;
            if(isValidSpot(boxes, r , c )){
            count+=countqueens2DSubsequence( boxes ,  i , tnq , q+1  , ans+" q"+ q+"p"+i);
            }
            count+=countqueens2DSubsequence(boxes , i);
            
            int  count  =0 ;
            return  count;
        }
*/
        static   boolean  queens2D(boolean boxes[][], int  idx  , int tnq, int q  , String   ans){
            if(q==tnq){
                System.out.println(ans);
                return   true;                
            }
            int  count =0; 
            boolean  flag = false;
            for(int  i = idx  ; i<boxes.length * ( boxes[0].length)  ; i++){
                int r =  i / boxes.length;
                int c =  i  % boxes.length;

                if(isValidSpot(boxes , r , c)){
                boxes[r][c] = true;
                flag = flag || queens2D(boxes , i+1 , tnq , q+1 , ans+" q"+ q + "p" + i);
                boxes[r][c] =false;
                }
            }
            return  flag;
        }

        static  boolean   isValidSpot(boolean   boxes[][] ,  int r , int c  ){
            if(boxes[r][c] ||  r <0 || c <0 || r>=boxes.length  ||  c>=boxes[0].length)
            return   false;

            int dir[][]= {{0,1} ,{0,-1},{1,0},{-1,0},{-1,-1},{-1,1} ,{1,1},{1,-1}};

            int  max=  Math.max(boxes.length , boxes[0].length);
            boolean   yes = true;
            for(int dist = 0 ;  dist<max ;dist++){
            for(int  d =  0 ; d <dir.length ;d++){
              int  row = r+(dir[d][0]*dist);
              int col = c+(dir[d][1]*dist);
              if(((row>=0 && col>=0) && (row<boxes.length && col<boxes[0].length)) && boxes[row][col] ){
                    yes = false;
              }
            }
        }
        return   yes;
    }


        static  void  sumequal(int arr[] ,boolean block[], int count , int idx ,int sum,int tsum,String ans){
                if(idx>=arr.length || count<=0 || sum==tsum){
                    if(sum==tsum)
                    System.out.println(ans);
                    return;
                }

                for(int  i =idx ;i<arr.length ;i++){
                    if(!block[i]){
                    block[i] = true;
                sumequal(arr,block,count-1,i+1 , sum , tsum+arr[i] , ans+" "+arr[i]);
                block[i] = false;
                    }
                }
        }

        static  int  maxSubSeqLengthh(int arr[] , int count , int idx , String ans){
            if(idx>=arr.length){                
                System.out.println(ans);
                return count;
            }

            if((idx+1<arr.length) && (arr[idx]>arr[idx+1])){
            count = 1;
            ans=" ";
            }
            else{
                count++;
                ans=ans+" "+arr[idx];
            }
            
            int c1 = maxSubSeqLengthh(arr,count, idx+1 , ans);
            
            return Math.max(c1 ,count);
        }



        static  HashSet<String>   uniqueArrays(int arr[] , int k , String  ans){ 
        if(k>=arr.length){
            HashSet<String>  hs  =  new HashSet<>();
            hs.add(ans);
            return   hs;
        }            

        HashSet<String>  tmphs =  new HashSet<>();
        HashSet<String> res =  new HashSet<>();
        for(int  i =k ; i< arr.length ;i++){
            if(i+1<arr.length && arr[i+1]>arr[i]){
                res= uniqueArrays(arr,i+1 , ans+arr[i]);
                tmphs.add(ans+arr[i] + arr[i+1]);
               tmphs.addAll(res);}
                }
                return  tmphs;
    }

        static   ArrayList<String> possibleStrings(String str){
            if(str.length()==0){
                ArrayList<String>  al  = new ArrayList<>();
                al.add("");
                return  al;                
            }


            char  ch = str.charAt(0);
            str =  str.substring(1);
            ArrayList<String>  ans =  possibleStrings(str);
            ArrayList<String>  res =  new ArrayList<>();
            for(String   tmp : ans){
              
                res.add(tmp);
                for(int  i =0 ; i<=tmp.length() ; i++)
                res.add(tmp.substring(0,i) + ch + tmp.substring(i));
            }
            return res;
        }




        static ArrayList<String> fincCombStrings(String str , int k){
            if(k<=0){
                ArrayList<String>  ans = new ArrayList<>();
                ans.add("");
                return ans;
            }

            char ch = str.charAt(0);
            String  tmpstr = str.substring(1);
            ArrayList<String>  al = fincCombStrings(tmpstr , k-1);
            ArrayList<String>  res =  new ArrayList<>();
            for(String tmp : al){
                for(int  i =0 ; i  <=tmp.length() ; i++){
                      res.add( tmp.substring(0,i) + ch + tmp.substring(i));                    
                }
            }
            return res;
        }

        static  int  arrayIncComb(int arr[] , int   i, String ans ){
            if(i>=arr.length){
                System.out.println(ans);
                return 0;
            }


            int count   =0; 
            for(int  x = i;  x< arr.length  ; x++){
                    if(x+1<arr.length &&  arr[x]<arr[x+1] )     {           
                        count+=1; 
                        count+=arrayIncComb(arr, x+1  ,ans+arr[x]+arr[x+1]);} 
                }
                    return   count;

    }

        static  int    findQueen2DPosPermus( boolean  block[][], int idx  ,int tnq , int q ,String  ans){
                if(q==tnq+1  ||   idx==(block.length * block[0].length)){
                    if(q==tnq+1){
                    System.out.println(ans);
                    return  1;
                }
                return   0;
            }

                int count = 0;
                for(int  i = idx ; i< block.length * block[0].length ; i++ ){
                    int row = i/block[0].length;  
                    int col =  i%block.length;
                    if(!block[row][col]){
                        block[row][col] = true;
                        count+=findQueen2DPosPermus(block, idx+1 , tnq , q+1 ,  ans + " q"+q+" p"+row+col+"  ");
                        block[row][col] = false;
                    }


                }
                return count;
        }



        static int  findQueenPosPermus( int bitmask, int  boxes ,int box ,int  tnq ,int q ,String ans){
            if(q==tnq+1){
                System.out.println(ans);
                return 1;
            }
            int count=0;
            for(int  i  = box  ;i<=boxes;i++){                  
                if((bitmask>>i & 1) == 0){
                    bitmask|= (1<<i) ;
                    count+=findQueenPosPermus(bitmask,boxes, 1,tnq ,q+1 ,ans +" q"+q +" p" +  i);            
                    bitmask &= (~( 1<<i));
                }
           }
           return  count;
       }



        static int  findQueenPosCombi(int  boxes ,int box ,int  tnq ,int q ,String ans){
             if(q==tnq+1 ){
                 System.out.println(ans);
                 return 1;
             }
             int count=0;
             for(int  i  = box  ;i<=boxes;i++){                  
                count+=findQueenPosCombi(boxes, i+1,tnq ,q+1 ,ans +" q"+q +" p" +  i);            
            }
            return  count;
        }


        static  int  seeBuild(int H[] , int C[]){
            int count= 0 ,tmp = 0;
            int tmpC[] = new int [Integer.MAX_VALUE-1];
            String  ans ="";

            for(int i  = H.length-1 ; i>=0 ; i--){                
                if(tmp < H[i] && !(tmpC[C[i]]>0)){
                        tmp =H[i];
                         count ++;                    
                         tmpC[C[i]] ++;
                         ans += tmp;
                }
            }
            System.out.println(ans);

            return count;
        }

        static  int seesun(int arr[]){
            int tmp = 0 ,count= 0 ;            
            for(int  i=0 ; i< arr.length ; i++)
                {
                    if(arr[i] > tmp){
                        count++;
                        tmp  = arr[i];
                    }
                }
                return  count;
        }

        static void insertionSort(int arr[]  ,int idx){
            if(idx==arr.length)
                return;
                           
            for( int  i =idx ; i>0 ;i--)
            {   
                if(arr[i-1] > arr[i]){
                    int tmp = arr[i];
                    arr[i] = arr[i-1];                
                    arr[i-1] = tmp;                    
                }
            }
            insertionSort(arr,idx+1);
        }

        static  int  minvalsum(int arr[] , int i ,int sum,int count , String ans){

            if(sum<=0 && (i<=arr.length)){
                if(sum<0){
                    return 0;
                }
                System.out.println(ans);
                return count;                 
            }else if(i>=arr.length && (sum>=0 || sum<0)) {return 0;}
            int c=0,c1= 0;
            c= minvalsum(arr , i+1 ,sum, count ,  ans);
            c1= minvalsum(arr , i+1 ,sum-arr[i], count+1 ,  ans +" "+arr[i]);
            return  Math.max(c,c1);
        }

        static  void  findQueenPos(int queens[] , int  pos , int q , int qp , String   ans ){


        }



        static  void  findStringComb(){}


        static  int findCoinSubseqPermu(int  arr[] ,boolean  block[], int  i  ,int  s , String  ans){
            if(s==0 &&  i >=arr.length ){
                System.out.println(ans+ " ");
                return 1;
            } else if(s<0 || i >=arr.length){
                return   0;
            }

            int  count = 0 ; 
            if(s>=0){
                
                if(!block[i]){
                    block[i] = true;
                    count+= findCoinSubseqPermu(arr ,block, i+1, s-arr[i]  , ans+arr[i]);
                    block[i] = false;
                    count+= findCoinSubseqPermu(arr , block,i+1, s, ans);
                    
                }      
            }

            return  count;
        }

        static  int findCoinSubseqCoV
    int res = 0;
    while(x>0){
        if(i%2==1){
            res = res|(1<<i);
        }
        i+=1;
        x= x>>1;
    }

    printBinary(n|res);

}

static  void getKthBit(){
    System.out.println("enter  the shift :");
    int  k  = sc.nextInt();
    System.out.println("enter  the number : ");
    int  n  = sc.nextInt();
    printBinary(n&(1<<k));

}


static  void  shiftKBits(){
    System.out.println("enter  the shift :");
    int  k  = sc.nextInt();
    System.out.println("enter  the number : ");
    int  n  = sc.nextInt();
    printBinary(n);
printBinary( n&(1<<(k-1)));
}

static  void printBinary (int n ){
    System.out.println();
    System.out.print("binary of "+n+ " = ");
    String Nbin = "";
    while(n!=0){
        Nbin =n%2 +Nbin;
        n/=2;        
    }
    System.out.print(Nbin);
    System.out.println();
}

}