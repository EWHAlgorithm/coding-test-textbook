package Algorithm;

import java.util.Scanner;

public class q18 {

    // "균형잡힌 괄호 문자열"의 인덱스 반환
    public int balancedIndex(String p) {
        int count = 0; // 왼쪽 괄호의 개수
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count += 1;
            else count -= 1;
            if (count == 0) return i;
        }
        return -1;
    }

    // "올바른 괄호 문자열"인지 판단
    public boolean checkProper(String p) {
        int count = 0; // 왼쪽 괄호의 개수
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count += 1;
            else {
                if (count == 0) { // 쌍이 맞지 않는 경우에 false 반환
                    return false;
                }
                count -= 1;
            }
        }
        return true; // 쌍이 맞는 경우에 true 반환
    }

    public String solution(String p) {
        String answer = "";
        if (p.equals("")) return answer;
        int index = balancedIndex(p);
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);
        // "올바른 괄호 문자열"이면, v에 대해 함수를 수행한 결과를 붙여 반환
        if (checkProper(u)) {
            answer = u + solution(v);
        }
        // "올바른 괄호 문자열"이 아니라면 아래의 과정을 수행
        else {
            answer = "(";
            answer += solution(v);
            answer += ")";
            u = u.substring(1, u.length() - 1); // 첫 번째와 마지막 문자를 제거
            String temp = "";
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') temp += ")";
                else temp += "(";
            }
            answer += temp;
        }
        return answer;
    }
}

//https://programmers.co.kr/learn/courses/30/lessons/60058

// 균형잡힌 괄호 문자열이 아닌 경우엔 어떻게? 그건 상관 없나?
// 우선 균형잡힌 ( 왼 괄호와 오른 괄호의 개수가 같은지 ) 괄호인지를 판단하는 것이 필요!
//