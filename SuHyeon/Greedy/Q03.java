package Greedy;

import java.util.*;

public class Q03 {
    public static void main(String[] args) {
        // 문자열 s 입력받기
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int group = 1;
        for(int i=0; i<s.length()-1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);
            if(c1 == c2)
                continue;
            else
                group++;
        }

        System.out.println(group/2);
        sc.close();
    }
}
