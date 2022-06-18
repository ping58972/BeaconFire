public class ReverseString {
    public static void main(String[] args) {
        System.out.println(revereString("ReverseString"));
    }
    public static String revereString(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.reverse().toString();
    }
}
