package SuHyeon;

import java.util.Scanner;

public class Time {
    public static void main(String[] args) {
        // 정수 n 입력 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int result = 0;

        for(int i=0; i<=n; i++) {
            if (i == 3 || i == 13 || i == 23) {
                result += 3600;
            }
            else {
                result += 1575;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
