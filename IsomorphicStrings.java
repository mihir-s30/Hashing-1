import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Time Complexity: O(n) where n is the length of input string s.
// Space Complexity: O(1). Both characterMap and visitedSet can have a maximum of 26 distict keys for this example.
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


// Implemented isIsomorphic using hashMap that stores the character mappings for input string s to t at specific indexes
// and hashSet that stores which characters for input t have already been visited i.e. already mapped for some character in s. 
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> characterMap = new HashMap<>();
        Set<Character> visitedSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (characterMap.containsKey(s.charAt(i))){
                char mapValue = characterMap.get(s.charAt(i));
                if (mapValue != t.charAt(i)) {
                    return false;
                }
            } else {
                if (visitedSet.contains(t.charAt(i))) {
                    return false;
                }
                characterMap.put(s.charAt(i), t.charAt(i));
                visitedSet.add(t.charAt(i));
            }
        }
        return true;
    }
}

class IsomorphicStringsRunner {
    public static void main(String[] args) {
        String s = "paper", t = "title";
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        
        System.out.println(isomorphicStrings.isIsomorphic(s, t));
    }
}
