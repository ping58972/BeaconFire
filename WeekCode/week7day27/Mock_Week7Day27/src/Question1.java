/*
* Question Name
132. Root of Largest Tree
Question Description
Given a forest (one or more disconnected trees). Find the root of largest tree and return its Id. If there are multiple such roots, return the smallest id of them.
The forest is represented with a Map<Integer, Integer>, which indicates the child -> parent relationship. The key is child and value is the corresponding immediate parent.
Constaints:
Child cannot have more than one immediate parent
Parent can have more than immediate child
The given key-value pair forms a well-formed forest ( a tree of n nodes will have n
Example 1:
Input: { {1 -> 2}, { 3 -> 4} }
Output: 2
Explanation: There are two trees one having root of Id 2 and another having root of Id 4. Both trees have size of 2. The smallest number of 2 and 4 is 2. Hence, the answer is 2.
Example 2:
﻿Input: { {1 -> 2}, {3 -> 6}, {6 -> 4}, {2 -> 5}, {7 -> 8}}
Output: 4
Explanation: We have 3 trees in this forest. Since the number of nodes in two trees are the same, we return the smaller root id.
Please use the below method signature to implement this question:
int largestTree(Map<Integer, Integer> forest)﻿
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Question1 {
    public static void main(String[] args) {
        Map<Integer, Integer> forest = new HashMap<>();
        forest.put(2, 10);
        forest.put(3, 2);
        forest.put(4,3);
        forest.put(6,5);
        forest.put(7,6);
        System.out.println(largestTree((forest)));
    }
    public static int largestTree(Map<Integer, Integer> forest){
        int max = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int key: forest.keySet()){
            if(!forest.keySet().contains(forest.get(key))){
                map.put(forest.get(key), 0);
            }
            max = Math.max(max, Math.max(key, forest.get(key)));
        }
        int[] parent = new int[max+1];
        Arrays.fill(parent, -1);
        for(int key: map.keySet()){
            parent[key]=key;
        }
        for(int key: forest.keySet()){
            parent[key] = forest.get(key);
        }
        int temp = 0;
        for(int i=0; i<=max; i++){
            if(parent[i] != -1){
                parent[i] = getPart(i, parent);
                map.put(parent[i], map.get(parent[i]) + 1);
                temp = Math.max(temp, map.get(parent[i]));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int key:map.keySet()){
            ans = Math.min(ans, key);
        }
        return ans;

    }

    private static int getPart(int i, int[] parent) {
        if(parent[i] != i){
            return getPart(parent[i], parent);
        }
        return i;
    }
}
