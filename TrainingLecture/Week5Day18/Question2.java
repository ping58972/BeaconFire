import java.util.HashMap;

/**
 * Given an unsorted integer array nums and an integer k, return the k most
 * frequent elements. The answer can be returned in any order.
 * 
 * Example 1:
 * Input: numbers = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * Input: numbers = [42], k = 1
 * Output: [42]
 * Please not that to receive full credit, the time complexity must be better
 * than O(n log n), where n is the array's size.
 * 
 * Please use the below method signature to complete this question:
 * 
 * int[] findTopFrequentElements(int[] numbers, int k)
 */
import java.util.*;

public class Question2 {
    public static void main(String[] args) {

    }

    static int[] findTopFrequentElements(int[] numbers, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : numbers) {
            if (map.containsKey(num)) {
                int v = map.get(num);
                map.put(num, v++);
            } else {
                map.put(num, 1);
            }
            SortedSet<Map.Entry<Integer, Integer>> ss = new TreeSet<>((e1, e2) -> {
                return e2.value().compareTo(e1.value());
            });
            ss.addAll(map.entrySet());
        }
        return null;
    }
}
