import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomNoteMap = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            ransomNoteMap.put(c, ransomNoteMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> magazineMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : ransomNoteMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (magazineMap.getOrDefault(c, 0) < count) {
                return false;
            }
        }
        return true;
    }
}