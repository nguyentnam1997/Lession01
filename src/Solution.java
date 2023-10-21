public class Solution {
    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 0) return nums[i];
        }
        return 0;
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int count = 1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] != nums[j]) break;
                    else count++;
                }
                if (count > tmp) tmp = count;
            }
        }
        return tmp;
    }
    public int majorityElement(int[] nums) {
        int n = nums.length / 2;
        int element = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (i != 0) {
                if (nums[i] == nums [i - 1]) continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) count++;
            }
            if (count > n) element = nums[i];
        }
        return element;
    }
    public int[] shuffle(int[] nums, int n) {
        int[] newArr = new int[nums.length];
        newArr[0] = nums[0];
        newArr[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            newArr[i] = newArr[n];
            newArr[i + 1] = newArr[n + 1];
            n++;
        }
        return newArr;
    }
}
