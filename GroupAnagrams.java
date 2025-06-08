import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Time Complexity: O(n * k log k) where n is the length of input string array and k is the average length of each string.
// Space Complexity: O(n) where n is the length of input string array.
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


// Implemented groupAnagrams by storing the values of the input strings in a map using the sorted value of the word as key and 
// maintaining a list of all the different words as value. Finally, the resulting list is created by adding the values from the 
// hashmap into a list of lists as expected from the method. 
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedAnagramMap = new HashMap<>();

        for (String word : strs) {
            String sortedWord = getSortedString(word);
            if (!groupedAnagramMap.containsKey(sortedWord)) {
                groupedAnagramMap.put(sortedWord, new ArrayList<>());
            }
            groupedAnagramMap.get(sortedWord).add(word);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> mapValue : groupedAnagramMap.values()) {
            result.add(mapValue);
        }

        return result;
    }

    private String getSortedString(String input) {
        char[] inputCharacters = input.toCharArray();
        Arrays.sort(inputCharacters);

        return new String(inputCharacters);
    }
}

class GroupAnagramsRunner {
    public static void main(String[] args) {
        String[] inpuStrings = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        GroupAnagrams groupAnagrams = new GroupAnagrams();

        System.out.println(groupAnagrams.groupAnagrams(inpuStrings));
    }
}
