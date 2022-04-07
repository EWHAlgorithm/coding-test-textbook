package DFS_BFS;

import java.util.Stack;

/**
 * '('와 ')'의 개수가 같다면 균형잡힌 괄호 문자열이라 함
 * '('와 ')'의 짝도 모두 맞을 경우에는 올바른 괄호 문자열이라 함
 * 균형잡힌 문자열을 u, v로 분리함 (u는 균형잡힌 괄호 문자열로 더 이상 분리할 수 없어야 함
 * 수행한 결과 문자열을 u에 이어붙인 후 반환
 * 문자열 u가 올바른 괄호 문자열이라면 문자열 v에 대해 1단계부터 다시 수행
 */

public class Q18 {
    public String solution(String p) {
        String answer = "";
        if(p.equals("")) return answer;
        // 문자열 p를 u와 v로 나누기 (균형잡힌 괄호 문자열의 index 받아야 함)
        int index = balancedIndex(p);
        String u = p.substring(0, index+1);
        String v = p.substring(index+1);

        //u가 올바른 괄호 문자열인 경우 문자열 v에 대해 1단계부터 다시 수행
        if(properString(u)) {
            answer = u + solution(v);
        }
        // 올바른 괄호 문자열이 아닌 경우
        else {
            answer = "(";
            answer += solution(v);
            answer += ")";
            u = u.substring(1, u.length() - 1);
            String temp = "";
            for(int i=0; i<u.length(); i++) {
                if (u.charAt(i) == '(') temp += ')';
                else temp += '(';
            }
            answer += temp;
        }
        return answer;
    }

    private boolean properString(String u) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<u.length(); i++) {
            char c = u.charAt(i);
            if(c == '(') {
                stack.push(c); // 왼쪽 괄호일 경우 스택에 집어 넣기
            }
            // 닫는 괄호인 경우
            else {
                if(stack.isEmpty()) return false; // 스택이 비어 있으면 짝이 맞지 않으므로 false
                else stack.pop(); // 왼쪽 괄호 쌍 꺼내기
            }
        }

        if(stack.empty()) return true;
        return false;
    }

    private int balancedIndex(String p) {
        int count = 0;
        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '(') {
                count++;
            } else count--;

            if(count == 0) return i;
        }
        return -1;
    }
}
