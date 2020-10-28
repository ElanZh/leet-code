package no1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Solution2 {
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
        int[] x = new Solution2().twoSum(
                Solution2.src
                , 16021
        );
        System.out.println(x[0] + " " + x[1]);

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length, 1);
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];

    }
}
