import java.util.PriorityQueue;

/*
* Question Name
574. Kth Largest Element in an Array
Question Description
Given an integer array nums and an integer k, return the kth largest element in the array. Note that it is the kth largest element in the sorted order, not the kth distinct element. k will always be within bounds.
* */
public class Question2 {
    public static void main(String[] args) {
        int [] nums = {2, 4, 3, 5, 5, 1};
        System.out.println(findKthLargest(nums, 3));

    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2)-> (- Integer.compare(o1, o2)));
        for(int num: nums){
            maxHeap.add(num);
        }
        int ans = maxHeap.peek();
        while(k> 0 && !maxHeap.isEmpty()){
           ans = maxHeap.poll();
           k--;
        }
            return ans;
    }
}
