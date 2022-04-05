package Greedy;

import java.util.*;

public class Q02 {
    public static void main(String[] args) {
        // 문자열 s 입력받기
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int result = s.charAt(0) - '0';
        
        // 문자열 S의 크기만큼 돌며 0이거나 1인 경우 +를, 그 외의 경우 x 연산을 해 줌
        for(int i=1; i<s.length(); i++) {
            int num = s.charAt(i) - '0';
            if(num <= 1 || result <= 1)
                result += num;
            else
                result *= num;
        }

        System.out.println(result);
        sc.close();
    }
}