class ArraysEasy {

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

    public static void main(String[] args) {
        // int[] nums = {9,6,4,2,3,5,7,0,1};
        // System.out.println(missingNumbers(nums));
        // int[] nums = { 1, 0, 1, 1, 0, 1 };
        // System.out.println((findMaxConsecutiveOnes(nums)));
        int[] nums = { 1 };
        System.out.println(singleNumber(nums));

    }
}