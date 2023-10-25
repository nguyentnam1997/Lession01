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

    public int longestMountain(int[] arr) {
       /* int result = 0;
        if (arr == null || arr.length < 3) return result;
        int i = 1;
        int start = 0;
        boolean upHill = false;
        boolean downHill = false;
        while (i < arr.length) {
            start = i - 1;
//go uphill
            while (i < arr.length && arr[i - 1] < arr[i]) {
                upHill = true;
                i++;
            }
//go downhill
            while (i < arr.length && arr[i - 1] > arr[i]) {
                downHill = true;
                i++;
            }

            //if found uphill and downhill then there was mountain
            if (upHill && downHill) {
                //only update when mountain size was equal or greater than 3
                if (i - start >= 3) result = Math.max(i - start, result);
            } else {
                //if there was no mountain, then ensuring it's not plain surface
                while (i < arr.length && arr[i - 1] == arr[i]) i++;
            }

            //update uphill and downhill for next iteration.
            upHill = false;
            downHill = false;
        }
        return result;*/
        // arr = [2,1,4,7,3,2,5]
        int result = 0;
        int left = 0;
        int right = 0;
        if (arr.length < 3) return 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                left  = i;
                right = i;
                while (left > 0 && arr[left] > arr[left - 1]) left--;
                while (right < arr.length - 1 && arr[right] > arr[right + 1]) right++;
                result = Math.max(right - left + 1, result);
            }
        }
        return result;
    }
    public int balancedStringSplit(String s) {
        char[] charArr = s.toCharArray();
        int countR = 0;
        int countL = 0;
        int result = 0;
        for (char c : charArr) {
            if (c == 'R') countR++;
            else if (c == 'L') countL++;
            if (countL == countR) {
                result++;
                countR = 0;
                countL = 0;
            }
        }
        return result;
    }
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder word1Str = new StringBuilder();
        StringBuilder word2Str = new StringBuilder();
        for (String str : word1) {
            word1Str.append(str);
        }
        for (String str : word2) {
            word2Str.append(str);
        }
        return word1Str.toString().contentEquals(word2Str);
    }
}
