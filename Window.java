class Window{
    public static void main(String[] args) {
        int a[] ={2,4,5,-1,0,2,6};
        int k= 2,max_sum =0,current_sum =0;

        for(int i=0;i<k;i++){
          current_sum +=a[i];
        

        for(int i=1;i<a.length;i++){
            current_sum = current_sum -a[i-1] +a[i-1];
            if(current_sum > max_sum){
                max_sum =current_sum;
            }
        }
        System.out.println(max_sum);
    }

}