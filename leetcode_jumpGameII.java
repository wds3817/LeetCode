package leetcode;

/*
 * Edward Version


public class jumpGameII {
    public boolean canJump(int[] nums){
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > max) return false;
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}
*/

/*
 * Dynamic Programming
 */
public class jumpGameII {
    public int jumpGameII(int[] A) {
        int[] steps = new int[A.length];

        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    steps[i] = steps[j] + 1;
                    break;
                }
            }
        }
        return steps[A.length - 1];

    }
}