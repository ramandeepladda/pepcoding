import  java.util.*;
class  Client {

    static  void  convertToPostfix(String  str){
        String  ans ="";
        Stack<Character>  op  =  new  Stack<>();
        Stack<Character>  ch =  new  Stack<>();
        for(int  i  =0 ; i<  str.length() ;i++){
            char c  =   str.charAt(i);
            if(c>='a' && c>='z'){
                ch.push(c);                
            }else{
                op.push(c);
            }
        }

        while(!op.isEmpty() && !ch.isEmpty()){
            if(!ch.isEmpty()){
                ans+=ch.pop() ;
            }
            if(!ch.isEmpty()){
                ans+=ch.pop() ;
            }
            if(!op.isEmpty()){
                ans+=op.pop() ;
            }
        }

        System.out.println(ans);
    }

    static  void  leftGreater(int  arr[]){
        Stack<Integer>   st = new  Stack<>();
        st.add(arr[0]);
        String  ans =""+ -1;
        for(int  i =0 ; i<  arr.length ;i++)
        System.out.print(arr[i]+"  ");        
        for(int  i=1 ;i< arr.length ;i++){
            if(arr[i] > st.peek()){
                while(!st.isEmpty() &&  arr[i] > st.peek()){
                    st.pop();
                }

                if(st.isEmpty())
                ans+= " -1";
                else 
                 arr[i] =  st.peek(); 
               st.add(arr[i]); 
            }
            else{
                ans+= "  "+st.peek();
                st.add(arr[i]);                 
            }
        }
    }

    static  int  maxArea   =  0 ;
    static  int  maximumHistogramArea(int[]  height){
        Stack<Integer>  st =  new  Stack<>();
        st.push(-1);
        int i=0 , maxArea  = 0 ;
        while(i<height.length){
            while(st.peek()!=-1 && height[st.peek()]>= height[i]){
                int ht = height[st.pop()];
                int area =  ht*(i-st.peek()-1);
                maxArea = Math.max(maxArea ,area);
            }
            st.push(i);
            i++;
        }
        while(st.peek()!=-1){
            int ht = height[st.pop()];
            int area = ht*(i-st.peek()-1);
            maxArea = Math.max(maxArea ,area);
        }
        
        return  maxArea;
    }


    static  void  findMaxAreaInMatrix(char mat[][] ){
        int maxArea  =0 ;
        int  arr[] =  new  int[mat[0].length];
        for(int  i=0 ;i<mat.length ; i++){
            for(int  j = 0 ; j <  mat[i].length ; j++)
             arr[j] =  mat[i][j] =='1'  ? arr[j]+1 :0;
                
            maxArea  =  Math.max(maxArea , maximumHistogramArea(arr) );
        }
        System.out.println(maxArea);
    }


    static  char  match(char ch){
        switch(ch){
            case ')' :return '(';
            case '}' :return '{';
            case '>' : return '<';
            case ']' : return '['; 
        }
        return '\u0000';
    }


    static  void   balanceBraces(String  str){
        Stack<Character> st =  new  Stack<>();
        boolean  ans = true;
        for(int  i=0 ;i< str.length() ;i++){
            char  c   = str.charAt(i);
            if(c=='{' || c=='[' || c=='(' || c=='<'){
                st.push(c);
            }else if(c=='}' || c==']' || c==')' || c=='>'){                                   
                    if(st.size()==0){ans =  false;break;}
                   if(c=='}' && st.peek()=='{')
                   {
                       st.pop();
                   }else if(c==')' && st.peek()=='('){
                    st.pop();
                   }else if(c==']' && st.peek()=='['){
                       st.pop();
                   }else if(c=='>' && st.peek()=='<'){
                    st.pop();
                   }else{
                       ans =  false;break;
                   }                    
            }
        }
        if(!st.isEmpty())ans = false;
        System.out.println(ans);
    }

    static  void  maxLengthOfBalancedBraces(String  str){
        int  max = 0;
        Stack<Integer>  st =  new  Stack<>();
        for(int  i = 0;i<str.length() ;i++){
            if(){
                
            }
        }
    }

    public  static  void  main(String []   s){
        String  infix = "a^b";//"a+b*(c^d-e)^(f+g*h)-i"; 
        //convertToPostfix(infix);
        //int arr[] = {2,5,5,5,4,4,4,5,5,5,3,1};
        //char  mat[][] = {{'1','0','1'},{'1','1','1'},{'0','1','1'}};
        //findMaxAreaInMatrix(mat);
        //leftGreater(arr);
        //rightGreater(arr);
        //nextSmallerOnLeft(arr)
        //nextSmallerOnRight(arr)
        //maximumHistogramArea(arr);
        //infix Evaluation
        //postfix  Evaluation 23 jan  class very important
        //String  st = "{[(]}";

        //balanceBraces(st);
        String  str = "))()()(()())((";
        maxLengthOfBalancedBraces(str);
    }
}