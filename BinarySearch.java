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
    }

    public static void main(String[] args) {

        int[] nums = { 3, 4, 4, 7, 8, 10 };
        // System.out.println(Arrays.toString(findFloorCeil(nums, 8)));
        // System.out.println(findLowerBound(nums, 7));
        // System.out.println(Arrays.toString(findLowerBoundAndUpperBound(nums, 7)));
        // System.out.println(searchInsert(nums, 0));

    }
}
