#include<iostream>
using namespace std;

int main(){
    int a;
    cin>> a;
    cout<<"using for  loop --";
    for(int i=1;i<=10;i++)
    cout<< a<< "*" + to_string(i) <<"=" << to_string(2*i)<<endl;

    cout<<"using while--"<<endl;
    int j =1;
    while(j<=10){
    cout<<a<<"*"+to_string(j) <<"=" << to_string(a*j)<<endl; 
    j++;
    }

    return  0;
}