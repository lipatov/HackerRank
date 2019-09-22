package ExceptionHandling.TryCatch;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(x / y);
        } catch (Exception e) {
            if (e.toString().contains("InputMismatchException: For input string"))   // костыль
                System.out.println(e.toString().substring(0, e.toString().indexOf(":")));
            else
                System.out.println(e);
        }
    }
}
