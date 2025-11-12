import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    /**
     * Checks whether a given integer array contains duplicates
     * 
     * @param nums array of integers
     * @return return `true` if any value appears more than once in the array, otherwise return `false`
     */
    public boolean containsDuplicate(int[] nums) {
        return containsDuplicateStreamDistinct(nums);
    }

    /*
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    private boolean containsDuplicateStreamDistinct(int[] nums) {
        return Arrays.stream(nums).distinct().count() != nums.length;
    }

    /*
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    private boolean containsDuplicateHashSet(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsSet.contains(nums[i])) {
                return true;
            }
            numsSet.add(nums[i]);
        }
        return false;
    }

    /*
     * Primitive (int[]) - Dual-Pivot QuickSort - Time complexity: O(nlog(n)) avg, O(n^2) worst; Space Complexity: O(log(n)) (stack)
     * Object (Integer[]) - TimSort	- Time complexity: O(nlog(n)); Space Complexity: O(n) (aux array)
     */
    private boolean containsDuplicateSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /*
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    private boolean containsDuplicateHashMap(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], (frequencyMap.get(nums[i]) == null) ? 1 : frequencyMap.get(nums[i]) + 1);
        }
        return frequencyMap.entrySet()
                .stream()
                .anyMatch(entry -> entry.getValue() > 1);
    }
    
    /*
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    private boolean containsDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
