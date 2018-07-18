package leetcode;
/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

比较重点
Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

index: 0  1  2  3  4  5
          L1  R1
nums1: 3  4 | 8  9              4 cut1
nums2: 1  2  7 | 10  11  12     6 cut2
             L2  R2
nums3: 1 2 3 4 7 8 9 10 11 12

L1 <= R2
L2 <= R1

L1 > R2  cut1 <<  (cutL, cut1 - 1)
L2 > R1  cut2 >>  (cut1 + 1, cutR)

*/
public class findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        if (nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int len = nums1.length + nums2.length;
        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = nums1.length;
        while (cut1 <= nums1.length){
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = len / 2 - cut1;
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2){
                cutR = cut1 - 1;
            }else if (L2 > R1){
                cutL = cut1 + 1;
            }else {
                if (len % 2 == 0) {
                    L1 = L1 > L2 ? L1 : L2;
                    R1 = R1 < R2 ? R1 : R2;
                    return (L1 + R1) / 2;
                } else {
                    R1 = (R1 < R2) ? R1 : R2;
                    return R1;
                }
            }
        }
        return -1;
    }





    /* For O(m+n):
        public double findMedianSortedArrays(int [] nums1, int[] nums2){
            int[] res = merge(nums1,nums2);
            int n = res.length;
            if (n % 2 == 0){
                return (res[(n - 1) / 2] + res[n/2]) / 2.0;
            }else {
                return res[n / 2];
            }
        }

        private int[] merge(int[] nums1, int[] nums2) {
            int[] merged = new int[nums1.length + nums2.length];
            int i = 0, j = 0, k = 0;
            while (i < nums1.length && j < nums2.length){
                merged[k++] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
            }
            while (i < nums1.length){
                merged[k++] = nums1[i++];
            }
            while (j < nums2.length){
                merged[k++] = nums2[j++];
            }
            return merged;
        }
        */


}
