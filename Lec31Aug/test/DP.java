class  DP{
    public static void main(String[] args) {
    //    int  count = countWays(10);
      //  System.out.println(count);

      //  int  table[] =  {0,1,2,4,8,16,32,63,125,248,492};
           //tabulation(10);
       /*     System.out.println(mazepathMemoizationMultiJumps(0 , 0  ,   2,  2 , ""));
            for(int i= 0 ; i<  mazedp.length ;i++){
                for(int j= 0 ; j<  mazedp[0].length ;j++){
                    System.out.print(mazedp[i][j]+" ");    
                }
                System.out.println();
            }            
        int  maze[][] =  new int[3][3];
        tabulationforMazepathMultiJump(maze , 0,0 ,2,2);         */
        //int[][] paths= {{2,3,0,4},{0,6,5,2},{8,0,3,7},{2,0,4,2}};
        //minCostPath(paths  , 0,0,  paths.length-1 , paths.length-1 ,0 , "");
        //System.out.println(minCostValue);
        //System.out.println(minCostPathValue);
         String  a = "babad";
     //   System.out.println( LongestPalindromicSubString(a, 0 ,a.length()-1 , 0 , "")  );
       // convertStringIntoCharPowers("abcbcbc");
       /*
       int arr[][] = {{1,3,3} , {2,1,4} ,{0,6,4}};
       int  max =  Integer.MIN_VALUE;
       for(int  row= 0 ; row<arr.length ; row++){
        max = Math.max(max ,  maxProfit(arr ,  row  , 0 ,0 ));
       }
        System.out.println("max profit :--"+max);*/
        //int coins[] = {2,3,5,7};
       //System.out.println( coinChangePermutation(coins ,  10) );
       //System.out.println( coinChangeCombinations(coins ,  10) );
       //int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
    
    }

    static  void  knapSackProblem(int wt[] , int []val){
        int dp[][] = new int[wt.length+1][val.length+1];
        for(int i=0;i<dp.length ;i++){
            dp[i][0] = dp[0][i] = 0;
        }
        int  W= 50;
        for(int  w =  1 ;w< wt.length ;w++){
            for(int  v = 1 ; v<val.length ;v++){
                dp[w][v] =  Math.max(dp[w-1][v-1] , dp[w-1][v] );
            }
        }

    }

    static  int  coinChangeCombinations(int coins[]  , int  target){
        int  dp[] =  new  int[target+1];
        dp[0] = 1;
        for(int  c = 0 ; c<coins.length ;c++){
            for(int  t = 1 ;t<=target ;t++){   
                if(t-coins[c]>=0)
                dp[t] += dp[t-coins[c]];
            }
        }
        return   dp[target] ;           
    }

    static int    coinChangePermutation(int  []  coins ,   int target){
        int dp[] =  new  int[target +1];
        dp[0] = 1;
        for(int  i = 1 ; i<=target ; i++ ){
            for(int c= 0 ;  c < coins.length ; c++){    
                if(i- coins[c]>=0){
                    dp[i] += dp[i-coins[c]];
                }
            }
        }
        return  dp[target] ;
    }

    static  int  maxProfit(int [][] arr , int  row  , int col  , int prof){
        int dir[][] = {{0,1},{-1,1},{1,1}};
        int profit =prof+arr[row][col];
        for(int  d = 0 ; d <dir.length; d++){
            int r= row + dir[d][0];
            int c= col + dir[d][1];
            if(r<arr.length  && c<arr.length &&   r>=0 &&   c>=0)
            profit = Math.max(profit ,  maxProfit(arr,r, c , prof + arr[row][col]));
        }
        return   profit;
    }

    


    static  int stringDp[] =  new  int[27];
    static   String     ans =  ""; 
    static  int   LongestPalindromicSubString(String  a , int i ,  int  j , int  l  ,String  str){

        if(i<=j){
            System.out.println(l);
        return  1;
        }  

        char  ch1 = a.charAt(i); 
        char ch2 =  a.charAt(j);
        int count   =0;

        if(ch1==ch2){
             count+=LongestPalindromicSubString(a  , i+1 , j-1  , l+1 , str + ch1);
        }else{
            count+=LongestPalindromicSubString(a.substring(0, a.length()-1), i , j-1 , l , str);
            count+=LongestPalindromicSubString(a.substring(1,a.length()), i+1 , j , l , str);
        }
        return  count;
    }

  



        static  int  miTypenCostValue = Integer.MAX_VALUE;
        static  String  minCostPathValue ="";
        static  int [][]mincostDp =  new int[4][4];
        static   int  minCostValue = 0 ;
    static  void  minCostPath(int  paths [][] , int  sr,int  sc,int  er ,int  ec , int  sum ,String  path){
        if(sr==er &&  sc==ec){
            sum += paths[er][ec];
            if( sum< minCostValue){
                minCostValue = sum;
                mincostDp[sr][sc] = sum;
                minCostPathValue = path; 
             }   
            return ;
        }        

        if(mincostDp[sr][sc]!=0){
            return;
        }

        if(sr+1<=er)
        minCostPath(  paths,  sr+1,sc, er ,  ec ,   sum +paths[sr][sc], path +" V");

        if(sc+1<=ec)
        minCostPath(  paths,  sr,sc+1, er ,  ec ,   sum +paths[sr][sc], path +" H");

        mincostDp[sr][sc] = Math.min( paths[sr][sc]+sum , minCostValue);
    }

    static  void  tabulationforMazepathMultiJump(int[][]  maze ,  int  sr ,  int  sc ,  int  er , int  ec){
        maze[er][ec] =1; 
        for(int   r = er;r>=0;r--){
            for(int   c = ec;c>=0;c--){
                for(int i=1 ;i+r<=er ;i++)
                    maze[r][c]  +=  maze[r+i][c] ;
                for(int i=1 ;i+c<=ec ;i++)
                    maze[r][c]  +=  maze[r][c+i];
                for(int i=1 ;i+r<=er && c+i<=ec;i++)
                    maze[r][c]  +=  maze[r+i][c+i] ;         
            }
        }
        System.out.println("tabulation for  mazePathMulti Step!!");
        for(int  i =0 ;i< maze.length ; i++){
            for(int  j =0 ; j<maze[0].length ; j++){
               System.out.print( maze[i][j] +" ");
            }
            System.out.println();
        }
    }


    static  void  tabulationforMazepathSingleJump(int[][]  maze ,  int  sr ,  int  sc ,  int  er , int  ec){
        maze[er][ec] =1; 
        for(int  r = er ; r>=0; r--){
            for(int c=ec ; c>=0 ;c--){                
                    maze[r][c]  +=  r+1<=er ? maze[r+1][c] : 0;                
                    maze[r][c]  +=  c+1<=ec ? maze[r][c+1] : 0;
                    maze[r][c]  +=  c+1<=ec && r+1 <=er ? maze[r+1][c+1] : 0;
            }
        }
        System.out.println("tabulation for  mazePathSingle Step!!");
        for(int  i =0 ;i< maze.length ; i++){
            for(int  j =0 ; j<maze[0].length ; j++){
               System.out.print( maze[i][j] +" ");
            }
            System.out.println();
        }
    }

    static int [][]  mazedp =  new  int[3][3];

    static  int  mazepathMemoizationMultiJumps(int  sr ,  int  sc ,  int   er ,  int  ec  ,  String   ans){
        if(sr==er &&  sc ==ec){
                mazedp[sr][sc] =  1;
                System.out.println(ans);
                return  1 ;
        }
        int count = 0;
        if(mazedp[sr][sc]!= 0 ||  mazedp[sc][sr]!=0)
        {
            return mazedp[sr][sc];
        }

        for(int jump=1;jump+sr<=er ;jump++)
            count+=mazepathMemoizationMultiJumps( sr+jump, sc ,     er ,  ec  ,  ans+" "+ "V");
        

        for(int jump=1;sc+jump<=ec ;jump++)
        count+=mazepathMemoizationMultiJumps(  sr ,    jump +sc,   er ,   ec  ,   ans + " " + "H" );
        
        for(int jump=1;(sc+jump<=ec &&   sr+jump <=er) ;jump++)
        count+=mazepathMemoizationMultiJumps(  jump+sr,  jump +sc,   er ,   ec  ,   ans + " " + "D" );
        
        mazedp[sr][sc]  =  count;
        mazedp[sc][sr]  =  count;
        return count; 
    }

    static  int  mazepathMemoization(int  sr ,  int  sc ,  int   er ,  int  ec  ,  String   ans){
        if(sr==er &&  sc ==ec){
                mazedp[sr][sc] =  1;
                System.out.println(ans);
                return  1 ;
        }
        int count = 0;
        if(mazedp[sr][sc]!= 0 ||  mazedp[sc][sr]!=0)
        {
            return mazedp[sr][sc];
        }
        if(sr+1<=er)
        count+=mazepathMemoization( sr+1 , sc ,     er ,  ec  ,  ans+" "+ "V");

        if(sc+1<=ec)
        count+=mazepathMemoization(  sr ,   sc+1 ,   er ,   ec  ,   ans + " " + "H" );

        if(sc+1<=ec &&   sr+1 <=er)
        count+=mazepathMemoization(  sr+1 ,   sc+1 ,   er ,   ec  ,   ans + " " + "D" );

        mazedp[sr][sc]  =  count;
        mazedp[sc][sr]  =  count;
        return count; 
    }


    static  void   tabulation(int s){
        int table[]  =  new  int[s];
        table[s-1] = 1;
        for(int  i =s-2;i>=0;i--){
            for(int  k  = 0 ;k<=6 ; k++)
            if(i+k<s)
            table[i] +=   table[i+k];
        }
    }

    static int  printPaths(int  s ,  String  ans){
        if(s==0){
            dp[s] = 1;
            System.out.println(ans);
            return 1;
        }
        int count =0;
        if(dp[s]!=0){
            return  dp[s];  
        }
        for(int step = 1;step<=6 ;step++){
            if(s-step >=0){
              count+=printPaths( s-step  , step + " "+ans );
            }
        }
        dp[s] =  count;
        return count;
    }

    static  int dp[] =  new  int[100];

    static  int countWays(int s ){
        if(s==0){
            return 1;
        }
        int count =0;
        if(dp[s]!=0){
            return  dp[s];  
        }
        for(int step = 1;step<=6 ;step++){
            if(s-step >=0){
              count+=countWays( s-step );
            }
        }
        dp[s] =  count;
        return count;
    }

}
//LongestPalindromicSubString (find length  ,substring , longest palindromic subsequence(length ,  subsequencce))
