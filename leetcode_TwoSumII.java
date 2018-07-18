package leetcode;

import java.util.Arrays;

public class TwoSumII {
    public int twoSum2(int[] nums, int target){
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int ans = 0;
        while(left < right) {
            if(nums[left] + nums[right] > target) {
                ans = ans + (right + left);
                right --;
            } else {
                left ++;
            }
        }
        return ans;
    }
}
