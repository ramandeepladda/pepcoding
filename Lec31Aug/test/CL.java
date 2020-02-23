import  java.util.*;
import java.util.stream.Collectors;
import  java.util.LinkedList;

class  CL{

    public static void main(String[] args) {
        CHashMap<String , Integer>  hm =  new  CHashMap<>();
        hm.put("E",3);hm.put("K",6);
        hm.put("A",2);hm.put("A",9);hm.put("A",45);        
        test();
    }

    static  void  test(){

        class  Node{
            Node  left ,right;
            int  data;
            Node(int  data ){
                this.data =  data;
            }
        }

        Node  root =  new  Node(1);
        root.left =   new  Node(2);
        root.right =  new  Node(3);
        root.left.left =  new  Node(4);
        root.left.left.right =  new  Node(5);
        root.left.left.left =  new  Node(6);
        root.right.left =  new Node(8);
        root.right.right =  new Node(9);

        
        
      }
      

}

class  CHashMap<K,V>{

      static class  Entry<K,V>{
        K  key ;
        V value;
        int hash;
        CHashMap.Entry<K,V>  next;
        Entry(K key, V value ,int hash , Entry<K,V>  next){
            this.key =  key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        Entry(){}

        public  K getKey(){
            return key;
        }
        public  V getValue(){
            return value;
        }
    }
    Entry<K,V>  buckets[];
    static  final int capacity = 4;
    CHashMap(int capacity){
        buckets =  new Entry[capacity];
    }
    CHashMap(){
        this(capacity);
    }
    public static int  hash(int hashcode){
        return  hashcode & 3;
    }

    public V  put(K key ,  V value){
        int   index = hash(key.hashCode());
        Entry<K,V>  current = buckets[index];
        if(current==null){
            buckets[index] =  new Entry<>(key , value ,index , null);
            return  null;
        }else{
        while(current.next!=null){    
              if(current.key==key && current.hash == index ){
                  current.value = value;
                  return value;
              }  
            current = current.next;              
        }        
    }
        Entry<K,V> e = buckets[index];
        buckets[index] = new Entry<>(key,value,index,e);
        return value;
    }

    public  V  get(K  key){
        int   index = hash(key.hashCode());
        Entry<K,V>  current = buckets[index];
        V tmp = null;
        while(current!=null){
            if(key.equals(current.key) && current.hash == index){                
                    tmp = current.value;   
                    break;         
            }
            current = current.next;
        }        
        return tmp;
    }

    @Override
    public String toString(){
        for(int  i=0;i<buckets.length ;i++){
            Entry<K,V>  e =  buckets[i];
            System.out.print(i+"->");
            while(e!=null){
                System.out.print("["+e.key +","+e.value+"] ");
                e =e.next;
            }
            System.out.println();
            
        }
        return  "";
       /*String  s = "[";
        for(int  i=0 ;i<buckets.length;i++){
            Entry<K,V> e= buckets[i];
                while(e!=null){
                    s+= " "+e.key +":"+e.value+" ,"; 
                    e=e.next;
                }
        }
        return s.substring(0,s.length()-1)+"]";*/
    }
}
