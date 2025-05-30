
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
        return new int[] { lowerBound, upperBound };
    }

    public static int findLowerBound(int[] nums, int x) {   //smallest index grater than or equal to x arr[mid]>=x
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

    public static int findUpperBound(int[] nums, int x) { //smallest inded grater than x arr[mid]>x
        int upperBound = nums.length;
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        Arrays.sort(nums);
        while (low <= high) {
            mid = (low + high) / 2;
            if (x < nums[mid]) {
                upperBound = mid;
                high=mid-1;
            } else {
                low=mid+1;
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
        return new int[] { floor, ceil };
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
            return new int[] { -1, -1 };
        }
        return new int[] { lowerBound, findUpperBound(nums, lowerBound) - 1 };

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
            return new int[] { -1, -1 };
        }
        return new int[] { firstOccurence(nums, target), lastOccurance(nums, target) };
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
        // int sum = 0;
        // for (int j = 0; j < len; j++) {
        // sum += Math.ceil((double) nums[j] / d);
        // }
        // if (sum <= threshold) {
        // return d;
        // }
        // }
        // return -1;
        int low = 1;
        int high = findLargestElementInArray(nums);
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = returnSumByDivisor(nums, mid);
            if (sum <= threshold) {
                // 1 2 3 4 5 6 7 8 9
                // low mid high
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
        /*
         * Brute Force
         * Goal: Find the minimum ship capacity to deliver all packages within a given
         * number of days.
         * 
         * Starts checking from:
         * 
         * max(weights) → Minimum possible capacity.
         * 
         * sum(weights) → Maximum needed capacity.
         * 
         * For each capacity:
         * 
         * Uses calculateLoadAndDays to compute how many days it takes to ship.
         * 
         * Returns the first capacity that meets the day requirement.
         * 
         * Returns -1 if no valid capacity found (edge case).
         */
        // int mini = findLargestElementInArray(weights);
        // int totalWeight = summationOfArray(weights);
        // for (int capacity = mini; capacity <= totalWeight; capacity++) {
        // int daysRequire = calculateLoadAndDays(weights, capacity);
        // if (daysRequire <= days) {
        // return capacity;
        // }
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
                // 10 11 12 13 14 15 16 17 18 19 ...... 55
                // low high
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int findKthPositive(int[] arr, int k) {
        /*
         * Brute force
         * Iterates through the array arr, incrementing k for each element less than or
         * equal to k.
         * Stops at the first element greater than k and returns k.
         */
        // int len = arr.length;
        // for (int i = 0; i < len; i++) {
        // if (arr[i] <= k) {
        // k++;
        // } else {
        // break;
        // }
        // }
        // return k;
        /*
         * Optimal
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
        /*
         * Brute force
         * search linearly to get the answer
         */
        // Arrays.sort(nums);
        // int len = nums[nums.length-1]-nums[0];
        // for (int i = 1; i < len; i++) {
        // if (!canArrangeCows(nums, k, i)) {
        // return i - 1;
        // }
        // }
        // return len;

        /*
         * Optimal approach
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
            if (isAllocationPossible(nums, mid, m)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean isAllocationPossible(int[] nums, int pagesRange, int noOfStudents) {
        int len = nums.length;
        int studentsCount = 1;
        int noOfpages = 0;
        for (int i = 0; i < len; i++) {
            int accumulatedPages = noOfpages + nums[i];
            if (accumulatedPages > pagesRange) {
                studentsCount++;
                noOfpages += nums[i];
            } else {
                noOfpages += nums[i];
            }
        }
        return studentsCount <= noOfStudents;
    }

    public static boolean withintheSplitRange(int[] arr, int currentNum, int k) {
        int sum = 0;
        int currentSplit = 1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > currentNum) {
                currentSplit++;
                sum = arr[i];
            }
        }
        return currentSplit <= k;
    }

    public static int largestSubarraySumMinimized(int[] a, int k) {
        int low = findLargestElementInArray(a);
        int high = summationOfArray(a);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (withintheSplitRange(a, mid, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
         * Brute force
         * merge 2 sorted arrays using 2 pointers
         * then find the median of the merged array
         * if the merged array size is even, return the average of the two middle
         * elements
         * if odd, return the middle element
         * Time complexity: O(n+m) where n and m are the lengths of the two arrays
         * Space complexity: O(n+m) for the merged array
         */
        // int i=0, j=0;
        // int len1=nums1.length;
        // int len2=nums2.length;
        // List<Integer> mergedList = new ArrayList<>();

        // while(i<len1 && j<len2){
        // if(nums1[i]<nums2[j]){
        // mergedList.add(nums1[i++]);
        // }
        // else{
        // mergedList.add(nums2[j++]);
        // }
        // }
        // while(i<len1){
        // mergedList.add(nums1[i++]);
        // }
        // while(j<len2){
        // mergedList.add(nums2[j++]);
        // }
        // if(mergedList.size()%2==0){
        // return
        // (double)(mergedList.get(mergedList.size()/2)+mergedList.get((mergedList.size()/2)-1))/2;
        // }
        // else{
        // return mergedList.get(mergedList.size()/2);
        // }
        /*
         * Better approach
         * insted of using the 3rd array we can use the 2 pointer approach to find the
         * median
         */
        // int len1 = nums1.length;
        // int len2 = nums2.length;
        // int i = 0, j = 0;
        // int totalLen = len1 + len2;
        // int index2 = totalLen / 2;
        // int index1 = index2 - 1;
        // int element1 = -1, element2 = -1;
        // int count = 0;
        // while (i < len1 && j < len2) {
        // if (nums1[i] < nums2[j]) {
        // if (count == index1) {
        // element1 = nums1[i];
        // }
        // if (count == index2) {
        // element2 = nums1[i];
        // }
        // count++;
        // i++;
        // } else {
        // if (count == index1) {
        // element1 = nums2[j];
        // }
        // if (count == index2) {
        // element2 = nums2[j];
        // }
        // count++;
        // j++;
        // }
        // }
        // while (i < len1) {
        // if (count == index1) {
        // element1 = nums1[i];
        // }
        // if (count == index2) {
        // element2 = nums1[i];
        // }
        // count++;
        // i++;
        // }
        // while (j < len2) {
        // if (count == index1) {
        // element1 = nums2[j];
        // }
        // if (count == index2) {
        // element2 = nums2[j];
        // }
        // count++;
        // j++;
        // }
        // if (totalLen % 2 == 0) {
        // return (double) (((double) element1 + (double) element2) / 2);
        // }
        // return (double) (element2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len2 < len1) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int totalLen = len1 + len2;
        int left = (len1 + len2 + 1) / 2;
        int low = 0;
        int high = len1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if (mid1 - 1 >= 0) {
                l1 = nums1[mid1 - 1];
            }
            if (mid2 - 1 >= 0) {
                l2 = nums2[mid2 - 1];
            }
            if (mid1 < len1) {
                r1 = nums1[mid1];
            }
            if (mid2 < len2) {
                r2 = nums2[mid2];
            }
            if (l1 <= r2 && l2 <= r2) {
                if (totalLen % 2 == 0) {
                    return (((double) Math.max(l1, l2)) + ((double) Math.min(r1, r2))) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }

        }
        return 0;
    }

    public static int kthElement(int[] a, int[] b, int k) {
        int len1 = a.length;
        int len2 = b.length;
        if (len2 < len1) {
            return kthElement(b, a, k);
        }
        int left = k;
        int low = Math.max(0, k - len2);
        int high = Math.min(k, len1);
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if (mid1 - 1 >= 0) {
                l1 = a[mid1 - 1];
            }

            if (mid2 - 1 >= 0) {
                l2 = b[mid2 - 1];
            }

            if (mid1 < len1) {
                r1 = a[mid1];
            }

            if (mid2 < len2) {
                r2 = b[mid2];
            }

            if (l2 <= r1 && l1 <= r2) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }

    // Binary search on a 2D array

    public static int rowWithMax1s(int[][] mat) {
        /*
         * Brute force go through all the rows using a
         * nested for loop and count ones
         */
        int len = mat.length;
        int index = -1;
        int maxCount = -1;
        for (int i = 0; i < len; i++) {
            int len2 = mat[i].length;
            int rowCount = 0;

            // brute force
            // for (int j = 0; j < len2; j++) {
            // if (mat[i][j] == 1) {
            // rowCount++;
            // }
            // }

            // optimal approach binary search
            rowCount = len2 - findLowerBound(mat[i], 1);
            if (rowCount > maxCount) {
                maxCount = rowCount;
                index = i;
            }
        }
        return index;
    }

    public static boolean BinarySearch(int[] arr, int target) {
        int len = arr.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == arr[mid]) {
                return true;
            } else if (target <= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        /*
         * Brute force is travese through every element in the array
         * and find the element or return false;
         */

        /*
         * better solution
         * check the starting and ending index in the each row
         * if the target is in between the starting and ending item of the array
         * do a binary serach to find the target value if value available return true
         * else false
         */

        // int len = matrix.length;
        // for (int i = 0; i < len; i++) {
        // int len2 = matrix[i].length;
        // if (matrix[i][0] <= target && target <= matrix[i][len2 - 1]) {
        // return BinarySearch(matrix[i], target);
        // }
        // }
        // return true;

        /*
         * optimal solution
         * form a imaginary 1D array and do a binary search on it
         * the 1D array is formed by taking the first element of each row and the last
         */
        int low = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int high = rows * columns - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int currentRow = mid / columns;
            int currentColumn = mid % columns;
            if (matrix[currentRow][currentColumn] == target) {
                return true;
            } else if (matrix[currentRow][currentColumn] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static boolean searchTargetInMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        int len2 = matrix[0].length;
        int row = 0;
        int col = len2 - 1;
        while (row < len && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static int findMaxIndex(int[][] matrix, int col) {
        int maxValue = -1;
        int index = -1;
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            if (maxValue < matrix[i][col]) {
                maxValue = matrix[i][col];
                index = i;
            }
        }
        return index;
    }

    public static int[] findPeakElementInMatrix(int[][] arr) {
        int len = arr.length;
        int len2 = arr[0].length;
        int low = 0;
        int high = len2 - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int maxRowIndex = findMaxIndex(arr, mid);
            int left = mid - 1 >= 0 ? arr[maxRowIndex][mid - 1] : -1;
            int right = mid + 1 < len2 ? arr[maxRowIndex][mid + 1] : -1;
            if (arr[maxRowIndex][mid] > left && arr[maxRowIndex][mid] > right) {
                return new int[] { maxRowIndex, mid };
            } else if (arr[maxRowIndex][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] { -1, -1 };
    }

    public static int samllestElementInMatrix(int[][] matrix) {
        int smallest = Integer.MAX_VALUE;
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            if (matrix[i][0] < smallest) {
                smallest = matrix[i][0];
            }
        }
        return smallest;
    }

    public static int largestElementInMatrix(int[][] matrix) {
        int largest = Integer.MIN_VALUE;
        int len = matrix.length;
        int len2 = matrix[0].length;
        for (int i = 0; i < len; i++) {
            if (matrix[i][len2 - 1] > largest) {
                largest = matrix[i][len2 - 1];
            }
        }
        return largest;
    }

    public static int blackbox(int[][] matrix, int mid) {
        int count = 0;
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            count += findUpperBound(matrix[i], mid);
        }
        return count;
    }

    public static int findMedian(int[][] matrix) {
        /*
         * Brute force form a single dimensional array
         * and sort the array and find the median
         */

        /*
         * optimal approach
         * find the min and max element in the array
         * do a binary search between the min and max element
         * find the mid element
         * count the number of elements less than or equal to mid
         * if count is less than or equal to (rows*columns)/2
         * move the left pointer to mid+1
         * else move the right pointer to mid-1
         * if count is equal to (rows*columns)/2
         * return mid
         */

        int low = samllestElementInMatrix(matrix);
        int high = largestElementInMatrix(matrix);
        int rows = matrix.length;
        int columns = matrix[0].length;
        int required = (rows * columns) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int smallerEquals = blackbox(matrix, mid);
            if (smallerEquals <= required) {

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
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
        // int[] nums={3,5,1};
        // int k=3;
        // System.out.println(largestSubarraySumMinimized(nums, k));
        // int[] nums1 = {1, 3, 8, 9, 15};
        // int[] nums2 = {7, 11, 18, 19, 21, 25};
        // System.out.println(findMedianSortedArrays(nums1, nums2));
        // int[] nums = {4, 2, 1, 3, 6};
        // System.out.println(aggressiveCows(nums, 2));
        // int[] nums={25, 46, 28, 49, 24};
        // System.out.println(findPages(nums, 4));
        // int[] nums1 = { 2, 3, 6, 7, 9 };
        // int[] nums2 = { 1, 4, 8, 10 };
        // int k = 5;
        // System.out.println(kthElement(nums1, nums2, k));
        // int[][] mat = { { 0, 0, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
        // System.out.println(rowWithMax1s(mat));
        // int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        // System.out.println(searchMatrix(matrix, 16));
        // int[][] arr = { { 10,20,15},
        // { 21,30,14},
        // { 7,16,32} };
        // System.out.println(Arrays.toString(findPeakElementInMatrix(arr)));
        int[][] matrix=  {{ 1, 4, 9}, {2, 5, 6}, {3, 7, 8}};
        System.out.println(findMedian(matrix));
    }
}