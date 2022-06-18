/*
* Author: Ping Danddank
3. Using only the programming techniques you learned in this lesson, write an application that
calculates the squares and cubes of the numbers from 0 to 10 and prints the resulting values in
table format, as shown below. (Build-in functions are not acceptable)
number square cube
0 0 0
1 1 1
2 4 8
...
10 100 1000
 */
public class SquaresAndCubes {
    public static void main(String[] args) {
        calculatesSquaresAndCubes(0,10);
    }
    // to calculating the number from start to end for squares and cubes, then format to a Table.
    public static void calculatesSquaresAndCubes(int start, int end){
        System.out.println("number\tsquare\tcube");
        for(int i=start; i<=end; i++){
            System.out.println(String.format("%d\t%d\t%d",i, i*i, i*i*i));
        }
    }
}
