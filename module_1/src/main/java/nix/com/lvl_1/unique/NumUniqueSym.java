package nix.com.lvl_1.unique;

import java.util.Arrays;

public class NumUniqueSym {

    public int getUniqueSymbols(int[] nums) {
        int count = 0;
        int[] uniqueNums = new int[getMaxEl(nums) + 1];

        for (int i = 0; i < uniqueNums.length; i++) {
            uniqueNums[i] = 0;
        }

        for (int num : nums) {
            if (uniqueNums[num] == 0) {
                uniqueNums[num] = 1;
            }
        }

        for (int num : uniqueNums) {
            if (num == 1){
                count++;
            }
        }

        return count;
    }

    private int getMaxEl(int[] nums) {
        return Arrays.stream(nums).max().getAsInt();
    }
}
