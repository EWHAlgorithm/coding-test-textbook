package DFS_BFS;

import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        // 삽입
        s.push(5);
        s.push(2);
        s.push(3);
        s.push(7);

        // 삭제
        s.pop();

        s.push(1);
        s.push(4);

        s.pop();

        while(!s.empty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
    }
    
}