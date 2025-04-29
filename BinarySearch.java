
import java.util.Arrays;

public class BinarySearch {

    public static int[] findLowerBoundAndUpperBound(int[] nums, int x) {
        int lowerBound = -1;
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        int upperBound = -1;
        Arrays.sort(nums);
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] >= x) {
                lowerBound = nums[mid]; // Potential floor
                low = mid + 1; // Move right to find a larger value
            } else {
                upperBound = nums[mid]; // Potential ceil
                high = mid - 1; // Move left to find a smaller value
            }
        }
        return new int[]{lowerBound, upperBound};
    }

    public static int findLowerBound(int[] nums, int x) {
        int lowerBound = nums.length;
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        Arrays.sort(nums);
        while (low <= high) {
            mid = (low + high) / 2;
            if (x <= nums[mid]) {
                lowerBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lowerBound;
    }

    public static int findUpperBound(int[] nums, int x) {
        int upperBound = nums.length;
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        Arrays.sort(nums);
        while (low <= high) {
            mid = (low + high) / 2;
            if (x < nums[mid]) {
                upperBound = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return upperBound;
    }

    public static int[] findFloorCeil(int[] nums, int x) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        int floor = -1;
        int ceil = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (x >= nums[mid]) {
                floor = nums[mid];
                low = mid + 1;
            } else {
                ceil = nums[mid];
                high = mid - 1;
            }
        }
        return new int[]{floor, ceil};
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        int ans = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target <= nums[mid]) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int[] firstAndLastOccurence(int[] nums, int target) {
        /*
         * Brute force
         * introduce 2 variables first and last initialize with -1
         * iterate through update the first and last occurence if
         * the first variable and last variable are -1
         * return array with the first variable and second variable
         */

 /*
         * Optimal solution
         * use the function already created find lower bound and upper bound
         */
        int lowerBound = findLowerBound(nums, target);
        if (lowerBound != target || lowerBound == nums.length) {
            return new int[]{-1, -1};
        }
        return new int[]{lowerBound, findUpperBound(nums, lowerBound) - 1};

        /*
         * if
         * lower bound and upper bound is not accepted
         */
    }

    public static int firstOccurence(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        int mid = 0;
        int ans = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target <= nums[mid]) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int lastOccurance(int[] nums, int target) {
        int ans = -1;
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target >= nums[mid]) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static int findTargetSortedRotatedArr(int[] nums, int target) {

        /*
         * Optimal approach
         * 
         * Find mid and check if nums[mid] == target.
         * Check if the left half (nums[low] to nums[mid]) is sorted:
         * If target is in this range, search left (high = mid - 1).
         * Otherwise, search right (low = mid + 1).
         * If right half (nums[mid] to nums[high]) is sorted:
         * If target is in this range, search right (low = mid + 1).
         * Otherwise, search left (high = mid - 1).
         * If target is found, return its index; otherwise, return -1.
         */
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
        }
        return -1;
    }

    public static boolean findTargetSortedRotatedArrWithDuplicates(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low += 1;
                high -= 1;
            } else {
                if (nums[low] <= nums[mid]) {
                    if (nums[low] <= target && target <= nums[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }

                } else {
                    if (nums[mid] <= target && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }

                }
            }
        }
        return false;
    }

    public static int[] firstAndLastOccurenceSeperate(int[] nums, int target) {
        int first = firstOccurence(nums, target);
        if (first == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{firstOccurence(nums, target), lastOccurance(nums, target)};
    }

    public static int minimumOfSortedRotatedArr(int[] nums) {
        /*
         * Initialize ans = Integer.MAX_VALUE to track the minimum value.
         * 
         * Binary Search (low <= high):
         * 
         * If left half (nums[low] to nums[mid]) is sorted, update ans with nums[low]
         * and move right (low = mid + 1).
         * 
         * Otherwise, right half is sorted, update ans with nums[mid] and move left
         * (high = mid).
         * 
         * Return ans after the loop.
         * 
         * Time Complexity
         * O(log n) (Binary Search)
         */

        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, nums[mid]);
                high = mid;
            }

        }
        return ans;
    }

    public static int findPeakElement(int[] nums) {
        /*
         * Brute force
         * search through the array linearly
         * add the peak condition if condition matches return the number
         * this works only for single peak
         */
        // int len=nums.length;
        // for(int i=0; i<len;i++){
        // if((i==0 || nums[i-1]< nums[i]) && (i==len-1 ||nums[i]> nums[i+1])){
        // return i;
        // }
        // }
        // return -1;

        /*
         * Brute force
         * Handle Edge Cases:
         * 
         * If the array has only one element, return index 0.
         * 
         * If the first element is greater than the second, return 0.
         * 
         * If the last element is greater than the second last, return len - 1.
         * 
         * Initialize Binary Search:
         * 
         * Set low = 1 and high = len - 2.
         * 
         * Binary Search Loop:
         * 
         * Compute mid = (low + high) / 2.
         * 
         * If nums[mid] is greater than both neighbors, return mid (peak found).
         * 
         * If nums[mid] > nums[mid - 1] and nums[mid] < nums[mid + 1], move low = mid +
         * 1 (search right).
         * 
         * Else, move high = mid - 1 (search left).
         * 
         * Return -1 (should never be reached if a peak exists).
         */
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }
        int high = nums.length - 2;
        int low = 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;

    }
    // public static int noOfRotationsUsingBinarySearch(int[] nums) {

    // }
    public static int singleElementInSortedArray(int[] nums) {
        /*
         * Brute force
         * search linearly and add the conditions
         */
        // if (nums.length == 1) {
        // return nums[0];
        // }
        // for (int i = 0; i < nums.length; i++) {
        // if (i == 0) {
        // if (nums[i] != nums[i + 1]) {
        // return nums[i];
        // }
        // } else if (i == nums[nums.length - 1]) {
        // if (nums[i] != nums[i - 1]) {
        // return nums[i];
        // }
        // } else {
        // if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
        // return nums[i];
        // }
        // }
        // }
        // return -1;

        /*
         * Optimal Solution
         * Handle Edge Cases
         * 
         * If the array has only one element, return it.
         * 
         * If the first or last element is unique, return it immediately.
         * 
         * Binary Search for the Unique Element
         * 
         * If nums[mid] is not equal to nums[mid + 1] or nums[mid - 1], it is the unique
         * element.
         * 
         * Check the pattern of duplicates:
         * 
         * If mid is odd and nums[mid] == nums[mid - 1], or mid is even and nums[mid] ==
         * nums[mid + 1], the unique element is on the right half → move low = mid + 1.
         * 
         * Otherwise, search in the left half → move high = mid - 1.
         */
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[len - 2] != nums[len - 1]) {
            return nums[len - 1];
        }
        int low = 1;
        int high = len - 2;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }
            if (mid % 2 == 1 && nums[mid - 1] == nums[mid] || mid % 2 == 0 && nums[mid] == nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int floorSqurt(int n) {
        int low = 1;
        int high = n;
        int mid = 0;
        int val = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            val = mid * mid;
            if (val <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static int multiply(int times, int number) {
        int result = 1;
        for (int i = 0; i < times; i++) {
            result *= number;
        }
        return result;
    }

    public static int nthRoot(int n, int m) {
        // code here
        int low = 1;
        int high = m;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            int multipluedValue = multiply(n, mid);
            if (multipluedValue == m) {
                return mid;
            } else if (multipluedValue < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int findLargestElementInArray(int[] arr) {
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static int findSmallestElementInArray(int[] arr) {
        int smallest = arr[0];
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (smallest > arr[i]) {
                smallest = arr[i];
            }
        }
        return smallest;
    }

    public static int timeConsumeToEatAPile(int[] pile, int bananasPerHr) {
        int result = 0;
        for (int i = 0; i < pile.length; i++) {
            result += (int) Math.ceil((double) pile[i] / bananasPerHr);
        }
        return result;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findLargestElementInArray(piles);
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            int timeConsumed = timeConsumeToEatAPile(piles, mid);
            if (h < timeConsumed) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int minDaysToMakeBoqute(int[] bloomDay, int m, int k) {
        /*
         * Brute force
         * by checking the each and every item in the arry you do the brute force
         * approach
         */
        // int mini = smallestElementInArray(bloomDay);
        // int maxi = findLargestElementInArray(bloomDay);
        // for (int i = mini; i <= maxi; i++) {
        // if (possible(bloomDay, i, m, k)) {
        // return i;
        // }
        // }
        // return -1;

        /*
         * Optimal approach
         * we know the range do binary serch between the range
         */
        if (bloomDay.length < (m * k)) {
            return -1;
        }
        int low = findSmallestElementInArray(bloomDay);
        int high = findLargestElementInArray(bloomDay);
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean possible(int[] bloomDay, int currentDay, int m, int k) {
        int len = bloomDay.length;
        int count = 0;
        int noOfBouqutes = 0;
        for (int i = 0; i < len; i++) {
            if (bloomDay[i] <= currentDay) {
                count++;
            } else {
                noOfBouqutes += count / k;
                count = 0;
            }
        }
        noOfBouqutes += count / k;
        if (noOfBouqutes >= m) {
            return true;
        } else {
            return false;
        }
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        /*
         * Brute force
         * choose the divisor by iterating from 1 to maxi element
         * add the every element divid by the current divisor
         * if sum <= return the divisor
         */
        // int maxi = findLargestElementInArray(nums);
        // int len = nums.length;
        // for (int d = 1; d <= maxi; d++) {
        //     int sum = 0;
        //     for (int j = 0; j < len; j++) {
        //         sum += Math.ceil((double) nums[j] / d);
        //     }
        //     if (sum <= threshold) {
        //         return d;
        //     }
        // }
        // return -1;
        int low = 1;
        int high = findLargestElementInArray(nums);
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = returnSumByDivisor(nums, mid);
            if (sum <= threshold) {
                //1 2 3 4 5 6 7 8 9
                //low    mid      high 
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int returnSumByDivisor(int[] arr, int divisor) {
        int len = arr.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.ceil((double) arr[i] / divisor);
        }
        return sum;
    }

    public static int summationOfArray(int[] arr) {
        int sum = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int calculateLoadAndDays(int[] weight, int capacity) {
        int days = 1;
        int load = 0;
        int len = weight.length;
        for (int i = 0; i < len; i++) {
            int currentLoad = load + weight[i];
            if (currentLoad > capacity) {
                days += 1;
                load = weight[i];
            } else {
                load += weight[i];
            }
        }
        return days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        /*Brute Force
         * Goal: Find the minimum ship capacity to deliver all packages within a given number of days.

           *  Starts checking from:

            *max(weights) → Minimum possible capacity.

            *sum(weights) → Maximum needed capacity.

            * For each capacity:

            *Uses calculateLoadAndDays to compute how many days it takes to ship.

            * Returns the first capacity that meets the day requirement.

            * Returns -1 if no valid capacity found (edge case).
         */
        // int mini = findLargestElementInArray(weights);
        // int totalWeight = summationOfArray(weights);
        // for (int capacity = mini; capacity <= totalWeight; capacity++) {
        //     int daysRequire = calculateLoadAndDays(weights, capacity);
        //     if (daysRequire <= days) {
        //         return capacity;
        //     }
        // }
        // return -1;

        int low = findLargestElementInArray(weights);
        int high = summationOfArray(weights);
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int currentCalculation = calculateLoadAndDays(weights, mid);
            if (currentCalculation <= days) {
                ans = mid;
                //10 11 12 13 14 15 16 17 18 19 ......   55
                // low                                  high
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int findKthPositive(int[] arr, int k) {
        /*Brute force
         * Iterates through the array arr, incrementing k for each element less than or equal to k. 
         * Stops at the first element greater than k and returns k.
         */
        // int len = arr.length;
        // for (int i = 0; i < len; i++) {
        //     if (arr[i] <= k) {
        //         k++;
        //     } else {
        //         break;
        //     }
        // }
        // return k;
        /*Optimal
         * 
         */
        int len = arr.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (high + 1 + k);
    }

    public static int aggressiveCows(int[] nums, int k) {
        /*Brute force
     * search linearly to get the answer
         */
        // Arrays.sort(nums);
        // int len = nums[nums.length-1]-nums[0];
        // for (int i = 1; i < len; i++) {
        //     if (!canArrangeCows(nums, k, i)) {
        //         return i - 1;
        //     }
        // }
        // return len;

        /*Optimal approach
         * Binary search
         */
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canArrangeCows(nums, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static boolean canArrangeCows(int[] nums, int cows, int distance) {
        int len = nums.length;
        int cowCount = 1;
        int lastCow = nums[0];
        for (int i = 1; i < len; i++) {
            int distanceWithcurrentSpace = (nums[i] - lastCow);
            if (distanceWithcurrentSpace >= distance) {
                cowCount++;
                lastCow = nums[i];
            }
        }
        return cowCount >= cows;

    }

    public static int findPages(int[] nums, int m) {
        int low = findLargestElementInArray(nums);
        int high = summationOfArray(nums);
        while (low <= high) {
            int mid = (low + high) / 2;
            if(isAllocationPossible(nums,mid,m)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }

    public static boolean isAllocationPossible(int[] nums, int pagesRange, int noOfStudents) {
        int len = nums.length;
        int studentsCount = 1;
        int noOfpages = 0;
        for (int i = 0; i < len; i++) {
            int accumulatedPages=noOfpages+nums[i];
            if(accumulatedPages>pagesRange){
                studentsCount++;
                noOfpages+=nums[i];
            }
            else{
                noOfpages+=nums[i];
            }
        }
        return studentsCount<=noOfStudents;
    }

    public static void main(String[] args) {

        // int[] nums = { 3, 4, 4, 7, 8, 10 };
        // System.out.println(Arrays.toString(findFloorCeil(nums, 8)));
        // System.out.println(findLowerBound(nums, 7));
        // System.out.println(Arrays.toString(findLowerBoundAndUpperBound(nums, 7)));
        // System.out.println(searchInsert(nums, 0));
        // int[] nums = { 1, 3, 5, 6 };
        // System.out.println(Arrays.toString(findLowerBoundAndUpperBound(nums, 7)));
        // System.out.println(searchInsert(nums, 0));
        // int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        // System.out.println(findTargetSortedRotatedArr(nums, 0));
        // int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
        // System.out.println(findTargetSortedRotatedArrWithDuplicates(nums, 0));
        // int[] nums = { 1, 1, 2, 2, 2, 2, 3 };
        // System.out.println(Arrays.toString(firstAndLastOccurenceSeperate(nums, 2)));
        // int[] nums = { 39, 6, 11, 14, 18, 36, 37, 38 };
        // System.out.println(noOfRotationsUsingBinarySearch(nums));
        // int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        // System.out.println(singleElementInSortedArray(nums));
        // int[] nums = { 1, 5, 1, 2, 1 };
        // System.out.println(findPeakElement(nums));
        // System.out.println(nthRoot(2, 9));
        // int[] piles = { 805306368,805306368,805306368 };
        // int h = 6;
        // System.out.println(minEatingSpeed(piles, h));
        // int[] bloomDay = { 1, 10, 3, 10, 2 };
        // int m = 2;
        // int k = 3;
        // System.out.println(minDaysToMakeBoqute(bloomDay, m, k));
        // int[] nums = {44,22,33,11,1};
        // int threshold = 5;
        // System.out.println(smallestDivisor(nums, threshold));
        // int[] weights = {1, 2, 3, 1, 1};
        // int days = 4;
        // System.out.println(shipWithinDays(weights, days));
        // int[] arr = {2, 3, 4, 7, 11};
        // int k = 5;
        // System.out.println(findKthPositive(arr, k));
        // int[] nums = {4, 2, 1, 3, 6};
        // System.out.println(aggressiveCows(nums, 2));
    int[] nums={25, 46, 28, 49, 24};
    System.out.println(findPages(nums, 4));
    
    }
}