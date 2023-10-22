import java.util.*;

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
                if (nums[i] == nums[i - 1]) continue;
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
        for (int i = 1; i < nums.length - 2; i++) {
            newArr[i] = nums[n];
            newArr[i + 1] = nums[n + 1];
            n++;
        }
        return newArr;
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int n : nums) {
            if (String.valueOf(n).length() % 2 == 0) count++;
        }
        return count;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] tmpNums1 = new int[m+n];
//        if (nums1.length == 0) nums1 = nums2;
//        else {
//            for (int i = 0; i < tmpNums1.length; i++) {
//                nums1[m] = nums2[i];
//                m++;
//            }
//        }
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);   //key: ký tự thứ i; value: số lần xuất hiện của ký tự
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
    public int removeElement(int[] nums, int val) {
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            if (num != val) {
                numsList.add(num);
            }
        }
        for (int i = 0; i < numsList.size(); i++) {
            nums[i] = numsList.get(i);
        }
        return numsList.size();
    }
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                i++;
            }
        }
    }
    public void moveZeroes(int[] nums) {
//        Arrays.sort(nums);
//        int count = 0;
//        for (int num: nums) {
//            if (num == 0) count++;
//        }
//        if(count != 0) {
//            Arrays.sort(nums);
//            if (nums.length > 1) {
//                for (int i = 0; i < nums.length - count; i++) {
//                    nums[i] = nums[i + count];
//                }
//                for (int i = nums.length - count; i < nums.length; i++) {
//                    nums[i] = 0;
//                }
//            }
//        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == 0) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

}
