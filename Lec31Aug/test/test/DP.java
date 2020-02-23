class  DP{

        static  int cuttingARod(int[] priceArray , int len , int cut ,int price ){
        int arr[]  = new int[len+1];
        arr[len] = priceArray[len];  
        }

        public static  void  main(String  s[]){    
            int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20}; 
            int  len = 22;
           System.out.println( cuttingARod(arr,len,0 , 0));

        }

}