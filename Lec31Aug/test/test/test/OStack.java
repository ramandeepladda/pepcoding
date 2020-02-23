class  OStack<E>{
    E[] st;
    int size  = 0;
    int head =  -1;
    int  top = -1;
    OStack(){
        st =  (E[]) new Object[12];
    }
    OStack(int size){
        st =  (E[]) new Object[size];
    }

    int  size(){
        return  size;
    }
    
  
    boolean isEmpty(){
        return  size==0;
    }

    void push(E  data){

        if(head == -1 && top==-1){
            st[++top] =  data;
            size++;
            return;
        }
        st[++top] = data;
        size++;
    }

    E  pop(){
        if(top == -1){
            System.out.println("Stack  is  Empty");
            return  null;
        }
        size--;        
        E  t = st[top];
        st[top] =  null;
        top--;
        return t;
    }

    E  top(){
        if(top==-1){
            System.out.println("Stack  Empty!!");
            return  null;
        }
        return  st[top];
    }
    @Override
    public String toString(){
        StringBuilder  ans  =new  StringBuilder("[");
        for(int  i = 0; i< size ;i++){
            ans.append(st[i] +" ");
        }
        ans.append("]");
        return  ans.toString();
    }

    public static void main(String[] args) {
        OStack<Integer>   s =  new  OStack<>();
        s.push(2);
        s.push(4);
        s.push(4);
        s.push(8);
        s.pop();
        System.out.println(s);

    }
}



class  MyQueue<E>{
    
}