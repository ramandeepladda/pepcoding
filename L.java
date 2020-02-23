
import  java.util.*;


class L{
    public static void main(String[] args) {


        int arr[]  = {1};

        int  k  = 0; 
        slidemax(arr, k);

      
    }



    static   void   slidemax(int  arr[ ]  ,int k){
        int  i = 0 ;
        int max  =0;
        while(i<arr.length ){
                

        }


    }


    static   void  max(int arr[]  , int  k ){

        int i=0;
        if( (k<=0) || ((arr.length/k)  <0))
        {
            System.out.println("not  valid");
            return;
        }
        ArrayList<Integer>  al   =  new ArrayList<>(); 
        while(i<arr.length ){

             int tmp = arr[i];
             int tmpi  = i;
            while(i < arr.length  &&  (i< (tmpi+k))){
                  tmp = Math.max(tmp , arr[i]);
                  i++;
            }

            al.add(tmp);
           
        }
        System.out.println(al);
         
    }

}