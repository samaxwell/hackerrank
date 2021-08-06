import java.io.*;
import java.util.*;
import java.util.function.Function;

interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public static PerformOperation isOdd() {
        return (int n) -> n%2 != 0;
    }
    public static PerformOperation isPrime() {
        return (int n) -> {
            boolean isPrime = true;
            for (int i = 2; i <= n / 2; ++i) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            return isPrime;
        };
    }
    public static PerformOperation isPalindrome() {
        return (int number) -> {
            String l2r = Integer.toString(number);
            String r2l = new StringBuilder(l2r).reverse().toString();
            return l2r.equals(r2l);
        };
    }
    // Write your code here

}
public class Solution {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                    op = ob.isOdd();
                    ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                    op = ob.isPrime();
                    ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                    op = ob.isPalindrome();
                    ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
