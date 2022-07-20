

// works
public class NumOfRepeatedSubstrings {

    // Remove all the substring, then check the difference on string length before and after removal
    // Divide the temp string with number of characters from the substring gives you the occurrences
    // https://stackoverflow.com/questions/45888605/how-to-find-the-count-of-substring-in-java
    // time: O(logN) ?
    static int calcNumSubstrings(String str, String substr) {
        String temp = str.replace(substr, "");
        int count = (str.length() - temp.length()) / substr.length();
        return count;
    }

    // using indexOf O(logN) ?
    static int calcNumSubstrings2(String s, String substr) {
        int count = 0;
        for (int i = s.indexOf(substr); i >= 0; i = s.indexOf(substr, i + 1))
            count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(
                calcNumSubstrings("abbca bb ertyuabbyiuoi", "abb")); //2

        System.out.println(
                calcNumSubstrings2("abbca bb ertyuabbyiuoi", "abb")); //2

    }
}

