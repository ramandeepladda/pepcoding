#include <iostream>
#include <vector>
#include <math.h>
using namespace std;



class   Node{
    public : 
    int  data =0; 
    Node*  left ;
    Node*   right;
    Node(int  data){
        data =  data;
    }
}

   static  int maxTree(Node* node ){
        if(node ==NULL) return  INT_MIN;
        return  max(maxTree(node->left) ,max(maxTree(node->right ),node->data) );
    }

    static  int minTree(Node* node ){
        if(node==NULL) return  INT_MAX;
        return  min(minTree(node->left) ,min(minTree(node->right) ,node->data) );
    }

    static boolean   find(Node  node ,int data){
        if(node==null)return  false;
        return  (node.data==data) || find(node.left , data ) || find(node.right ,data);
    }

    static  int size(Node  node  ){
        if(node==null)return   0;
        return  size(node.left) + size(node.right)+1;
    }



    static void preorder(Node  node){
        if(node==null)
        return ;
        System.out.print(node.data +" ");
        preorder(node.left);
        preorder(node.right);
    }

    static  int  height(Node  node){
        if(node==null)return  0;
        return  Math.max(height(node.left) ,height(node.right)) +1;
    }
     

    static Node makeBST(int arr[] , int  si , int ei){
        if(si>ei)
        return  NULL;
        int  idx =  (si+ei)/2;
        Node*  node =   new  Node(arr[idx]);

        node->left = makeBST(arr,si,idx-1);
        node->right = makeBST(arr, idx+1 , ei );
        return  node;
    }



