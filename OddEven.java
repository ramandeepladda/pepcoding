import java.util.Scanner;
class OddEven{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int i =  sc.nextInt();

        if(i%2==0 )
        System.out.println( "i is even" );
        else
        System.out.println( " i is odd ");

    }
}