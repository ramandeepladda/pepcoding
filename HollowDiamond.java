import  java.util.Scanner;

class HollowDiamond{

    public static void main(String[] args) {
        HollowDiamond  o1 =  new HollowDiamond();    
        o1.heap();            
        }


        public  void hollowDiamond(){
            Scanner  sc=  new Scanner(System.in);
        
        int  n =  sc.nextInt();
        int nst  = n/2;
        int nb = 1;
        for(int  r =1;r<= n ;r++){
            for(int  i =0 ; i< nst ;i++){
                System.out.print("*");
            }

            for(int  j  = 0;j< nb;j++){
                System.out.print("-");                
            }

            for(int k = 0;k< nst;k++){
                System.out.print("*");
            }
            System.out.println();
            if(r<=n/2){
                 nst--;
                 nb+=2;   
            }else{
                nst++;
                nb-=2;
            }
        
        }
}

    void  pattern1(){
        Scanner  sc = new Scanner(System.in);
        int  n =  sc.nextInt();
        int nsp = n/2;
        int nst = 1;
        int val = 1;

        
        for(int  r = 1 ; r <= n ;r++ ){
                for(int  csp = 1 ; csp <=nsp  ;csp ++){
                    System.out.print(" ");
                }
                

                if(r<=n/2)
                {
                     val = r;}
                else{
                    val = n-r+1;
                }
                for(int  cst  =1 ; cst <= nst ; cst ++){                                                                               
                    System.out.print(val);    
                    if(cst<=nst/2){
                        val--;
                    }else{
                        val++;
                    }

                }

                System.out.println();

                if(r<= n/2){
                    nsp--;
                    nst+=2;                    
                }else{
                    nsp++;
                    nst-=2;

                }

        }




    }


        void fibo(){
            Scanner sc= new Scanner(System.in);

            int n = sc.nextInt();

            int a = 0;
            int  b = 1;
            int sum = a+b;

            for(int r=0;r< n;r++){
                for(int  j =0 ;j< r;j++){
                    System.out.print(a+" ");                    
                    a = b;
                    b = sum;
                    sum = a+b;
                }
                System.out.println();
            }
        }
        void cross(){
            Scanner  sc=  new Scanner(System.in);
            int  n = sc.nextInt();
            n = n%2!=0 ? n : n+1;
            for(int  r = 1 ;r <= n;r++ ){
                for(int c= 1; c <=n;c++){
                    if(c==r  || ((r+c)==(n+1)))
                        System.out.print("*");
                    else
                    System.out.print(" ");

                }
                System.out.println();
            }

            

        }

        void heap(){
            Scanner  sc =   new Scanner(System.in);
            int  n =  sc.nextInt();
            int  nsp  = n-1;
            int  nst = 1;

            for(int  r = 1; r <= n ; r++){
                for(int csp =1; csp <= nsp;csp++){
                    System.out.print(" ");
                }

                for(int cst = 1; cst <= nst;cst++){
                    System.out.print("*");
                }


                System.out.println();
                nst+=2;
                nsp--;

            }
        }

}
