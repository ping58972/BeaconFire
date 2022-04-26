/*
* Author: Ping Danddank
4. (Print a table) Write a program that displays the following table:
a b pow(a, b)
1 2 1
2 3 8
3 4 81
4 5 1024
5 6 15625
 */
public class PrintPowerTable {
    public static void main(String[] args) {
        printTable(1,6);
    }
    // print power of integer from start to end, by table format
    public static void printTable(int start, int end){
        System.out.println("a\tb\tpow(a,b)");
        for(int i=start; i<end; i++){
            int a = i;
            int b = i + 1;
            System.out.println(String.format("%d\t%d\t%d",a, b, (int)Math.pow(a, b)));
        }
    }
}
