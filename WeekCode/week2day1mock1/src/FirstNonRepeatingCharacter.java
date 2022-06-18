import java.util.*;

/*
* Given a String s, find the first non-repeating character.
* Return an empty character if such character does not exist.
* Example:
Input: s = "abcda"
Output: 'b'
Please implement this method using the below signature:
char firstNonRepeating(String s)
 * */
public class FirstNonRepeatingCharacter {
    static int staticVal = 1;
    int nonStaticVal = 1;
    public static void main(String[] args) {
        String s = "abcdasdbfgft";
        char ans = firstNonRepeating(s);
        System.out.println(ans);
        FirstNonRepeatingCharacter demo1 = new FirstNonRepeatingCharacter();
        FirstNonRepeatingCharacter demo2 = new FirstNonRepeatingCharacter();
        demo1.staticVal = 999;
        demo1.nonStaticVal = 999;
        System.out.println(demo2.staticVal);
        System.out.println(demo2.nonStaticVal);
    }
    public static char firstNonRepeating(String s){
        int [] chars = new int[128];
        for(char ch: s.toCharArray()){
            chars[ch]++;
        }
        for(char ch: s.toCharArray()){
            if(chars[ch]==1){
                return ch;
            }
        }
        return '\0';

    }
}
