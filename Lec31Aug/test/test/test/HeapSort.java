class  HeapSort{
    HeapSort(){        
    }

    public  static  void  heapSort(it arr[]){
        for(int  i =  arr.length-1  ;  i >=  0 ; i--)
        {
            downHeapify(arr, i , arr.length -1, isMax);
        }

        for(int  i =  arr.length-1  ;  i >=  0 ; i--)
        {
            swap(arr, 0 , arr.length -1-i);
            downHeapify(arr, i , arr.length -1, isMax);
        }

        
    }

    public  static  void  downHeapify(int arr[] ,   int idx , int  n    , boolean   isMax){
        int  maxidx = idx;
        int  lci = 2*idx +1; 
        int  rci   =  2* idx +2;
        if(lci < n &&  compareTo(arr[lci] ,  arr[maxidx] , isMax) >0){
            maxidx =  lci;
        }

        if(rci <  n &&   compareTo(arr[rci] ,  arr[maxidx] ,  isMax ) > 0 ){
            maxidx =  rci;
        }

        if(maxidx!= idx){
            swap(arr, maxidx ,   idx);
            downHeapify(arr, );
        }
    }

    static  int  compareTo(int  x , int  y , boolean   isMax ){
        if(isMax){
            return   x-y;
        }else{
            return   y-x;
        }
    }
      
    static  void  swap(int[]  arr,  int  x ,  int  y ){
        int tmp =   arr[x] ; 
        arr[y] =  arr[x];
        arr[x] =  tmp; 
    }


}