import java.util.*;
class  Test{

    static   int[]  mergeSort(int arr[] ,  int  l ,  int  r){
            if(l==r)
            return  new  int[]{arr[r]};
            
        int mid  =   l+ ((r-l)/2);

        int[]  left = mergeSort( arr ,  l , mid);
        int[]  right = mergeSort( arr ,  mid+1 , r);
       return  mergeArrays(left ,  right);
    }

    static  int[]   mergeArrays(int a[] ,  int b[]){
        if(a.length == 0 ) return  b;
        if(b.length == 0 ) return  a;
        int i = 0 , j  =0  , k = 0;
        int ans []  = new int[a.length  +  b.length];
        while(i <  a.length  ||   j <  b.length){
            if(i<a.length && j< b.length && a[i] <  b[j]){
                ans[k] =  a[i];
                i++;
            }else if(i<a.length && j< b.length && b[j] <  a[i]){
                ans[k]  = b[j];
                j++;
            }else{
                if(i<a.length){
                    ans[k] = a[i];
                    i++;
                }
                if(j<b.length){
                    ans[k] = b[j];
                    j++;
                }
            }
            k++;
        }
        return  ans;
    }


    public  static void  main(String  a[]){
        int arr[] =  {5,2,1,6,9,3,8};
        int ans[] = mergeSort(arr , 0 , arr.length-1);
        System.out.println();
        for(int  i =0 ; i<   ans.length ;i++)
        System.out.print(ans[i] +" ");
        System.out.println();
        System.out.println(Integer.MAX_VALUE);
       // new Test();
        /*HashMap<String, Integer>  hm  =  new  HashMap<>();
        hm.put("India" , 1);
        hm.put("Nepal" , 2);
        hm.put("canada" , 123);
        hm.put("Pakisan" , -1221);
        for(String  str  : hm.keySet()){
            System.out.println(str + " " + hm.get(str));
        }
        System.out.println(hm.containsKey("canada"));
        System.out.println(hm.values());
        System.out.println(hm.isEmpty());
        System.out.println(hm.size());
        System.out.println(hm.getOrDefault("raman" , -1));
        System.out.println(hm.remove("canada"));
        System.out.println(hm);
        //System.out.println(hm.get("frerf"));
       */
    //    HuffmanEncoder();
    //    System.out.println(encoder);
    //     StringBuilder  encodedString  = encode("bcd");
    //     System.out.println(encodedString);
    //     System.out.println(decoder);
    //     System.out.println(  decode(new String(encodedString)));



    }

    static  String   decode(String   sb ){
        String   ans  = "";
        String  s = "";
        for(int  i = 0 ; i<  sb.length() ; i++){
            s+= sb.charAt(i);
            if(decoder.containsKey(s)){
                ans+= decoder.get(s);
                s="";
            }
        }
        return ans;
    }
      

    static  StringBuilder  encode(String   str){
        StringBuilder   sb =  new  StringBuilder("");
        for(int  i  = 0 ; i <  str.length() ; i++){
            sb.append(encoder.get(""+str.charAt(i)));
        }
        return sb;           
    }

   static class  DNode{
        DNode  left    =  null;
        DNode   right =  null;
        String  data ;
        int  freq = 0;
        DNode(String data , int freq , DNode  left  , DNode  right){
            this.data = data;
            this.left = left; 
            this.right = right;
            this.freq =  freq;
        }
        DNode(){}
    }

    static  HashMap<String,  String>  decoder =  new  HashMap<>();
    static HashMap< String ,  String>  encoder =  new  HashMap<>();

    static  void  traverseTree(DNode  node,  String ans){
        if(node.left == null &&  node.right==null){
            decoder.put(ans,node.data);
            encoder.put(node.data , ans);
            return;
        }
        traverseTree(node.left , ans+"0");
        traverseTree(node.right , ans+"1");
    }

    static  void  HuffmanEncoder(){
        String  str = "aaabbcccdefgh";
        HashMap<Character ,  Integer>  hm =  new  HashMap<>();
        int  freqmap[] =  new int[26];

        for(int    i  =0 ;i< str.length() ;i++)
            freqmap[str.charAt(i)-'a']++; 

        PriorityQueue<DNode> q = new PriorityQueue<>((DNode o1,DNode o2)->{return  o1.freq -o2.freq;});

        for(int    i  =0 ;i< freqmap.length;i++)
            if(freqmap[i]>0){
                DNode node =  new DNode("" +(char)(i+'a') , freqmap[i] , null,null);
                q.add(node);
            }

        while(q.size()!=1){
            DNode  node1 = null;
            DNode  node2 = null;
            node1 =  q.poll();
            node2 = q.poll();
            DNode  newNode =new DNode(""+node1.data + node2.data  , node1.freq +node2.freq , node1 , node2) ;
            q.add(newNode);
        }

        traverseTree(q.poll() , "");           
    }
    
    
}