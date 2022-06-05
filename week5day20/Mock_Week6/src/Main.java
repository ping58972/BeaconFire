import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int [] arr = {2, 9, 4, 3, 6, 4, 4, 2, 5 };
        int num1 = 4;
        int num2 = 4;
        int ans = minimumIndexDiff(arr,  num1,  num2);
        System.out.println(ans);
        int [] nums = {-3,-2,-3};

        ans = findMaxCircularSum(nums);
        System.out.println(ans);
    }

    public static int minimumIndexDiff(int[] arr, int num1, int num2){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                if(arr[i] == num1){
                    if(map.containsKey(num2)){
                        if(Math.abs(map.get(num2) - i) < Math.abs(
                                map.get(num2) - map.get(num1) )){
                            map.put(arr[i], i);
                        }
                    }
                }
            } else {
                map.put(arr[i], i);
            }
        }
        return Math.abs(map.get(num1) - map.get(num2));
    }
    //int [] nums;
    public static int findMaxCircularSum(int [] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int begin = 0;
        int end= 0;
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            } else{
                begin = map.get(nums[i]);
                end = i;
            }
        }
        int ans = 0;
        int max = nums[begin];
        for(int j=begin; j<= end; j++){
            if(nums[j]>0){
                ans += nums[j];
            }
            if(max<nums[j]){
                max = nums[j];
            }
        }
        if(ans == 0){
            ans = max;
        }
        return ans;
    }
}