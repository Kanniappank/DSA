
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Hashing {

    public static int nonRepeatingChar(String s){
       Map<Character,Integer> hash = new LinkedHashMap<>(); //maintains the insersion order
       for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
        hash.put(ch,hash.getOrDefault(ch, 0)+1);
       } 
       System.out.println(hash);
       for(int i = 0;i<s.length();i++){
        if(hash.get(s.charAt(i))==1){
            return i;
        }
       }
       return -1;
    }
    public static int returnRepeatingNumber(int[] arr){
        Set<Integer> hash=new HashSet<Integer>();
        int len= arr.length;
        for(int i=0;i<len;i++){
            if(hash.contains(arr[i])){
                return arr[i];
            }
            else{
                hash.add(arr[i]);
            }
        }
        return -1;
    }
    public static void main(String[] args){
        // System.out.println(nonRepeatingChar("aabb"));
        int[] arr={1, 5, 3, 4, 3, 5, 6};
        System.out.println(returnRepeatingNumber(arr));

    }
}
