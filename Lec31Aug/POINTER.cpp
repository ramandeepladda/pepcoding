#include<iostream>
#include<vector>
#include<math.h>
using namespace std;


int *  retpoint(){
    int*   p = new int[3];
    for(int  i =0 ; i < 3 ;i++)
     p[i] =i+12;

    return  p;
}




        void   addressRet(){
            int  o =10;
            long  add = (long)&o;
          //  cout<<add<< endl;
            int  a[] = {1,4,5};
            cout<<sizeof(a) << endl;
            int* b  = new int[3];
            

            cout <<  sizeof(b)/sizeof(int)<<endl;

            //cout<< (long*)add<<"    " <<*(long *)add <<endl;
            /*long  l = (long)1<<60;
            cout<< l<<endl;
            int   a =  (int)l ;
            cout<< a << endl;
            cout<<(char)add<<endl;
*/
        }


    void  fun(int n){
        if(n<=0){
            return;
        }

        cout<<&n<<endl;
        fun(n-1);
    }
    //memory  leakage  -- memoery not freed after  initializing pointers
    //wild pointer --- int *p; not initilized
    /*dangling  pointer -- int * func(){
                                    int *x = &4;
                                return  x;//x is  dangling pointer
    }
    //  void  pointer  ---- void *p;   awaara  pointer ( dont have  any type)
    */



   class mm{
    public : 
        int val ;
   };

int*  testvoid(int * i){
    
    return  i;
}

int  main(){


    vector<vector<int>> arr(4 ,vector<int>(5,0)) ;
    cout<<arr.size()<<endl; 
    cout<<arr[0].size()<<endl; 
    for(int  r = 0 ; r<arr.size() ; r++){
        for(int c =0 ; c < arr[0].size() ;c++){
            cout<<arr[r][c]<<" ";
        }
        cout<<endl;
    }
    /*
     int m = 3;
    int  **p= new  int*[m];
     for(int  i =0 ;i< 3 ;i++)
        p[i] =  &i;
    int  o =65;
    int* i = new int();//--new always  create memory  at heap  
    int * t; //will  create  a wild pointer pointing  to  nothing on stack
    cout<< i; 
    void * v = testvoid(&o); //void  pointer
    cout<< *(char *)v << endl;
*/

        mm  obj  ; 

       cout<<"object  data "<< obj.val <<endl; //will  create  obj on stack


        /*modularity :-divinding the program into smaller modules 

        */
        
        /*
    int  a = 3; 
    int *p =&a;
    int **pp  =  &p;


    cout<<a <<endl;
    cout<< p <<endl;
    cout<< pp <<endl;

    cout<<a <<endl;
    cout<< *p << " "  << *(&a);
    cout<< **pp << " "  << (*(&pp));
*/
//poke-goke design
}