package no4;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] total = new int[nums1.length + nums2.length];
        if (nums1.length == 0) {
            total = nums2;
        } else if (nums2.length == 0) {
            total = nums1;
        } else {
            int i = 0;
            int j = 0;
            while (i < nums1.length && j < nums2.length) {
                int a = nums1[i];
                int b = nums2[j];
                int t = i + j;
                if (a == b) {
                    total[t] = a;
                    total[t + 1] = b;
                    i++;
                    j++;
                } else if (a < b) {
                    total[t] = a;
                    i++;
                } else {
                    total[t] = b;
                    j++;
                }

                if (i == nums1.length) {
                    while (j < nums2.length) {
                        total[i + j] = nums2[j];
                        j++;
                    }
                }
                if (j == nums2.length) {
                    while (i < nums1.length) {
                        total[i + j] = nums1[i];
                        i++;
                    }
                }
            }
        }
        int size = total.length;
        int index = size >> 1;
        if ((size & 1) == 0) {
            return ((float) total[index] + (float) total[index - 1]) / 2;
        } else {
            return (float) total[index];
        }
    }
}