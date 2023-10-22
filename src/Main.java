import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = new int[] {2,5,1,3,4,7};
        //System.out.println(solution.singleNumber(nums));
        //System.out.println(solution.findMaxConsecutiveOnes(nums));
        //System.out.println(solution.majorityElement(nums));
        //System.out.println(Arrays.toString(solution.shuffle(nums, nums.length / 2)));
        //System.out.println(solution.firstUniqChar("hhllo"));
        int[] nums = new int[]{0,1,0,3,12};
        solution.moveZeroes(nums);

    }
}