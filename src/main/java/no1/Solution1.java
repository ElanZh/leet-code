package no1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution1 {
    static {
        try {
            String content = Files.readString(Paths.get("E:\\code-repo\\leet-code\\src\\main\\resources\\no1.txt"), StandardCharsets.UTF_8);
            content = content.replaceAll(" ", "");
            String[] txt = content.split(",");
            int[] temp = new int[txt.length];
            for (int i = 0; i < txt.length; i++) {
                temp[i] = Integer.parseInt(txt[i]);
            }
            src = temp;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static int[] src;

    public static void main(String[] args) {
        int[] x = new Solution1().twoSum(
                Solution1.src
                , 16021
        );
        System.out.println(x[0] + " " + x[1]);

    }

    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 1;
        do {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                break;
            } else {
                j++;
                if (j == nums.length) {
                    i++;
                    j = i + 1;
                }
            }
        } while (i < nums.length);
        return new int[]{i, j};
    }
}
