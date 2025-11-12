# 242. Valid Anagram

## Description
Given two strings `s` and `t`, return `true` if the two strings are anagrams of each other, otherwise return `false`.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

### Example
```
Input: s = "anagram", t = "nagaram"

Output: true
```

```
Input: s = "rat", t = "car"

Output: false
```

### Constraints
- `1 <= s.length, t.length <= 5 * 104` (optional)
- `s` and `t` consist of lowercase English letters.

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

### Recommended Solution
- **Approach:** Hash Table
- **Time Complexity:** O(n + m), where n is the length of the string s and m is the length of the string t.
- **Space Complexity:** O(1)

### Meta
- **Difficulty** Easy
- **Topics** Hash Table, Sorting, String

### Resources
- [Leetcode problem](https://leetcode.com/problems/valid-anagram/description/)
- [Neetcode explanation](https://neetcode.io/solutions/valid-anagram)

### Similar Questions
- Group Anagrams - Medium
- Palindrome Permutation - Easy
- Find All Anagrams in a String - Medium
- Find Resultant Array After Removing Anagrams - Easy