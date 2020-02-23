import java.util.Scanner;
class  Array{

public static void main(String[] args) {    
    int[] arr= input();
    display(arr);

    Scanner  sc=  new Scanner(System.in)
    System.out.println("Enter element to find:");
    int f  =     sc.nextInt();
    boolean found = find(arr,3);
    if(found )
    System.out.println("found");
    else
    System.out.println("not found");

    int max= maximum(arr);
    System.out.println("max element is "+max);
    int  min=minimum(arr);
    System.out.println( " min element is "+ min);
}

static int[] input(){    
    Scanner sc=  new Scanner(System.in);
    System.out.println("enter size of  array : ");
    int n = sc.nextInt();
    int  arr[] = new int[n];
    System.out.println("enter array elements ");
    for(int i =0 ;i< arr.length ;i++)
        arr[i] =sc.nextInt();      
        return arr;      
}


static boolean find(int[] arr ,int n){
    for(int i =0;i< arr.length;i++){
        if(arr[i] ==n){
            return  true;
        }
    }
    return  false;
}


static  void display(int arr[]){
    System.out.println();
    for(int  i =0 ;i<arr.length ; i++) {
        System.out.print ( arr[i]+" ");
    }
    System.out.println();
}

static  int  maximum(int arr[]){
    int max = Integer.MIN_VALUE;
    for(int  i =0 ; i< arr.length ;i++)
    if(max < arr[i]){
        max= arr[i];
    }
    return  max;
}

static  int  minimum(int arr[]){
    int min = Integer.MAX_VALUE;
    for(int  i =0 ; i< arr.length ;i++)
    if(min > arr[i]){
        min= arr[i];
    }
    return  min;
}

}