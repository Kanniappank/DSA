import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        // int sum;
        // int maxLength = 0;
        // for (int i = 0; i < nums.length; i++) {
        // sum = 0;
        // for (int j = i; j < nums.length; j++) {
        // sum += nums[j];
        // if (sum == k) {
        // maxLength = Math.max(maxLength, j - i + 1);
        // }
        // }
        // }
        // return maxLength;

        // better solution optimal for negative zero and positive numbers
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
         * iterate through the array for the first occurance of the el in array set 1 to
         * the
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

    static int longestConsecutiveSequence(int[] numbers) {

        // brute
        /*
         * brute can be done using nested for loops
         */

        // better force
        /*
         * sort the give array
         * have currentcount=0;
         * lastsmallest=min;
         * longest=1;
         * iterate through the sortedarray
         * if lastsmallest = current number-1 increase the currentcount and set the
         * lastsmallest as the current number
         * if lastsamllest !=current number
         * start the current count increment fresh by initializing it by 1 and set last
         * smallest as current number
         * preserve longest
         * time complexity will be n log n
         */
        // Arrays.sort(numbers);
        // int currentcount = 0;
        // int lastSmallest = Integer.MIN_VALUE;
        // int longest = 1;
        // for(int i=0;i<numbers.length;i++){
        // if(lastSmallest==numbers[i]-1){
        // lastSmallest=numbers[i];
        // currentcount++;
        // }
        // else if(lastSmallest!=numbers[i]){
        // lastSmallest=numbers[i];
        // currentcount=1;
        // }
        // longest=Math.max(currentcount,longest);
        // }
        // return longest;

        // Optimal solution
        /*
         * To do this without sorting add all the element to a set
         * iterate through the set
         * while encountering a element check wheather the element-1 is available
         * if it is availabe don't go if it is not available it means
         * it is the start of the conscutive element
         * go for the consicutive elements with while loop
         * check for the consecutive numbers and and increase the count if consecutive
         * numbers available
         * and keep track of the max using longest and current count
         */

        int len = numbers.length;
        Set<Integer> numsSet = new HashSet<Integer>();

        int longest = Integer.MIN_VALUE;
        if (len == 0)
            return 0;
        for (int i = 0; i < len; i++) {
            numsSet.add(numbers[i]);
        }
        for (Integer num : numsSet) {
            if (!numsSet.contains(num - 1)) {
                int curCount = 1;
                int x = num;
                while (numsSet.contains(x + 1)) {
                    x += 1;
                    curCount++;
                }
                longest = Math.max(curCount, longest);
            }
        }
        return longest;
    }

    static void rotate(int[][] matrix) {
        /*
         * Brute force
         * rotaring the matrix by 90 degree
         * [[1 ,2 ,3 ,4 ]
         * [5 ,6 ,7 ,8 ]
         * [9 ,10,11,12]
         * [13,14,15,16]]
         * to
         * [[13,9 ,5 ,1 ]
         * [14,10,6 ,2]
         * [15,11,7 ,3]
         * [16,12,8 ,4]]
         * 
         * [0][0]->[0][3]
         * [0][1]->[1][3]
         * [0][2]->[2][3]
         * [0][3]->[3][3]
         * 
         * [1][0]->[0][2]
         * [1][1]->[1][2]
         * [1][2]->[2][2]
         * [1][3]->[3][2]
         * 
         * [i][j]->[j][n-1-i] we are concluding to this formula
         * please refer
         * https://www.youtube.com/watch?v=Z0R2u6gd3GU&ab_channel=takeUforward
         */

        // int[][] ans = new int[matrix.length][matrix[0].length];
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[i].length; j++) {
        // int formula = matrix.length - 1 - i;
        // ans[j][formula] = matrix[i][j];
        // }
        // }

        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[i].length; j++) {
        // System.out.print("\t" + ans[i][j]);
        // }
        // System.out.println();
        // }

        /*
         * Optimal approach
         * 
         * first transpose the matrix and reverse the each row we
         * can rotate the matrix 90 degrees
         * 
         * [[1 ,2 ,3 ,4 ]
         * [5 ,6 ,7 ,8 ]
         * [9 ,10,11,12]
         * [13,14,15,16]]
         * 
         * transopse
         * 
         * [[1 ,5 ,9 ,13]
         * [2 ,6 ,10,14]
         * [3 ,7 ,11,15]
         * [4 ,8 ,12,16]]
         * 
         * [0][1]->[1][0]
         * [0][2]->[2][0]
         * [0][3]->[3][0]
         * [1][2]->[2][1]
         * [1][3]->[3][1]
         * [2][3]->[3][2]
         * 
         * i->0 (1 to 3)
         * i+1 to n-1
         * 
         * i->1 (2 to 3)
         * i+1 to n-1
         * 
         */

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                swapMatrixElements(matrix, i, j);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix[i], 0, matrix[i].length - 1);
        }

    }

    static void swapMatrixElements(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    static void setColumnsMinus1(int j, int[][] matrix) {
        for (int i = 0; i < matrix[j].length; i++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    static void setRowMinus1(int i, int[][] matrix) {
        for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    static void setMatrixZeros(int[][] matrix) {

        /*
         * Brute force
         * traverse through the matrix and find the placement of the
         * mark the rows and columns as -1
         * 
         * after updating the rows and columns again iterate through the array
         * and update the -1's as 0
         */
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[i].length; j++) {
        // if (matrix[i][j] == 0) {
        // setRowMinus1(i, matrix);
        // setColumnsMinus1(j, matrix);
        // }
        // }
        // }
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[i].length; j++) {
        // System.out.print("\t" + matrix[i][j]);
        // }
        // System.err.println();
        // }
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[i].length; j++) {
        // if (matrix[i][j] == -1) {
        // matrix[i][j] = 0;
        // }
        // }
        // }

        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[i].length; j++) {
        // System.out.print("\t" + matrix[i][j]);
        // }
        // System.err.println();
        // }

        /*
         * Better solution
         * use 2 arrays as size of row of a matrix and column of the matrix
         * mark corresponding row and colum as 1 if you witness a 0 by iterating through
         * the matrix
         * iterate through the matrix again if row number or column number is 0 make the
         * corresponding row and column as zero
         */

        // int[] row = new int[matrix.length];
        // int[] colums = new int[matrix[0].length];

        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[i].length; j++) {
        // if (matrix[i][j] == 0) {
        // row[i] = 1;
        // colums[j] = 1;
        // }
        // }
        // }

        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[i].length; j++) {
        // if (row[i] == 1 || colums[j] == 1) {
        // matrix[i][j] = 0;
        // }
        // }
        // }

        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[i].length; j++) {
        // System.out.print("\t" + matrix[i][j]);
        // }
        // System.err.println();
        // }

        /*
         * Optimal solution
         * the optimal solution is as same as better insted of creating rows array and
         * columns array we are using the first row and first colums as the anoter extra
         * space
         */

        int col0 = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("\t" + matrix[i][j]);
            }
            System.err.println();
        }

    }

    static List<Integer> spiralMatrix(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1, right = matrix[0].length - 1, left = 0;

        List<Integer> spiralList = new ArrayList<Integer>();
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                spiralList.add(matrix[top][i]);

            }
            top++;
            for (int i = top; i <= bottom; i++) {
                spiralList.add(matrix[i][right]);

            }
            right--;
            // if (top <= bottom) {
            for (int i = right; i >= left; i--) {
                spiralList.add(matrix[bottom][i]);
            }
            bottom--;
            // }
            // if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                spiralList.add(matrix[i][left]);
            }
            left++;
            // }
        }
        return spiralList;
    }

    public static int noOfSubarraysWithGivenSum(int[] nums, int k) {
        /*
         * Brute force
         * generate every subarray and check for the sum
         * if the sum is equal to the sum calculated increase the count
         * at the end of the iteration return the count
         * 
         * Time complexity = O(n^2)
         * Space Complexity - O(1) there is no extra spaces
         */

        // int count = 0;
        // int len = nums.length;
        // for (int i = 0; i < len; i++) {
        // int sum = 0;
        // for (int j = i; j < len; j++) {
        // sum += nums[j];
        // if (sum == k) {
        // count++;
        // }
        // }
        // }
        // return count;

        /*
         * optimal solution
         * using prefix sum we are gone find the solution
         * at any point we get k we need to find the s-k in the sub array
         * 
         */

        int preSum = 0;
        int count = 0;
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        hash.put(0, 1);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            System.out.println(hash);
            preSum += nums[i];
            int remove = preSum - k;
            count += hash.getOrDefault(remove, 0);
            hash.put(preSum, hash.getOrDefault(preSum, 0) + 1);
        }
        return count++;
    }

    // hard problems begins

    public static int findNCR(int n, int r) {

        /*
         * brute force
         * pacal triangle
         * 1
         * 1 1
         * 1 2 1
         * 1 3 3 1
         * 1 4 6 4 1
         * 1 5 10 10 5 1
         * 1 6 15 20 15 6 1
         * 1 7 21 35 32 21 7 1
         * this is the pascal triangle
         * there can be asked 3 types of question asked they are
         * 
         * 1, the positions will be given and we have to give the corresponding elements
         * 
         * using the formuls nCr n!/r!(n-r)!
         * say 6C3 = 6*5*4*3*2*1/3*2*1 (3*2*!)
         * common 3! will be cancled
         * 
         * 2, row number will be given and you will be asked to print the entire row
         * this can be achived using the same formula as above mentioned it is the brute
         * force approach
         * 
         * 
         * 
         */
        int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        // System.out.println("Result "+res);
        return res;
    }

    public static void printPascalRow(int row) {

        /*
         * 2, row number will be given and you will be asked to print the entire row
         * this can be achived using the same formula as above mentioned it is the brute
         * force approach
         */

        // brute force
        // for(int i=1;i<=row;i++){
        // System.out.print(findNCR(row-1, i-1)+"\t");
        // }

        /*
         * optimal approach to print the given row number of the pascal triangle
         * iterate from 1 to the number of the row given in the problem
         * first number and the last number of any row will be one(1)
         * first column we need to go with 1
         * second column we need to go with 5/1 i.e 5C1 -> 5*4*3*2*1/1*4*3*2*1 -> 4! and
         * 4! will be cancled we get 5
         * third column we need to go with 5*4/1*2 -> 5C2 -> 5*4*3*2*1/1*2*(3*2*1) -> 3!
         * and 3! will be cancled we get 10
         * fourth column we need to go with 5*4*3/1*2*3 -> 5C3 -> 5*4*3*2*1/3*2*1*(2*1)
         * 2! and 2! will be cancled we get 10
         * fifth column we need to go with 5*4*3*2/1*2*3*4 -> 5C4 -> 5*4*3*2*1/4*3*2*1*
         * 4! and 41 will be cancled we get 5
         * sixth column we need to go with 5*4*3*2*1/1*2*3*4*1 -> 5C5
         * 5*4*3*2*1/1*2*3*4*1 5! and 5! will be cancled we get 1
         * 
         * in each itration 4/2 3/3 4/2 has been kept on multipiled we come to the
         * formula
         * ans=1;
         * ans=ans*(n-i)
         * ans=ans/i
         */

        // int ans = 1;
        // System.out.print(ans+"\t");
        // for(int i=1;i<row;i++){
        // ans = ans*(row-i);
        // ans = ans/(i);
        // System.out.print(ans+"\t");
        // }

        /* se need to print the complete pascal triangle */
        /*
         * brute force
         * we go for a nested loop and call findNCR function
         * time complexity will be O(nxnxr) ~ O(n^3)
         */

        // for(int i=1;i<row;i++){
        // for(int j=1;j<=i;j++){
        // System.out.print(findNCR(i-1, j-1)+"\t");
        // }
        // System.out.println();
        // }

        /*
         * optimal approach for printing the
         * we are gone uh use the above better approach to get the optimal approach of
         * printing the each rows
         */

        for (int i = 1; i < row; i++) {
            int ans = 1;
            System.out.print(ans + "\t");
            for (int j = 1; j < i; j++) {
                ans = ans * (i - j);
                ans = ans / j;
                System.out.print(ans + "\t");
            }
            System.out.println();
        }

    }

    // if pascal triangle need to be returned as a list of lists
    public static List<Integer> generatePascalRow(int rowNum) {
        List<Integer> ansRow = new ArrayList<Integer>();
        int ans = 1;
        ansRow.add(ans);
        for (int row = 1; row < rowNum; row++) {
            ans = ans * (rowNum - row);
            ans = ans / row;
            ansRow.add(ans);
        }
        return ansRow;
    }

    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>>();
        for (int i = 1; i <= numRows; i++) {
            pascalTriangle.add(generatePascalRow(i));
        }
        return pascalTriangle;
    }

    public static List<Integer> majorityElementNby3(int[] nums) {

        /*
         * Brute force
         * Use a nested array and count the occurance of the each element
         */
        // List<Integer> ans = new ArrayList<Integer>();
        // for (int i = 0; i < nums.length; i++) {
        // int count = 0;
        // /*
        // * if size of the array size is 8 we can only have
        // * max of 2 elements repeating grated than n/3 time minimum of 0 repeating
        // * elements
        // * if length is 8 8/3=2.something so floor value is 2 morethan n/3 in the
        // sense
        // * the value should be repeate 3 times so 3+3+3=9 it applies for every size
        // */
        // if (ans.size() == 0 || ans.get(0) != nums[i]) {
        // for (int j = 0; j < nums.length; j++) {
        // if (nums[j] == nums[i]) {
        // count++;
        // }
        // }
        // if (count > (nums.length / 3)) {
        // ans.add(nums[i]);
        // }
        // }
        // if (ans.size() == 2)
        // break;
        // }
        // return ans;
        // List<Integer> ans = new ArrayList<Integer>();
        // int targetCount = nums.length/3;
        // Map<Integer,Integer> refMap = new HashMap<Integer,Integer>();
        // for(int i=0;i<nums.length;i++){
        // int value = refMap.getOrDefault(nums[i], 0);
        // if(value==targetCount){
        // ans.add(nums[i]);
        // }
        // refMap.put(nums[i], value+1);
        // }
        // return ans;

        /*
         * optimal apporach
         * we are gone apply the same logic for this problem as we applied to majority
         * element of n/2
         * but this time we are using 2 el and 2 count vaiable but there is a slight
         * change
         * we need to modify the if condition to check wheather the number we are
         * iterating
         * should not be equal to element1 or element2 in the current iteration
         * it will cause an error
         */

        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE, count1 = 0, count2 = 0;
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && nums[i] != el2) {
                el1 = nums[i];
                count1 = 1;
            } else if (count2 == 0 && nums[i] != el1) {
                el2 = nums[i];
                count2 = 1;
            } else if (el1 == nums[i]) {
                count1++;
            } else if (el2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        int target = nums.length / 3;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el1)
                count1++;
            if (nums[i] == el2)
                count2++;
        }
        if (count1 > target)
            ans.add(el1);
        if (count2 > target)
            ans.add(el2);

        return ans;

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        /*
         * brute force
         * iterate through the array using the nested of 3 loops with indexes i,j,k find
         * wheather the sum is 0 or not
         * if it is zero add it to a temprory list and sort them push it to a set
         * end of the day add all the list in the set to the ans list return the answer
         * list
         * 
         * Time complexity -> O(n^3)
         * Space complexity -> O(no. of triplets)
         */

        // Set<List<Integer>> uniqeSet = new HashSet<List<Integer>>();
        // for (int i = 0; i < nums.length; i++) {
        // for (int j = i + 1; j < nums.length; j++) {
        // for (int k = j + 1; k < nums.length; k++) {
        // if (nums[i] + nums[j] + nums[k] == 0) {
        // List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]);
        // temp.sort(null);
        // uniqeSet.add(temp);
        // }
        // }
        // }
        // }
        // List<List<Integer>> ans = new ArrayList<>(uniqeSet);
        // return ans;

        /*
         * Better approach we are reducing the kth loop here by deriving a formula
         * nums[i]+nums[j]+nums[k]=0
         * nums[k]=-(nums[i]+nums[j])
         * with the help of hasing we are going to find the nums[k]
         * we should ensure we are not the duplicating the numbers in the triplet
         * we can confirm this by hashing only between the current i and j th indexes
         * as we seen above store the triplets in the set for uinqeness
         * 
         * Time complexity -> O(N^2) log M
         * Space complexity -> O(N)+O(No.oftuples)
         * 
         */
        // int len = nums.length;
        // Set<List<Integer>> uniquSet = new HashSet<>();
        // for (int i = 0; i < len; i++) {
        // Set<Integer> hashSet = new HashSet<>();
        // for (int j = i + 1; j < len; j++) {
        // int thirdItem = -(nums[i] + nums[j]);
        // if (hashSet.contains(thirdItem)) {
        // List<Integer> temp = Arrays.asList(nums[i], nums[j], thirdItem);
        // temp.sort(null);
        // uniquSet.add(temp);
        // }
        // hashSet.add(nums[j]);

        // }
        // }
        // return new ArrayList<>(uniquSet);

        /*
         * optimal solution
         * we are using a 2-pointer to solve this in the optimal way
         * firstly sort the given array
         * i at the first element k at the last element
         * j is at i+1 add the 3 elements
         * if sum = 0 form a triplet
         * if sum is grater reduce k
         * if sum is lesser than 0 increase j
         */

        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }

        }
        return ans;
    }

    public static List<List<Integer>> fourSum(int[] nums) {

        /*
         * Brute force
         * created nested loop and check the wheather the addition get to the target
         * i.e 0 if it goes to 0 add every thing to the
         * array and add them to the final array
         */
        // int len = nums.length;
        // int sum = 0;
        // Set<List<Integer>> uniqueSet = new HashSet<List<Integer>>();

        // for (int i = 0; i < len; i++) {
        // for (int j = i + 1; j < len; j++) {
        // for (int k = j + 1; k < len; k++) {
        // for (int l = k + 1; l < len; l++) {
        // sum = nums[l] + nums[k];
        // sum += nums[j];
        // sum += nums[i];
        // if (sum == 0) {
        // List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
        // uniqueSet.add(temp);
        // }
        // }
        // }
        // }
        // }
        // List<List<Integer>> ans = new ArrayList<>(uniqueSet);
        // return ans;

        /*
         * Better approach we are reducing the kth loop here by deriving a formula
         * nums[i]+nums[j]+nums[k]+nums[l]=0
         * nums[l]=-(nums[i]+nums[j]+nums[k])
         * with the help of hasing we are going to find the nums[l]
         * we should ensure we are not the duplicating the numbers in the triplet
         * we can confirm this by hashing only between the current j and k th indexes
         * as we seen above store the triplets in the set for uinqeness
         * 
         * Time complexity -> O(N^2) log M
         * Space complexity -> O(N)+O(No.4pairs)
         * 
         */

        // int len = nums.length;
        // Set<List<Integer>> uniqueSet = new HashSet<List<Integer>>();
        // for(int i=0;i<len;i++){
        // for(int j=i+1;j<len;j++){
        // Set<Integer> hashSet = new HashSet<>();
        // for(int k = j+1;k<len;k++){
        // int fourthEle = -(nums[i]+nums[j]+nums[k]);
        // if(hashSet.contains(fourthEle)){
        // List<Integer> temp = new
        // ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],fourthEle));
        // temp.sort(null);
        // uniqueSet.add(temp);
        // }
        // hashSet.add(nums[k]);
        // }
        // }
        // }
        // List<List<Integer>> ans = new ArrayList<>(uniqueSet);
        // return ans;

        /*
         * Optimal approach
         * using 2 pointer
         * sort the array first
         * fix i and j l will be the last element of the array
         * k wil be the next element of j
         * while added it should give target
         * if less than the target increase k value
         * if grater than the target decrease the l value
         */

        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < len; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = len - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum > 0) {
                        l--;
                    } else if (sum < 0) {
                        k++;
                    } else {
                        List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        ans.add(temp);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static int longestSubarrayOfSumZero(int[] nums) {

        /*
         * brute force
         * genetating the all the sub arrays with the nested for loops and finding the
         * largest sub array
         * 
         */

        /*
         * optimal solution
         * we are having a arr
         * say from 0 index m we are getting a sum as some number say for example 3
         * and form 0 index to k index we are getting the sum as same 3 so form
         * index m to n the summation will be 0 in this way we find the longest subarray
         * with sum zero
         * iterate throught the array add the elements in the array to sum variable
         * if sum == 0 add 1 with the current index that is maxi
         * if not 0 check wheather the has map consist of the sum already
         * if it is available get the pair it has the index subtract the current index
         * index in the pair compare with the maxi variable and store the maximum
         * variable
         * if the the hash map does nt have the value add the value and the index to the
         * map
         */
        int maxi = 0, sum = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                maxi = i + 1;
            } else {
                if (hash.containsKey(sum)) {
                    int value = hash.get(sum);
                    maxi = Math.max(maxi, i - value);
                } else {
                    hash.put(sum, i);
                }
            }
        }
        return maxi;
    }

    public static void mergeSortedArrays(int[] firstarr, int[] secondArr) {
        /*
         * Brute force
         * we are using a third array for this solution
         * have 2 pointers first in first array and second in second array
         * initialize the pointers as 0
         * compare the current pointers in both the arrays
         * and add it to the third array using a index variable
         * 
         */
        // int n = firstarr.length;
        // int m = secondArr.length;
        // int[] thirdArr = new int[n + m];
        // int i = 0;
        // int j = 0;
        // int index = 0;
        // while (i < n && j < m) {
        // if (firstarr[i] <= secondArr[j]) {
        // thirdArr[index] = firstarr[i];
        // i++;
        // } else {
        // thirdArr[index] = secondArr[j];
        // j++;
        // }
        // index++;
        // }
        // while (i < n) {
        // thirdArr[index] = firstarr[i];
        // i++;
        // index++;
        // }
        // while (j < m) {
        // thirdArr[index] = secondArr[j];
        // j++;
        // index++;
        // }
        // for (int k = 0; k < n + m; k++) {
        // if (k < n)
        // firstarr[k] = thirdArr[k];
        // else
        // secondArr[k - n] = thirdArr[k];
        // }
        // return thirdArr;

        /*
         * first optimal solution
         * have 2 pointers in each arrays i and j compare ith index and jth index
         * if ith index is grater than jth index ith index element belongs to jth index
         * array
         * if jth index is lesser than ith index jth index element belongs to ith index
         * array
         * swap the corresponding elements to their respective arrays and sort them
         */
        int n = firstarr.length;
        int m = secondArr.length;
        int i = n - 1;
        int j = 0;

        while (i >= 0 && j < m) {
            if (firstarr[i] > secondArr[j]) {
                int temp = firstarr[i];
                firstarr[i] = secondArr[j];
                secondArr[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }
        Arrays.sort(firstarr);
        Arrays.sort(secondArr);
        System.out.println(Arrays.toString(firstarr));
        System.out.println(Arrays.toString(secondArr));

    }

    public static List<List<Integer>> mergeIntevals(int[][] intervals) {

        // List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // Arrays.sort(intervals,new Comparator<int[]>() {
        // public int compare(int[] a,int[] b){
        // return a[0]-b[0];
        // }
        // });
        // for(int i=0;i<intervals.length;i++){
        // System.out.print(Arrays.toString(intervals[i]));
        // }
        // System.out.println("after processing");
        // for(int i=0;i<intervals.length;i++){
        // int start=intervals[i][0];
        // int end = intervals[i][1];
        // if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
        // continue;
        // }
        // for(int j=i+1;i<intervals.length;j++){
        // if(intervals[j][0]<=end){
        // end=Math.max(end,intervals[j][1]);
        // }
        // else{
        // break;
        // }
        // }
        // ans.add(Arrays.asList(start,end));
        // }

        // for(int i=0;i<intervals.length;i++){
        // System.out.print(Arrays.toString(intervals[i]));
        // }

        // // return new int[][] {{0,0},{0,0}};

        /*
         * Optimal approach
         * iterate through the array if the second item of the interval is grater than
         * the
         * next intervals first item expand the interval
         * if the second item is lesser than first item of the next intrval
         * it is the new interval
         */

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int len = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        System.out.println("after sorting");
        // for(int i=0;i<intervals.length;i++){
        // System.out.print(Arrays.toString(intervals[i]));
        // }

        for (int i = 0; i < len; i++) {
            if (ans.isEmpty() || ans.get(ans.size() - 1).get(1) < intervals[i][0]) {
                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            } else {
                int size = ans.size();
                ans.get(size - 1).set(1, Math.max(intervals[i][1], ans.get(size - 1).get(1)));
            }
        }

        return ans;

    }

    public static ArrayList<Long> findTwoElement(int arr[]) {
        /*
         * Brute force
         * Initialize variables: len, ans (ArrayList), missing = -1, repeating = -2.
         * Loop through numbers from 1 to N:
         * Count occurrences using a nested loop.
         * If count == 2, set repeating = i.
         * If count == 0, set missing = i.
         * Break early if both numbers are found.
         * Add missing and repeating to ans and return.
         * 
         */
        // int len = arr.length;
        ArrayList<Long> ans = new ArrayList<Long>();
        // int missing = -1;
        // int repeating = -1;
        // for (int i = 1; i <= len; i++) {
        // int count = 0;
        // for (int j = 0; j < len; j++) {
        // if (i == arr[j]) {
        // count++;
        // }
        // }
        // if (count == 2)
        // repeating = i;
        // else if (count == 0)
        // missing = i;
        // if (missing != -1 && repeating != -1) {
        // break;
        // }

        // }
        // ans.add(missing);
        // ans.add(repeating);
        // return ans;

        /*
         * better approach
         * Initialize variables: missing = -1, repeating = -1, len = arr.length.
         * Create and initialize a hash array of size len + 1 to store element
         * frequencies.
         * First loop:
         * Count occurrences of each number in arr using hash[arr[i]]++.
         * Second loop (1 to N):
         * If hash[i] == 2, set repeating = i.
         * If hash[i] == 0, set missing = i.
         * Break early if both numbers are found.
         * Store repeating and missing in ans and return it.
         * Efficiency:
         * ✅ Time Complexity: O(N)
         * ✅ Space Complexity: O(N) (due to extra hash array)
         */

        // int missing = -1;
        // int repeating = -1;
        // int len = arr.length;
        // var hash = new int[len + 1];
        // Arrays.fill(hash, 0);
        // for (int i = 0; i < len; i++) {
        // hash[arr[i]]++;
        // }
        // for (int i = 1; i <= len; i++) {
        // if (hash[i] == 2) {
        // repeating = i;
        // } else if (hash[i] == 0) {
        // missing = i;
        // }
        // if (missing != -1 && repeating != -1) {
        // break;
        // }
        // }
        // ans.add(repeating);
        // ans.add(missing);
        // return ans;

        /*
         * Optimal approach
         * Calculate expected sum (Sn) and sum of squares (S2n) for numbers 1 to N:
         * 
         * Sn = (N * (N + 1)) / 2 → Sum of first N natural numbers.
         * S2n = (N * (N + 1) * (2N + 1)) / 6 → Sum of squares of first N natural
         * numbers (Incorrect in your code).
         * Compute actual sum (S) and sum of squares (S2) from the given arr:
         * 
         * S = sum of all elements in arr
         * S2 = sum of squares of all elements in arr
         * Find the differences:
         * 
         * val1 = S - Sn → Difference between actual sum and expected sum → (Repeating -
         * Missing)
         * val2 = S2 - S2n → Difference between actual sum of squares and expected sum
         * of squares → (Repeating² - Missing²)
         * Solve for x (repeating number) and y (missing number):
         * 
         * val2 = val2 / val1 → Computes (Repeating + Missing)
         * x = (val1 + val2) / 2 → Repeating number
         * y = x - val1 → Missing number
         * Store the results in ans and return.
         * 
         * Time & Space Complexity:
         * ✅ O(N) Time Complexity (Single pass through arr).
         * ✅ O(1) Space Complexity (Only a few extra variables).
         */

        long n = arr.length;
        long Sn = (n * (n + 1)) / 2;
        long S2n = (n * (n + 1) * (2 * (n + 1))) / 2;
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += arr[i];
            S2 += arr[i] * arr[i];
        }
        long val1 = S - Sn;
        long val2 = S2 - S2n;
        val2 = val2 / val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;
        ans.add(x);
        ans.add(y);
        return ans;

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
        // int[] nums = { 100, 102, 100, 101, 101, 4, 3, 2, 3, 2, 1, 1, 1, 2 };
        // System.out.println(longestConsecutiveSequence(nums));
        // int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13,
        // 14, 15, 16 } };
        // rotate(matrix);
        // int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        // setMatrixZeros(matrix);
        // int[][] matrix = { { 1, 2, 3, 4 } };
        // System.out.println(spiralMatrix(matrix));
        // findNCR(4,2);
        // printPascalRow(7);
        // int[] nums = { 1, 1, 1, 2, 2, 3, 3, 3 };
        // System.out.println(majorityElementNby3(nums));
        // int nums[] = { -1, 0, 1, 2, -1, -4 };
        // System.out.println(threeSum(nums));
        // int[] nums = { 1, -1, 3, 2, -2, -8, 1, 7, 10, 23 };
        // System.out.println(longestSubarrayOfSumZero(nums));
        // int[] nums = { 1, 2, 3 };
        // System.out.println(noOfSubarraysWithGivenSum(nums, 3));
        // int[] firstArr = { 1, 3, 5, 7 };
        // int[] secondArr = { 0, 2, 4, 6, 8 };
        // mergeSortedArrays(firstArr, secondArr);
        // int[][] intervals = { { 15, 18 }, { 1, 3 }, { 2, 6 }, { 8, 10 }, };
        // mergeIntevals(intervals);
        // int[] nums = { 4, 3, 6, 2, 1, 1 };
        // System.out.println(findTwoElement(nums));
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        System.out.println(fourSum(nums));
    }
}
