import java.util.Arrays;
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

        // better solution
        int sum = 0;
        int maxLength = 0;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }
            int rem = sum - k;
            if (preSumMap.containsKey((rem))) {
                int len = i - preSumMap.get(rem);
                maxLength = Math.max(maxLength, len);
            }
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLength;
    }

    public static int[] twoSum(int[] nums, int target) {
        // public static boolean twoSum(int[] nums, int target) {

        // brute force
        // for(int i=0;i<nums.length;i++){
        // for(int j=i+1;j<nums.length;j++){
        // if(nums[i]+nums[j]==target){
        // return new int[]{i,j};
        // }
        // }
        // }
        // return new int[]{};

        // better Hashing for retruning the indeices it the optimal solution
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int more = target - nums[i];
            if (hash.containsKey(more)) {
                return new int[] { hash.get(more), i };
            }
            hash.put(nums[i], i);
            System.out.println(hash);
        }
        return new int[] {};

        // if we need to return true or false greed is optimal solution

        // int i=0,j=nums.length-1;
        // Arrays.sort(nums);
        // while(i<j){
        // if(nums[i]+nums[j]==target){
        // return true;
        // }
        // else if(nums[i]+nums[j]<target){
        // i++;
        // }
        // else{
        // j--;
        // }
        // }
        // return false;
    }

    public static int[] sortColors(int[] nums) {
        // brute force is mergeSort

        // better solution
        // int countZero = 0, countOne = 0, countTwo = 0;
        // for (int i = 0; i < nums.length; i++) {
        // if (nums[i] == 0)
        // countZero++;
        // else if (nums[i] == 1)
        // countOne++;
        // else
        // countTwo++;
        // }
        // System.out.println("zero "+countZero+" one "+countOne+" two "+countTwo);
        // for (int i = 0; i < countZero; nums[i] = 0, i++);
        // for (int i = countZero; i < countOne+countZero; nums[i] = 1, i++);
        // for (int i = countZero+countOne; i < countOne+countZero+countTwo; nums[i] =
        // 2, i++);
        // return nums;

        // Optimal solution Dutch National flag algorithm

        /*
         * [0... low-1] -> 0 extrem left
         * [low... mid-1] -> 1
         * [mid... high] -> unsorted array we have sort it
         * [high+1... n-1] -> 2 extrem right
         * arr[mid]==0 swap(arr[low],arr[mid]),low++,mid++
         * arr[mid]==1 mid++
         * arr[mid]==2 swap(arr[mid],arr[high]),high--;
         */

        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
        return nums;

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int majorityElement(int[] nums) {
        // brute force
        // for(int i=0;i<nums.length;i++){
        // int count=0;
        // for(int j=0;j<nums.length;j++){
        // if(nums[i]==nums[j]){
        // count++;
        // }
        // }
        // if(count>=(nums.length/2)){
        // return nums[i];
        // }
        // }
        // return -1;

        // better
        // Map<Integer, Integer> hash = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        //     int value =hash.getOrDefault(nums[i], 0);
        //     hash.put(nums[i], value+1);
        // }
        // for(Map.Entry<Integer,Integer> it:hash.entrySet()){
        //     if(it.getValue()>(nums.length/2)){
        //         return it.getKey();
        //     }
        // }

        //optimal
        
        
        return -1;
    }

    public static void main(String[] args) {
        // int[] nums = {9,6,4,2,3,5,7,0,1};
        // System.out.println(missingNumbers(nums));
        // int[] nums = { 1, 0, 1, 1, 0, 1 };
        // System.out.println((findMaxConsecutiveOnes(nums)));
        // int[] nums = { 1 };
        // System.out.println(singleNumber(nums));
        // int[] nums = { 10, 5, 2, 7, 1, -10 };
        // // System.out.println(longestSubarray(nums, 15));
        // int[] nums = { 2, 6, 5, 8, 11 };
        // System.out.println(twoSum(nums, 14));
        // int[] nums = { 2, 0, 2, 1, 1, 0 };
        // System.out.println(Arrays.toString(sortColors(nums)));
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums));
    }

}