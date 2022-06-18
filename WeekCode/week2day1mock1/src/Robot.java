import java.util.Arrays;
import java.util.Objects;

/*
Question Description
A robot on an infinite XY-plane starts at point [0,0], this robot can receive a series of command, such as "UUDL", and move accordingly.
"U": move +Y direction
"D": move -Y direction
"R": move +X direction
"L": move -X direction
Write a method that takes a series of command in String format and return the final coordination of the robot.
Example 1:
Input: commands = "UUDL"
Output: [-1, 1]
Example 2:
Input: commands = "UUULRDUR"
Output: [1, 3]﻿
Please implement the method using below signature:
int[] walk(String commands)
 */
public class Robot {
    private int x;
    private int y;
    public static int a = 0;
    public Robot(){}
    public Robot(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public static void main(String[] args) {


        String command = "UUULRDUR";
        Robot robot = new Robot();
        int [] ans = robot.walk(command);
        System.out.println(Arrays.toString(ans));
    }
    public int[] walk(String commands){

        for (char c: commands.toCharArray()) {
            command(c);
        }
        int [] result = {x,y};
        return result;
    }
    private void command(char c){
        switch (c){
            case 'U':
                y++;
                break;
            case 'D':
                y--;
                break;
            case 'R':
                x++;
                break;
            case 'L':
                x--;
                break;
            default: break;
        }
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "["+ x +
                ", " + y +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return x == robot.x && y == robot.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
