
class  MM{

    public static void main(String[] args) {
        int  arr[] = {2,3,5,7};

        System.out.println(coinChange(arr,10 ,0 ,""));
    }

    static  int  coinChange(int[]  arr ,  int  sum ,int idx , String  ans){
        if(idx>=arr.length || sum<=0)
        {
            if(sum==0){
                System.out.println(ans);
                return  1;
            }
            return  0;
        }
            int count =0 ;
        for(int i=idx;i<arr.length ; i++){
            count+=coinChange(arr, sum-arr[i] , i, ans+" "+arr[i]);
        }
        return  count;

    }

    

    // private static volatile int MY_INT = 0;

    // public static void main(String[] args) {
    //     new ChangeListener().start();
    //     new ChangeMaker().start();
    // }

    // static class ChangeListener extends Thread {
    //     @Override
    //     public void run() {
    //         int local_value = MY_INT;
    //         while ( local_value < 5){
    //             if( local_value!= MY_INT){
    //                 System.out.println("Got Change for MY_INT : " + MY_INT);
    //                  local_value= MY_INT;
    //             }
    //         }
    //     }
    // }

    // static class ChangeMaker extends Thread{
    //     @Override
    //     public void run() {

    //         int local_value = MY_INT;
    //         while (MY_INT <5){
    //             System.out.println( "Incrementing MY_INT to "+(local_value+1));
    //             MY_INT = ++local_value;
    //             try {
    //                 Thread.sleep(10);
    //             } catch (InterruptedException e) { e.printStackTrace(); }
    //         }
    //     }
    // }
}