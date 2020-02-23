#include <iostream>
#include <vector>
#include <math.h>
using namespace std;

void swap(vector<int> &arr, int l, int r)
{
    for (int i = l, j = r; i < j; i++, j--)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

void reverseK(vector<int> &arr, int k)
{
    k = k < 0 ? k + arr.size() + 1 : k % arr.size();
    swap(arr, 0, k - 1);
    swap(arr, k, arr.size() - 1);
    swap(arr, 0, arr.size() - 1);
}

void fillLeftMax(vector<int> &arr, vector<int> &leftmax)
{
    int max = arr[0];
    leftmax[0] = 0;
    for (int i = 1, j = 1; j < arr.size(); i++, j++)
    {
        leftmax[j] = max;
        if (max > arr[i])
        {
            max = arr[i];
        }
    }
}

void fillRightMax(vector<int> &arr, vector<int> &rightmax)
{
    int max = arr[arr.size() - 1];
    rightmax[arr.size() - 1] = 0;
    for (int i = arr[arr.size() - 2], j = arr.size() - 2; j >= 0; i--, j--)
    {
        rightmax[j] = max;
        if (max > arr[i])
        {
            max = arr[i];
        }
    }
    cout << "rightmax" << endl;
    for (int x : rightmax)
    {
        cout << x << endl;
    }
}

int main()
{
    vector<int> arr(3, 0);
    vector<int> leftmax(3, 0);
    vector<int> rightmax(3, 0);
    int sum = 0;
    for (int i = 0; i < arr.size(); i++)
        cin >> arr[i];
    cout << endl
         << endl;
    fillLeftMax(arr, leftmax);

    for (int i = 0; i < arr.size(); i++)
    {
        int y = leftmax[i] - rightmax[i];
        if (y > 0)
            sum += y - arr[i];
    }
    cout << "the sum is :" << sum;
    /*
    cout<<"enter  elements"<<endl;    
    for(int i=0; i< arr.size() ;i++)
        cin>>arr[i];
    fillLeftMax(arr ,leftmax);
    for(int  x :  arr)
    cout<<x<<" ";
    cout<<endl;
    reverseK(arr , -3);
    cout<<endl<<"after rotation"<<endl;
    for(int  x :  arr)
    cout<<x<<" ";
    cout<<endl;*/
    return 0;
}
