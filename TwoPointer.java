
import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointer {

    public static int removeDuplicatesReturnLength(int[] arr) {
        int i = 0;
        int j = 1;
        int len = arr.length;
        while (j < len) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            } else {
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return i + 1;

    }

    public static ArrayList<Integer> twoSum(ArrayList<Integer> arr, int target) {
        int start = 0;
        int end = arr.size() - 1;
        ArrayList<Integer> ans = new ArrayList<>();

        while (start < end) {
            int sum = arr.get(start) + arr.get(end);
            if (sum == target) {
                ans.add(start);
                ans.add(end);
                return ans;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return ans;
    }

    public static int[] twoSumPremitive(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == target) {
                return new int[] { start, end };
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[] { start, end };

    }

    public static int trappingRainWater(int[] arr) {

        /*
         * Brute force approach
         * 1. Initialize prefixMax and suffixMax arrays to store the maximum height to
         * the left and right of each bar.
         * 2. Fill prefixMax by iterating from left to right, setting prefixMax[i] as
         * the maximum of prefixMax[i-1] and arr[i].
         * 3. Fill suffixMax by iterating from right to left, setting suffixMax[i] as
         * the maximum of suffixMax[i+1] and arr[i].
         * 4. Iterate through each bar, and for each, calculate the trapped water as the
         * minimum of leftMax and rightMax minus the current height, if possible.
         * 5. Sum up the trapped water for all bars and return the total.
         * /*
         * Time Complexity: O(n)
         * - We traverse the array three times: once to fill prefixMax, once to fill
         * suffixMax, and once to compute the total trapped water. Each traversal is
         * O(n), so the overall time complexity is O(n).
         * 
         * Space Complexity: O(n)
         * - We use two additional arrays, prefixMax and suffixMax, each of size n,
         * where n is the length of the input array.
         * 
         * Dry Run:
         * Input: arr = [0,1,0,2,1,0,1,3,2,1,2,1]
         * 
         * Step 1: Compute prefixMax:
         * prefixMax = [0,1,1,2,2,2,2,3,3,3,3,3]
         * 
         * Step 2: Compute suffixMax:
         * suffixMax = [3,3,3,3,3,3,3,3,2,2,2,1]
         * 
         * Step 3: Calculate trapped water at each index:
         * i=0: min(0,3)-0 = 0
         * i=1: min(1,3)-1 = 0
         * i=2: min(1,3)-0 = 1
         * i=3: min(2,3)-2 = 0
         * i=4: min(2,3)-1 = 1
         * i=5: min(2,3)-0 = 2
         * i=6: min(2,3)-1 = 1
         * i=7: min(3,3)-3 = 0
         * i=8: min(3,2)-2 = 0
         * i=9: min(3,2)-1 = 1
         * i=10: min(3,2)-2 = 0
         * i=11: min(3,1)-1 = 0
         * 
         * Total trapped water = 1+1+2+1+1 = 6
         */
        // int len = arr.length;
        // int[] prefixMax = new int[len];
        // int[] suffixMax = new int[len];
        // prefixMax[0] = arr[0];
        // for (int i = 1; i < arr.length; i++) {
        // prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        // }
        // suffixMax[len - 1] = arr[len - 1];
        // for (int i = len - 2; i >= 0; i--) {
        // suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
        // }

        // int total = 0;
        // for (int i = 0; i < len; i++) {
        // int leftMax = prefixMax[i];
        // int rightMax = suffixMax[i];
        // if (arr[i] < leftMax && arr[i] < rightMax) {
        // total += (Math.min(leftMax, rightMax)) - arr[i];
        // }
        // }
        // return total;

        /*
         * Optimal approach (Two Pointer Technique)
         * 
         * Steps:
         * 1. Initialize two pointers, left at 0 and right at the last index.
         * 2. Initialize leftMax and rightMax to 0 to keep track of the maximum height
         * seen so far from both ends.
         * 3. While left < right:
         * a. If arr[left] is less than or equal to arr[right]:
         * - If arr[left] is greater than leftMax, update leftMax.
         * - Else, add (leftMax - arr[left]) to total trapped water.
         * - Move left pointer to the right.
         * b. Else:
         * - If arr[right] is greater than rightMax, update rightMax.
         * - Else, add (rightMax - arr[right]) to total trapped water.
         * - Move right pointer to the left.
         * 4. Return the total trapped water.
         * 
         * Time Complexity: O(n)
         * - The array is traversed only once using two pointers.
         * 
         * Space Complexity: O(1)
         * - Only a constant amount of extra space is used for pointers and variables.
         * 
         * Dry Run:
         * Input: arr = [0,1,0,2,1,0,1,3,2,1,2,1]
         * left = 0, right = 11, leftMax = 0, rightMax = 0, total = 0
         * 
         * Iteration steps:
         * left=0, right=11: arr[left]=0, arr[right]=1
         * arr[left] <= arr[right], leftMax=0, leftMax >= arr[left], left++, total=0
         * 
         * left=1, arr[left]=1
         * leftMax=0 < arr[left]=1, update leftMax=1, left++
         * 
         * left=2, arr[left]=0
         * leftMax=1 > arr[left]=0, total += 1-0=1, left++
         * 
         * left=3, arr[left]=2
         * leftMax=1 < arr[left]=2, update leftMax=2, left++
         * 
         * left=4, arr[left]=1
         * leftMax=2 > arr[left]=1, total += 2-1=1, left++
         * 
         * left=5, arr[left]=0
         * leftMax=2 > arr[left]=0, total += 2-0=2, left++
         * 
         * left=6, arr[left]=1
         * leftMax=2 > arr[left]=1, total += 2-1=1, left++
         * 
         * left=7, arr[left]=3
         * leftMax=2 < arr[left]=3, update leftMax=3, left++
         * 
         * left=8, arr[left]=2
         * leftMax=3 > arr[left]=2, total += 3-2=1, left++
         * 
         * left=9, arr[left]=1
         * leftMax=3 > arr[left]=1, total += 3-1=2, left++
         * 
         * left=10, arr[left]=2
         * leftMax=3 > arr[left]=2, total += 3-2=1, left++
         * 
         * left=11, loop ends
         * 
         * Total trapped water = 1+1+2+1+1 = 6
         */

        int leftMax = 0, rightMax = 0, total = 0, len = arr.length;
        int left = 0, right = len - 1;
        while (left < right) {
            if (arr[left] <= arr[right]) {
                if (leftMax > arr[left]) {
                    total += leftMax - arr[left];
                } else {
                    leftMax = arr[left];
                }
                left++;
            } else {
                if (rightMax > arr[right]) {
                    total += rightMax - arr[right];
                } else {
                    rightMax = arr[right];
                }
                right--;
            }
        }
        return total;

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.addAll(Arrays.asList(-4, -1, 0, 2, 5, 9));
        System.out.println(twoSum(arr, 1));

        int[] buildings = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trappingRainWater(buildings));
    }
}
