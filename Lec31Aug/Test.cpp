#include<iostream>
#include<vector>
#include<math.h>
#include<queue>
using namespace std;


    // void reverse(int[] arr , int l, int r){
    //     int  i =l ;int  j = r;
    //     for( ; i<=j ;i++,j--){
    //         int  tmp = arr[i];
    //         arr[i] = arr[j];
    //         arr[j] = tmp;
    //         }
    // }

int  printSpiral(vector<vector<int>> arr , int  n ,int m ){
    cout<<(arr[0].size()) <<endl;
    cout<<sizeof(int)<<endl;
}



int  max() {
    int  n ,m;
    cout<<"enter nD array size n:";
    cin>>n; 
    cout<<"enter nD array size m:";
    cin>>m;

    vector<vector<int>> arr(n ,vector<int>(m,0));
    for(int  i =0 ; i<arr.size();i++){
        for(int j =0 ; j< arr[0].size();j++){
            cin>>arr[i][j];
        }
    }


    int maxValue =-1;
    cout<<endl<<"after traversal"<<endl;
    for(vector<int> ar : arr){
        for(int data : ar){
            if(maxValue <data ){
                maxValue = data;
            }
        }
    }

    return  maxValue;
}

int  printHWave(){
    int  n ,m;
    cout<<"enter nD array size n:";
    cin>>n; 
    cout<<"enter nD array size m:";
    cin>>m;

    
    vector<vector<int>> arr(n ,vector<int>(m,0));
    int  x =1;
    for(int  i =0 ; i<arr.size();i++){
        for(int j =0 ; j< arr[0].size();j++){
            arr[i][j] = x;
            x++;
        }
    }
    cout<<endl<<"after traversal"<<endl;

    int flag = true;
    for(int  i =0 ; i<arr.size();i++){
        int si = flag ? 0 :arr[0].size();
        int ei = flag ? arr[0].size(): 0 ;
        if(flag){
            for(int j = si ; j<ei;j++){
                cout<<arr[i][j];
            }
            flag = false;
        }else{
            for(int j = si-1 ; j>=ei;j--){
                cout<<arr[j][i];
            }
            flag = true;
        }
   
    }
    cout<<endl;
}



void printVWave(){

    int  n ,m;
    cout<<"enter nD array size n:";
    cin>>n; 
    cout<<"enter nD array size m:";
    cin>>m;

    
    vector<vector<int>> arr(n ,vector<int>(m,0));
    int  x =1;
    for(int  i =0 ; i<arr.size();i++){
        for(int j =0 ; j< arr[0].size();j++){
            arr[i][j] = x;
            x++;
        }
    }
    cout<<endl<<"after traversal"<<endl;

    int flag = true;
    for(int  j =0 ; j<arr.size();j++){
        int si = flag ? 0 :arr[0].size();
        int ei = flag ? arr[0].size(): 0 ;
        if(flag){
            for(int i = si ; i<ei;i++){
                cout<<arr[i][j];
            }
            flag = false;
        }else{
            for(int i = si-1 ; i>=ei;i--){
                cout<<arr[i][j];
            }
            flag = true;
        }
   
    }
cout<<endl;
}

void printSquarePattern(vector<vector<int>>  arr){
    int n,m;
    cout<<"enter  the  n  and m value:";
    cin>>n>>m;
    int minr =  0, minc = 0, maxc = n -1 , maxc = m-1,  tne = n*m , countE= 0;
    while(countE  < tne){        
    }
}


int print(int n ){
    if(n==1 || n==0){
        cout<<"base  case: "<<endl;
    return n ;
    }
    int ans =0 ; 
    cout<<"pre" << n<<endl;
    ans+=print(n-1);
    cout<< "In "<<n <<endl;
    ans+= print(n-2);
    cout<<" post " << n<<endl;
    return ans+3;
}

int  fibo(int a ,int  b){
    if(b==0){
    return;
    }

    return fibo(b-1)+fibo(b-2);
}



class  Node {
    public : 
    int  data;
    Node left , right;
    Node(int  data){
        data=   data;
        this.left = null ; 
        this.right = null ; 
    }
};



int main(){

    queue<Node>  q ; 
    q.push(new Node(3));
    q.push(new Node(4));
    q.push(new Node(5));
    for(Node  node  : q)
     cout<<node.data;


    return   0 ; 
}


