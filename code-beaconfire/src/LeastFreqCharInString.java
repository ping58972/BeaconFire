
import java.util.*;

// works
public class LeastFreqCharInString {

    static char findLeastFreqChar(String s) {
        // init hashmap
        Map<Character, Integer> map = new HashMap<>();
        // populate hashmap (key=char, value=occurrences)
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else
                map.put(ch, 1);
        }
        // sort map by value/occurrences
        Optional<Map.Entry<Character, Integer>> leastFreqChar = map
                .entrySet()
                .stream().min((a, b) -> a.getValue() - b.getValue());
        return leastFreqChar.isPresent() ? leastFreqChar.get().getKey() : '0';
    }

    public static void main(String[] args) {
        System.out.println(findLeastFreqChar("abcabcab")); // c
    }

}

