package Implementation;

import java.util.Scanner;

/**
 * 문자열에서 같은 값이 연속해서 나타나는 것을
 * 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현
 * ex) aabbaccc ==> 2a2ba3c
 * 문자가 반복되지 않아 한 번만 나타난 경우 1은 생략
 * 
 * 이러한 방식은 반복되는 문자가 적은 경우 압축률이 낮다는 단점 있음
 * 이런 단점 해결하기 위해 문자열을 1개 이상의 단위로 잘라서 압축
 * ex) ababcdcdababcdcd => 2ab2cd2ab2cd  or 2ababcdcd
 * 
 * 압축할 문자열 s가 매개벼누로 주어질 때
 * 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중
 * 가장 짧은 것의 길이를 return하도록
 */

public class Q09 {

    public static int solution(String s) {
        int answer = s.length();
        int max_len = s.length() / 2 + 1; // 가장 길게 짜를 수 있는 길이

        // 1개 단위부터 차례대로 끊어보며 최소 길이 업데이트하기
        for(int i=1; i<=max_len; i++){
            String compressed = ""; // 압축된 문자열 저장용 변수

            // 앞에서부터 i만큼의 문자열을 추출해 줌(0 이상 i 미만)
            String prev = s.substring(0, i);
            int cnt = 1;

            // i 크기만큼 증가시키며 이전 문자열과 비교하는 방식으로 압축하기
            for(int j=i; j<s.length(); j+=i) {
                // 비교할 문자열 저장
                String comp;
                if(j+i >= s.length()) {
                    comp = s.substring(j, s.length());
                }
                else{ 
                    comp = s.substring(j, j+i);
                }

                // 만약 이전 문자열과 현재 문자열이 같다면 카운트 증가
                if(prev.equals(comp)) cnt++;
                // 다를 경우
                else {
                    compressed += (cnt>=2) ? cnt + prev : prev;
                    prev = comp;
                    cnt = 1;
                }
            }

            // 남은 문자열 처리 (?? 이부분 잘 이해 안 됩니닷...)
            compressed  += (cnt >= 2) ?  cnt + prev : prev;
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.next()));
        sc.close();
    }
}
