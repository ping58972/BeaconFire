import java.util.HashMap;
import java.util.Map;
/*
* Author: Ping Danddank
5.(Occurrence of max numbers) Write a program that reads integers, finds the
largest of them, and counts its occurrences. Assume that the input ends with
number 0. Suppose that you entered 3 5 2 5 5 5 0; the program finds that the
largest is 5 and the occurrence count for 5 is 4.
Enter numbers: 3 5 2 5 5 5 0
The largest number is 5
The occurrence count of the largest number is 4
 */
public class OccurrenceOfMaxNumbers {
    public static void main(String[] args) {
        int [] arr = {3,5,2,5,5,5,0};
        findOccurenceOfMaxNumbers(arr);
    }
    /*use for find the Occurence of Max numbers for input array
@arr: array int[] -> array to find.
@return: void.
 */
    public static void findOccurenceOfMaxNumbers(int [] arr){
        // use hash map for collect can count the occurence.
        Map<Integer, Integer> memos = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int a: arr){
            // if max small then the element of arr, update max.
            if (max < a) max = a;
            if (memos.containsKey(a)){
                // if the element of arr contained in memo, increase to count.
                memos.put(a,memos.get(a)+1 );
            } else{
                // it not contain, put it to memos.
                memos.put(a, 1);
            }
        }
        System.out.println("the largest number is "+ max);
        System.out.println("The occurrence count of the largest number is "+ memos.get(max));

    }
}
