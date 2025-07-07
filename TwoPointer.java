
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
                return new int[]{start, end};
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{start, end};

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.addAll(Arrays.asList(-4, -1, 0, 2, 5, 9));
        System.out.println(twoSum(arr, 1));
    }
}
