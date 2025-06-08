import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Time Complexity: O(n + m) where n is the length of input string pattern and m is length of input string s.
// Space Complexity: O(n + m). Both patternMap and visitedWordSet can have maximum of n distinct keys and wordsArray stores words from string s.
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


// Implemented wordPattern using hashMap that stores the word mappings for each character in string pattern to s at 
// specific index values after we split s by space into string array. A hashSet stores which words from input s have
// already been visited i.e. already mapped for some character in pattern.
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternMap = new HashMap<>();
        Set<String> visitedWordSet = new HashSet<>();

        String[] wordsArray = s.split(" ");

        if (wordsArray.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (patternMap.containsKey(pattern.charAt(i))) {
                String mapValue = patternMap.get(pattern.charAt(i));
                if (!mapValue.equals(wordsArray[i])) {
                    return false;
                }
            } else {
                if (visitedWordSet.contains(wordsArray[i])) {
                    return false;
                }
                patternMap.put(pattern.charAt(i), wordsArray[i]);
                visitedWordSet.add(wordsArray[i]);
            }
        }
        return true;
    }
}

class WordPatternRunner {
    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        WordPattern wordPattern = new WordPattern();
        
        System.out.println(wordPattern.wordPattern(pattern, s));
    }
}
