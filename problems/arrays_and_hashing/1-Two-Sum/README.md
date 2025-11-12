# 1. Two Sum

## Description
Given an array of integers `nums` and an integer `target`, return the indices `i` and `j` such that `nums[i] + nums[j] == target` and `i != j`.

You may assume that every input has exactly one pair of indices i and j that satisfy the condition. / You may assume that each input would have exactly one solution, and you may not use the same element twice.

Return the answer with the smaller index first. / You can return the answer in any order.

### Example
```
Input: nums = [2,7,11,15], target = 9

Output: [0,1]

Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```

```
Input: nums = [3,2,4], target = 6

Output: [1,2]
```

```
Input: nums = [3,3], target = 6

Output: [0,1]
```

### Constraints

- `2 <= nums.length <= 104`
- `-109 <= nums[i] <= 109`
- `-109 <= target <= 109`
- Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

### Recommended Solution
- **Approach:** HashSet or Stream Distinct
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

### Meta
- **Difficulty** Easy
- **Topics** Array, Hash Table, Sorting

### Resources
- [Leetcode problem](https://leetcode.com/problems/two-sum/description/)
- [Neetcode explanation](https://neetcode.io/solutions/two-sum)

### [Similar Questions](https://leetcode.com/problems/two-sum/description/#:~:text=Similar%20Questions,-Discussion%20(1.7K))