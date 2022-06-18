import java.util.*;

public class Main {
    public static void main(String[] args) {

        int ans = findMinimumChanges("aba", "aab");
        System.out.println(ans);
//        int[] heights = {78, 90, 65, 51, 87, 99, 100, 31, 150};
//        int[] arr = hillClimbing(heights);
//        System.out.println(Arrays.toString(arr));
    }

    static int[] hillClimbing(int[] heights){
        List<Integer> result = new ArrayList<>();
        int curr, step = 0;
        for(int i=0; i<heights.length; i++){
            if(i != heights.length -1) step=1;
             else step =0;
            curr = heights[i];
            int j= i+1;
            while(j<heights.length && heights[j]<curr){
                step++;
                j++;
            }
            result.add(step);
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
    static int findMinimumChanges(String str1, String str2){
        int[] memo = new int[256];
        int count = 0;
        for(char c: str1.toCharArray()){
            memo[c]++;
        }
        for(char cc: str2.toCharArray()){
            if(memo[cc]>0)
            memo[cc]--;
        }
        for(int i=0; i<memo.length; i++){
            count += memo[i];
        }
        return count;
    }
}