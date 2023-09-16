import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solve_Me_First {


    static int solveMeFirst(int a, int b) {
        // Hint: Type return a+b; below
        return a+b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        System.out.print("Enter 'a' number: ");
        a = in.nextInt();
        int b;
        System.out.print("Enter 'b' number: ");
        b = in.nextInt();
        int sum;
        sum = solveMeFirst(a, b);
        System.out.print("The sum of the two numbers is: ");
        System.out.println(sum);
    }
}
