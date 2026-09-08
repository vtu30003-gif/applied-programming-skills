class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        // Pass 1: Build frequency count
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Pass 2: Find the first character with a count of 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1; // No unique character found
    }
}