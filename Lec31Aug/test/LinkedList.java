import java.util.*;
class  Node {
    Node  next;
    int data;
    Node(int data){
        this.data =  data;
        next =  null;
    }
}
class LinkedList{
    static  void  traverse(Node  node){
        System.out.println();
        while(node!=null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();        
    }   

    public static void main(String[] args){
       // int arr[] = {1,2,3,4,5,6,7,8};
        //boolean   r[] =  new boolean[arr.length];
        String  s1 =  "send";
        String  s2 =  "more";
        String  s3 =  "money";
        int i1 = s1.length()-1;
        int i2 = s2.length()-1;
        int i3 = s3.length()-1;
        int arr[] =  new int[26];
        int n = 0;
        int g[] = new int[9];
        int row=0;
        int col = 0;
        //String  ans = getuniqueString(s1,s2,s3);
        //cryptoEncryptionBySubSeq(s1 ,  s2 ,  s3  ,ans, 0 , 0, arr, 0 );
        int sudo[][]={{3, 0, 6, 5, 0, 8, 4, 0, 0},  
                      {5, 2, 0, 0, 0, 0, 0, 0, 0},  
                      {0, 8, 7, 0, 0, 0, 0, 3, 1},  
                      {0, 0, 3, 0, 1, 0, 0, 8, 0},  
                      {9, 0, 0, 8, 6, 3, 0, 0, 5},  
                      {0, 5, 0, 0, 9, 0, 6, 0, 0},  
                      {1, 3, 0, 0, 0, 0, 2, 5, 0},  
                      {0, 0, 0, 0, 0, 0, 0, 7, 4},  
                      {0, 0, 5, 2, 0, 6, 3, 0, 0}};  
       // sudokoMask(sudo);
       int  rows[] = new int[9];
       int  cols[] = new int[9];
       int mat[][] =  new  int[3][3];
       ///sudokoMask(sudo ,rows ,cols  , mat );
       //sudokoByBitMap(sudo,  rows , cols ,  mat , 0);
        int  cross[][] =  {
    {'*' , '#' , '*' , '*' ,'*' , '*' , '*' , '*' , '*' , '*' },
    {'*' , '#' , '*' , '*' ,'*' , '*' , '*' , '*' , '*' , '*' },
    {'*' , '#' , '*' , '*' ,'*' , '*' , '#' , '*' , '*' , '*' },
    {'*' , '#' , '#' , '*' ,'*' , '*' , '#' , '#' , '*' , '*' },
    {'*' , '#' , '*' , '*' ,'*' , '*' , '#' , '*' , '*' , '*' },
    {'*' , '#' , '*' , '*' ,'*' , '*' , '#' , '*' , '*' , '*' },
    {'*' , '#' , '*' , '*' ,'*' , '*' , '#' , '*' , '*' , '*' },
    {'*' , '#' , '*' , '#' ,'#' , '#' , '#' , '#' , '#' , '*' },
    {'*' , '#' , '*' , '*' ,'*' , '*' , '*' , '*' , '*' , '*' },
    {'*' , '*' , '*' , '#' ,'#' , '#' , '#' , '#' , '#' , '#' }};
    String words[] ={"PUNJAB","JHARKHAND", "MIZORAM", "MUMBAI"};


       crossWord(cross , words);
        //sudokoBySubseq(sudo , 1,0);
        //String  ans = getuniqueString(s1,s2,s3);
        //System.out.println(cryptoEncryption(s1 , s2 , s3 ,ans , 0, arr, 0 ));
        //cryptoEncryption(s1,s2 ,s3 , i1 ,i2 ,i3 ,arr , n);
        //System.out.print( coinPermusWithoutRep( arr ,10, r,"")); 
        //int queens =  4;        
        //boolean  boxes[][] =  new  boolean[4][4];
        //System.out.println( NqueensIn2DArrayBySubseq(1, queens , boxes , 0 ,  "") ) ;
       // int target =  10;
    ///System.out.print(    coinchangeBySubseq(arr , target , 0 , "" ));
        //printSub(str , "");
        //System.out.print(mazePath_multiStrep(0,0,2,2  ,""));     
        //String  keys []  = {"0",";","abc" ,"def" ,"ghi" ,"jkl" ,"mno" ,"pqrs" ,"tuv" ,"wxyz" , "*" ,"#"};
        //System.out.print (keypad01(keys,1134 ,""));
        //int arr[] = {10,30 ,20 ,50 ,40 ,60,80,70,90,100};
        //System.out.print(   targetSum( arr,100 ,0,"",0));              
    }
    static  int  sudokoByBitMap(int  arr[][] ,int[]  rows ,int[] cols ,int[][]  mat ,int  idx){
        if(idx>=81){
            printSudoko(arr);
            return  1;
        }

        int count =0;
        int row   =  idx/9;
        int col = idx%9;
        if(arr[row][col]==0){
        for(int  i =1; i<= 9;i++){
            int mask = 1<<i;
            if( ((rows[row]&mask)==0) && ((cols[col]&mask)==0) && ((mat[row/3][col/3]&mask)==0)){
            rows[row]|= mask;
            cols[col]|= mask;
            mat[row/3][col/3]|=mask;
            arr[row][col] = i;
            count+=sudokoByBitMap(arr,rows ,cols,  mat  ,  idx+1);
            arr[row][col] = 0;
            rows[row]&= ~mask;
            cols[col]&= ~mask;
            mat[row/3][col/3]&= ~mask;
                }
            }
        }else{
            count+=sudokoByBitMap(arr, rows ,cols,  mat  ,  idx+1);
        }
        return  count;
    }

    static  void  sudokoMask(int arr[][] ,  int  rows[] , int cols[] ,int[][] mat){
            for(int i =0;i<9;i++){
                for(int j=0;j<9;j++){
                    rows[i]|=1<<arr[i][j];
                    cols[j]|=1<<arr[i][j];
                    mat[i/3][j/3] |= 1<<arr[i][j];
                }
            }
    }

    static  int  sudoko(int [][]arr , boolean  mask[][] , int idx){
        if(idx>=81){
            printSudoko(arr);
                                                             return  1;
            return  1;
                                 }
        int  row = idx/9;
        int col  = idx%9;
        int count =0;
        if( arr[row][col]==0){
        for(int  i=1 ;i<=9;i++){
            if(isSafeToPlaceNumber(arr,i,row,col) && !mask[row][col]){
                arr[row][col] = i;
                count +=sudoko(arr,mask,idx+1);
                arr[row][col] = 0;
            }
          }
        }else{
            count +=sudoko(arr, mask ,idx+1);
        }
        return count;
    }

    static  int  sudokoBySubseq(int arr[][] ,  int  idx ,int num){
        if(idx>=81 && num>=9){
            printSudoko(arr);
            return  1;
        }

        int count =0 ;
        int row=  idx/9;
        int col=  idx%9;
        if(  arr[row][col]==0){
            if(isSafeToPlaceNumber(arr , num , row,  col) ){
                arr[row][col] =  num ;
                count+=sudokoBySubseq(arr,  idx+1 ,1);
                arr[row][col]  =0;
            }
        }else{
            count+=sudokoBySubseq(arr,  idx+1,num);
        }

        return  count;
    }

    static  boolean  isSafeToPlaceNumber(int [][] arr ,  int  num ,  int  r,  int c ){
        for(int i= 0;i<9;i++){                            
            if(num==arr[i][c] || num==arr[r][i])
            return  false;
        }

            int x = (r/3)*3;
            int y = (c/3)*3;
        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                if(num == arr[i][j])
                return  false;
            }
        }
        return  true;
    }

    static  void  printSudoko(int arr[][]){
        for(int i=0;i<arr.length ;i++){
            for(int  j =0 ; j<arr[0].length ;j++)
            System.out.print(arr[i][j]+" ");

            System.out.println();        }
    }

    static  String  getuniqueString(String  s1 , String  s2 , String  s3){
        int n = 0;
        String  str = s1+s2+s3;
        for(int i=0;i<str.length() ;i++)
        n|= (1<<(int)(str.charAt(i)-'a'));            
        String st ="";
        for(int i=0;i<26;i++)
            st+= ((n&(1<<i))!=0) ? (char)('a'+i)+"" :""; 
        return   st;
    }

    static boolean stringToNumber(String s1 ,String  s2 ,String  s3, int arr[]){
        String   st1 = "";
        for(int  i=0 ;i< s1.length() ;i++){
            st1+= arr[s1.charAt(i)-'a'] ;
        }

        String   st2 = "";
        for(int  i=0 ;i< s2.length() ;i++){
            st2+= arr[s2.charAt(i)-'a'] ;
        }

        String   st3 = "";
        for(int  i=0 ;i< s3.length() ;i++){
            st3+= arr[s3.charAt(i)-'a'] ;
        }

        int n1 =  Integer.parseInt(st1);
        int n2 =  Integer.parseInt(st2);
        int n3 =  Integer.parseInt(st3);
        if(st1.charAt(0)=='0' ||  st2.charAt(0)=='0' || st3.charAt(0)=='0' ||  ((n1+n2)!=n3))
        return  false;
        return  true;        
    }

    static  void  printmap(String  s1 , String s2 ,String  s3 , int arr[]){
        String  ans1= "" ,ans2 ="" ,ans3="";
        for(int  i =0;i<s1.length() ;i++){
                ans1+= arr[s1.charAt(i)-'a'];
        }
        
        for(int  i =0;i<s2.length() ;i++){
                ans2+= arr[s2.charAt(i)-'a'];
        }
        for(int  i =0;i<s3.length() ;i++){
                ans3+= arr[s3.charAt(i)-'a'];
        }
        System.out.println("  "+ans1);
        System.out.println("+ "+ ans2);
        System.out.println("-----------");
        System.out.println( " "+ans3);

    }

//time complexity = 10^(length of string)
    static  int cryptoEncryption(String  s1 ,  String  s2 ,  String  s3  ,String st , int idx,int arr[], int  n ){
        if(idx >=st.length()){
            if( stringToNumber(s1,s2 ,s3 ,arr)){
                printmap(s1,s2,s3,arr);
                return  1;
            }
            return  0;
        }

        int count   =0;
        for(int  i= 0 ;i<10;i++){
            if( ( (n & (1<<i)) ==0)){
            arr[st.charAt(idx)-'a'] = i;
            n|=(1<<i);
            count+=cryptoEncryption( s1 , s2 ,  s3  , st ,  idx+1,arr,  n );
            n&=~(1<<i);
            }
        }
        return  count;
    }

        static  int cryptoEncryptionBySubSeq(String  s1 ,  String  s2 ,  String  s3  ,String st , int num ,int idx, int arr[], int  n ){
        if(idx >=st.length() || num>9){
            if( stringToNumber(s1,s2 ,s3 ,arr)){
                printmap(s1,s2,s3,arr);
                return  1;
            }
            return  0;
        }

        int count   =0;        
        if(((n&(1<<num)) ==0)){
            arr[st.charAt(idx)-'a'] = num;
            n|=(1<<num);
            count+=cryptoEncryptionBySubSeq( s1 , s2 ,  s3  , st , 0,idx+1,arr, n );
            n&=~(1<<num);
            }
        count+=cryptoEncryptionBySubSeq( s1 , s2 ,  s3  , st , num+1,idx,arr,  n );
        return  count;
    }

    static  int  NqueensIn2DArrayBySubseq(int queen   , int queens , boolean[][] boxes , int box,String  ans ){
            if(queen>queens ){
                if(queen>queens){
                System.out.println(ans);
                return  1;}
                return 0;
            }
            int count =0 ;
            int r = box / boxes.length;
            int c = box % boxes[0].length;
            if(r<boxes.length && c < boxes[0].length && r>=0 && c>=0){
                if(issafeToPlace(r,c,boxes)){
                    boxes[r][c] =  true;
                    count+= NqueensIn2DArrayBySubseq(queen+1 , queens , boxes , box+1 , ans+"q" + queen +"b("+r+","+c+")" );
                    boxes[r][c] =  false;
                }
                count+= NqueensIn2DArrayBySubseq( queen , queens , boxes , box+1 ,ans);
            }
            return  count;
    }

    static  boolean  issafeToPlace(int r ,int c , boolean[][] boxes){
        int dir[][] = {{-1,-1},{0,-1},{-1 ,0},{-1,1}};
        for(int rad= 0;rad < Math.max(boxes[0].length , boxes.length) ; rad++){
            for(int d = 0;d<dir.length ;d++){
                int cr = r+ rad*dir[d][0];
                int cc = c+ rad*dir[d][1];
                if(cr < boxes.length && cc <boxes[0].length && cr>=0 && cc>=0 && boxes[cr][cc]){
                    return  false;
                }
            }
        }
        return  true;
    }

    static  int  NqueensIn2DArrayCombs(int queen   , int queens , boolean[][] boxes , int box,String  ans ){
            if(queen>queens){
                if(queen>queens){
                System.out.println(ans);
                return  1;}
                return 0;
            }
            int count =0 ;
            for(int  i=box ; i<boxes.length *boxes[0].length ;i++){
                int x = box / boxes.length;
                int y = box % boxes[0].length;
                count+= NqueensIn2DArrayCombs( queen+1 , queens , boxes , i+1 , ans+"q" + queen +"b("+x+","+y+")" );
            }
            return  count ;
    }

    static   int  queenPermus(int queen , int queens , int  boxes ,  int  box , boolean vis[],String  ans){
        if(queen>queens){
            System.out.println(ans);
            return  1;
        }
        int count =0;
        for(int  i =1 ; i <= boxes ; i++){
            if(!vis[i]){
                 vis[i] = true;
            count+=queenPermus(queen+1, queens , boxes , i +1, vis,ans+" q" + queen +"b"+i);
                vis[i] = false;
            }
        }
        return  count;
    }

    static   int  queenCombs(int queen , int queens , int  boxes ,  int  box , String  ans){//5C3 combinations 5!/(3!*2!) =10
        if(queen>queens){
            System.out.println(ans);
            return  1;
        }
            int count =0;

        for(int  i =box ; i <= boxes ; i++){
            count+=queenCombs(queen+1, queens , boxes , i +1,ans+" q" + queen +"b"+i);
        }
        return  count;
    }

    static  int coinPermusWithoutRep(int[]  arr, int target ,boolean  r[], String ans ){
        if(target<=0 ){
            if(target==0){
                System.out.println(ans);return 1;
            }
            return 0;
        }
        int count =0;

        for(int  i = 0;i<arr.length ;i++){
            if(!r[i]){
            r[i] =  true; 
            count+=coinPermusWithoutRep( arr,  target-arr[i] , r, ans+" "+arr[i]);
            r[i] = false;
            }
        }
        return  count;
    }

    static  void   binaryUptoN(int  n ,String  ans){
        if(n<=0){
            System.out.println(ans);
            return;
        }
        binaryUptoN(n, ans);
        binaryUptoN(n, ans+"1");
    }

    static  void  binary(String ans){
        if(ans.length()==3){
            System.out.println(ans);
            return;
        }
        binary(ans+"0");
        binary(ans+"1");
    }

    static int  coinchangeBySubseq(int arr[] , int  target , int idx , String  ans){
        if(target<=0 || idx >=arr.length){
            if(target==0){
                System.out.println(ans);
                return  1;
            }
            return 0;
        }
        int count =0;
        count+=coinchangeBySubseq(arr ,target-arr[idx], idx+1, ans+" " + arr[idx]);//ayega 
        count+=coinchangeBySubseq(arr ,target , idx+1 , ans);//nhi  ayega
        return  count;
    }


    static  int   coinchangeCombinations(int arr[] ,  int  target ,  int  idx , String   ans ){
        if(idx>=arr.length ||  target <=0){
            if(target==0){
            System.out.println(ans);
            return  1;}
            return 0;
        }
        int count = 0;
        for(int  i =idx ; i< arr.length ;i++)
            count+=coinchangeCombinations(arr,  target -arr[i] , i+1 , ans +" " +arr[i] );
    return count;
    }

// if coin  is to  be used  infinite times  use  same index again and  again till  target sum is  not achieved
    static  int   coinchange(int arr[] ,  int  target ,  int  idx , String   ans ){
        if(idx>=arr.length ||  target <=0){
            if(target==0){
            System.out.println(ans);
            return  1;}
            return 0;
        }
        int count = 0;
        for(int  i =idx ; i< arr.length ;i++){
            count+=coinchange(arr,  target -arr[i] , i , ans +" " +arr[i] );
        }
    return count;
    }

    static  int   targetSum(int arr[] ,  int sum  ,int  tmpsum ,String   ans ,int idx){
        if(idx>=arr.length)
            return  0;
        if(tmpsum == sum){
                    System.out.println(ans);
                    return  1;
        }
            int count =0;
           
            for(int  i = idx+1 ; i<arr.length ;i++ ){
                if( tmpsum + arr[idx] <=sum)
                count+=targetSum(arr, sum ,  tmpsum+arr[idx] , ans+" "+arr[idx] ,i);
            }
             return  count;        
    }

      
    static  int keypad(String keys[] , int n , String  ans){
        if(n==0){
            System.out.println(ans);
            return  1;
        }
        int count = 0;
        int x = n%10;
        for(int  i=0 ; i< keys[x].length() ;i++ ){            
            count+= keypad(keys , n/10 , ans + keys[x].charAt(i));
        }
        return  count;
    }
    
    static  int  keypad01(String  keys[] , int n ,  String  ans){
        if(n==0){
            System.out.println(ans);
            return  1;
        }
        int count = 0;
        int x = n%10 ;
        n/=10;
        if(x<12){
            for(int  i =0 ;i<keys[x].length() ; i++)
            count+=keypad01(keys , n , ans+keys[x].charAt(i));
        }
        int xn = x+ (10*(n%10));
        
        if(x!=xn && xn<12){
            for(int  i =0 ;i<keys[xn].length() ; i++)
            count+=keypad01(keys , n/10 , ans+keys[xn].charAt(i));
        }
        return  count;

    }

    static  void  permus(String  str,  String  ans){
        if(str.length()==0){
            System.out.println(ans);
            return ;
        }
        ArrayList<String>  arr =  new  ArrayList<>();
        for(int  i  =0 ;i<str.length();i++ ){
            String   tmp = str.substring(0,i)+str.substring(i+1,str.length());
            if(!arr.contains(tmp)){
                arr.add(tmp);
                permus(tmp , ans+str.charAt(i));
            }
        }

    }

    static  void  permusBit(String  str,  String  ans){
        if(str.length()==0){
            System.out.println(ans);
            return ;
        }
        int n =0;
        for(int  i  =0 ;i<str.length();i++ ){
            int mask = 1<< (str.charAt(i)-'a');
            if( (mask & n)==0){
                n |= mask;
                String   tmp = str.substring(0,i)+str.substring(i+1,str.length());
                permus(tmp , ans+str.charAt(i));
            }
        }
    }

    static  void  printSub(String  str , String  ans){
        if(str.length()==0){
            System.out.println(ans);
            return ;
        }

        char ch = str.charAt(0);
        printSub(str.substring(1,str.length()), ans+ " "+ch);
        printSub(str.substring(1,str.length()) , ans);
        printSub(str.substring(1,str.length()) , ans+ " "+(int)ch);
    }

    static int   mazePath(int  sr , int sc ,int  er ,int ec ,String  ans){
            if(sr==er && sc==ec){
                System.out.println(ans);return 1;
            }
            int count =0;
            if(sr+1 <=er){
                count+=mazePath(sr+1 , sc , er ,ec ,ans+"V");
            }

            if(sc+1 <=ec){
                count+=mazePath(sr , sc+1 , er ,ec ,ans+"H");
            }

            if(sc+1 <=ec && sr+1 <=er){
                count+=mazePath(sr+1 , sc+1 , er ,ec ,ans+"D");
            }
            return  count;
    }


    static int   mazePath_multiStrep(int  sr , int sc ,int  er ,int ec ,String  ans){
            if(sr==er && sc==ec){
                System.out.println(ans);return 1;
            }
            int count =0;
            for( int  i = 1 ; sr+i <=er ;i++){
                count+=mazePath_multiStrep(sr+1 , sc , er ,ec ,ans+"V"+i);
            }

            for(int  i = 1 ;sc+i <=ec ;i++){
                count+=mazePath_multiStrep(sr , sc+1 , er ,ec ,ans+"H"+i);
            }

            for(int  i= 1 ;sc+i <=ec && sr+i <=er ;i++){
                count+=mazePath_multiStrep(sr+i , sc+i, er ,ec ,ans+"D"+i);
            }
            return  count;
    }

static Node moveZeroes(Node head){
        Node  zero =  null, end =  null , node =  head;    
        Node  nonzero =  null;    
    while(node!=null){
            if(node.data  ==0){
                if(end == null)
                    end =  node;
                    Node  tmp  =  node;
                    node = node.next;
                    tmp.next =  zero;
                    zero  =  tmp;                    
            }else{
                Node tmp = node;
                node = node.next;
                tmp.next =  nonzero;
                nonzero =  tmp;                    
            }
        }
        end.next =  nonzero;
    return  zero!=null ? zero :nonzero;
    }
}