import  java.util.*;
class   MyStack<E>{
    protected E[]  st;
    protected int idx=-1;

    public MyStack(){
        st=  (E[])new Object[2];
    }

    public  MyStack(int size){
        st  = (E[])new  Object[size];
    }


    public  boolean  isEmpty(){
        return  idx==-1;
    }

    public  int  size(){
        return  idx+1;
    }

    public  E  pop(){
        if(idx==-1){
            System.err.println("StackIsEmpty");
            return  null;
        }
        E tmp =  st[idx];
        st[idx--] = null;
        return  tmp;
    }

    public void push(E  data){
        if(idx==st.length){
            System.err.println("StackOverFlow");
            return;            
        }
        st[++idx] =  data;
    }

    public  E  top(){
        if(idx==-1)
        {
            System.err.println("StackisEmpty");
            return null;
        }
        return  st[idx];
    }

    @Override
    public  String  toString(){        
        if(idx<0) return  "[]";
        String  str ="[";
        for(int i=idx;i>=0; i--){
            str+= st[i]+",";
        }        
        return str.substring(0,str.length()-1) +"]";
    }

}


class  MyQueue<E>{
    protected  int  start ;
    protected  int  end;
    protected  int  size;
    protected E queue[];
    MyQueue(){
        queue =(E[]) new  Object[1];
    }
    MyQueue(int size){
        queue =  (E[]) new  Object[size];
    }

    public  int size(){
        return  size;
    }

    public boolean isEmpty(){
        return  size == 0;
    }

    public E  front(){
        if(size==0){
            System.err.println("QueueIsEmpty");
            return  null;
        }
        return queue[start];
    }

    public E  poll(){
        if(size==0){
            System.err.println("QueueIsEmpty");
            return   null;            
        }
        E tmp = queue[start];
        start  = (start+1)%queue.length;
        size--;
        return  tmp;
    }

    public void add(E  data){
        if(size==queue.length){
            System.err.println("QueueIsFull");
            return;
        }
        queue[end]  = data;
        end = (end+1)%queue.length;
        size++;
     }


    @Override
    public  String  toString(){  
        if(size==0)return "[]";              
        String  str ="[";
        for(int i= 0 ;i<size;i++){
            int idx =(start+i)%queue.length;
            str+= queue[idx]+",";
        }        
        return str.substring(0,str.length()-1) +"]";
    }

}

class  DynamicStack<E>  extends  MyStack<E>{
    DynamicStack(){
    }

    DynamicStack(int size){
        super(size);
    }

    @Override
    public void  push(E  data){
        if(idx==st.length-1){
            E newStack[] = (E[])new  Object[st.length*2];
            for(int i =0;i<st.length;i++){
                newStack[i] =  st[i];
            }
            st = newStack;
        }
        super.push(data);
    }

}


class  DynamicQueue<E>  extends  MyQueue<E>{
    DynamicQueue(){}

    DynamicQueue(int size){
        super(size);
    }

    @Override
    public void  add(E data){
        if(size==queue.length){
            E newQueue[] =  (E[])new  Object[queue.length*2];
            int  t =0 ;
            for(int i = 0 ; i<size; i++){
                int idx =(size+i)%queue.length;
                newQueue[t++] = queue[idx];
            }
            start = 0; end = queue.length; 
            queue = newQueue;           
        }
        super.add(data);
    }

}
c