package leetcode;

/*
 * 7.7.2018
 */

public class findMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = 0;
        int m = nums.length - 1;

        while (n < m) {
            int mid = n + (m - n) / 2;
            if (nums[mid] < nums[m]) {
                m = mid;
            } else {
                n = mid + 1;
            }
        }
        return nums[n];
    }
}
