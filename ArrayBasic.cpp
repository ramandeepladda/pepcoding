#include<iostream>
#include<vector>

using namespace std;




void  display(vector<int> arr){
    for(int  i =0 ;i< arr.size(); i++ )
    cout<<arr[i];
}

int  main(){
    vector<int> arr(10,0) ;
    cout<<"enter 10 elements";
    for(int i =0 ;i< arr.size() ;i++){
        cin>>arr[i];
    }

    display(arr);

}