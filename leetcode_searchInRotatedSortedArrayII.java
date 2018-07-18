package leetcode;

/*
 *
 * time:O(logn)   worst:O(n)
 * space:O(1)
 */

public class searchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return true;
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            } else if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) end = mid;
                else start = mid;
            } else {
                if (nums[mid] <= target && target <= nums[end]) start = mid;
                else end = mid;
            }
        }
        if (nums[start] == target) return true;
        if (nums[end] == target) return true;
        return false;
    }
}
