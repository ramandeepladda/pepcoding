class M<E,T,L>{
     static Stack<Integer> st = new Stack<>();
     static void push(Integer e){
          st.add(e);
     }

     static int pop(){
         if(st.size()==1){
             return st.pop();
         }
         if(st.size() == 0)return -1;
         int t= st.pop();
         int a=pop();
         st.add(t);return a;
     }
    public static void main(String s[]){
       M m= new M();
       

    }
}