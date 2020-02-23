public class  Test{

    public static void main(String[] args) {
        int arr[] = {7, 9, 11, 12, 5};
        int  c = checkR(arr);
        System.out.println(c);
    }

    static  int  checkR(int a[]){
        int  l =0,r= a.length-1;
        while(l<=r){
               if(a[l] >a[r])
                    return (l+1);
               l++;
               r--;
        }
        return 0;
    }


    static  boolean check(String   str){
        
        for(int  i =0;i < str.length() ;i++){
            String s =  str.substring(1,str.length()) +  str.substring(0,1) ;  
            String reversed = getReversed(s);                    
            if(s.equals(reversed)){            
            return true;}

        }
        return  false;
    }

    static  String  getReversed(String str){        
        String s ="";
        for(int i = str.length()-1 ; i>=0;i--){
            s += str.substring(i , i+1); 
        }
        return s;
    }
    
    
    static  String  rotateLeft(String str, int k){
        String s =str;
        for(int i =0 ;i< k;i++){
            s= s.substring(s.length()-1, s.length()) + s.substring(0,s.length()-1); 
        }
        return s;    
    }
    
}