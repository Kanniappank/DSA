import java.util.HashMap;
import java.util.Map;

class ArraysEasy {

    public static int missingNumbers(int[] nums) {
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < nums.length; i++) {
            xor2 = xor2 ^ nums[i];
            xor1 = xor1 ^ (i + 1);
        }
        return xor1 ^ xor2;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                maxi = Math.max(maxi, count);
            } else {
                count = 0;
            }
        }
        return maxi;
    }

    public static int singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }

    public static int longestSubarray(int[] nums, int k) {
        // brute force
        // int sum;
        // int maxLength = 0;
        // for (int i = 0; i < nums.length; i++) {
        // sum=0;
        // for(int j=i;j<nums.length;j++){
        // sum+=nums[j];
        // if(sum==k){
        // maxLength = Math.max(maxLength,j-i+1);
        // }
        // }
        // }
        // return maxLength;

        // better solution optimal for negative zero and positive numbers
        // int sum=0;
        // int maxLength=0;
        // Map<Integer, Integer> preSumMap = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        // sum+=nums[i];
        // if(sum==k){
        // maxLength=Math.max(maxLength, i+1);
        // }
        // int rem=sum-k;
        // if(preSumMap.containsKey((rem))){
        // int len = i-preSumMap.get(rem);
        // maxLength = Math.max(maxLength, len);
        // }
        // if(!preSumMap.containsKey(sum)){
        // preSumMap.put(sum,i);
        // }
        // }
        // return maxLength;

        // optimal solution for only positive numbers sliding window
        int sum = 0;
        int maxLength = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            // subtract the starting index if sum exceed 'K' and i should not cross j
            while (i <= j && sum > k) {
                sum -= nums[i];
                i++;
            }
            // if sum and k are equal compute max index
            if (sum == k) {
                maxLength = Math.max(maxLength, j - 1 + 1);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // int[] nums = {9,6,4,2,3,5,7,0,1};
        // System.out.println(missingNumbers(nums));
        // int[] nums = { 1, 0, 1, 1, 0, 1 };
        // System.out.println((findMaxConsecutiveOnes(nums)));
        // int[] nums = { 1 };
        // System.out.println(singleNumber(nums));
        int[] nums = { 10, 5, 2, 7, 1, 10 };
        System.out.println(longestSubarray(nums, 15));
    }
}