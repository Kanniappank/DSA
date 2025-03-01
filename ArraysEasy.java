import java.util.ArrayList;
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

    // public int subarraySum(int[] nums, int k) {
        
    // } 

    // hard problems begins


    public static int findNCR(int n,int r){

        /*
         * brute force
         * pacal triangle
         *          1
         *         1  1
         *        1  2  1
         *       1  3  3  1
         *      1  4  6  4  1
         *     1  5 10 10  5  1
         *    1  6 15 20 15  6  1
         *   1  7  21 35 32 21  7  1
         * this is the pascal triangle 
         * there can be asked 3 types of question asked they are
         * 
         * 1, the positions will be given and we have to give the corresponding elements
         * 
         * using the formuls nCr n!/r!(n-r)!
         * say 6C3 = 6*5*4*3*2*1/3*2*1 (3*2*!)
         * common 3! will be cancled 
         * 
         *2, row number will be given and you will be asked to print the entire row
         *  this can be achived using the same formula as above mentioned it is the brute force approach
         * 
         * 
         * 
         */  
        int res=1;
        for(int i=0;i<r;i++){
            res=res*(n-i);
            res=res/(i+1);
        }
        // System.out.println("Result "+res);
        return res;
    }

    public static void printPascalRow(int row){

       /*2, row number will be given and you will be asked to print the entire row
         *  this can be achived using the same formula as above mentioned it is the brute force approach
         */
         
        // brute force
        // for(int i=1;i<=row;i++){
        //     System.out.print(findNCR(row-1, i-1)+"\t");
        // }

        /*
         * optimal approach to print the given row number of the pascal triangle
         * iterate from 1 to the number of the row given in the problem
         * first number and the last number of any row will be one(1)
         * first column we need to go with 1
         * second column we need to go with 5/1 i.e 5C1 -> 5*4*3*2*1/1*4*3*2*1 -> 4! and 4! will be cancled we get 5
         * third column we need to go with  5*4/1*2 -> 5C2 -> 5*4*3*2*1/1*2*(3*2*1) -> 3! and 3! will be cancled we get 10 
         * fourth column we need to go with 5*4*3/1*2*3 -> 5C3 -> 5*4*3*2*1/3*2*1*(2*1) 2! and 2! will be cancled we get 10
         * fifth column we need to go with 5*4*3*2/1*2*3*4 -> 5C4 -> 5*4*3*2*1/4*3*2*1* 4! and 41 will be cancled we get 5
         * sixth column we need to go with 5*4*3*2*1/1*2*3*4*1 -> 5C5 5*4*3*2*1/1*2*3*4*1 5! and 5! will be cancled we get 1
         * 
         * in each itration 4/2 3/3 4/2 has been kept on multipiled we come to the formula
         * ans=1;
         * ans=ans*(n-i)
         * ans=ans/i
         */

        // int ans = 1;
        // System.out.print(ans+"\t");
        // for(int i=1;i<row;i++){
        //     ans = ans*(row-i);
        //     ans = ans/(i);
        //     System.out.print(ans+"\t");
        // }

        /*  se need to print the complete pascal triangle*/
        /*
         * brute force
         * we go for a nested loop and call findNCR function
         * time complexity will be O(nxnxr) ~ O(n^3)
         */

        // for(int i=1;i<row;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print(findNCR(i-1, j-1)+"\t");
        //     }
        //     System.out.println();
        // }      
        
        /*
         * optimal approach for printing the 
         * we are gone uh use the above better approach to get the optimal approach of printing the each rows
         */

         for(int i=1;i<row;i++){
            int ans=1;
            System.out.print(ans+"\t");
            for(int j=1;j<i;j++){
                ans=ans*(i-j);
                ans=ans/j;
                System.out.print(ans+"\t");
            }
            System.out.println();
         }

        
    }
    // if pascal triangle need to be returned as a list of lists
    public static List<Integer> generatePascalRow(int rowNum){
        List<Integer> ansRow = new ArrayList<Integer>();
        int ans = 1;
        ansRow.add(ans);
        for(int row=1;row<rowNum;row++){
            ans = ans*(rowNum-row);
            ans=ans/row;
            ansRow.add(ans);
        }
        return ansRow;
    }

    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList();
        for(int i=1;i<=numRows;i++){
            pascalTriangle.add(generatePascalRow(i));
        }
        return pascalTriangle;
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
        printPascalRow(7);
    }
}
