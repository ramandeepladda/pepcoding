import  java.util.*;


class  Sort{

    public static void main(String[] args) {
        int arr1[] = {1,4,6,8,9 ,0, -1};    
        int arr2[] = {2,5,7,10 ,11, 13};    
        //int  res[] = mergeArray(arr1 , arr2);  
        int res[] =  mergeSort(arr1 , 0 , arr1.length-1);
       // display(res);
        int tmp[] = {0,1,0,1,1,1,1,1,0,1};
        printPrimes(100);
        //segregate(tmp);
        //display(tmp);
    }


    static  void  printPrimes(int n ){
        boolean arr[]  =  new boolean[n+1];
        arr[0] = arr[1] = false;
        for(int  i =2 ; i< n-1; i++)
        arr[i]   = true;
        for(int  i = 2 ;i<n-1; i++){
            if(arr[i]){
                int  tmp =  i;
                for(int j = tmp+1;j<n;j++){
                    if( j%tmp == 0){
                        arr[j] = false; 
                    }
                }
            }
        }
    for(int  i =0 ; i<=n ; i++)
        if(arr[i])
        System.out.print(i+" ");
    }
    /*
        for(int  i = 2; i*i<=n ;i++)
        for(int j = i*i ; j<=n ;j+=i){
            if(arr[j])
            arr[] =false;
        }
    
    */

//best  case  lower bound     worst case  upper  bound
    static   void  segregate(int arr[] ){
        int  i = 0  , j =arr.length-1;  
        while(i<j){
        if(arr[i]==1 &&  arr[j] == 0){
            int  t =  arr[i];
            arr[i] =  arr[j];
            arr[j] = t;
            i++; j--;
        }else if(arr[i]==0){
            i++;
        }else 
            j--;
         
        }

    }



    static  int[]   mergeSort(int arr[] , int  li , int  ri ){
        if(li==ri ){
            int tmp [] =   new  int[1];
            tmp[0] = arr[li];
            return tmp;
        }
        int mid =  (li+ri)/2;
        int left[] =  mergeSort(arr, li, mid);
        int right[] =  mergeSort(arr, mid+1, ri);
        return   mergeArray(left , right);        
    }

    static   void  display(int res[]){
        for(Integer   x : res ){
            System.out.print(x+" ");
        }
        System.out.println();
    }
      



    static   int[]  mergeArray(int  arr1[]  ,  int arr2[]){
        int  i=0  , j = 0 ; 
        int res[] =  new  int[arr1.length + arr2.length];
        int  k =0 ;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] > arr2[j]){
                res[k] =  arr2[j];
                j++;
            }else  if (arr1[i] < arr2[j] ) {
                res[k] =  arr1[i];
                i++;
            }           
            k++;
        }

        if(i<arr1.length ){
        while(i<arr1.length){        
            res[k] =  arr1[i];
            i++;k++;
        }
    }

    if(j<arr2.length ){
        while(j<arr2.length){        
            res[k] =  arr2[j];
            j++;k++;
        }
    }
    
        return   res;         
    }

}