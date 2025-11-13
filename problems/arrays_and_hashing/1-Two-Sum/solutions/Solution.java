import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * Gives indices of the two numbers from an array such that they add up to target
     * 
     * @param nums array of integers
     * @param target an integer target
     * @return return the indices `i` and `j` such that `nums[i] + nums[j] == target` and `i != j`
     */
    public int[] twoSum(int[] nums, int target) {
        return twoSumHashMapV2(nums, target);
    }

    /*
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    private int[] twoSumHashMapV2(int[] nums, int target) {
        Map<Integer, Integer> diffFromTargetToIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (diffFromTargetToIndexMap.containsKey(nums[i])) {
                return new int[] {diffFromTargetToIndexMap.get(nums[i]), i};
            }
            int diffFromTarget = target - nums[i];
            diffFromTargetToIndexMap.put(diffFromTarget, i);
        }
        return new int[] {-1, -1};
    }

    /*
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    private int[] twoSumHashMapV1(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diffFromTarget = target - nums[i];
            if (numsMap.containsKey(diffFromTarget)) {
                return new int[] {numsMap.get(diffFromTarget), i};
            }
            numsMap.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    /*
     * Time complexity: O(nlogn)
     * Space complexity: O(n)
     */
    private int[] twoSumTwoPointers(int[] nums, int target) {
        int nums2d[][] = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            nums2d[i][0] = nums[i];
            nums2d[i][1] = i;
        }
        Arrays.sort(nums2d, Comparator.comparingInt(x -> x[0]));
        int left = 0;
        int right = nums2d.length - 1;
        while (left < right) {
            int currentSum = nums2d[left][0] + nums2d[right][0];
            if (currentSum == target) {
                int min = Math.min(nums2d[left][1], nums2d[right][1]);
                int max = Math.max(nums2d[left][1], nums2d[right][1]);
                return new int[] {min, max};
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1};
    }

    /*
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    private int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }   
        }
        return new int[] {-1, -1};
    }

}
