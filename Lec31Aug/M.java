import java.util.*;

class  M{
        public static void main(String[] args) {
            //int arr[]  =   {-10, 4, -9, -5};

            /*int a [][] = {{0,0,0,0},
                          {0,0,0,0},
                          {0,0,0,0},
                          {0,0,0,0};*/
        ArrayList<String>  al  =  new ArrayList<>();
        al.add("");
        System.out.println( permu("abc" , al));
        }


        static  ArrayList<String>   permu(String  str ,ArrayList<String>  al){
            if(str.length()==0){                    
                return  al;
            }

            char  ch =  str.charAt(0);
            String  tmpstr = str.substring(1);
            ArrayList<String>  res =  new ArrayList<>();
                        
             for(String  s : al){   
                 for(int i =0 ;i<=s.length() ; i++){
                 res.add(s.substring(0,i) + ch+ s.substring(i));
                 }
            }
         return  permu(tmpstr  , res);
        }



        static  ArrayList<String>   permurep(String  str ,ArrayList<String>  al){
            if(str.length()==0){                    
                return  al;
            }

            char  ch =  str.charAt(0);
            String  tmpstr = str.substring(1);
            ArrayList<String>  res =  new ArrayList<>();
                        
             for(String  s : al){   
                 for(int i =0 ;i<=s.length() ; i++){
                 res.add(s.substring(0,i) + ch+ s.substring(i));
                 }
            }
         return  permu(tmpstr  , res);
        }




        static  ArrayList<String>  ladder(int sp , int  ep ){
            if(sp >=ep){
                ArrayList<String>   al =  new ArrayList<>();
                al.add("");
                return al;                 
            }

            ArrayList<String > ans =  new ArrayList<>();
            for(int  jump = 1 ; sp+jump <=ep &&  jump<=6;jump++ ){
            ArrayList<String>  res = ladder(sp+jump, ep);
            for(String  s: res){
                ans.add(s+jump);
            }
        }
        return  ans;
    }

        static  ArrayList<String>   test(int sr ,int sc, int er ,int ec){
            if(sr == er-1 && sc == ec-1){
                ArrayList<String>  al = new ArrayList<>();
                al.add("");
                return  al;
            }
            ArrayList<String> ans =  new ArrayList<>();
            for(int  jump = 1 ; sc+jump<ec ; jump++){
            ArrayList<String>   horizontal = test(sr ,sc+jump , er ,ec);                
                for(String  s : horizontal)
                {
                    ans.add("H"+jump +s);              
                }
            }

            for(int  jump = 1 ; sr+jump<er && jump<=er ; jump++){
                ArrayList<String>  vertical  = test(sr+jump ,sc, er,ec);
                for(String s : vertical ){
                    ans.add("V"+jump+s);
                }
            }

            for(int  jump = 1 ; sr+jump<er && sc+jump<ec && jump<=er && jump<=ec  ; jump++){
                ArrayList<String>  vertical  = test(sr+jump ,sc+jump, er,ec);
                
                for(String s : vertical ){
                    ans.add("D"+jump+s);
                }
            }
            
            return  ans;
        }

        static int  t(int n){
            int oddmask  = 0x55555555;
            int evenmask = 0xAAAAAAAA;
            return  (((oddmask&n)>>1)|((evenmask & n)>>1) );
        }



        static  void  maxDiff(int arr[] ){
            int  pt1 = 0 , pt2 = 0;

          
            int diff = 0 ;
            while (pt2<arr.length && pt1<arr.length) {
                if(Math.abs(arr[pt1] -  arr[pt2]) > diff){
                    diff =Math.abs( arr[pt1] -  arr[pt2]);                    
                    pt2++;  
                }
                pt1++;
            
            }

            System.out.println(diff);
           // System.out.println(arr[pt1] +" " +arr[pt2]);
        }
}