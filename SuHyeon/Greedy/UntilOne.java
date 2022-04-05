package Greedy;

import java.util.*;

public class UntilOne {
    public static void main(String[] args) {
        int n, k;
        int cnt = 0;

        // n, k값 입력받기
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); k = sc.nextInt();

        // n이 1이 되기 전까지 과정  반복
        while(n != 1) {
            // k로 나누어 떨어지는 경우
            if(n % k == 0)
                n /= k; // 2번 과정 수행
            else
                n--; // 1번 과정 수행
            cnt++;
        }

        System.out.println(cnt);
        sc.close();
    }
}