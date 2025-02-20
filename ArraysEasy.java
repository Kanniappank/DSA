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

        /*
         * mores voting algorithm
         * two variables el,count
         * iterate through the array for the first occurance of the array increase the
         * count
         * if you encounter the same element increase the count by 1
         * if it is a diffrent element decrease the count
         * if count becomes 0 change the el variable should be changed to the current
         * variable
         * after the iteration introduce new variable count1 iterate through the array
         * again increase the
         * count1 if you encounter the el which you found in the last iteration
         * if count1 is grater than by len/2 el is the majority element
         * i.e el appears more time in the array
         * 
         */

        int el = 0, count = 0, count1 = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (count == 0) {
                el = nums[i];
                count = 1;
            } else if (el == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        for (int i = 0; i < len; i++) {
            if (el == nums[i]) {
                count1++;
            }
        }
        if (count1 > (len / 2)) {
            return el;
        }

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
        int index;
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
            index = negaticeLength * 2;
            for (int i = negaticeLength; i < len; i++) {
                nums[index] = positives.get(i);
                index++;
            }

        } else {
            for (int i = 0; i < postiveLength; i++) {
                nums[2 * i] = positives.get(i);
                nums[2 * i + 1] = negatives.get(i);
            }
            index = postiveLength * 2;
            for (int i = postiveLength; i < len; i++) {
                nums[index] = negatives.get(i);
                index++;
            }
        }
        return nums;

    }

    public static int[] nextPermutation(int[] nums) {
        /*
         * question is we will get a sample array say [3,1,2]
         * possible permutations are
         * 1-[1,2,3]
         * 2-[1,3,2]
         * 3-[2,1,3]
         * 4-[2,3,1]
         * 5-[3,1,2]
         * 6-[3,2,1]
         * in the sorted order respectively
         * the sample array we got is in the in the 5th position
         * we need to return the 6 position as per the sorted order it is the next
         * permutation
         */

        // brute force
        /*
         * generate all the possible arrays
         * linear search
         * retrun the next index
         * if not return the first index of the sorted order
         */

        // Optimal
        /*
         * Step-1 iterate from last to first find the brake point [i]<[i+1]
         * Step-2 initialy set index to -1 after the iteration if index comes to -1
         * reverse the array
         * i.e. the first permutation if the given array is the gratest permutation
         * step-3 else you will get a index i.e. you found the brake point
         * iterate from the last to the index look for the largest than index
         * [i]>[index]
         * swap the largest number and index number
         * step-4 reverse the numbers after index
         * 
         */
        int len = nums.length;
        int index = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            for (int i = len - 1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    swap(nums, i, index);
                    break;
                }
            }
            reverse(nums, index + 1, len - 1);
        }
        return nums;
    }

    public static void reverse(int[] arr, int startingIndex, int endingIndex) {
        for (int i = startingIndex,
                j = endingIndex; i <= (((endingIndex - startingIndex) / 2) + startingIndex); swap(arr, i, j), i++, j--)
            ;
    }

    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        // brute force
        /*
         * brute force can be done using nested for loop
         */
        /*
         * optimal
         * travese the array from the back
         * find the largest element in stages i.e.
         * [10,22,12,3,0,6]
         * in first iteration 6 is leader
         * second 0 will not because 6 is a leader
         * third 3 < 6 so not
         * 12>6 so add 12 to
         * 22>12 so add 22 too
         */
        ArrayList<Integer> leaders = new ArrayList<>();
        int len = arr.length;
        int leader = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] > leader) {
                leaders.add(arr[i]);
            }
            leader = Math.max(leader, arr[i]);
        }
        return leaders;
    }

    static int[] longestConsecutive(int[] nums) {
        Arrays.sort(nums);
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
        // int[] nums = { 3, 1, -2, -5, -2, -4 };
        // System.out.println(Arrays.toString(rearrangeArray(nums)));
        // int[] nums = { 1, 3, 2 };
        // System.out.println(Arrays.toString(nextPermutation(nums)));
        // int[] nums = { 10, 22, 12, 3, 0, 6 };
        // System.out.println(leaders(nums));
        int[] nums={5, 2, 8, 1, 3};
        System.out.println(Arrays.toString(longestConsecutive(nums)));
    }

}
