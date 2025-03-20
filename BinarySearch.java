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
        int lowerBound = -1;
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        Arrays.sort(nums);
        while (low <= high) {
            mid = (low + high) / 2;
            if (x <= nums[mid]) {
                lowerBound = nums[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lowerBound;
    }

    public static int findUpperBound(int[] nums, int x) {
        int upperBound = -1;
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        Arrays.sort(nums);
        while (low <= high) {
            mid = (low + high) / 2;
            if (x > nums[mid]) {
                upperBound = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return upperBound;
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

    public static void main(String[] args) {

        int[] nums = { 1, 3, 5, 6 };
        // System.out.println(Arrays.toString(findLowerBoundAndUpperBound(nums, 7)));
        System.out.println(searchInsert(nums, 0));
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findTargetSortedRotatedArr(nums, 0));

    }
}
