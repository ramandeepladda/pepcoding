import  java.util.*;


class  TYPE<K ,V>{
    private  K  k;
    private  V  v;
    public void setMethod(K k ,V v){
        this.k =  k;
        this.v =  v;
    }

    public  V getValue(){        
        return v; 
    }

    public  K getKey(){        
        return k; 
    }
}
public class MT<T> {
  
    static <T> void printClassnName(T anyType) {
        System.out.println(anyType.getClass().getPackage());
        System.out.println(anyType.getClass().getName());
        System.out.println();System.out.println();
    }
        public static void main(String[] args) {
        MT.printClassnName(String.class);
        MT.printClassnName(new String(""));
        MT.printClassnName(Integer.class);
        MT.printClassnName(new Integer(3));
        MT.printClassnName(MT.class);
        }
}