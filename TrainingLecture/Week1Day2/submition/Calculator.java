/*
* Author: Ping Danddank
* 1. Develop a mathematical Calculator
a. (2 Variables -- X=5,Y=7) -->> Add, Sub, Mul, Div
b. (3 Variables -- X=5,Y=6,Z=7) -->> Add, Sub, Mul, Div
The input contains two array, an array of variables and an array of operators:
input1 = [5,6,14,7], input2 = [“Add”, “Sub”, “Div”]
The precedence of operator needs to be taken care of, for example, the above example should
be 5 + 6 - (14 / 7) = 9 instead of (5 + 6 - 14) / 7 = 0 (if the end result is not integer, output the
floor of the decimal result)
Assumption:
1. No parentheses
2. Input will always be valid
3. input2.length = input1.length - 1
* */

public class Calculator {
    public static void main(String[] args) {
        int[] input1 = {5,6,14,7, 2, 2 };
        String[] input2 = {"Add", "Sub", "Div", "Add", "Mul"};
        int ans = operators(input1, input2);
        System.out.println(ans);
    }

     /*use for following each operator for input array
     to calulate each element integer of array.
     @input1: array int[] number to calurating
     @input2: array String[] operators to calurating.
     @return: int -> the result of calurating.
      */
    public static int operators( int[] input1, String[] input2){
        for (int i=0; i<input2.length; i++){
            if(input2[i]=="Mul"){
                input1[i] *= input1[i+1];
            } else if(input2[i]=="Div"){
                input1[i] = (int)(input1[i] / input1[i+1]);
            }
        }
        int ans = input1[0];
        for(int j=1; j<input1.length; j++ ){
            if(input2[j-1]=="Mul" || input2[j-1]=="Div"){
                continue;
            } else if(input2[j-1]=="Add"){
                ans += input1[j];
            } else if (input2[j-1]=="Sub"){
                ans -= input1[j];
            }
        }
        return ans;
    }

}
