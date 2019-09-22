package DataStructure.Advanced.JavaSHA256;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Scanner;

public class Solution {
    public static String getSHA256(String input) {

        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return toReturn;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        System.out.println(getSHA256(text));
    }
}
