import java.util.*;
import java.util.stream.Collectors;

/*
* 573. Median of Two Sorted Array
Question Description
Given two sorted arrays nums1 and nums2, return the median of the two sorted arrays.
Example 1:
Input: nums1 = [1,3], nums = [2]
Output: 2
Explanation: merged array = [1,2,3] and median is 2.
Please use the below method signature:
double medianOfTwoSortedArray(int[] nums1, int[] nums2)
* */
public class Main {
    public static void main(String[] args) {
        int [] nums1 = {6,8,10};
        int [] nums2 = {1,2,3,4,5};
        System.out.println(medianOfTwoSortedArray(nums1, nums2));
    }
    public static double medianOfTwoSortedArray(int[] nums1, int[] nums2){
        int [] nums = new int[nums1.length + nums2.length];
        List<Integer> q = new ArrayList<>();
        List<Integer> q1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> q2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        while(!q1.isEmpty()|| !q2.isEmpty()) {
            if(!q1.isEmpty() && !q2.isEmpty()) {

                if (q1.get(0) < q2.get(0)) {
                    q.add(q1.remove(0));
                } else {
                    q.add(q2.remove(0));
                }
            } else{
                if(q1.isEmpty()){
                    q.add(q2.remove(0));
                } else if(q2.isEmpty()){
                    q.add(q1.remove(0));
                }
            }

        }
        int size = q.size();
        if(size %2 != 0){
            return q.get(size/2);
        }
        return (q.get(size/2 -1) + q.get(size/2))/(2.0);
    }
}