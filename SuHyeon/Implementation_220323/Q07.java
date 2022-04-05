package SuHyeon;

import java.util.Scanner;

/**
 * 럭키 스트레이트 기술을 사용할 수 있는 상황은
 * 현재 캐릭터의 점수를 N이라고 할 때
 * 자릿수를 기준으로 점수 N을 반으로 나누어
 * 왼쪽 부분의 각 자릿수의 합과 오른쪽 부분의 각 자릿수의 합을 더한 값이 동일한 상황
 * 
 * 현재 점수 N이 주어지면 럭키 스레이트를 사용할 수 있는 상태인지 아닌지를 알려주는 프로그램
 */

public class Q07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();

        // 왼쪽 오른쪽의 합을 저장할 변수
        int left = 0, right = 0;

        // n의 길이만큼 돌면서 왼쪽 값의 합은 left변수에
        // 오른쪽 값의 합은 right변수에 차례대로 더함
        for(int i=0; i<n.length(); i++) {
            // str의 길이의 절반보다 작은 인덱스의 경우에는 왼쪽에 해당
            if(i < (n.length() / 2)) {
                left += n.charAt(i) - '0';
            }
            else {
                right += n.charAt(i) - '0';
            }
        }

        // 럭키 스트레이트인지 아닌지 판단
        if(left == right)
            System.out.println("LUCKY");
        else
            System.out.println("READY");
        
        sc.close();
    }
}
