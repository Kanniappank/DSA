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
         * 
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
        int[] nums={1,1,2,3,3,4,4,8,8};
        System.out.println(singleElementInSortedArray(nums));

    }
}
