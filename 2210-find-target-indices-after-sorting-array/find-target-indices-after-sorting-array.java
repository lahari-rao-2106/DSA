
import java.util.*;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        int smaller = 0;
        int equal = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                smaller++;
            }
            if (nums[i] == target) {
                equal++;
            }
        }

        for (int i = 0; i < equal; i++) {
            result.add(smaller + i);
        }

        return result;
    }
}
