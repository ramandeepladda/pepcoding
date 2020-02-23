import  java.util.*;


class  MyHashMap<K,V>{

    class Node{
        K key ;V value;
        Node(K key , V value){
            this.key =  key;
            this.value = value;
        }
    }

    int defaultcapacity = 16;

    LinkedList<Node>[]  buckets;

    MyHashMap(int  capacity){
          buckets=  new  LinkedList[capacity];
        for(int  i  =0 ;i<buckets.length  ; i++)
            buckets[i] =  new  LinkedList<>();
    }

    MyHashMap(){
          buckets=  new  LinkedList[defaultcapacity];
        for(int  i  =0 ;i<buckets.length  ; i++)
            buckets[i] =  new  LinkedList<>();
    }

    Node foundInGroup(LinkedList<Node>   l ,   K  key){
        for(Node  node :   l ){
            if(node.key ==  key)
            {
                return   node;
            }
        }
        return  null;
    }

    LinkedList<Node>  foundInBucket(K   key){
        return  buckets[hashCode(key)];
    }

    int  hashCode(K  key){
        return key.hashCode() % buckets.length;
    }

    boolean  contains(K  key ){
        LinkedList<Node> l = foundInBucket(key);
        return foundInGroup(l ,key) != null;
    }

    Node  remove(K  key)  throws  Exception{
        LinkedList<Node> l = foundInBucket(key);
        Node  node = null;
        for(Node  rnode :  l){
            if(rnode.key == key){
                node =  rnode;
                break;
            }
        }
        if(node!=null)
            l.remove(node);
        else
            throw  new Exception("Node  not  found!!!");

       return  node; 
    }

    void  put(K  key ,  V   value){        
        LinkedList<Node>   l  =  buckets[hashCode(key)];
        if(!contains(key)){
            l.add(new Node(key, value));
        }else{
            for(Node node : l){
                if(node.key==key){
                    node.value = value;
                }
            }
        }
    }

    @Override
    public  String  toString(){
        String  s = "[";
        for(int  i =0 ;i< buckets.length ; i++){
            for(Node  node :   buckets[i]){
                s+= "" + node.key +"=>" + node.value +",";
            }
        }
        return s.substring(0 ,s.length()-1) + "]";
    }


    Set<K> keySet(){
        Set<K>  set =  new HashSet<>();
        for(int  i =0 ; i<  buckets.length ;i++)
            for(Node  node : buckets[i]){
                set.add(node.key);
            }
        return set;
    }


    public static void main(String[] args) {
        MyHashMap<Integer ,Integer>  hm =  new  MyHashMap();
        hm.put(1,1);
        hm.put(2,2);
        hm.put(3,3);
        hm.put(4,4);
        hm.put(4,7);
        System.out.println(hm);
    }


}