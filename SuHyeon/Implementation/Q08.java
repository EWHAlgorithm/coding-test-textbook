package Implementation;

import java.util.Arrays;
import java.util.Scanner;

public class Q08 {
    /**
     * 알파벳 대문자와 숫자(0 ~ 9)로만 구성된 문자열이 입력으로 주어짐
     * 모든 알파벳을 오름차순으로 정렬하여 이어서 출력한 뒤에
     * 모든 숫자를 더한 값을 이어서 출력
     * 
     * ex) K1KA5CB7 ==> ABCKK13
     */
    public static void main(String[] args) {
        // 문자열 입력 받기
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        // 입력받은 문자 차례대로 배열에 저장
        char[] ch = new char[s.length()];
        for(int i=0; i<s.length(); i++) {
            ch[i] = s.charAt(i);
        }
        Arrays.sort(ch); // 오름차순으로 정렬

        int sum = 0;
        int start_index = 0; // 알파벳 시작 인덱스 저장용
        for(int i=0; i<ch.length; i++) {
            // 숫자인 경우
            if(ch[i] >= '0' && ch[i] <= '9') {
                sum += ch[i] - '0';
                continue;
            } else {
                start_index = i;
                break;
            }
        }

        // 문자열과 합 출력
        for(int i=start_index; i < ch.length; i++) {
            System.out.print(ch[i]);
        }
        System.out.println(sum);

        sc.close();
    }
}
