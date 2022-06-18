import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
* Author: Ping Danddank
6. Given a non-empty array of integers nums, every element appears twice except for one.
Find that single one. Could you implement a solution with a linear runtime complexity and
without using extra memory?(Hint: xor)
Input: nums = [2,2,1]
Output: 1
* Input: nums = [4,1,2,1,2]
Output: 4
 */

public class SingleOne {
    public static void main(String[] args) {
        int nums [] = {4,1,2,1,2};
        int ans = findSingleOne(nums);
        System.out.println(ans);
        int ans1 = findSingleOne_1(nums);
        System.out.println(ans1);
        int ans2 = findSingleOne_2(nums);
        System.out.println(ans2);
    }
    // to find the single one in nums arr.
    // @nums : array int []
    // @return int
    // time complexity O(n)
    // space complexity O(1)
    public static int findSingleOne(int [] nums){
        // 0^4 = 4
        // 4^4 = 0
        int ans = 0;
        for(int n: nums){
            // 4^1^2^1^2 = 4
            ans ^= n;
        }
        return ans;
    }
    // to find the single one in nums arr.
    // @nums : array int []
    // @return int
    // time complexity O(n)
    // space complexity O(n)
    public static int findSingleOne_1(int [] nums){
        HashSet<Integer> memo =  new HashSet<>();
        for ( int n: nums) {
            if(! memo.add(new Integer(n))){
                memo.remove(new Integer(n));
            }
        }
        return memo.iterator().next();
    }
    // to find the single one in nums arr.
    // @nums : array int []
    // @return int
    // time complexity O(n)
    // space complexity O(n)
    public static int findSingleOne_2(int [] nums){
        Map<Integer, Integer> memos = new HashMap<>();
        for (int n: nums){
            if (memos.containsKey(n)){
                memos.put(n,memos.get(n)+1 );
            } else{
                memos.put(n, 1);
            }
        }
        for(Integer k: memos.keySet()){
            if (memos.get(k) == 1){
                return k;
            }
        }
        return 0;
    }
}
