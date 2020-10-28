package no4;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;
        int oddEven = totalSize & 1;
        int index = totalSize >> 1;

        int i = 0;
        int j = 0;

        double result = 0.0;
        switch (oddEven) {
            default:
                break;
            case 0:
                // 总数为偶数
                int[] rstList = new int[index + 1];
                for (int x = 0; x <= index; x++) {
                    if (i == nums1.length) {
                        while (x <= index) {
                            rstList[x] = nums2[j];
                            j++;
                            x++;
                        }
                        break;
                    }
                    if (j == nums2.length) {
                        while (x <= index) {
                            rstList[x] = nums1[i];
                            i++;
                            x++;
                        }
                        break;
                    }
                    int a = nums1[i];
                    int b = nums2[j];
                    if (a == b) {
                        rstList[x] = a;
                        x++;
                        if(x > index){break;}
                        rstList[x] = b;
                        i++;
                        j++;
                    } else if (a < b) {
                        rstList[x] = a;
                        i++;
                    } else {
                        rstList[x] = b;
                        j++;
                    }
                }
                result = ((double) rstList[index] + (double) rstList[index - 1]) / 2;

                break;
            case 1:
                // 总数为奇数
                for (int x = 0; x <= index; x++) {
                    if (i == nums1.length) {
                        return (double) nums2[index - i];
                    }
                    if (j == nums2.length) {
                        return (double) nums1[index - j];
                    }
                    int α = nums1[i];
                    int β = nums2[j];
                    if (α == β) {
                        result = α;
                        i++;
                        j++;
                        x++;
                    } else if (α < β) {
                        result = α;
                        i++;
                    } else {
                        result = β;
                        j++;
                    }
                }
                break;
        }
        return result;
    }
}