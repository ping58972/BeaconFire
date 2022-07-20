import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(findLastSoldier(6, 3));
    }
    // O(n^2)
    public static int findLastSoldier(int n, int k){
        List<Integer> soldiers = new LinkedList<>();
        for(int i=1; i<=n; i++){
            soldiers.add(i);
        }
        int index =0;
        // O(n)
        while(soldiers.size() != 1){
            index = (index +k)%soldiers.size();
            // O(N)
            soldiers.remove(index);
        }
        return soldiers.get(0);
    }

}