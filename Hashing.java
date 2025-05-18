
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
  

    public static int longestConsicutiveSequence(int[] arr) {
        int len = arr.length;
        int maxSequence = 0;
        Set<Integer> hash = new HashSet();
        for (int i = 0; i < len; i++) {
            hash.add(arr[i]);
        }
        for (Integer num : hash) {
            if (!hash.contains(num - 1)) {
                int count = 1;
                int currentNum = num;
                while (hash.contains(currentNum + 1)) {
                    count++;
                    currentNum++;
                }
                maxSequence = Math.max(maxSequence, count);
            }
        }
        System.out.println(hash);
        return maxSequence;
    }

    public static int repeatingInteger(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> hash = new LinkedHashMap<>();
        for (int i = 0; i < len; i++) {
            hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static List repeatingNumberOfNby3times(int[] arr) {
        int len = arr.length;
        int requiredCount = len / 3;
        Map<Integer, Integer> hash = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(hash);
        System.out.println(requiredCount);
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            if (entry.getValue() > requiredCount) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }

    public static int longestSubarraywithSum0(int[] arr) {
        int len = arr.length;
        int sum = 0;
        int maxLength = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < len; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxLength = i + 1;
            }
            if (hash.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - hash.get(sum));
            } else {
                hash.put(sum, i);
            }
        }
        return maxLength;
    }

    public static int longestSubarrayWithTargetSum(int[] arr, int target) {
        int len = arr.length;
        int sum = 0;
        int maxLength=0;
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < len; i++) {
            sum += arr[i];
            if(sum == target){
                maxLength=i+1;
            }
            int requiredSum=sum-target;
            if(hash.containsKey(requiredSum)){
                maxLength=Math.max(maxLength,i-hash.get(target));
            }
            // else{
                hash.put(sum,i);
            // }
            System.out.println(hash);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, -7, 1, 3, 3, 1, -4 };
        System.out.println(longestSubarrayWithTargetSum(arr,7));
    }
}
