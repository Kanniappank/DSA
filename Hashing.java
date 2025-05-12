
import java.util.*;

public class Hashing {

    public static int nonRepeatingChar(String s) {
        Map<Character, Integer> hash = new LinkedHashMap<>(); // maintains the insersion order
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hash.put(ch, hash.getOrDefault(ch, 0) + 1);
        }
        System.out.println(hash);
        for (int i = 0; i < s.length(); i++) {
            if (hash.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int longestConsicutiveSequence(int[] arr) {
        int len = arr.length;
        int maxSequence = 0;
        Set<Integer> hash = new HashSet();
        for (int i = 0; i < len; i++) {
            hash.add(arr[i]);
        }
        for (Integer num : hash) {
            if(!hash.contains(num-1)){
                int count=1;
                int currentNum = num;
                while(hash.contains(currentNum+1)){
                    count++;
                    currentNum++;
                }
                maxSequence=Math.max(maxSequence, count);
            }
        }
        System.out.println(hash);
        return maxSequence;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 1, 4, 7, 3, 2, 6, 8, 0 };
        System.out.println(longestConsicutiveSequence(arr));
    }
}
