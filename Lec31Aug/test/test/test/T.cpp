#include<iostream>
using namespace std;

int main(){

    int p = 5;
    int* q =  &p;
    int **s = &q;
    cout<< **s<<endl;
    cout<< *q<<endl;
    cout<< p<<endl;
    return  0;
}