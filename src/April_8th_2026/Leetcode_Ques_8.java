package April_8th_2026;
import java.util.*;
public class Leetcode_Ques_8 {
    public static int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-')
                sign = -1;
            i++;
        }
        int ans = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int dgt = s.charAt(i) - '0';
            if (ans > (Integer.MAX_VALUE - dgt) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + dgt;
            i++;
        }

        return ans * sign;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(myAtoi(s));

    }
}
