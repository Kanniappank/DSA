import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ArraysEasy {
    // Easy Questions starts

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
        int sum;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;

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
        // int sum = 0;
        // int maxLength = 0;
        // int i = 0;
        // for (int j = 0; j < nums.length; j++) {
        // sum += nums[j];
        // // subtract the starting index if sum exceed 'K' and i should not cross j
        // while (i <= j && sum > k) {
        // sum -= nums[i];
        // i++;
        // }
        // // if sum and k are equal compute max index
        // if (sum == k) {
        // maxLength = Math.max(maxLength, j - 1 + 1);
        // }
        // }
        // return maxLength;

    }

    // Medium Questions starts
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
        // int value =hash.getOrDefault(nums[i], 0);
        // hash.put(nums[i], value+1);
        // }
        // for(Map.Entry<Integer,Integer> it:hash.entrySet()){
        // if(it.getValue()>(nums.length/2)){
        // return it.getKey();
        // }
        // }

        // optimal

        return -1;
    }

    public static int maxSubArray(int[] nums) {
        // return the sum of the subarray with max length

        // Brute Force
        // int sum;
        // int len = nums.length;
        // int maximum = Integer.MIN_VALUE;
        // for (int i = 0; i < len; i++) {
        // sum = 0;
        // for (int j = i+1; j < len; j++) {
        // sum += nums[j];
        // maximum = Math.max(sum, maximum);
        // }
        // }
        // return maximum;

        /*
         * Optimal Kadane's Algorithm
         * Iterate through out the array add every element to the sum
         * if sum goes less than zero make sum = 0
         * mean while track the max element
         * at the end return the max element
         * thats it kadanes's algorith of returning the sum of the largest sub array
         */

        int sum = 0;
        int maximum = Integer.MIN_VALUE;
        int len = nums.length;
        int start = 0;
        int ansStart = 0;
        int ansEnd = 0;
        for (int i = 0; i < len; i++) {
            if (sum == 0) {
                start = i;
            }
            sum += nums[i];
            if (sum > maximum) {
                maximum = sum;
                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return maximum;
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int mini = prices[0];
        int cost = 0;
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            cost = prices[i] - mini;
            maxProfit = Math.max(maxProfit, cost);
            mini = Math.min(mini, prices[i]);
        }
        return maxProfit;
    }

    public static int[] rearrangeArray(int[] nums) {

        // Brute force
        // ArrayList<Integer> positives = new ArrayList<>();
        // ArrayList<Integer> negatives = new ArrayList<>();
        // int len = nums.length;
        // for (int i = 0; i < len; i++) {
        // if (nums[i] > 0) {
        // positives.add(nums[i]);
        // }
        // else{
        // negatives.add(nums[i]);
        // }
        // }
        // for (int i = 0; i < len / 2; i++) {
        // nums[i * 2] = positives.get(i);
        // nums[i * 2 + 1] = negatives.get(i);
        // }
        // return nums;

        // Optimal
        // ArrayList<Integer> ans = new ArrayList<>();
        // int positiveIndex = 0;
        // int negativeIndex = 1;
        // int len = nums.length;
        // for (int i = 0; i < len; i++) {
        // ans.add(0);
        // }
        // System.out.println("ans"+ans);
        // for (int i = 0; i < len; i++) {
        // if (nums[i] > 0) {
        // ans.set(positiveIndex, nums[i]);
        // positiveIndex += 2;
        // } else {
        // ans.set(negativeIndex, nums[i]);
        // negativeIndex += 2;
        // }
        // }
        // return ans;

        // varient 2 positive numbers and negative number are not equal
        ArrayList<Integer> positives = new ArrayList<>();
        ArrayList<Integer> negatives = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                positives.add(nums[i]);
            } else {
                negatives.add(nums[i]);
            }
        }
        int negaticeLength = negatives.size();
        int postiveLength = positives.size();
        if (positives.size() > negatives.size()) {
            for (int i = 0; i < negaticeLength; i++) {
                nums[2 * i] = positives.get(i);
                nums[2 * i + 1] = negatives.get(i);
            }
            for (int i = negaticeLength; i < len; i++) {
                nums[negaticeLength] = positives.get(negaticeLength);
            }

        } else {
            for (int i = 0; i < postiveLength; i++) {
                nums[2 * i] = positives.get(i);
                nums[2 * i + 1] = negatives.get(i);
            }
            for (int i = postiveLength; i < len; i++) {
                nums[negaticeLength] = negatives.get(postiveLength);
            }

        }
        return nums;

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
        // int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        // System.out.println(majorityElement(nums));
        // int[] nums = { 4 ,3, 1, 5, 6 };
        // System.out.println(maxSubArray(nums));
        // int[] prices = {7,1,5,3,6,4};
        // System.out.println(maxProfit(prices));
        int[] nums = { 3, 1, -2, -5, -2, -4 };
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }

}