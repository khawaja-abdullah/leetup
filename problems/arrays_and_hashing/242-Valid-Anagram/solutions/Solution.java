import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * In all cases below m = n as we return early on length mismatch
 */
class Solution {

    /**
     * Checks whether given strings are anagrams
     * 
     * @param s first input string containing lowercase English letters
     * @param t second input string containing lowercase English letters
     * @return `true` if the two strings are anagrams of each other, otherwise `false`
     */
    public boolean isAnagram(String s, String t) {
        return isAnagramHashTable(s, t);
    }

    /*
     * Time complexity:
     * - Length check: O(1)
     * - Single pass updating hash table: O(n)
     * - Verify all hash table entries are zero: O(26)
     * - Overall: O(n)
     *
     * Space complexity:
     * - One array of size 26; O(26) -> O(1)
     */
    private boolean isAnagramHashTable(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] alphabetsHashTable = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabetsHashTable[s.charAt(i) - 'a'] += 1;
            alphabetsHashTable[t.charAt(i) - 'a'] -= 1;
        }

        for (int entry : alphabetsHashTable) {
            if (entry != 0) {
                return false;
            }
        }
        return true;
    }

    /*
     * Time complexity:
     * - Length check: O(1)
     * - Build frequency maps: O(n)
     * - Compare both maps: O(k); where k is unique chars of s and t
     * - Overall: O(n + k) -> O(n); k <= n
     *
     * Space complexity:
     * - Two HashMaps each storing up to k unique chars of s and t: O(2k) -> O(k)
     * - With fixed lowercase alphabet (<= 26 letters): O(1)
     */
     private boolean isAnagramTwoHashMaps(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Integer> frequencyMapS = new HashMap<>();
        Map<Character, Integer> frequencyMapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            frequencyMapS.put(
                s.charAt(i), 
                frequencyMapS.getOrDefault(s.charAt(i), 0) + 1
            );
            frequencyMapT.put(
                t.charAt(i), 
                frequencyMapT.getOrDefault(t.charAt(i), 0) + 1
            );
        }

        return frequencyMapS.equals(frequencyMapT);
    }

    /*
     * Time complexity:
     * - Length check: O(1)
     * - Single pass updating frequencies: O(n)
     * - Verify all entries are zero: O(k); where k is unique chars of s and t
     * - Overall: O(n + k) -> O(n)
     *
     * Space complexity:
     * - Single HashMap for up to k unique chars of s and t: O(k)
     * - With fixed lowercase alphabet (<= 26 letters): O(1)
     */
    private boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            frequencyMap.put(
                s.charAt(i), 
                frequencyMap.getOrDefault(s.charAt(i), 0) + 1
            );
            frequencyMap.put(
                t.charAt(i),
                frequencyMap.getOrDefault(t.charAt(i), 0) - 1
            );
        }

        return frequencyMap.entrySet()
                    .stream()
                    .allMatch(entry -> entry.getValue() == 0);
    }

    /*
     * Uses Arrays.sort() with Dual-Pivot QuickSort for char arrays
     * - Time Complexity: O(n log n) average, O(n^2) worst case (rare)
     * - Space Complexity: O(log n) for recursion stack
     */
     private boolean isAnagramSorting(String s, String t) {
        if (s.length() != t.length()) return false;
        
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        return Arrays.equals(sCharArray, tCharArray);
    }

}
