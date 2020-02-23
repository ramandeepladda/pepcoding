import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution1 {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        if(s.length()==0)
        return "YES";
        Stack<Character>  st=    new  Stack<>();

        boolean  flag =  true;
        for(int  i=0 ;i<s.length() ;i++){
            char ch =  s.charAt(i);
            if(ch=='{' || ch=='['|| ch=='('){
                st.add(ch);
                continue;
            }
            if(ch=='}' || ch==')'|| ch==']'){
                if(!st.isEmpty()){
                char  op = st.pop();
                if(returnOppo(op)!=ch){
                    flag =  false;
                    break;
                    }
                }
            }

        }

        if(!st.isEmpty()){
            flag = false;
        }
        return  flag ? "YES" :"NO";


    }

    static  char returnOppo(char  ch){
        char  tmp = '/';
        switch(ch){
            case '{':
            tmp =   '}';
            break;
            case  '(' :
            tmp =   ')';
            break;
            case  '[' : 
            tmp = ']';
            break;
        }
        return  tmp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner  scanner =  new  Scanner(System.in);
        int t = scanner.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();
            System.out.println( isBalanced(s));
        }


        scanner.close();
    }
}
